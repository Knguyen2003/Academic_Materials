package util;

import java.net.URI;
import java.util.Map;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.types.Node;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import entity.Address;
import entity.Category;
import entity.Contact;
import entity.Customer;
import entity.Product;
import entity.Supplier;

public class AppUltil {
	private static final Gson GSON = new GsonBuilder().create();

	/**
	 * Init driver to connect to neo4j server
	 * 
	 * @return driver
	 */
	public static Driver initDriver() {
		URI uri = URI.create("neo4j://localhost:7687");
		String user = "neo4j";
		String password = "123456789";
		return GraphDatabase.driver(uri, AuthTokens.basic(user, password));

	}

	public static <T> T nodeToPOJO(Node node, Class<T> clazz) { // Generic method

		Map<String, Object> properties = node.asMap(); // HashMap<String, Object>
//		System.out.println(properties);

		String json = GSON.toJson(properties);
//		System.out.println(json);

		T obj = GSON.fromJson(json, clazz);

		return obj;
	}
	
	
	public static Product nodeToProduct(Node node) {
		Map<String, Object> properties = node.asMap();
		
		String json = GSON.toJson(properties);

		Supplier supplier = GSON.fromJson(json, Supplier.class);
		Category category = GSON.fromJson(json, Category.class);
		
		Product product = GSON.fromJson(json, Product.class);
		
		product.setSupplier(supplier);
		product.setCategoryID(category);
		
//		System.out.println(customer);
		
		return product;
	}
	
	
	public static Customer nodeToCustomer(Node node) {
        Map<String, Object> properties = node.asMap();
//        System.out.println(properties);
        String json = GSON.toJson(properties);
        
        
//        System.out.println(json);
        Contact contact = GSON.fromJson(json, Contact.class);
//        System.out.println(contact);
        Address address = GSON.fromJson(json, Address.class);
//        System.out.println(address);
        
     
        Customer customer = GSON.fromJson(json, Customer.class);
        customer.setContact(contact);
        customer.setAddress(address);

        return customer;
	}
}
