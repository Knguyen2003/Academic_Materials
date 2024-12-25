package test;

import java.util.List;
import java.util.Map;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.Values;
import org.neo4j.driver.types.Node;

import dao.CourseDao;
import dao.DepartmentDao;
import dao.StudentDao;
import entity.Course;
import entity.Department;
import entity.Student;
import util.AppUltil;

public class Main {
	public static void main(String[] args) {
		
//		String ps = "12345678";
//		String us = "neo4j";
//		String uri = "neo4j+s://localhost:7687";
//		// Create a connection to the database
//		Driver driver = GraphDatabase.driver(uri , AuthTokens.basic(us , ps ));
//		
//		Session session = driver.session(SessionConfig.forDatabase("coursedb"));
//		
////		Transaction tx = session.beginTransaction();
//		
//		// Find one course by course id
//		
//		String courseId = "MA301";
//		String query = "MATCH (c: Course) "
//				+ "WHERE c.courseID = $id "
//				+ "RETURN c;";
//		
//		
////		Result result = tx.run(query, Values.parameters("id", courseId));
//		
//		Result result = session.executeRead(tx -> tx.run(query, Values.parameters("id", courseId)));
//		
//		Record record = result.single();
//		
//		Node node = record.get("c").asNode();
//				
//		Course course = new Course();
////		course.setCourseId(node.get("courseID").asString());
////		course.setName(node.get("name").asString());
////		course.setHours(node.get("hours").asInt());
//		
//		System.out.println(course);
		
		
		
		
		//Test find one student by student id
//	    StudentDao studentDao = new StudentDao(AppUltil.initDriver(), "quanlikhoahoc");
//		Student student = studentDao.findOneStudentByID("22");
//		System.out.println(student);
		
		//Test find list course in the department by department id
		CourseDao courseDao = new CourseDao(AppUltil.initDriver(), "quanlikhoahoc");
//		courseDao.findCourseInTheDepartmentByID("IE").forEach(System.out::println);
		
//		String id= courseDao.addCourseDepartentIEReturnID();
//		System.out.println(id);
		
	
		
       DepartmentDao departmentDao = new DepartmentDao(AppUltil.initDriver(), "quanlikhoahoc");
//       departmentDao.getAllDepartments().forEach(System.out::println);
	   
		
//		departmentDao.findNameDean().forEach(System.out::println);
//       courseDao.findCourseOfCSAndIE().forEach(System.out::println);
       
//       courseDao.findStudentForCourse("CS101").forEach(System.out::println);
       
//       Map<String, Long> map = courseDao.countStudentOfDepartment();
//       System.out.println(map);
//	   for (Map.Entry<String, Long> entry : map.entrySet()) {
//		   //map.entrySet() trả về một tập hợp các entry của map (mỗi entry là một cặp key-value)
//			System.out.println(entry.getKey() + " " + entry.getValue());
//	   }
	   
       
       
       StudentDao studentDao = new StudentDao(AppUltil.initDriver(), "quanlikhoahoc");
//       studentDao.sumStudentOfDepartment().forEach((k,v) -> System.out.println(k + " " + v));
//       studentDao.sumStudentOfDepartment2().forEach((k,v) -> System.out.println(k + " " + v));
       
//       studentDao.findNameDean().forEach(System.out::println);
       
//       List<Student> list = studentDao.findStudentGpaGreaterEqual3_2();
//       list.forEach(System.out::println);
       
       
       
       //Test " Danh sách khoa có số lượng sinh viên đăng kí nhiều nhất "
       List<Department> listDept = departmentDao.getDeptMaxStudent();
       listDept.forEach(System.out::println);
	   
	}
}
