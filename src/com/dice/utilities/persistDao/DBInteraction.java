package com.dice.utilities.persistDao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInteraction {

	static Connection con;
	static Statement st ;
	
	public static void connect()
	{
		
		try {
			System.out.println("Driver loading.");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded successfully.");
			String url ="jdbc:mysql://localhost/dice_game_bd";
			con = DriverManager.getConnection(url, "root", "");
			st = con.createStatement();	
			
			System.out.println("connecter");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static ResultSet select(String sql)
	{
		ResultSet rs = null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public static int Maj(String sql)
	{
		int nb=0;
		try {
			 nb=st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nb;
	}
	
	public static void disconnect()
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
