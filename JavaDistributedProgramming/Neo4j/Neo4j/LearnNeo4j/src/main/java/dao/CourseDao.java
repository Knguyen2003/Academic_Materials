package dao;

import java.util.List;
import java.util.Map;

import org.neo4j.driver.AccessMode;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.types.Node;

import entity.Course;
import entity.Department;

public class CourseDao {
	
	private Driver driver;
	private SessionConfig sessionConfig;
	
	//Mở kết nối đến database
	public CourseDao(Driver driver, String dbName) {
		this.driver = driver;
		sessionConfig = SessionConfig.builder().withDefaultAccessMode(AccessMode.WRITE).withDatabase(dbName).build();
	}
	
	
	/**
	 * Tìm danh sách khóa học thuộc khoa theo id khoa
	 * @param idDept : id của khoa
	 * @return List<Course> : danh sách khóa học thuộc khoa
	 */
	public List<Course> findCourseInTheDepartmentByID(String idDept){
		 String query = "MATCH (c:Course) -[:BELONGS_TO]-> (d:Department) \r\n"
		 		+ "WHERE toUpper(d.deptID) = $id  \r\n"
		 		+ "RETURN c, d.deptID AS deptID";
		 Map<String, Object> params = Map.of("id", idDept);
		 
			try (Session session = driver.session(sessionConfig)) {
				
				return session.executeRead(
						tx -> {
					        Result result = tx.run(query, params);
					        return result 
					        		.stream() // trả về Stream<Record>
					        		.map(record -> {
					        			Node node = record.get("c").asNode();
					        			
					        			//Lấy id của khoa
					        			String nodeDept = record.get("deptID").asString();
					        			
					        			//Tạo đối tượng Department
					        			Department department = new Department();
					        			department.setDepartmentID(nodeDept);
					        			
					        			
						                return new Course(node.get("courseID").asString(), 
						                		          node.get("name").asString(),
								                          node.get("hours").asInt(),
								                          department
						                		           );
					                })
					        		.toList();
				         }
				);
			}
	}
	
	
	/**
	 * Thêm khóa học vào khoa IE
	 */
	public void addCourseDepartentIE() {
		String query = "MATCH (d:Department {deptID:\"IE\"}) CREATE (c:Course {courseID:\"IE202\", name:\"Simulation\", hours:3})-[:BELONG_TO]->(d)";
		try(Session session = driver.session(sessionConfig)){
			session.executeWrite(tx -> {
				return tx.run(query).consume();
				
			});
		}
	}
	
	/**
	 * Thêm khóa học vào khoa IE trả về ID khóa học vừa thêm
     * @return String : id của khóa học vừa thêm
     * String query = "MATCH (d:Department {deptID:$deptID}) CREATE (c:Course {courseID:$courseID, name:$name, hours:$hours})-[:BELONGS_TO]->(d) RETURN c.courseID AS courseID";
	 */
	 public String addCourseDepartentIEReturnID() {
		 String query = "MATCH (d:Department {deptID:$deptID}) CREATE (c:Course {courseID:$courseID, name:$name, hours:$hours})-[:BELONGS_TO]->(d) RETURN c.courseID AS courseID";
		 Map<String, Object> params = Map.of("deptID", "IE", "courseID", "IE204", "name", "Simulation", "hours", 5);
		 
		 try(Session session = driver.session(sessionConfig)){
			 
				return session.executeWrite(tx -> {
					 Result result = tx.run(query, params);
					 return result.single().get("courseID").asString();
				}); 
		 }
	 }
	 
	 /**
	  * Liệt kê tất cả các khóa học của CS và IE
	  * @return
	  */
	 public List<Course> findCourseOfCSAndIE(){
		 String query = "MATCH (c:Course)-[:BELONGS_TO]->(d: Department) WHERE d.deptID=\"CS\" OR d.deptID=\"IE\" RETURN c,d";
		 try(Session session = driver.session(sessionConfig)){
			 return session.executeRead(
					 tx -> {
						 Result result = tx.run(query);
						 return result
								 .stream()
								 .map(
									record -> {
										Node node= record.get("c").asNode();
										Node nodeDep= record.get("d").asNode();
										return new Course(node.get("courseID").asString(),
												node.get("name").asString(), 
												node.get("hours").asInt()
                                                );
									   }	 
								).toList();	 
					 }
					 );
			 
			 
		 }
	 }
	
	 
	 /**
	  * Liệt kê danh sách các tên của các sinh viên đăng ký học khóa học CS101
	  * @param courseID 
	  * @return 
	  */
	 public List<String> findStudentForCourse(String courseID){
		 String query = "MATCH (s:Student) - [:ENROLLED] -> (c:Course {courseID:$id}) RETURN s.name";
		 Map<String, Object> para = Map.of("id",courseID);
		 try(Session session = driver.session(sessionConfig)){
			 
			 return session.executeRead(
					 tx -> {
						 Result result = tx.run(query,para);
						 return result.stream()
								      .map(
								    	 record -> {
								    		 return record.get("s.name").asString();
								    	 }).toList();
	});}}
	 
	 
	/**
	 * Tổng số sinh viên đăng ký học của mỗi khoa (hiển thị những khoa không có sinh viên)
	 */
	public Map<String, Long> countStudentOfDepartment(){
		String query = "MATCH (d:Department) OPTIONAL MATCH (s:Student) - [:ENROLLED] -> (c:Course) - [:BELONGS_TO] -> (d) RETURN d.deptID, count(s) as totalStudent";
		try (Session session = driver.session(sessionConfig)) {
			return session.executeRead(tx -> {
				Result result = tx.run(query);
				return result.stream()
						     // .collect : Đây là một phương thức trong Java Streams API được sử dụng để thu thập dữ liệu từ một luồng và biến đổi nó thành một cấu trúc dữ liệu khác.
						     // Collectors.toMap : chuyển dữ liệu từ stream sang map
						
						     .collect(java.util.stream.Collectors.toMap(
						                  record -> record.get("d.deptID").asString(), 
						                  record -> record.get("totalStudent").asLong())
						     );
			});
			
		}
	}
	
	
    /**
     * Xóa tất cả khóa học
     */
	public void deleteAllCourse() {
		String query = "MATCH (course:Course) \r\n"
				+ "DETACH DELETE course";
		try(Session session = driver.session(sessionConfig)){
		       session.executeWrite(
					tx ->{
						return tx.run(query).consume();
					}
			);
		}
	}
	 
	
	//đóng kết nối;
	public void close() {
		driver.close();
	}

}
