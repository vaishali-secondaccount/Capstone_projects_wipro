package JDBC_conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class Create_table {

	public static void main(String[] args)  {
		String url="jdbc:mysql://localhost:3306/mydb";
		String user="root";
		String password="root";
		
		// create table
		String sql="create table if not exists students(rollno int,"
				+ "name varchar(50),"
				+ " per int,"
				+ "email varchar(50))";
		// insert record
		String insertSQL="insert into students values(101,'Neeva Sharma',98,'abc@gmail.com'),"
				+ "(102,'Reeva Sharma',89,'Reeva@gmail.com'),"
				+ "(103,'Shiva Upadhyay',79,'shiva@gmail.com')";
		
		try
		{
			// driver connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,password);
			System.out.println("Connection created");
			// create statement for query execution
			Statement stmt=con.createStatement();
			// call create query using statement
			stmt.executeUpdate(sql);
			System.out.println("Students table created");
			// call insert query using statement
			int rowInserted=stmt.executeUpdate(insertSQL);
			if(rowInserted>0)
			{
				System.out.println("new Student record inserted ");
			}
			//Print table
			ResultSet rs=stmt.executeQuery("Select * from students");
			System.out.println("rollno\t name\t Per\t Email");
			// while loop for fetching all the table records
			while(rs.next())
			{
				int rollno=rs.getInt("rollno");
				String name=rs.getString("name");
				int per=rs.getInt("per");
				String email=rs.getString("email");
				System.out.println(rollno+" "+ name+" "+ per+" "+ email);
				//System.out.println("rollno:"+rollno+"\tName:"+ name+"Percentage:"+ per+"Email:"+ email);
			}
			
			stmt.close();
			con.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		
		

	}

}
