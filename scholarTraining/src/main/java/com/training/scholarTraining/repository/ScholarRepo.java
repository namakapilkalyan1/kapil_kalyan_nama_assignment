

package com.training.scholarTraining.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.training.scholarTraining.model.Scholar;

//Connect to DB, Do DB Operation, Return the data/result
@Repository
public class ScholarRepo {
	public List<Scholar> scholars = new ArrayList<>();
	
	public List<Scholar> getAllScholars() {
		ResultSet rs=null;
		
		//CONNECT TO DB
		//EXECUTE QUERY
		try {
		      // This will load the MySQL driver, each DB has its own driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      // Setup the connection with the DB
		      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		      System.out.println("connection established");
		      Statement stmt = conn.createStatement();
		      //stmt.execute("create table teacher1 (id integer(10),name varchar(20))");
		      //System.out.println("table established");
		      //stmt.execute("insert into teacher1 values (10,'kk')");
		     // System.out.println("insertion established");
		      stmt.execute("select * from scholar");
		      rs=stmt.getResultSet();
		      while(rs.next())
		      {
		    	  Scholar scholar1 = new Scholar();
		    	  scholar1.setiNumber(rs.getString("id"));
		  		scholar1.setCourseDuration(rs.getInt("duration"));
		  		
		  		scholar1.setJoiningYear(rs.getInt("joiningyear"));
		  		scholar1.setName(rs.getString("name"));
		  		scholars.add(scholar1);
		    	  
		      }
		      
		    }
		    catch (Exception e) {
				// TODO: handle exception
		    	System.out.println(e);
		    	
			}
		    
		

		/*Scholar scholar1 = new Scholar();
		scholar1.setiNumber("I327953");
		scholar1.setCourseDuration(2);
		scholar1.setJoiningYear(2016);
		scholar1.setName("Diptesh");

		Scholar scholar2 = new Scholar();
		scholar2.setiNumber("I317953");
		scholar2.setName("Diptesh Sil");
		scholar2.setCourseDuration(4);
		scholar2.setJoiningYear(2020);

		scholars.add(scholar1);
		scholars.add(scholar2);*/
		
		
		return scholars;
	}

	public Scholar getScholar(String id) {
       ResultSet rs=null;
		
		//CONNECT TO DB
		//EXECUTE QUERY
		try {
		      // This will load the MySQL driver, each DB has its own driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      // Setup the connection with the DB
		      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		      System.out.println("connection established");
		      Statement stmt = conn.createStatement();
		      //stmt.execute("create table teacher1 (id integer(10),name varchar(20))");
		      //System.out.println("table established");
		      //stmt.execute("insert into teacher1 values (10,'kk')");
		     // System.out.println("insertion established");
		      stmt.execute("select * from scholar");
		      rs=stmt.getResultSet();
		      while(rs.next())
		      {
		    	  if(rs.getString("id").equals(id))
		    	  {
		    		  Scholar scholar2 = new Scholar();
			    	  scholar2.setiNumber(rs.getString("id"));
			  		scholar2.setCourseDuration(rs.getInt("duration"));
			  		
			  		scholar2.setJoiningYear(rs.getInt("joiningyear"));
			  		scholar2.setName(rs.getString("name"));
			  		return scholar2;
			  		
		    	  }
		    	  
		      }
		      
		    }
		    catch (Exception e) {
				// TODO: handle exception
		    	System.out.println(e);
		    	
			}
		
		
		  
		/*Scholar scholar3 = new Scholar();
		scholar3.setiNumber(id);
		scholar3.setName("Kapil");
		scholar3.setCourseDuration(2);
		scholar3.setJoiningYear(2020);
		return scholar3;*/
		return null;
	}

	public void addScholar(Scholar scholar) {
		//System.out.println(scholar.getiNumber() + " " + scholar.getName() + " " + scholar.getCourseDuration());
PreparedStatement prepStmt = null;
		
		try {
		      // This will load the MySQL driver, each DB has its own driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      // Setup the connection with the DB
		      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		      System.out.println("connection established");
		     //Statement stmt = conn.createStatement();
		      //stmt.execute("create table teacher1 (id integer(10),name varchar(20))");
		      //System.out.println("table established");
		      //stmt.execute("insert into teacher1 values (10,'kk')");
		     // System.out.println("insertion established");
		      
		      String sqlStmt = "insert into scholar values(?,?,?,?)";
		      prepStmt = conn.prepareStatement(sqlStmt);
		      prepStmt.setString(1,scholar.getiNumber());
		      
		      prepStmt.setInt(2, scholar.getCourseDuration());
		      prepStmt.setInt(3, scholar.getJoiningYear());
		      prepStmt.setString(4,scholar.getName());
		      
            // prepStmt.setString(1,"I524740");
		      
		      //prepStmt.setInt(2,2);
		      //prepStmt.setInt(3,2020);
		     // prepStmt.setString(4,"kapil");
		      
		      
		      int row = prepStmt.executeUpdate();
		      System.out.println("rows inserted"+row);
		      System.out.println("sucessfully inserted");
		      
		    }
		    catch (Exception e) {
				// TODO: handle exception
		    	System.out.println(e);
		    	
			}
		
		
	}

	public void deleteScholar(String id) {
		// TODO Auto-generated method stub
		PreparedStatement prepStmt = null;
		
		try {
		      // This will load the MySQL driver, each DB has its own driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      // Setup the connection with the DB
		      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		      System.out.println("connection established");
		     //Statement stmt = conn.createStatement();
		      //stmt.execute("create table teacher1 (id integer(10),name varchar(20))");
		      //System.out.println("table established");
		      //stmt.execute("insert into teacher1 values (10,'kk')");
		     // System.out.println("insertion established");
		      
		      String sqlStmt = "DELETE FROM scholar where id=?";
		      prepStmt = conn.prepareStatement(sqlStmt);
		      prepStmt.setString(1,id);
		      int row = prepStmt.executeUpdate();
		      System.out.println("rows affected"+row);
		      System.out.println("sucessfully deleted");
		      
		    }
		    catch (Exception e) {
				// TODO: handle exception
		    	System.out.println(e);
		    	
			}
		
		
	}

}