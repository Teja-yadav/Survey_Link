package com.edutech.progressive.config;

<<<<<<< HEAD
import java.io.IOException;
import java.io.InputStream;
=======
import java.io.FileInputStream;
import java.io.IOException;
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

<<<<<<< HEAD
public class DatabaseConnectionManager {
    private static final Properties properties = new Properties();

    static {
        loadProperties();
    }

    private static void loadProperties() {
        try (InputStream input = DatabaseConnectionManager.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                throw new IllegalStateException("resource.properties not found in classpath");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Error loading properties file", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = properties.getProperty("spring.datasource.url");
        String user = properties.getProperty("spring.datasource.username");
        String password = properties.getProperty("spring.datasource.password");
=======
public final class DatabaseConnectionManager {

    private static final Properties PROPS = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("src/main/resources/application.properties")) {
            PROPS.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load application.properties", e);
        }
    }

    private DatabaseConnectionManager() {
        // utility class
    }

    public static Connection getConnection() throws SQLException {
        String url = PROPS.getProperty("spring.datasource.url");
        String user = PROPS.getProperty("spring.datasource.username");
        String password = PROPS.getProperty("spring.datasource.password");

>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
        return DriverManager.getConnection(url, user, password);
    }
}