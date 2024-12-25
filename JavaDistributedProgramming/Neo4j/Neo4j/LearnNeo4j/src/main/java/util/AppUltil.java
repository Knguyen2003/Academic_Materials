package util;

import java.net.URI;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;

public class AppUltil {
    
	/**
	 * Khởi tạo driver để kết nối với neo4j server
	 * @return driver
	 */
	public static Driver initDriver() {
		URI uri = URI.create("neo4j://localhost:7687"); //đây là địa chỉ của neo4j, mặc định là neo4j://localhost:7687
		String user = "neo4j"; //tên đăng nhập mặc định là neo4j
		String password = "123456789"; //mật khẩu 
		return GraphDatabase.driver(uri, AuthTokens.basic(user, password));
		//GraphDatabase.driver là một phương thức tạo một đối tượng Driver, đối tượng này được sử dụng để kết nối và thực hiện các thao tác với một cơ sở dữ liệu Neo4j.
	}
}

//Đối tượng Driver này được sử dụng để kết nối và thực hiện các thao tác với một cơ sở dữ liệu Neo4j.