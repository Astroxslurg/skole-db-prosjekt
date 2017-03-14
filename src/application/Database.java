package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Database {
	private static String mysqlAddr = "jdbc:mysql://mysql.stud.ntnu.no:3306/jonaseth_tdt4145database?allowMultiQueries=true";
    private static String mysqlUser = "jonaseth_tdt4145";
    private static String mysqlPass = "tdt4145";
    
    
    public static void test(){
    	try{
    		Connection conn = DriverManager.getConnection(mysqlAddr, mysqlUser, mysqlPass);
            PreparedStatement stmt = conn.prepareStatement("SELECT Beskrivelse FROM GRUPPE");
            ResultSet rs = stmt.executeQuery();        
            while(rs.next()){
            	System.out.println(rs.getString(1));
            }
        }
        catch(SQLException e){
            System.out.println();
        }
    }
    
    public static void insertExercise(String Navn, String Beskrivelse, int Type) {
    	try {
    		Connection conn = DriverManager.getConnection(mysqlAddr, mysqlUser, mysqlPass);
    		PreparedStatement stmt = conn.prepareStatement("insert into OVELSE (Navn, Beskrivelse, Type) values (?,?,?)");
    		stmt.setString(1, Navn);
    		stmt.setString(2, Beskrivelse);
    		stmt.setInt(3, Type);
    		stmt.executeUpdate();
    	} catch(SQLException e) {
        	System.out.println(e);
        }
    }
    
    public static void getExercises() {
    	try {
    		Connection conn = DriverManager.getConnection(mysqlAddr, mysqlUser, mysqlPass);
    		PreparedStatement stmt = conn.prepareStatement("select * from OVELSE");
    		ResultSet rs = stmt.executeQuery();
    		
    		ObservableList exerciseList = FXCollections.observableArrayList();
    		
    		while(rs.next()) {
    			System.out.println(rs.getString("Navn"));
    			System.out.println(rs.getString("Beskrivelse"));
    		}
    	} catch(SQLException e) {
    		System.out.println(e);
    	}
    }
    		
    public static void insertGoal(){
    	try {
    		Connection conn = DriverManager.getConnection(mysqlAddr, mysqlUser, mysqlPass);
    		PreparedStatement stmt = conn.prepareStatement("insert into KONDISJONSMAAL (Lengde, Tid, Type) values (?,?,?)");
    		stmt.executeUpdate();
    	} catch(SQLException e) {
        	System.out.println(e);
    	}
    }
    
    public static void insertResult(String ovelse, int type) {
    	try {
    		Connection conn = DriverManager.getConnection(mysqlAddr, mysqlUser, mysqlPass);
    		//If the exercise is a "kondisjon" exercise
    		if (type == 0) {
    			PreparedStatement stmt = conn.prepareStatement("insert into KONDISJONSRESULTAT (Lengde, Tid, Ovelse_id) values (?,?,?)");
        		stmt.setString(1, Navn);
        		stmt.setString(2, Beskrivelse);
        		stmt.setInt(3, Type);
        		stmt.executeUpdate();	
    		} 
    		//If the exercise is a "styrke" exercise
    		else if (type == 1) {
    			PreparedStatement stmt = conn.prepareStatement("insert into OVELSE (Navn, Beskrivelse, Type) values (?,?,?)");
        		stmt.setString(1, Navn);
        		stmt.setString(2, Beskrivelse);
        		stmt.setInt(3, Type);
        		stmt.executeUpdate();
    		}
    	} catch(SQLException e) {
        	System.out.println(e);
        }
    }
    
    /*  FUNKSJON FOR � LEGGE TIL I DATABASEN
    public static void createTopic(Topic topic){
    	try{
            Connection conn = DriverManager.getConnection(mysqlAddr, mysqlUser, mysqlPass);
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO topic (lectureID, number, name) VALUES (?,?,?)");
            stmt.setInt(1, Integer.parseInt(topic.getLectureID()));
            stmt.setInt(2, Integer.parseInt(topic.getTopicNumber()));
            stmt.setString(3, topic.getTopicName());
            
            stmt.executeUpdate();
    	}
        catch(SQLException e){
        	System.out.println(e);
        }
    }
    */
    
    /* FUNKSJON FOR � SLETTE TING I DATABASEN
    public static void deleteTopic(Topic topic){
    	try{
            Connection conn = DriverManager.getConnection(mysqlAddr, mysqlUser, mysqlPass);
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM topic WHERE topicID = ?");
            stmt.setInt(1, Integer.parseInt(topic.getTopicID()));
            
            stmt.executeUpdate();
    	}
        catch(SQLException e){
        	System.out.println(e);
        }
    }*/
    
    
    
}
