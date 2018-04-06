package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class connect_db {
	
	public static void main(String[] args) {

	     // Connect to database
	        /*String hostName = "your_server.database.windows.net";
	        String dbName = "your_database";
	        String user = "your_username";
	        String password = "your_password";*/
	        String url = String.format("jdbc:sqlserver://geizhammer.database.windows.net:1433;database=geizhammerDB;user=Edmin@geizhammer;password=SQL16db_2018_req;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
	       
	        
	        Connection connection = null;

	        try {
	                connection = DriverManager.getConnection(url);
	                String schema = connection.getSchema();
	                System.out.println("Successful connection - Schema: " + schema);

	                System.out.println("Query data example:");
	                System.out.println("=========================================");

	                // Create and execute a SELECT SQL statement.
	                String selectSql = "SELECT * " 
	                    + "FROM tbl_Standorte";

	                try (Statement statement = connection.createStatement();
	                    ResultSet resultSet = statement.executeQuery(selectSql)) {

	                        // Print results from select statement
	                        System.out.println("Result of SQL Query:");
	                        while (resultSet.next())
	                        {
	                            System.out.println(resultSet.getString(1) + " "
	                                + resultSet.getString(2));
	                        }
	                 connection.close();
	                }                   
	        }
	        catch (Exception e) {
	                e.printStackTrace();
	        }
	    }
	}



