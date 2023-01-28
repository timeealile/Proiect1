package com.example.proiecttimeea;
import java.sql.*;

public class Database {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://db4free.net:3306/proiectp3?enabledTLSProtocols=TLSv1.2&verifyServerCertificate=false&useSSL=true";
    private static String user = "timeealile";
    private static String password = "Parola1234";
    public static Connection connection() {
        Connection cn = null;

        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(url, user, password);

            return cn;
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
