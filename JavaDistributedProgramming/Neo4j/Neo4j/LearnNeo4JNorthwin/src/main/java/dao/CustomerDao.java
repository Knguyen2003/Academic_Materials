package dao;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.neo4j.driver.AccessMode;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;

public class CustomerDao {
   private Driver driver;
   private SessionConfig sessionConfig;
   
	public CustomerDao(Driver driver, String dbName) {
		this.driver = driver;
		sessionConfig = SessionConfig.builder()
				.withDefaultAccessMode(AccessMode.WRITE)
				.withDatabase(dbName).build();
	}
	
	
	
	
	/**
	 * Thống kê số khách hàng theo từng thành phố (sắp xếp theo số khách hàng giảm dần)
	 */
	public Map<String, Long> getCustomerByCity() {
		String query = "MATCH (c:Customer)\r\n"
				+ "RETURN c.city as city, count(c) as count\r\n"
				+ "ORDER BY count DESC";
		try(Session session = driver.session(sessionConfig))
		{
			return session.executeRead(
				 tx -> {
					Result result = tx.run(query);
					return result.stream()
							     .collect(Collectors.toMap(
							    		 	record -> record.get("city").asString(),
							    		 	record -> record.get("count").asLong(),   
							    		    (v1,v2) -> v1,
							    		     LinkedHashMap::new
							    		 ));
				
			});
		}
	}
	
	/**
	 * Thống kê số khách hàng theo từng thành phố (sắp xếp theo city giảm dần).
	 */
	public Map<String, Long> getCustomerByCity2() {
		String query = "MATCH (c:Customer)\r\n"
				+ "RETURN c.city as city, count(c) as count\r\n";
		try(Session session = driver.session(sessionConfig)){
			return session.executeRead(
				tx -> {
					Result result = tx.run(query);
					return result.stream()
							     .collect(Collectors.toMap(record -> record.get("city").asString(), 
										record -> record.get("count").asLong(), 
										(v1, v2) -> v1, 
//										TreeMap::new // sắp xếp theo city giảm dần
										// sắp xếp theo city tăng dần
										() -> new TreeMap<>(Comparator.reverseOrder())
										));
				}
			);
		}
	}
	
	
	public void close() {
		driver.close();
	}
}
