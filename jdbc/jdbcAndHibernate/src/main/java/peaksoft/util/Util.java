package peaksoft.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static final String url="jdbc:postgresql://localhost:5432/postgres";
    private static final String username="postgres";
    private static final String password="zoom";


    public static Connection getConnection(){
        try{
            Connection connection=DriverManager.getConnection(url, username, password);
            System.out.println("Connection succeeded");
            return connection ;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }


    public static SessionFactory getSession() {

        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/maven2");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "zoom");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.HBM2DDL_AUTO, "update");

        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(User.class);
        return configuration.buildSessionFactory();
    }
}
