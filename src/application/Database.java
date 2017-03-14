package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    
    public static void insertExercise(Exercise ex) {
    	try {
    		Connection conn = DriverManager.getConnection(mysqlAddr, mysqlUser, mysqlPass);
    		PreparedStatement stmt = conn.prepareStatement("insert into OVELSE (Navn, Beskrivelse, Type) values (?,?,?)");
    		stmt.setString(1, ex.getNavn());
    		stmt.setString(2, ex.getBeskrivelse());
    		stmt.setBoolean(3, ex.erStyrkeOvelse());
    		stmt.executeUpdate();
    	} catch(SQLException e) {
        	System.out.println(e);
        }
    }
    
    public static ObservableList<Exercise> getExercises() {
    	try {
    		Connection conn = DriverManager.getConnection(mysqlAddr, mysqlUser, mysqlPass);
    		PreparedStatement stmt = conn.prepareStatement("select * from OVELSE");
    		ResultSet rs = stmt.executeQuery();
    		
    		ObservableList<Exercise> exerciseList = FXCollections.observableArrayList();
    		
    		while(rs.next()) {
    			Exercise ex = new Exercise (rs.getInt("Id"), rs.getString("Navn"), rs.getString("Beskrivelse"), rs.getBoolean("Type"));
    			exerciseList.add(ex);
    		}
    		return exerciseList;
    		
    	} catch(SQLException e) {
    		System.out.println(e);
    	}
    	return null;
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
    
    public static void insertKondisjonResult(Exercise ovelse, int lengde, int tid) {
    	try {
    		Connection conn = DriverManager.getConnection(mysqlAddr, mysqlUser, mysqlPass);
    			PreparedStatement stmt = conn.prepareStatement("insert into KONDISJONSRESULTAT (Lengde, Tid, Ovelse_Id, Treningsokt_id) values (?,?,?,?)");
        		stmt.setInt(1, lengde);
        		stmt.setInt(2, tid);
        		stmt.setInt(3, ovelse.getId());
        		stmt.setInt(4, 1);
        		stmt.executeUpdate();
    	} catch(SQLException e) {
        	System.out.println(e);
        }
    }
    
    public static void insertStyrkeResult(Exercise ovelse, int belastning, int repetisjoner, int sett) {
    	try {
    		insertResult();
    		Connection conn = DriverManager.getConnection(mysqlAddr, mysqlUser, mysqlPass);
    			PreparedStatement stmt = conn.prepareStatement("insert into STYRKERESULTAT (Ovelse_Id, Belastning, Repetisjoner, Sett) values (?,?,?,?)");
        		stmt.setInt(1, ovelse.getId());
        		stmt.setInt(2, belastning);
        		stmt.setInt(3, repetisjoner);
        		stmt.setInt(4, sett);
        		stmt.executeUpdate();	
    	} catch(SQLException e) {
        	System.out.println(e);
        }
    }
    
    public static void insertResult() {
    	try {
    		Connection conn = DriverManager.getConnection(mysqlAddr, mysqlUser, mysqlPass);
    			PreparedStatement stmt = conn.prepareStatement("insert into RESULTAT () values ()");
        		
        		stmt.executeUpdate();	
    	} catch(SQLException e) {
        	System.out.println(e);
        }
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
    
    
    
