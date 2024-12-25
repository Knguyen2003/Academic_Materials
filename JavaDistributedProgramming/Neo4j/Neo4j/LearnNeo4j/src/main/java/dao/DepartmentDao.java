package dao;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.Value;
import org.neo4j.driver.types.Node;

import entity.Course;
import entity.Department;



public class DepartmentDao {
    private Driver driver; //dùng để thực hiện các truy vấn tới database
    private SessionConfig sessionConfig;  
    //cấu hình session để thực hiện truy vấn (xác định cơ sở dữ liệu mà các truy vấn sẽ được thực hiện)
    
    
    /**
     * Constructor dùng để khởi tạo đối tượng DepartmentDao với driver và dbName 
     * @param driver 
     * @param dbName
     */
	public DepartmentDao(Driver driver, String dbName) {
		this.driver = driver;
		sessionConfig = SessionConfig
				.builder()
//				.withDefaultAccessMode(AccessMode.WRITE)
				.withDatabase(dbName)
				.build();
	}
     
	

	
	/**
	 * Get the number of students in a department
	 * @param dept - name - The department's name
	 * @return Map<String, Long> - The number of students in the department (String là departmentID, Long là số lượng sinh viên)
	 * String query = "MATCH (dept:Department)<-[:BELONGS_TO]-(course:Course)<-[:ENROLLED]-(student:Student) "
     */
	
	 //lấy ra số lượng sinh viên trong một khoa 
	 public Map<String, Long> getNoOfStudentsByDept() {
			String query = "MATCH (dept:Department)<-[:BELONGS_TO]-(course:Course)<-[:ENROLLED]-(student:Student) "
					+ "RETURN dept.deptID as department_id, count(student) as total_students ";
			
			try (Session session = driver.session(sessionConfig);) {

				//cách 1
//				return session.executeRead(tx -> { //executeRead() thực hiện truy vấn và trả về kết quả dưới dạng Map<String, Long> 
//					//tx là một đối tượng Transaction, thực hiện truy vấn và trả về kết quả dưới dạng Map<String, Long>
//					return tx.run(query) //thực hiện truy vấn
//							.stream() //trả về kết quả dưới dạng Stream
//							// .collect dùng để chuyển kết quả từ dạng Stream sang dạng Map<String, Long>
//							.collect(Collectors.toMap(record -> record.get("department_id").asString(), //chuyển kết quả từ dạng Stream sang dạng Map<String, Long>
//									                  record -> record.get("total_students").asLong())
//									                  );
//
//				});
				
				//cách 2
				Result result = session.run(query);
				return result.stream().collect(Collectors.toMap(record -> record.get("department_id").asString(),
						record -> record.get("total_students").asLong()));
				
				
			}
	 }
	
	
	
	
	 /**
	  * Cập nhật name = “Mathematics” cho department_id = “Math” 
	  * 
	  * 
	  */
	 public void UpdateNameByID() {
		 String query ="MATCH (dept:Department) WHERE dept.deptID = 'Math' SET dept.name = 'Mathematics'";
		 
		 
			try (Session session = driver.session(sessionConfig);) {
				session.executeWrite(
				 tx ->{ 
					 return tx.run(query).consume();
					 
		         });
			 
		 }
	 }
	 
	 
	  /**
	  * Cập nhật name = “Rock n Roll” cho department_id = “Music”
	  */
	  public void updateNameByMusic() {
			String query  = "MATCH (dept:Department) WHERE dept.deptID = 'Music' SET dept.name = 'Rock n Roll'";
			try (Session session = driver.session(sessionConfig);) {
				session.executeWrite(tx -> {
					return tx.run(query).consume();

				});
			}
		}
	  
	  
	    /**
	    * Hiển thị tất cả các khoa
	    * @return List<Department> : danh sách khoa
	    */
		public List<Department> getAllDepartments() {
			 String query = "MATCH (d:Department) RETURN d";
			 try(Session session = driver.session(sessionConfig)){
				 return session.executeWrite(
					 tx -> { 
						 Result result = tx.run(query);
						 return result
								 .stream() 
								 .map( 
								    record -> {
								    	Node node = record.get("d").asNode();
								    	String roomString = node.get("room").asString().trim(); //roomString = "102"
								    	if (roomString.startsWith("\"") && roomString.endsWith("\"")) {
			                                roomString = roomString.substring(1, roomString.length() - 1); //roomString = 102
			                            }
								        return new Department(node.get("deptID").asString(),
								        		node.get("name").asString(), 
								        		node.get("dean").asString(), 
								        		node.get("building").asString(),
								        		Integer.parseInt(roomString) );
								}).toList();
				 });
			 }
		}
	
	
       
	
	/**
	 * Liệt kê tên tất cả trưởng khoa	
	 * @return : danh sách tên trưởng khoa
	 */
	public List<String> findNameDean(){
		String query = "MATCH (d:Department) RETURN d.dean AS tenTruongKhoa";
		try(Session session = driver.session(sessionConfig)){
			return session.executeWrite(
				tx -> {
					 Result result = tx.run(query);
					 return result.stream()
							      .map(
							    	 record -> {
							    		return record.get("tenTruongKhoa").asString();
							    	 }
							    		  
							       ).toList();
				});}
	}
	
	
	
	/**
	 * Tìm tên của trưởng khoa CS
	 * @return 
	 */
	public String getDeanCS() {
		String query = "MATCH (d:Department {deptID: \"CS\"}) RETURN d.dean";
	    try(Session session = driver.session(sessionConfig)){
	    	return session.executeRead(
	    		tx -> {
	    			Result result = tx.run(query);
	    			return result.single().get("d.dean").asString();
	    		}
		
	    	);
	    }
	}
	
	
	/**
	 * Danh sách khoa có số lượng sinh viên đăng kí nhiều nhất
	 */
	public List<Department> getDeptMaxStudent() {
		String query ="MATCH (d:Department) \r\n"
				+ "OPTIONAL  MATCH (s:Student) - [:ENROLLED]-> (c:Course) - [:BELONGS_TO] -> (d)\r\n"
				+ "WITH d as department, count(s) AS totalStudents\r\n"
				+ "WITH max(totalStudents) as maxStudents, collect({khoa : department,total: totalStudents}) as temp\r\n"
				+ "UNWIND temp AS t\r\n"
				+ "WITH maxStudents, t\r\n"
				+ "WHERE t.total = maxStudents\r\n"
				+ "RETURN t";
	 try(Session session = driver.session(sessionConfig)){
		 return session.executeRead(
				tx ->{
					Result result = tx.run(query);
					return result.stream()
							     .map(
							    	record -> {
							    	    Map<String, Object> map = record.get("t").asMap();
							    		Node node = (Node) map.get("khoa");
							    		String roomString = node.get("room").asString().trim();
											if (roomString.startsWith("\"") && roomString.endsWith("\"")) {
												roomString = roomString.substring(1, roomString.length() - 1); //loại bỏ dấu " ở đầu và cuối
												
											}
							    		return new Department(node.get("deptID").asString(),
							    				node.get("name").asString(),
							    				node.get("dean").asString(),
							    				node.get("building").asString(),
							    				Integer.parseInt(roomString)
                                				);
							    	}).toList();
				});}}
	
	
	
	
	/**
	 * Close the driver
	 *
	 */
	 public void close() {
		 driver.close();
	 }
}
