/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Abel Luna
 */
public class Db {
        final  String DB = "jdbc:mysql://localhost:3306/top?autoReconnect=true&useSSL=false";
	final  String User = "hackathon";
	final  String Password = "hackathon";
	final  String Table_user = "`users`";
        final  String Table_OwnerLog = "`OwnerLog`";
        final  String Table_tempLog = "`tempLog`";
        private String user_;
	private String password_;
        private String name;
        private int Dehydration, Blood_Preassure, Blood_Preassure2, heart_rate, uniqueID;
        
        public  void fileComplaint(String crewLeader, String complaint) throws SQLException{
            Connection conn = DriverManager.getConnection(DB, User, Password);
            
            PreparedStatement addDB = conn
					.prepareStatement("INSERT INTO " + Table_OwnerLog + "(CrewLeaderName, Complaint) VALUE (?,?)");
			addDB.setString(1, crewLeader);
			addDB.setString(2, complaint);
			addDB.executeUpdate();
			addDB.close();
        }
    
    	public  boolean confirmLogin(String username, String password) throws SQLException {
		Connection conn = DriverManager.getConnection(DB, User, Password);
		ResultSet userSearch = conn.createStatement().executeQuery(
				"SELECT * from   " + Table_user + "  WHERE username = '" + username + "' AND password = '" + password + "'");
		if (!userSearch.next()) {
			//User Not found.
                        userSearch.close();
                        conn.close();
			return false;
		} else {
			user_ = username;
			password_ = password;
                        userSearch.close();
                        conn.close();
                        return true;
			// Set the scene when function returns true. 
		}
		
	}
        
        public  void updateDB(int uniqueId, String name, int Dehydration, int Blood_Preassure, int Blood_Preassure2, int heart_rate) throws SQLException {
		Connection conn = DriverManager.getConnection(DB, User, Password);
		PreparedStatement updateDB = conn
				.prepareStatement("UPDATE" + Table_tempLog + "SET Name=?, Dehydration=?, Blood_Preassure=?,Blood_Preassure2=?,heart_rate=? WHERE uniqueID = ?");
		updateDB.setString(1, name);
		updateDB.setInt(2, Dehydration);
                updateDB.setInt(3, Blood_Preassure);
                updateDB.setInt(4, Blood_Preassure2);
                updateDB.setInt(5, heart_rate);
                updateDB.setInt(6, uniqueId);
		updateDB.executeUpdate();
		updateDB.close();
		conn.close();
                
                
	}
        /**
         * @param uniqueID
         */
        public  void updateWorkerStatus(int uniqueId, String name, int Dehydration, int Blood_Preassure, int Blood_Preassure2, int heart_rate ) throws SQLException {
		Connection conn = DriverManager.getConnection(DB, User, Password);
		ResultSet userSearch = conn.createStatement()
				.executeQuery("SELECT * from   " + Table_tempLog + "  WHERE uniqueID = '" + uniqueId + "' ");
                
		if (!userSearch.next()) {
			PreparedStatement addDB = conn
					.prepareStatement("INSERT INTO " + Table_tempLog + "(uniqueId, Name, Dehydration, Blood_Preassure, Blood_Preassure2, heart_rate) VALUE (?,?,?,?,?,?)");
			addDB.setInt(1, uniqueId);
			addDB.setString(2, name);
                        addDB.setInt(3, Dehydration);
                        addDB.setInt(4, Blood_Preassure);
                        addDB.setInt(5, Blood_Preassure2);
                        addDB.setInt(6, heart_rate);
			addDB.executeUpdate();
			addDB.close();
		} else {
			//This will run in the case that the ID already exists in the database.
			updateDB(uniqueId, name, Dehydration, Blood_Preassure, Blood_Preassure2, heart_rate);
		}
		userSearch.close();
		conn.close();

	}

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the Dehydration
     */
    public int getDehydration() {
        return Dehydration;
    }

    /**
     * @return the Blood_Preassure
     */
    public int getBlood_Preassure() {
        return Blood_Preassure;
    }

    /**
     * @return the Blood_Preassure2
     */
    public int getBlood_Preassure2() {
        return Blood_Preassure2;
    }

    /**
     * @return the heart_rate
     */
    public int getHeart_rate() {
        return heart_rate;
    }
    
    /**
     * @return the heart_rate
     */
    public int getUniqueID() {
        return uniqueID;
    }
}
