package CoreJavaProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

public class DatabaseInterface {
	
	static Connection con;
	
	public static void DBConnect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing","root", "Root@123");
	}
	
	public static void DBDisconnect() throws SQLException {
		con.close();
	}

	public static String getAll() throws SQLException {
		String query = "select * from clothes";
		
		Statement stat = con.createStatement();
		
		ResultSet rs = stat.executeQuery(query);
		
		String output = "------------------------------------------\n";
		output += "ID\tName\t\tPrice\tQuantity\n";
		output += "------------------------------------------\n";
		while(rs.next()) {
			output +="|" + rs.getInt("clothes_id") + 
					"\t|" + rs.getString(2) + 
					"\t|" + rs.getDouble(3) + 
					"\t|" + rs.getInt(4) + "\t|\n";
		}
		
		output += "------------------------------------------\n";
		
		return output;
	}

	public static String getbyId(int id) throws SQLException {
		String query = "select * from clothes where clothes_id = ?";
		
		String output = "";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			output += "\n\n------------------------------------------\n";
			output += "|ID\t|Name\t|Price\t|Quantity|\n";
			output += "------------------------------------------\n";
			output += "|" + rs.getInt("clothes_id") + 
					"\t|" + rs.getString(2) + 
					"\t|" + rs.getDouble(3) + 
					"\t|" + rs.getInt(4) + "\t|\n";
			output += "------------------------------------------\n";
		}
		else{
			output += "\n\n **** No Record Found **** \n\n";
		}
		
		return output;
	}

	public static String getbyName(String name) throws SQLException {
		String query = "select * from clothes where clothes_name like ?";
		
		String output = "";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, "%" + name + "%");
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			output += "\n\n------------------------------------------\n";
			output += "|ID\t|Name\t|Price\t|Quantity|\n";
			output += "------------------------------------------\n";
			output += "|" + rs.getInt("clothes_id") + 
					"\t|" + rs.getString(2) + 
					"\t|" + rs.getDouble(3) + 
					"\t|" + rs.getInt(4) + "\t|\n";
			output += "------------------------------------------\n";
		}
		else{
			output += "\n\n **** No Record Found **** \n\n";
		}
		
		return output;
	}

	public static String add(int id, String name, double price, int quantity) throws SQLException {
		String query = "insert into clothes values(?,?,?,?)";
		
		String output = "";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setDouble(3, price);
		ps.setInt(4, quantity);
		
		int i = ps.executeUpdate();
		
		if(i>0)
			output += "Insert Successful";
		else
			output += "Insertion Failed";
		
		return output;
	}

	public static String updateName(int id, String name) throws SQLException {
		String query = "update clothes set clothes_name = ? where clothes_id = ?";
		
		String output = "";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, name);
		ps.setInt(2, id);
		
		int i = ps.executeUpdate();
		
		if(i>0)
			output += "Update Successful";
		else 
			output += "Update Failed";
		
		return output;
	}

	public static String updatePrice(int id, double price) throws SQLException {
		String query = "update clothes set price = ? where clothes_id = ?";
		
		String output = "";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setDouble(1, price);
		ps.setInt(2, id);
		
		int i = ps.executeUpdate();
		
		if(i>0)
			output += "Update Successful";
		else 
			output += "Update Failed";
		
		return output;
	}

	public static String updateQuantity(int id, int quantity) throws SQLException {
		String query = "update clothes set quantity = ? where clothes_id = ?";
		
		String output = "";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, quantity);
		ps.setInt(2, id);
		
		int i = ps.executeUpdate();
		
		if(i>0)
			output += "Update Successful";
		else 
			output += "Update Failed";
		
		return output;
	}	
	
	public static String delete(int id) throws SQLException {
		String query = "delete from clothes where clothes_id = ?";
		
		String output = "";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id);
		
		int i = ps.executeUpdate();
		
		if(i>0)
			output += "Delete Successful";
		else 
			output += "Delete Failed";
		
		return output;
	}
}