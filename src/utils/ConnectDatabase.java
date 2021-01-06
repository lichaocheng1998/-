package utils;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    public static String uri="jdbc:mysql://localhost:3306/guanggao_db?user=root&password=1231230&useSSL=false&&serverTimezone=UTC&&autoReconnect=true&&characterEncoding=utf-8";
    public Connection con;
    public final void connectDatabase(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(uri);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
