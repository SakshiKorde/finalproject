package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.Part;

import com.bean.CitizenBean;
import com.bean.PoliceBean;
import com.connection.DBConnection;

public class PoliceDao {
	
	Connection connection=null;
	Boolean resultStatus=Boolean.FALSE;
	PreparedStatement ps;
	ResultSet rs;
    Statement st=null;
    String sql;
    boolean flag = false;

	public boolean InsertPoliceData(PoliceBean b) {
		sql = "insert into police(name,address,email,mobileno,dob,password,uid,status) values(?,?,?,?,?,?,?,?)";

		Connection con = DBConnection.getConnection();

		try {
			ps = con.prepareStatement(sql);
			
			
			ps.setString(1, b.getName());
			ps.setString(2, b.getAddress());
			ps.setString(3, b.getEmail());
			ps.setString(4, b.getMobileno());
			ps.setString(5, b.getDob());
			ps.setString(6, b.getPassword());
			ps.setString(7, b.getUid());
			ps.setString(8, b.getStatus());

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
	
	public PoliceBean CheckPolice(String email, String password) {
		PoliceBean bean=new PoliceBean();
		sql = "select * from police where email='" + email + "' and password='" + password + "' ";
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
				bean.setUid(rs.getString(8));
				bean.setStatus(rs.getString(9));
			
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(flag ==1)
			return bean;
		else 
			return null;
	}

	public boolean AddSaftyTips(PoliceBean b) {
		sql = "insert into safetytips(safetytips,video) values(?,?)";

		Connection con = DBConnection.getConnection();

		try {
			ps = con.prepareStatement(sql);
			
			
			ps.setString(1, b.getSafetytips());
			ps.setString(2, b.getVideo());

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

	public boolean AddPreviousCriminalRecord(PoliceBean b) {
		sql = "insert into criminal(criminalname,address,age,crime,name,uniqueid,image,imagename,nooffir,contact,status) values(?,?,?,?,?,?,?,?,?,?,?)";

		Connection con = DBConnection.getConnection();

		try {
			ps = con.prepareStatement(sql);
			
			
			ps.setString(1, b.getCriminalname());
			ps.setString(2, b.getAddress());
			ps.setString(3, b.getAge());
			ps.setString(4, b.getCrime());
			ps.setString(5, b.getName());
			ps.setString(6, b.getUniqueid());
			ps.setBlob(7, b.getImage());
			ps.setString(8, b.getImage_name());
			ps.setBlob(9, b.getImage());
			ps.setString(10, b.getImage_name());
			ps.setString(11, b.getStatus());

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

	public boolean AddWalkingPartner(CitizenBean b) {
		sql = "insert into walkingpartner(name,area,location,status) values(?,?,?,?)";

		Connection con = DBConnection.getConnection();

		try {
			ps = con.prepareStatement(sql);
			
			
			ps.setString(1, b.getName());
			ps.setString(2, b.getArea());
			ps.setString(3, b.getLocation());			
			ps.setString(4, b.getStatus());

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

	public boolean AddJoinPartner(CitizenBean b) {
		sql = "insert into joinpartner(name,area,partnername,msg,status) values(?,?,?,?,?)";

		Connection con = DBConnection.getConnection();

		try {
			ps = con.prepareStatement(sql);
			
			
			ps.setString(1, b.getName());
			ps.setString(2, b.getArea());
			ps.setString(3, b.getPartnername());
			ps.setString(4, b.getMsg());
			ps.setString(5, b.getStatus());

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

	public boolean AddSpotCrimeData(PoliceBean b) {
		sql = "insert into spotcrime(name,area,date,time,image,imagename,location,type,status) values(?,?,?,?,?,?,?,?,?)";

		Connection con = DBConnection.getConnection();

		try {
			ps = con.prepareStatement(sql);
			
			
			ps.setString(1, b.getName());
			ps.setString(2, b.getArea());
			ps.setString(3, b.getDate());
			ps.setString(4, b.getTime());
			ps.setBlob(5, b.getImage());
			ps.setString(6, b.getImage_name());
			ps.setString(7, b.getLocation());
			ps.setString(8, b.getType());
			ps.setString(9, b.getStatus());

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

	public boolean DeleteSpotCrime(int id) {
		String sql="delete from spotcrime where id='"+id+"'";
		 Connection con=DBConnection.getConnection();
		 try {
			ps=con.prepareStatement(sql);
			int index =ps.executeUpdate();
			if(index>0)
			{
				flag=true;
			}
			else
			{
				flag=false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
			return flag;
	}

	public boolean InsertFacebookData(PoliceBean b) {
		sql = "insert into feedback(name,feedback,status) values(?,?,?)";

		Connection con = DBConnection.getConnection();

		try {
			ps = con.prepareStatement(sql);
			
			
			ps.setString(1, b.getName());
			ps.setString(2, b.getFeedback());
			ps.setString(3, b.getStatus());

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

	public boolean DeleteSafetyTips(int id) {
		
			String sql="delete from safetytips where id='"+id+"'";
			 Connection con=DBConnection.getConnection();
			 try {
				ps=con.prepareStatement(sql);
				int index =ps.executeUpdate();
				if(index>0)
				{
					flag=true;
				}
				else
				{
					flag=false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 
				return flag;
		
	}

	public boolean InsertAlertData(PoliceBean b) {
		sql = "insert into alert(email,name,msg) values(?,?,?)";

		Connection con = DBConnection.getConnection();

		try {
			ps = con.prepareStatement(sql);
			
			
			ps.setString(1, b.getEmail());
			ps.setString(2, b.getName());
			ps.setString(3, b.getMsg());
			
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

	public boolean InsertLocationData(PoliceBean b) {
		sql = "insert into gpslocation(name,email,location) values(?,?,?)";

		Connection con = DBConnection.getConnection();

		try {
			ps = con.prepareStatement(sql);
			
			
			ps.setString(1, b.getName());
			ps.setString(2, b.getEmail());
			ps.setString(3, b.getLocation());
			
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

}
