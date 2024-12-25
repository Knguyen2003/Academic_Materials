package dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.neo4j.driver.AccessMode;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.types.Node;

import entity.Student;


public class StudentDao {
	
	private Driver driver;
	private SessionConfig sessionConfig;
	
	//Mở kết nối đến database
	public StudentDao(Driver driver, String dbName) {
		this.driver = driver;
		sessionConfig = SessionConfig
				.builder()
				.withDefaultAccessMode(AccessMode.WRITE)
				.withDatabase(dbName)
				.build();
	}
	
	
	/**
	 * Liệt kê danh sách n sinh viên 
	 * @param n - số sinh viên cần liệt kê
	 * @return lIST<Student> - danh sách n sinh viên
	 * String query = "MATCH (s:Student) RETURN s LIMIT $n";
     */
	public List<Student> findNStudent(int n) {
		//Viết câu truy vấn
		String query = "MATCH (s:Student) RETURN s LIMIT $n";
		//Truyền tham số vào câu truy vấn
		Map<String, Object> params = Map.of("n", n);
		//Thực hiện truy vấn
		try(Session session = driver.session(sessionConfig)){

			return session.executeRead(
				tx -> { 
				Result result = tx.run(query, params);				//xử lý result có 3 cách stream (trả về nhiều) , list (trả về nhiều), single (trả 1 giá trị)
				return result 
						.stream() // trả về Stream<Record>
						.map(record -> {
							Node node = record.get("s").asNode();
							
							return new Student(node.get("studentID").asString(), 
									           node.get("name").asString(),
									           Float.parseFloat(node.get("gpa").toString()));
				}).toList();
			});
		}
	}
	

	
	/**
	 *Tìm kiếm sinh viên khi biết mã sinh viên
	 *@param studentID - mã sinh viên
	 *@return Student - sinh viên có mã sinh viên là studentID
	 */
	public Student findOneStudentByID(String id) {
		String query = "MATCH (s:Student {studentID: $id}) RETURN s";
		Map<String, Object> params = Map.of("id", id);
		
		try (Session session = driver.session(sessionConfig)) {
			
			return session.executeRead(
				tx -> {
					Result result = tx.run(query, params);
					if (result.hasNext() == false) {
						return null;
					}
					//CÁCH 1 : Dùng stream
//					Record record = result.stream().findFirst().get();
//					Node node = record.get("s").asNode();
					
					
					//CÁCH 2 : Dùng Single
					//Record record = result.single(); //Node node = record.get("s").asNode();	
 					Node node = result.single().get("s").asNode();
 					
 					
					return new Student(node.get("studentID").asString(), node.get("name").asString(),
								node.get("gpa").asFloat());
					
				});
		}
		
	}
	
	/**
	 * Tổng số sinh viên đăng ký học của mỗi khoa, kết quả sắp xếp theo mã khoa (tăng dần)
	 * @return Map<String, Long> - Tổng số sinh viên đăng ký học của mỗi khoa
	 */

	public Map<String,Long> sumStudentOfDepartment() {
		String query = "MATCH (d:Department) OPTIONAL MATCH (s:Student) - [:ENROLLED] -> (c:Course) - [:BELONGS_TO] -> "
				+ "(d) RETURN d.deptID, count(s) as totalStudent ORDER BY d.deptID";
		try(Session session = driver.session(sessionConfig)){
			return session.executeRead(
					tx -> {
						Result result = tx.run(query);
						return result.stream()
								     .collect(Collectors.toMap(
								    		 record -> record.get("d.deptID").asString(),
								    		 record -> record.get("totalStudent").asLong(),
								    		 (existing, replacement) -> existing,
			                                 LinkedHashMap::new)
                                     );    
					} );
		}
	}
	

	/**
	 * Tổng số sinh viên đăng ký học của mỗi khoa, kết quả sắp xếp theo số sinh viên giảm dần
	 * @return
	 */
	public LinkedHashMap<String, Long> sumStudentOfDepartment2(){
		String query = "MATCH (d:Department) OPTIONAL MATCH (s:Student) - [:ENROLLED] -> (c:Course) - [:BELONGS_TO] -> (d) RETURN d.deptID, count(s) as totalStudent ORDER BY totalStudent DESC";
		try (Session session = driver.session(sessionConfig)) {
			return session.executeRead(tx -> {
				Result result = tx.run(query);
				return result.stream()
						.collect(Collectors.toMap(record -> record.get("d.deptID").asString(),
								record -> record.get("totalStudent").asLong(), 
								(existing, replacement) -> existing,
								LinkedHashMap::new));
			});
		}
	}
	
	
	/**
	 * Liệt kê danh sách tên của các trưởng khoa mà các khoa này không có sinh viên đăng ký học
	 * @return List<String> - danh sách tên của các trưởng khoa
	 */
	public List<String> findNameDean() {
		String query = "MATCH (d:Department)\r\n"
				+ "OPTIONAL MATCH (s:Student) - [:ENROLLED] -> (c:Course) - [:BELONGS_TO] -> (d) \r\n"
				+ "WITH d, count(s) as totalStudent\r\n"
				+ "WHERE totalStudent = 0 \r\n"
				+ "RETURN d.dean";
		try(Session session = driver.session(sessionConfig)){
			return session.executeRead(tx -> {
				Result result = tx.run(query);
				return result.stream()
						.map(
								 record ->{
									 return  record.get("d.dean").asString();
								 }
						).toList();
			});
		}
	}
	
	
	/**
	 * Danh sách sinh viên có gpa >= 3.2, kết quả sắp xếp giảm dần theo gpa
	 */
	public List<Student> findStudentGpaGreaterEqual3_2() {
		String query = "MATCH (s:Student) WHERE s.gpa >= 3.2 RETURN s ORDER BY s.gpa DESC";
		try (Session session = driver.session(sessionConfig)) {
			return session.executeRead(tx -> {
				Result result = tx.run(query);
				return result.stream().map(record -> {
					Node node = record.get("s").asNode();
					return new Student(node.get("studentID").asString(), node.get("name").asString(),
							Float.parseFloat(node.get("gpa").toString()));
				}).toList();
			});
		}
	}
	
	//close
	public void close() {
		driver.close();
	}


	
	
    

}
