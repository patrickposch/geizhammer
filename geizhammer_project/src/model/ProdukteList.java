package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class ProdukteList {
	
	LinkedList<Produkt> produkte = new LinkedList<Produkt>();
	
	
	public void add(Produkt p)
	{
		produkte.add(p);
	}
	
	public void clear()
	{
		produkte.clear();
	}
	
	public LinkedList<Produkt> getProdukte()
	{
		return produkte;
	}
	
	public LinkedList<Produkt> getProdukteByKategorie(int kategorie)
	{
		
		 String url = String.format("jdbc:sqlserver://geizhammer.database.windows.net:1433;database=geizhammerDB;user=Edmin@geizhammer;password=SQL16db_2018_req;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
	       
	        
	        Connection connection = null;

	        try {
	                connection = DriverManager.getConnection(url);

	                // Create and execute a SELECT SQL statement.
	               String selectSql = "SELECT * " 
	                    + "FROM tbl_Produkte where FKCat="+kategorie;

	                try (Statement statement = connection.createStatement();
	                    ResultSet resultSet = statement.executeQuery(selectSql)) {
	                	
	                	

	                        // Print results from select statement
	                        System.out.println("Result of SQL Query:");
	                        while (resultSet.next())
	                        {
	                            int id = Integer.parseInt(resultSet.getString("PID"));
	                        	String bezeichnung = resultSet.getString("Bezeichnung");
	                        	int packungsgr = Integer.parseInt(resultSet.getString("Packungsgroe�e"));
	                        	int packungsart = Integer.parseInt(resultSet.getString("FKPack"));
	                        	int kat = Integer.parseInt(resultSet.getString("FKCat"));
	                        	float preis = Float.parseFloat(resultSet.getString("Preis"));
	                        	int baumarkt = Integer.parseInt(resultSet.getString("FKbaum"));
	                        	
	                        	Produkt p = new Produkt(id,bezeichnung, packungsgr, packungsart, kat, preis, baumarkt);
	                        	produkte.add(p);
	                        	
	                        	System.out.println(id+"  "+bezeichnung+"  "+packungsgr+"  "+packungsart+"  "+kat+"  "+preis+"  "+baumarkt);
	                        }
	                 connection.close();
	                }                   
	        }
	        catch (Exception e) {
	                e.printStackTrace();
	        }
		return produkte;
	}
	

}