package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Course;
import util.AppUltil;

public class CourseDaoTest {
	
	private CourseDao courseDao;
	private static final String DB_NAME = "quanlikhoahoc";
	
	
	
	@BeforeEach
	//@BeforeEach dùng để chạy trước mỗi phương thức kiểm thử
	void setup() {
		courseDao = new CourseDao(AppUltil.initDriver(), DB_NAME);
	}
	
	
	
	
//	@Test
//	void testfindCourseInTheDepartmentByID() {
//		List<Course> courses = courseDao.findCourseInTheDepartmentByID("IE");
//		assertNotNull(courses); //Kiểm tra danh sách có rỗng hay không.Nếu rỗng thì fail
//		assertEquals(2, courses.size());
//		assertEquals("IE", courses.get(0).getDepartment().getDepartmentID()); //Kiểm tra id của khoa có đúng không
//		assertEquals("IE", courses.get(1).getDepartment().getDepartmentID()); //Kiểm tra id của khoa có đúng không
//
//	}
	
	
//	@Test
//	void testaddCourseDepartentIE() {
//	   courseDao.addCourseDepartentIE();
//	}
	
	
//	@Test
//	void testaddCourseDepartentIEReturnID() {
//		String id = courseDao.addCourseDepartentIEReturnID();
//		assertNotNull(id);
//		assertEquals("IE204", id);
//	}
	
//	@Test
//	void testFindCourseOfCSAndIE() {
//		List<Course> listCourse = courseDao.findCourseOfCSAndIE();
//		assertNotNull(listCourse);
//		assertEquals(6, listCourse.size());
//	}
	
//	@Test
//	void testFindStudentForCourse() {
//		List<String> listName = courseDao.findStudentForCourse("CS101");
//		assertNotNull(listName);
//		assertEquals(2, listName.size());
//		assertEquals("Cruz", listName.get(0));
//		assertEquals("Bush", listName.get(1));
//	}
	
	
//	@Test
//	void testCountStudentOfDepartment() {
//		Map<String, Long> map = courseDao.countStudentOfDepartment();
//		assertNotNull(map);
//		assertEquals(5, map.size());
//		assertEquals(3, map.get("CS"));
//		assertEquals(0, map.get("IE"));
//		assertEquals(3, map.get("Math"));
//		assertEquals(0, map.get("Music"));
//	}
	
	
	
	@Test
	void testDeleteAllCourse() {
		courseDao.deleteAllCourse();
		List<Course> list = courseDao.findCourseInTheDepartmentByID("IE");
		assertEquals(0, list.size());
	
	}
	

	@AfterEach
	//@AfterEach dùng để chạy sau mỗi phương thức kiểm thử
	void tearDown() {
		courseDao.close();
		courseDao = null;
	}

}
