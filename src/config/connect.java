package config;

import java.sql.*;
import javax.swing.JOptionPane;
public class connect {
	public Connection con;
	public ResultSet rs;
	public Statement st;
	public PreparedStatement ps;
	
	public connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/menu",//nama database
			"root",//username database
			"");//password database
			st=con.createStatement(1004,1008);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,
			"error");
		}
	}
	
	public ResultSet execute(String query) {
		try{
			rs=st.executeQuery(query);
		}catch(Exception e) {
			
		}
		return rs;
	}
	
	public void insertData(String code, String name, int price, int stock) {
		try {
			ps = con.prepareStatement("INSERT INTO datamenu (code, name, price, stock) VALUES (?, ?, ?, ?)");
			ps.setString(1,code);
			ps.setString(2, name);
			ps.setInt(3, price);
			ps.setInt(4, stock);
			
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateData(String name, int price, int stock) {
		try {
			ps = con.prepareStatement("UPDATE datamenu SET price = ?, stock = ? WHERE name = ?");
			ps.setString(3, name);
			ps.setInt(1, price);
			ps.setInt(2, stock);
			
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet getAllData() {
		
		try {
			rs = st.executeQuery("SELECT * FROM datamenu");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rs;
		
	}
	
	public void deleteMenu(String name) {
		try {
			ps = con.prepareStatement("DELETE FROM datamenu WHERE name = ?");
			ps.setString(1, name);
			
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
