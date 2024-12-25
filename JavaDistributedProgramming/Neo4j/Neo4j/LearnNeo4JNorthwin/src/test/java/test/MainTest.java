package test;

import dao.ProductDao;
import util.AppUltil;

public class MainTest {
	
	public static void main(String[] args) {

		// Test ProductDao
		ProductDao productDao = new ProductDao(AppUltil.initDriver(), "neo4j");
		productDao.findProductBySupplierName("Pavlova").forEach(System.out::println);
		
//		productDao.findProductMaxPrice().forEach(System.out::println);
		
		
		

		// Test CourseDao
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
