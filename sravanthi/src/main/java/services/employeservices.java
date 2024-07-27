package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import models.employe;

public class employeservices {
//Here we will write another two jdbc connections  create a statement and execution the statement and we will perform  curd operations
	private Connection conn;
//generate  super class constructor to flow of data

	 public employeservices(Connection conn) {
	super();
	this.conn = conn;
}
	
	
	//insertion
	//(modelname nickname)
	 public boolean addemploye(employe em) {
		 boolean f = false;
		 try {
			 String sql = "insert into datatable (name,email,password) values(?,?,?)";
			 PreparedStatement pmst = conn.prepareStatement(sql);
			 pmst.setString(1, em.getName());
			 pmst.setString(2, em.getEmail());
			 pmst.setString(3, em.getPassword());
//			 Here we are using integer i because for generating if loop
			 int i = pmst.executeUpdate();
			 if (i>0) {
				 f= true;
				
			}
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		 
		 return f; 
	 }

	//fetch all
	 //for fetching data we all have hetrogenous data that s why we are using list
	 public List<employe> fetchall(){
		 List<employe> li = new ArrayList<employe>();
		 employe e = null;
		 try {
			 String sql = "select * from datatable";
			 PreparedStatement pmst = conn.prepareStatement(sql);
		//when we are fetching all the data we use result set
			 ResultSet rs = pmst.executeQuery();
			 while (rs.next()) {
				e = new employe();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setPassword(rs.getString(4));
				li.add(e);
			}
				 
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return li; 
		 
	 }
	 
	 //fetch by id
	 public  employe fetchbyid( int id) {
		 employe em = null;
		 try {
		 String sql = "select * from datatable where id= ?";
		 PreparedStatement pmst = conn.prepareStatement(sql);
		 pmst.setInt(1, id);
	
		 ResultSet rs = pmst.executeQuery();
		 while (rs.next()) {
			 em =  new employe();
			 em.setId(rs.getInt(1));
			 em.setName(rs.getString(2));
			 em.setEmail(rs.getString(3));
			 em.setPassword(rs.getString(4));
			 
			
		}
		 
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		 return em ;
	 }
	 
	 //delete by id 
	 public boolean delbyid( int id) {
		 boolean h = false;
		 try {
			 String sql = "delete from datatable where id = ?";
			 PreparedStatement pmst = conn.prepareStatement(sql);
			 pmst.setInt(1, id);
			 int i = pmst.executeUpdate();
			 if (i>0) {
				 h = true;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return h;
	 }
	 
	
	
	
}
