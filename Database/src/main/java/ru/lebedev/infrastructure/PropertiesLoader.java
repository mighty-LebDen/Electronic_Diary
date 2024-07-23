package ru.lebedev.infrastructure;


import java.io.IOException;
import java.util.Properties;

import lombok.SneakyThrows;

public class PropertiesLoader {
	private static final Properties PROPERTIES = new Properties();
	private static final PropertiesLoader INSTANCE = new PropertiesLoader();
	private PropertiesLoader(){}
	public static PropertiesLoader getInstance() {
		return INSTANCE;
	}
	static {
		load();
		System.out.println("GOOD");
	}

	private static void load() {
		var properties = PropertiesLoader
			.class
			.getClassLoader()
			.getResourceAsStream("database.properties") ;
		try {
			PROPERTIES.load(properties);
		} catch (IOException e) {
			System.out.println("EXECP");
			throw new RuntimeException(e);
		}
	}
	public String get(String key) {
		return PROPERTIES.getProperty(key);
	}
}
