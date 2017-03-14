package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

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
    
    public static void insertKondisjonGoal(int lengde, int tid, int ovelse_id, Date start_dato, Date maal_dato){
    	try {
    		Connection conn = DriverManager.getConnection(mysqlAddr, mysqlUser, mysqlPass);
    		PreparedStatement stmt = conn.prepareStatement("insert into KONDISJONSMAAL (Lengde, Tid, Ovelse_id, Aktiv, Start_dato, Maal_dato) values (?,?,?,?,?,?)");
    		stmt.setInt(1, lengde);
    		stmt.setInt(2, tid);
    		stmt.setInt(3, ovelse_id);
    		stmt.setBoolean(4, true);
    		stmt.setDate(5, start_dato);
    		stmt.setDate(6, maal_dato);
    		stmt.executeUpdate();
    	} catch(SQLException e) {
        	System.out.println(e);
    	}
    }
    
    public static void insertStyrkeGoal(float belastning, int repetisjoner, int sett, int ovelse_id, Date start_dato, Date maal_dato){
    	try {
    		Connection conn = DriverManager.getConnection(mysqlAddr, mysqlUser, mysqlPass);
    		PreparedStatement stmt = conn.prepareStatement("insert into STYRKEMAAL (Belastning, Repetisjoner, Sett, Ovelse_id, Aktiv, Start_dato, Maal_dato) values (?,?,?,?,?,?,?)");
    		stmt.setFloat(1, belastning);
    		stmt.setInt(2, repetisjoner);
    		stmt.setInt(3, sett);
    		stmt.setInt(4, ovelse_id);
    		stmt.setBoolean(5, true);
    		stmt.setDate(6, start_dato);
    		stmt.setDate(7, maal_dato);
    		stmt.executeUpdate();
    	} catch(SQLException e) {
        	System.out.println(e);
    	}
}
    
    public static void insertKondisjonResult(Exercise ovelse, int lengde, int tid) {
    	try {
    		//Insert superclass Result.
    		int resultKey = insertResult();
    		Connection conn = DriverManager.getConnection(mysqlAddr, mysqlUser, mysqlPass);
    		PreparedStatement stmt = conn.prepareStatement("insert into KONDISJONSRESULTAT (Id, Lengde, Tid, Ovelse_Id, Treningsokt_id) values (?,?,?,?,?)");
    		stmt.setInt(1, resultKey);
    		stmt.setInt(2, lengde);
        	stmt.setInt(3, tid);
        	stmt.setInt(4, ovelse.getId());
        	stmt.setInt(5, 1);
        	stmt.executeUpdate();
    	} catch(SQLException e) {
        	System.out.println(e);
        }
    }
    
    public static void insertStyrkeResult(Exercise ovelse, int belastning, int repetisjoner, int sett) {
    	try {
    		//Insert superclass Result.
    		int resultKey = insertResult();
    		Connection conn = DriverManager.getConnection(mysqlAddr, mysqlUser, mysqlPass);
    		PreparedStatement stmt = conn.prepareStatement("insert into STYRKERESULTAT (Id, Ovelse_Id, Treningsokt_id, Belastning, Repetisjoner, Sett) values (?,?,?,?,?,?)");
    		stmt.setInt(1, resultKey);
        	stmt.setInt(2, ovelse.getId());
        	stmt.setInt(3, 1);
        	stmt.setInt(4, belastning);
        	stmt.setInt(5, repetisjoner);
        	stmt.setInt(6, sett);
        	stmt.executeUpdate();	
    	} catch(SQLException e) {
        	System.out.println(e);
        }
    }
    
    public static int insertResult() {
    	try {
    		Connection conn = DriverManager.getConnection(mysqlAddr, mysqlUser, mysqlPass);
    		PreparedStatement stmt = conn.prepareStatement("insert into RESULTAT () values ()", Statement.RETURN_GENERATED_KEYS);
        	stmt.executeUpdate();
        	ResultSet rs = stmt.getGeneratedKeys();
        	if (rs.next()) {
        		return rs.getInt(1);
        	} else {
        		System.out.println("rs empty");
        	}
    	} catch(SQLException e) {
        	System.out.println(e);
        }
    	return -1;
    }   
}
