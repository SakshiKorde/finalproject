package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.Part;

import com.bean.CitizenBean;
import com.connection.DBConnection;

public class CitizenDao {
	
	Connection connection=null;
	Boolean resultStatus=Boolean.FALSE;
	PreparedStatement ps;
	ResultSet rs;
    Statement st=null;
    String sql;
    boolean flag = false;

	
	public boolean InsertCitizenData(CitizenBean b) {
		sql = "insert into citizen(name,address,email,mobileno,dob,password,status) values(?,?,?,?,?,?,?)";

		Connection con = DBConnection.getConnection();

		try {
			ps = con.prepareStatement(sql);
			
			
			ps.setString(1, b.getName());
			ps.setString(2, b.getAddress());
			ps.setString(3, b.getEmail());
			ps.setString(4, b.getMobileno());
			ps.setString(5, b.getDob());
			ps.setString(6, b.getPassword());
			ps.setString(7, b.getStatus());

			int index = ps.executeUpdate();

			if (index > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return flag;
	}
	
	public CitizenBean CheckCitizen(String email, String password) {
		CitizenBean bean=new CitizenBean();
		sql = "select * from citizen where email='" + email + "' and password='" + password + "' ";
		int flag = 0;
		try {
			Statement stmt = DBConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				flag = 1;
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));					
				bean.setAddress(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setMobileno(rs.getString(5));
				bean.setDob(rs.getString(6));
				bean.setPassword(rs.getString(7));
				bean.setStatus(rs.getString(8));
			
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(flag ==1)
			return bean;
		else 
			return null;
	}

	public boolean UpdateWalkingStatus(int id, String status) {
		if(status.equalsIgnoreCase("Approve"))
			status="Pending";
		else
			status="Approve";
		
		String sql="update joinpartner set status=? where id=?";
		
		try {
			ps=DBConnection.getConnection().prepareStatement(sql);
			ps.setString(1, status);
			ps.setInt(2, id);
			
			int index=ps.executeUpdate();
			if(index>0)
			{
				flag=true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return flag;
	}

	public ResultSet SelectWalking() {
		ResultSet rs= null;
		String sql ="Select * from joinpartner";
		try {
			PreparedStatement pstmt = DBConnection.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}

	public String extractFileName(Part part) {
		final String partHeader = part.getHeader("content-disposition");
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
		return null;
	}

	public boolean AddEvidence(CitizenBean b) {
		sql = "insert into evidence(name,evdesc,image,imagename) values(?,?,?,?)";

		Connection con = DBConnection.getConnection();

		try {
			ps = con.prepareStatement(sql);	
			
			ps.setString(1, b.getName());
			ps.setString(2, b.getEvdesc());
			ps.setBlob(3, b.getImage());
			ps.setString(4, b.getImage_name());

			int index = ps.executeUpdate();

			if (index > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return flag;
	}

	public boolean update1(String email, String generatedotp) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql = "INSERT INTO userlogin(email,otp) VALUES(?,?)";
		int update = 0;
		Connection connection = (Connection) DBConnection.getConnection();
		try {
			PreparedStatement pstmt=(PreparedStatement) connection.prepareStatement(sql);
			
			pstmt.setString(1, email);
			
			pstmt.setString(2, generatedotp);
		
			
			int index=pstmt.executeUpdate();
			if(index>0)
			{
				flag=true;
			}
		}
		catch (Exception ex) {
			System.out.println (ex);
		}
	
		return flag;
	}

	public static String selectotp(String sql1) {
		// TODO Auto-generated method stub
				String genotp = "";
				Connection connection = (Connection) DBConnection.getConnection();
				try {
					Statement st=connection.createStatement();
					
				
					ResultSet rs = st.executeQuery(sql1);
					while(rs.next()){
						genotp = rs.getString(1);
					System.out.println(genotp);
					}
				}
				catch (Exception ex) {
					System.out.println (ex);
				}
				
				return genotp;
	}

	public static String selectotp1(String sql2) {
		// TODO Auto-generated method stub
				String genotp = "";
				Connection connection = (Connection) DBConnection.getConnection();
				try {
					Statement st=connection.createStatement();
					
					ResultSet rs = st.executeQuery(sql2);
					while(rs.next()){
						genotp = rs.getString(1);
					System.out.println(genotp);
					}
				}
				catch (Exception ex) {
					System.out.println (ex);
				}
			
				return genotp;
	}

	public CitizenBean CheckEmail(String email) {
		CitizenBean bean=new CitizenBean();
		sql = "select * from citizen where email='" + email + "'";
		int flag = 0;
		try {
			Statement stmt = DBConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				flag = 1;
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));					
				bean.setAddress(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setMobileno(rs.getString(5));
				bean.setDob(rs.getString(6));
				bean.setPassword(rs.getString(7));
				bean.setStatus(rs.getString(8));
			
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(flag ==1)
			return bean;
		else 
			return null;
	}

	public boolean UpdateCitizenPassword(String oldpass, String newpass) {
		sql="update citizen set password=? where password='"+oldpass+"'";
				
				Connection con = DBConnection.getConnection();
				
				try {
					ps=con.prepareStatement(sql);
					ps.setString(1, newpass);
					
					int index=ps.executeUpdate();
					
					if(index>0)
					{
						flag=true;
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				return flag;
			}


}
