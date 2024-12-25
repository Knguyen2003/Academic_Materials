package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Department;
import util.AppUltil;

public class DepartmentDaoTest {
	
   
	   private DepartmentDao deptDao;
	   private static final String DB_NAME = "quanlikhoahoc";
//		DepartmentDao deptDao = new DepartmentDao(AppUltil.initDriver(), "quanlikhoahoc");
//
//		deptDao.getNoOfStudentsByDept().entrySet().forEach(System.out::println);
	 
	   @BeforeEach
	   void setup() {
           deptDao = new DepartmentDao(AppUltil.initDriver(), DB_NAME);
       }
	   
	   
//	   @Test
//	   void testUpdateNameByID() {
//			deptDao.UpdateNameByID();
//	   }
	   
//	   @Test
//	   void testupdateNameByMusic() {
//			deptDao.updateNameByMusic();	
//	   }

	
//	   @Test
//	   void testgetAllDepartments() {
//		  List<Department> list =  deptDao.getAllDepartments();
//		  assertNotNull(list);
//		  assertEquals(5, list.size());  
//	   }
	   
	   
//	   @Test
//	   void testfindNameDean() {
//		   List<String> listDean = deptDao.findNameDean();
//		   assertNotNull(listDean);
//		   assertEquals(5, listDean.size());
//		   assertEquals("Rubio", listDean.get(0));
//		   assertEquals("Carson", listDean.get(1));
//		   assertEquals("Kasich", listDean.get(2));
//		   assertEquals("Cruz", listDean.get(3));
//		   assertEquals("Costello", listDean.get(4));
//		   
//	   }
	   
	   @Test
	   void testGetDeanCS() {
		   String dean = deptDao.getDeanCS();
		   assertNotNull(dean);
		   assertEquals("Rubio", dean);
	   }
	   
	   
	   @AfterEach
		void tearDown() {
			deptDao.close();
			deptDao = null;
		}

}
