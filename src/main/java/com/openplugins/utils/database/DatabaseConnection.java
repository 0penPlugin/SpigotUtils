package com.openplugins.utils.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private String host,username,password,table;
    private Connection connection;

    public DatabaseConnection(String host, String username, String password, String table) {
        this.host=host;
        this.username=username;
        this.password=password;
        this.table=table;

        try {
            this.connection= DriverManager.getConnection("jdbc:mysql//" + host + "/" + this.table,this.username,this.password);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
