package com.revature.Util;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

    private static String filename = "/media/removable/UNTITLED/Revature/Assignments/Week 4/Day 2/LoginPage/src/main/java/com/revature/Util/application.properties";


    public static Connection getConnection() throws IOException, SQLException {

        Properties prop = new Properties();


        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        prop.load(loader.getResourceAsStream(filename));
        String url = prop.getProperty("url");
        String username = prop.getProperty("usr");
        String password = prop.getProperty("pwd");
        return DriverManager.getConnection(url, username, password);

    }
}