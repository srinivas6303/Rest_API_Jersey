package com.srinivas.Restdemo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlienRepository { 
    
     Connection connection = null;
    
    public AlienRepository() {
       
        	
        	 String driver = "com.mysql.cj.jdbc.Driver"; 
             String url = "jdbc:mysql://localhost:3306/restdb"; 
             String username = "root"; 
             String password = "Srinu@4848"; 
             
             try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful!");
            } 
             catch (Exception e) {
              System.out.println(e);
             }
    }
    
    //CREATING NEW ALIEN
    public void create(Alien a1) {
        String sql = "INSERT INTO aliens(id, name, points) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, a1.getAlienid());
            preparedStatement.setString(2, a1.getName());
            preparedStatement.setInt(3, a1.getPoints());
            preparedStatement.executeUpdate();
            System.out.println("Record inserted");
        }
        catch (Exception e) {
        	System.out.println(e);
        } 
        
    }
    
    
    //GETTING ALL ALIENS
    public List<Alien> getAliens() {
    	List<Alien> aliens=new ArrayList<>();
    	
    	String sql="select * from aliens";
    	try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            
            while(resultSet.next()) {
            	
            	Alien a=new Alien();
        
                a.setAlienid( resultSet.getInt(1));
                a.setName(resultSet.getString(2));
                a.setPoints(resultSet.getInt(3));
                
                aliens.add(a);
                
            }
            System.out.println("All records are given...");
        }
        catch (Exception e) {
        	System.out.println(e);
        } 
    	return aliens;
    }
    
    
    //GETTING SINGLE ALIEN
    public Alien getAlien(int id) {
        String sql = "SELECT * FROM aliens WHERE id=?";
        Alien a = new Alien();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                a.setAlienid(resultSet.getInt(1)); // Assuming the first column is id
                a.setName(resultSet.getString(2)); // Assuming the second column is name
                a.setPoints(resultSet.getInt(3)); // Assuming the third column is points
                
                System.out.println("Single record given");
            }
            else {
                System.out.println("No record found for id: " + id);
            }
        } catch (Exception e) {
            System.out.println(e);
        } 
        return a;
    }

    
    //UPDATING RECORD(IF PRESENT OR CREATING  A RECORD IF NOT PRESENT
	public Alien updateAlien(Alien a1) {
		 String sql = "update aliens set name=?,points=? where id=?";
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, a1.getName());
	            preparedStatement.setInt(2, a1.getPoints());
	            preparedStatement.setInt(3, a1.getAlienid());
	            preparedStatement.executeUpdate();
	            System.out.println("alien record updated.....");
	        } catch (Exception e) {
	            System.out.println(e);
	        } 
	        return a1;
		
		
	}
	
	//DELETING ALIEN
	public void deleteAlien(int id) {
        String sql = "delete  FROM aliens WHERE id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Record deleted.....");
            
            
        } 
        catch (Exception e) {
            System.out.println(e);
        } 
       
    }

}
