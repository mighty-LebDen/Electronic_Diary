package ru.lebedev.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;

import lombok.SneakyThrows;

public class ConnectionManager {
	private static final ConnectionManager INSTANCE = new ConnectionManager();
	private final PropertiesLoader PROPER = PropertiesLoader.getInstance();
	private static final String URL_KEY = "db.url";
	private static final String USER_KEY = "db.user";
	private static final String PASSWORD_KEY = "db.password";
	
	private ConnectionManager(){}
	public static ConnectionManager getInstance() {
		return INSTANCE;
	}
	@SneakyThrows
	public Connection open() {
		return DriverManager.getConnection(
			PROPER.get(URL_KEY),
			PROPER.get(USER_KEY),
			PROPER.get(PASSWORD_KEY)
		);
	}
}
