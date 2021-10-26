package org.samierfabien.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

    //OBJECT
    private Connection connection;
    private final String url = "jdbc:mysql://localhost:3306/CarnetAdressesJava?serverTimezone=UTC";
    private final String user = "magash";
    private final String pass = "fabisami";

    private ConnectionManager() {
        try{
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("connection ok");
        } catch (Exception e) {
            System.out.println("Problème de connection !");
            e.printStackTrace();
        }
    }

    public Connection getCo() {
        return connection;
    }


    //SINGLETON
    public static ConnectionManager instance;

    public static Connection getConnection() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance.getCo();
    }
}
