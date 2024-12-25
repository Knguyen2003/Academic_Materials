package dao;



import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.neo4j.driver.AccessMode;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;

import entity.Customer;
import util.AppUltil;

public class OrderDao {

	private Driver driver;
	private SessionConfig sessionConfig;
	
	
	public OrderDao(Driver driver, String dbName) {
		super();
		this.driver = driver;
		sessionConfig = SessionConfig.builder().withDefaultAccessMode(AccessMode.WRITE).withDatabase(dbName).build();
	}
	
	
	/**
	 * Tính tổng tiền của đơn hàng khi biết mã số đơn hàng.
	 */
	public double sumOrder(String orderID) {
		String query = "MATCH (o:Order)-[r:ORDERS]->(p:Product) \r\n"
				+ "where o.orderID= $ma  \r\n"
				+ "RETURN sum(toFloat(r.unitPrice)*r.quantity) as totalAmount";
		Map<String, Object> params = Map.of("ma", orderID);
		try(Session session = driver.session(sessionConfig)){
            return session.executeRead(
                tx -> {
                	Result result = tx.run(query, params);
                	return result.single().get("totalAmount").asDouble();
                }
		   );
		}
	}
	
	/**
	 * Đếm số đơn hàng của từng khách hàng.
	 */
	public Map<Customer, Long> getOrdersByCustomers(){
		String query = "MATCH (c:Customer)-[p:PURCHASED]->(o:Order)\r\n"
				+ "RETURN c, count(o) as count";
		try(Session session = driver.session(sessionConfig)){
			return session.executeRead(
				tx -> {
					Result result = tx.run(query);
					return result.stream()
							     .collect(Collectors.toMap(
                                		 	record -> AppUltil.nodeToCustomer(record.get("c").asNode()),
                                		 	record -> record.get("count").asLong(), 
                                		    (v1, v2) -> v1,
            								() -> new TreeMap<>(Comparator.comparing(Customer::getCompanyName))
                                 ));
				});
		}
	
	}
	
	/**
	 * Thống kê tổng tiền hóa đơn theo tháng / năm.
	 */
	public double getTotalMoneyInMonth(int month, int year) {
		String query = "MATCH (o:Order)-[r:ORDERS]->(p:Product) \r\n"
				+ "WITH replace(o.orderDate, ' ', 'T')  AS formattedDateTime,r\r\n"
				+ "WITH datetime(formattedDateTime) AS dateTime,r\r\n"
				+ "WHERE dateTime.year = $year AND dateTime.month = $ month\r\n"
				+ "RETURN sum(toFloat(r.unitPrice) * r.quantity) as totalAmount";
		Map<String, Object> params = Map.of("month", month, "year", year);
		try (Session session = driver.session(sessionConfig)) {
			return session.executeRead(tx -> {
				Result result = tx.run(query, params);
				return result.single().get("totalAmount").asDouble();
			});
		}
	}
	
	
	public void close() {
		driver.close();
	}
	
	
}
