package dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Customer;
import util.AppUltil;

public class CustomerDaoTest {
   private CustomerDao customerDao;
   private static final String DB_NAME = "neo4j";
   
   
   @BeforeEach
	void setup() {
		customerDao = new CustomerDao(AppUltil.initDriver(), DB_NAME);
	}
//   @Test
//   void testGetCustomerByCity() {
//		Map<String, Long> result = customerDao.getCustomerByCity();
//		result.forEach((city, count) -> {
//			System.out.println(city + " : " + count);
//		}
//		);
//		assertNotNull(result);
//		
//   }
   
   @Test
   void testGetCustomerByCity2() {
	   Map<String, Long> result = customerDao.getCustomerByCity2();
	   assertNotNull(result);
		result.forEach((city, count) -> {
			System.out.println(city + " : " + count);
		});
   }
   
   
   
   
   @AfterEach
   void close() {
	   customerDao.close();
   }
}
