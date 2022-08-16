package config;

import java.io.ObjectInputFilter.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBhelper {
	private static DBhelper instance = null;
	private Connection connection = null;
	private String user;
	private String password;
	private String dbName;
	
	private DBhelper() {
		//để private để khóa không cho tạo đối tượng
		this.user = config.USER;
		this.password = config.PASSWORD;
		this.dbName = config.DB_NAME;
	}
	
	private DBhelper(String user, String password, String dbName) {
		super();
		this.user = user;
		this.password = password;
		this.dbName = dbName;
	}
	
	private static String createConnectURL(String user,String password,String database) {
		String url = String.format(
				"jdbc:sqlserver://localhost:1433;databaseName=%s;user=%s;password=%s;encrypt=true;trustServerCertificate=true;",
				database,user,password);
		return url;
	}
	
	public synchronized static DBhelper getDefaultInstance() {
		if(instance == null)
			instance = new DBhelper();
		return instance;
	}
	
	public DBhelper getInstance(String user, String password, String dbname) {
		return new DBhelper(user, password, dbname);
	}
	
	public Connection getConnection() throws SQLException{
		if(this.connection == null || this.connection.isClosed())
			this.connection = DriverManager.getConnection(createConnectURL(user, password, dbName));
		return this.connection;
	}
}
