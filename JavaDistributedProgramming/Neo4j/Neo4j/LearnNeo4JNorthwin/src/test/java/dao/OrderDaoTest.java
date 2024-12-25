package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Customer;
import util.AppUltil;

public class OrderDaoTest {
  private OrderDao orderDao;
  private static final String DB_NAME = "neo4j";
  
  
  @BeforeEach
	void setup() {
		orderDao = new OrderDao(AppUltil.initDriver(), DB_NAME);
	}
  
  
  
  
  
//	@Test
//	void testSumOrder() {
//		double result = orderDao.sumOrder("11005");
//		System.out.println("Tổng tiền của đơn hàng 11005 : " + result);
//		assertEquals(586.0, result);
//	}
	
	
//	@Test
//	void testGetOrdersByCustomers() {
//		Map<Customer, Long> result = orderDao.getOrdersByCustomers();
//		result.forEach((k, v) -> System.out.println(k.getCompanyName() + " : " + v));
//		assertEquals(89, result.size());
//	}
  
  
    @Test
    void testGetTotalMoneyInMonth() {
		double result = orderDao.getTotalMoneyInMonth(7, 1996);
		System.out.println("Tổng tiền các đơn hàng: " + result);
		
	}
    

	@AfterEach
	void close() {
		orderDao.close();
	}
}
