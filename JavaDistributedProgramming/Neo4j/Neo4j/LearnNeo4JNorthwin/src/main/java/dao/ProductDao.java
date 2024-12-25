package dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.neo4j.driver.AccessMode;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.types.Node;

import entity.Category;
import entity.Product;
import entity.Supplier;
import util.AppUltil;

public class ProductDao {
	
	private Driver driver;
	private SessionConfig sessionConfig;
	
	
	
	public ProductDao(Driver driver, String dbName) {
		
		this.driver = driver;
		sessionConfig = SessionConfig.builder()
				.withDefaultAccessMode(AccessMode.WRITE)
//				.withDatabase(dbName)
				.build();
	}
	
	
	
	/**
	 * Tìm các sản phẩm được cung cấp bởi một nhà cung cấp nào đó khi biết tên nhà cung cấp
	 */
	public List<Product> findProductBySupplierName(String supplierName) {
	    String query ="MATCH (s:Supplier)-[:SUPPLIES]->(p:Product)\r\n"
	    		+ "WHERE s.companyName = $name\r\n"
	    		+ "RETURN p";
	    Map<String, Object> params = Map.of("name", supplierName);
	    try(Session session = driver.session(sessionConfig)){
	    	return session.executeRead(
	    		tx -> {
	    			Result result = tx.run(query, params);
	    			return result.stream()
	    					.map( record -> record.get("p").asNode())
	    					.map(node -> AppUltil.nodeToProduct(node))
	    					.toList();
	    		}
	    	);
	    }
	}
	
	/**
	 * Tìm danh sách sản phẩm có giá cao nhất.
	 */
	public List<Product> findProductMaxPrice(){
		String query = "MATCH (p:Product) \r\n"
				+ "WITH max(p.unitPrice) as maxPrice \r\n"
				+ "MATCH (p:Product) WHERE p.unitPrice = maxPrice \r\n"
				+ "RETURN p";
		try(Session session = driver.session(sessionConfig)){
			return session.executeRead(
					tx -> {
						Result result = tx.run(query);
						return result.stream()
								     .map(record -> record.get("p").asNode())
								     .map(node -> AppUltil.nodeToProduct(node))
								     .toList();
					}
			);
		}
	}
	
	
   /**
   * Tổng số lượng của từng sản phẩm bán ra
   */
   
	public Map<String, Long> getQuantityOfProduct() {
		String query = "MATCH (o:Order)-[r:ORDERS]->(p:Product) \r\n"
				+ "return p.productName as productName, sum(r.quantity) as totalQuantity";
		try(Session session = driver.session(sessionConfig)){
			return session.executeRead(
				tx-> {
					Result result  = tx.run(query);
					return result.stream()
							     .collect(Collectors.toMap(record -> record.get("productName").asString(),
							    		 record -> record.get("totalQuantity").asLong(),
							    		 (v1,v2) -> v1,
							    		 () -> new TreeMap<>(Comparator.reverseOrder()) // Sắp xếp theo thứ tự giảm dần
							    		 ));
				}
					
			);
		}
	}
	
	
	/*
	 * Dùng text search để tìm kiếm sản phẩm theo tên sản phẩm.
	 */
	
	/*
	 * TRƯỚC TIÊN CẦN CHẠY CÂU LỆNH SAU Ở NEO4J:
	 * CREATE FULLTEXT INDEX text_index_pName for (p:Product) on EACH [p.productName]
	 */
	public List<Product> searchProductByName(String productName) {
		String query = "CALL db.index.fulltext.queryNodes('text_index_pName', $name) YIELD node RETURN node";
		
		Map<String, Object> params = Map.of("name", productName);
		try(Session session = driver.session(sessionConfig)){
			return session.executeRead(
				tx -> {
			       Result result =tx.run(query, params);
				   return result.stream()
						       .map(record -> AppUltil.nodeToProduct(record.get("node").asNode()))
						       .toList();
			});
		}
	}
	
	
	/**
	 * Tính tổng tiền của tất cả các hóa đơn trong một ngày nào đó.
	 */
	public double getTotalMoneyInDay(String dateString) {
        String dateTimeString = dateString + " 00:00:00.000";
        
        // Chuyển đổi chuỗi thành đối tượng LocalDateTime
		String query ="MATCH (o:Order)-[r:ORDERS]->(p:Product)\r\n"
				+ "WHERE o.orderDate = $dated\r\n"
				+ "RETURN sum(toFloat(r.unitPrice) * r.quantity) as totalAmount";
       Map<String, Object> params = Map.of("dated", dateTimeString);
		try (Session session = driver.session(sessionConfig)) {
			return session.executeRead(tx -> {
				Result result = tx.run(query,params);
				if (result.hasNext() == false) {
					return 0.0;
				}
				return result.single().get("totalAmount").asDouble();
			});
		}
	}
	
	
	
	
	
	public void close() {
		driver.close();
	}
    

}
