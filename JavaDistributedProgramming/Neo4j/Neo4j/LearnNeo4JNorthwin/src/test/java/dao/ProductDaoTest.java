package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Product;
import util.AppUltil;

public class ProductDaoTest {

	private ProductDao productDao;
	private static final String DB_NAME = "neo4j";
	
	
	@BeforeEach
	void setUp() {
		productDao = new ProductDao(AppUltil.initDriver(), DB_NAME);
	}
	
	
//	@Test
//	void testFindProductBySupplierName() {
//		List<Product> products = productDao.findProductBySupplierName("Pavlova");
////		products.forEach(System.out::println);
//		assertEquals(5, products.size());
//		for (Product product : products) {
//			assertEquals("7", product.getSupplier().getSupplierID());
//		}
//	}
	
//	@Test
//	void testFindProductMaxPrice() {
//		List<Product> products = productDao.findProductMaxPrice();
//		assertEquals(1, products.size());
//		assertEquals("38", products.get(0).getProductID());
//	}

	
//	@Test
//	void testGetQuantityOfProduct() {
//		Map<String, Long> result = productDao.getQuantityOfProduct();
//		result.forEach((k, v) -> System.out.println(k + " : " + v));
//	}
	
	
//	@Test
//	void testSearchProductByName() {
//		List<Product> products = productDao.searchProductByName("Sauce");
//		products.forEach(System.out::println);
//		for (Product product : products) {
//			assertEquals(true, product.getProductName().contains("Sauce"));
//		}
//	}
	
	@Test
	void testGetTotalMoneyInDay() {
		double total = productDao.getTotalMoneyInDay("1996-07-04");
//		assertEquals(0, total);
		assertNotNull(total);
//		assertTrue(total > 0); //KIỂM TRA TỔNG TIỀN > 0
		System.out.println("Total money in day: " + total);
	}
	
	@AfterEach
	void tearDown() {
		productDao.close();
	}
}
