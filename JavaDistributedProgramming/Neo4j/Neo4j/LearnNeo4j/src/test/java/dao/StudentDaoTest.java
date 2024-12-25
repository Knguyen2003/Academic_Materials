package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Student;
import util.AppUltil;

public class StudentDaoTest {
     private StudentDao studentDao;
     private static final String DB_NAME = "quanlikhoahoc";
     
     
     @BeforeEach
     //@BeforeEach dùng để chạy trước mỗi phương thức kiểm thử 
     void setup() {
    	 studentDao = new StudentDao(AppUltil.initDriver(), DB_NAME);
     }
     
     
//    @Test
//	void testfindNStudent() {
//		List<Student> students = studentDao.findNStudent(5); 
//		//Kiểm tra xem danh sách sinh viên có đúng là 5 sinh viên không
//		
//		assertEquals(5, students.size()); //assertEquals dùng để so sánh giá trị trả về từ phương thức kiểm thử với giá trị mong đợi
//	}
    
    
    @Test
    void testfindOneStudentByID() {
		Student student = studentDao.findOneStudentByID("22");
        // Kiểm tra xem sinh viên có mã SV1 có tồn tại không
		assertNotNull(student);
		assertEquals("22",student.getStudentID());
	}
    
    @Test
    void testfindOneStudentByID_Null() {
		Student student = studentDao.findOneStudentByID("59");
		// Kiểm tra xem sinh viên có mã SV1 có tồn tại không
		assertNull(student);
	}
    
    
//    @Test
//    void testSumStudentOfDepartment() {
//    	Map<String, Long> list = studentDao.sumStudentOfDepartment();
//    	//Kiểm tra xem số lượng sinh viên của các khoa có đúng không
//    	assertEquals(5, list.size());
//    	assertEquals(3, list.get("CS"));
//    	assertEquals(0, list.get("IE"));
//    	
//    }
    
    
//    @Test
//    void testSumStudentOfDepartment2() {
//    	LinkedHashMap<String, Long> list = studentDao.sumStudentOfDepartment2();
//    	//Kiểm tra xem số lượng sinh viên của các khoa có đúng không
//    	assertNotNull(list);
//    	assertEquals(5, list.size());
//    	assertEquals(3, list.get("CS"));
//    	assertEquals(0, list.get("IE"));
//    	//Kiểm tra xem số lượng sinh viên có sắp xếp giảm dần không
//
//    	List<Long> values = new ArrayList<>(list.values());
//        for (int i = 1; i < values.size(); i++) {
//            // So sánh giá trị với giá trị trước đó
//            assertTrue(values.get(i - 1) >= values.get(i));
//        }
//    	
//    }
    
    
//    @Test
//    void testFindNameDean() {
//		List<String> list = studentDao.findNameDean();
//		// Kiểm tra xem danh sách trưởng khoa có đúng không
//		assertNotNull(list);
//		assertEquals(2, list.size());
//		assertTrue(list.contains("Cruz"));
//		assertTrue(list.contains("Costello"));
//    }
    
     
     @Test
     void testFindStudentGpaGreaterEqual3_2() {
    	List<Student> list = studentDao.findStudentGpaGreaterEqual3_2();
    	//Kiểm tra xem danh sách sinh viên có gpa >= 3.2 có đúng không
    	assertNotNull(list);
    	assertEquals(3, list.size());
    	assertTrue(list.get(0).getGpa() >= 3.2);
    	assertTrue(list.get(1).getGpa() >= 3.2);
    	assertTrue(list.get(2).getGpa() >= 3.2);
     }
     
     
     
     @AfterEach
     //@AfterEach dùng để chạy sau mỗi phương thức kiểm thử
	void tearDown() {
		studentDao.close();
		studentDao = null;
	}
}
