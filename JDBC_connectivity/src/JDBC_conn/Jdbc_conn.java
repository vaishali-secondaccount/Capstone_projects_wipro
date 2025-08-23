package JDBC_conn;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.sql.*;

public class Jdbc_conn {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//import packages
		// create object for connection
		// Retrive data
		// close connection
		String url="jdbc:mysql://localhost:3306/mydb";
		String user="root";
		String password="root";
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection(url,user,password);
		System.out.println("Connection created");
		//create statement
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("Select * from Emp");
		System.out.println("ID\t name\t Salary");
		while(rs.next())
		{
			int id=rs.getInt("id");
			String name=rs.getString("name");
			int salary=rs.getInt("salary");
			System.out.println(id+" "+ name+" "+ salary);
			//System.out.println("ID:"+id+"\tName:"+ name+"Salary:"+ salary);
		}
		rs.close();
		stmt.close();
		con.close();
		
		

	}

}
