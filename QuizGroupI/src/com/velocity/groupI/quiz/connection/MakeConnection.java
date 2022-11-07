package com.velocity.groupI.quiz.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MakeConnection {
	
Connection con = null;
	
	public Connection getConnectionInfo() throws SQLException
	{
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","MySQL123@");
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return con ;
	}

}
