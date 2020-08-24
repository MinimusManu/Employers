package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import beans.Admin;
import servlets.User;

public class Admindao
{
    public static Connection getconnectiontodatabase()
    {
    	 Connection conn = null;
    	 try
    	 {
    		//Driver is required to connect to database
    		 Class.forName("com.mysql.cj.jdbc.Driver");
    		conn= DriverManager.getConnection("jdbc:mysql://localhost:3333/ecodersemployee","root","root");
    	 }
    	 catch(Exception e)
    	 {
    		 e.printStackTrace();
    	 }
		return conn;
    }
    public static int registeradmin(Admin a)
    {
    	 int result=0;
    	 try
    	 {
    		  //1. getting connected to database
 			
		       Connection conn = Admindao.getconnectiontodatabase();
		       
		    //2.Preparing the sql statement for the connection conn object
		       
		       PreparedStatement ps = conn.prepareStatement("insert into admin(username,password) value(?,?)");
		       
		    //3. telling ps to set the 1st ? as username and 2nd ? as password
		       
		       ps.setString(1,a.getUsername());
		       ps.setString(2,a.getPassword());
            //4. telling ps to execute the sql query 
		       
		      result = ps.executeUpdate();
		      conn.close();
    		 
    	 }
    	 catch(Exception e)
    	 {
    		 e.printStackTrace();
    	 }
    	 return result;
    }
    public static int loginadmin(String username, String password)
    {
    	 int result=0;
    	 try
    	 {
    		  //1. getting connected to database
 			
		       Connection conn = Admindao.getconnectiontodatabase();
		       
		    //2.Preparing the sql statement for the connection conn object
		       
		       PreparedStatement ps = conn.prepareStatement("select * from admin where username = ? and password = ?");
		       
		    //3. telling ps to set the 1st ? as username and 2nd ? as password
		       
		       ps.setString(1,username);
		       ps.setString(2,password);
            //4. telling ps to execute the sql query 
		       
		     ResultSet rs = ps.executeQuery();
		     if(rs.next())
		     {
		    	 result = 1 ;		     
		     }
		     conn.close();
		    
    	 }
    	 catch(Exception e)
    	 {
    		 e.printStackTrace();
    	 }
    	 return result;
    }

public static int insertuser(User u)
{
	 int result=0;
	 try
	 {
		  //1. getting connected to database
			
	       Connection conn = Admindao.getconnectiontodatabase();
	       
	    //2.Preparing the sql statement for the connection conn object
	       
	       PreparedStatement ps = conn.prepareStatement("insert into user( firstname,lastname, email, address, phone) value(?,?,?,?,?)");
	       
	    //3. telling ps to set the 1st ? as username and 2nd ? as password
	       
	       //ps.setInt(1,u.getId());
	       ps.setString(1,u.getFirstname());
	       ps.setString(2,u.getLastname());
	       ps.setString(3,u.getEmail());
	       ps.setString(4,u.getAddress());
	       ps.setInt(5,u.getPhone());
        //4. telling ps to execute the sql query 
	       
	      result = ps.executeUpdate();
	      conn.close();
		 
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 return result;
}

public static List<User> viewall( )
{
	 List<User> list = new ArrayList<User>();
	 try
	 {
		  //1. getting connected to database
			
	       Connection conn = Admindao.getconnectiontodatabase();
	       
	    //2.Preparing the sql statement for the connection conn object
	       
	       PreparedStatement ps = conn.prepareStatement("select * from user");
	       
	    //3. telling ps to set the 1st ? as username and 2nd ? as password
	       
	       //ps.setInt(1,u.getId());
	      // ps.setString(1,u.getFirstname());
	       //ps.setString(2,u.getLastname());
	       //ps.setString(3,u.getEmail());
	       //ps.setString(4,u.getAddress());
	       //ps.setInt(5,u.getPhone());
        //4. telling ps to execute the sql query 
	       
	      ResultSet rs = ps.executeQuery();
	      while(rs.next())
	      {
	    	  User u = new User();
	    	  u.setId(rs.getInt(1));
	    	  u.setFirstname(rs.getString(2));
	    	  u.setLastname(rs.getString(3));
	    	  u.setEmail(rs.getString(4));
	    	  u.setAddress(rs.getString(5));
	    	  u.setPhone(rs.getInt(6));
	    	  list.add(u);
	      }
	      conn.close();
		 
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 return list;
}
public static User viewallempbyid(int id) 
{
	User u = new User();
	
	 try
	 {
		  //1. getting connected to database
			
	       Connection conn = Admindao.getconnectiontodatabase();
	       
	    //2.Preparing the sql statement for the connection conn object
	       
	       PreparedStatement ps = conn.prepareStatement("select * from user where id = ?");
	       
	    //3. telling ps to set the 1st ? as username and 2nd ? as password
	      // User u1= new User();
	       ps.setInt(1,id);
	      // ps.setString(1,u.getFirstname());
	       //ps.setString(2,u.getLastname());
	       //ps.setString(3,u.getEmail());
	       //ps.setString(4,u.getAddress());
	       //ps.setInt(5,u.getPhone());
        //4. telling ps to execute the sql query 
	       
	      ResultSet rs = ps.executeQuery();
	      if(rs.next())
	      {
	    	 
	    	  u.setId(rs.getInt(1));
	    	  u.setFirstname(rs.getString(2));
	    	  u.setLastname(rs.getString(3));
	    	  u.setEmail(rs.getString(4));
	    	  u.setAddress(rs.getString(5));
	    	  u.setPhone(rs.getInt(6));
	    	  //list.add(u);
	    	  
	      }
	      conn.close();
		 
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }

	return u;
}

public static List<User> viewallmultipleemployees(String s) 
{
	List<User> list = new ArrayList<User>();
	 try
	 {
		 User u = new User();
		  //1. getting connected to database
			
	       Connection conn = Admindao.getconnectiontodatabase();
	       
	    //2.Preparing the sql statement for the connection conn object
	       
	       PreparedStatement ps = conn.prepareStatement("select * from user where firstname =? or lastname =? or email =? or address=?");
	       
	    //3. telling ps to set the 1st ? as username and 2nd ? as password
	      // User u1= new User();
	       //ps.setInt(1,u1.getId());
	       ps.setString(1,s);
	       ps.setString(2,s);
	       ps.setString(3,s);
	       ps.setString(4,s);
	       //ps.setInt(5,u.getPhone());
        //4. telling ps to execute the sql query 
	       
	      ResultSet rs = ps.executeQuery();
	      while(rs.next())
	      {
	    	  //User u = new User();
	    	  u.setId(rs.getInt(1));
	    	  u.setFirstname(rs.getString(2));
	    	  u.setLastname(rs.getString(3));
	    	  u.setEmail(rs.getString(4));
	    	  u.setAddress(rs.getString(5));
	    	  u.setPhone(rs.getInt(6));
	    	  list.add(u);
	    	  
	      }
	      conn.close();
		 
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }

	return list;
}


public static int deleteempbyid(int id) 
{
	int result=0;
	
	 try
	 {
		  //1. getting connected to database
			
	       Connection conn = Admindao.getconnectiontodatabase();
	       
	    //2.Preparing the sql statement for the connection conn object
	       
	       PreparedStatement ps = conn.prepareStatement("delete from user where id = ?");
	       
	    //3. telling ps to set the 1st ? as username and 2nd ? as password
	      // User u1= new User();
	       ps.setInt(1,id);
	      // ps.setString(1,u.getFirstname());
	       //ps.setString(2,u.getLastname());
	       //ps.setString(3,u.getEmail());
	       //ps.setString(4,u.getAddress());
	       //ps.setInt(5,u.getPhone());
        //4. telling ps to execute the sql query 
	       
	      result = ps.executeUpdate();
		 
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }

	return result;
}
public static int updateuser(User u) 
{
	int result=0;
	try
	{
		 //1. getting connected to database
		
	       Connection conn = Admindao.getconnectiontodatabase();
	       
	    //2.Preparing the sql statement for the connection conn object
	       
	       PreparedStatement ps = conn.prepareStatement("update user set firstname =? ,lastname =? , email=?, address=?, phone=? where id =?");
	       
	    //3. telling ps to set the 1st ? as username and 2nd ? as password
	       
	       ps.setInt(6,u.getId());
	       ps.setString(1,u.getFirstname());
	       ps.setString(2,u.getLastname());
	       ps.setString(3,u.getEmail());
	       ps.setString(4,u.getAddress());
	       ps.setInt(5,u.getPhone());
     //4. telling ps to execute the sql query 
	       
	      result = ps.executeUpdate();
	      conn.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return result;
}
public static List<User> ascendingorderfirstname()
{
	List<User> list = new ArrayList<User>();
	 try
	 {
		  //1. getting connected to database
			
	       Connection conn = Admindao.getconnectiontodatabase();
	       
	    //2.Preparing the sql statement for the connection conn object
	       
	       PreparedStatement ps = conn.prepareStatement("select * from user order by firstname");
	       
	    //3. telling ps to set the 1st ? as username and 2nd ? as password
	       
	       //ps.setInt(1,u.getId());
	      // ps.setString(1,u.getFirstname());
	       //ps.setString(2,u.getLastname());
	       //ps.setString(3,u.getEmail());
	       //ps.setString(4,u.getAddress());
	       //ps.setInt(5,u.getPhone());
       //4. telling ps to execute the sql query 
	       
	      ResultSet rs = ps.executeQuery();
	      while(rs.next())
	      {
	    	  User u = new User();
	    	  u.setId(rs.getInt(1));
	    	  u.setFirstname(rs.getString(2));
	    	  u.setLastname(rs.getString(3));
	    	  u.setEmail(rs.getString(4));
	    	  u.setAddress(rs.getString(5));
	    	  u.setPhone(rs.getInt(6));
	    	  list.add(u);
	      }
	      conn.close();
		 
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	
	return list;
}

public static List<User> descendingorderfirstname()
{
	List<User> list = new ArrayList<User>();
	 try
	 {
		  //1. getting connected to database
			
	       Connection conn = Admindao.getconnectiontodatabase();
	       
	    //2.Preparing the sql statement for the connection conn object
	       
	       PreparedStatement ps = conn.prepareStatement("select * from user order by firstname desc");
	       
	    //3. telling ps to set the 1st ? as username and 2nd ? as password
	       
	       //ps.setInt(1,u.getId());
	      // ps.setString(1,u.getFirstname());
	       //ps.setString(2,u.getLastname());
	       //ps.setString(3,u.getEmail());
	       //ps.setString(4,u.getAddress());
	       //ps.setInt(5,u.getPhone());
       //4. telling ps to execute the sql query 
	       
	      ResultSet rs = ps.executeQuery();
	      while(rs.next())
	      {
	    	  User u = new User();
	    	  u.setId(rs.getInt(1));
	    	  u.setFirstname(rs.getString(2));
	    	  u.setLastname(rs.getString(3));
	    	  u.setEmail(rs.getString(4));
	    	  u.setAddress(rs.getString(5));
	    	  u.setPhone(rs.getInt(6));
	    	  list.add(u);
	      }
	      conn.close();
		 
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	
	return list;
}
}