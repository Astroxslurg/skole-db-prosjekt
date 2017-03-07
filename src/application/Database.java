package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	private static String mysqlAddr = "jdbc:mysql://mysql.stud.ntnu.no:3306/jonaseth_tdt4145database?allowMultiQueries=true";
    private static String mysqlUser = "jonaseth_tdt4145";
    private static String mysqlPass = "tdt4145";
    
    
    public static void test(){
    	try{
            Connection conn = DriverManager.getConnection(mysqlAddr, mysqlUser, mysqlPass);
            PreparedStatement stmt = conn.prepareStatement("SELECT Beskrivelse FROM GRUPPE");

            System.out.println("4");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
            	System.out.println(rs.getString(1));
            }
        }
        catch(SQLException e){
            System.out.println();
        }

    }
}
