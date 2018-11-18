package com.bmpl.sms.users.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.bmpl.sms.utils.CommonDAO;

public class StudentDAO {

	public void updateStudInfo(String name,String fathername,String address,String phoneno,String emailid,String interestedcourse,String preferbatchtime,String clgname,String counsname,String date ,String dob) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		 
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement("insert into student_details(name,father_name,address,phoneno,emailid,intrestedcourse,preferbatchtime,college_compnay_name,counselor_name,date,dob) values(?,?,?,?,?,?,?,?,?,cast(? as date),cast(? as date))");
			ps.setString(1, name);
			ps.setString(2, fathername);
			ps.setString(3, address);
			ps.setString(4, phoneno);
			ps.setString(5, emailid);
			ps.setString(6, interestedcourse);
			ps.setString(7, preferbatchtime);
			ps.setString(8, clgname);
			ps.setString(9, counsname);
			
			ps.setString(10,date);
			ps.setString(11,dob);
			ps.executeUpdate();
		
			
		}finally {
			
			if(rs != null)
			{
				
				rs.close();
			}
			if(ps != null)
			{
				ps.close();
			}
			if(con != null)
			{
				con.close();
			}
			
		}
	}
	
	public ArrayList<StudentDTO> getStudInfo() throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		 
		ArrayList<StudentDTO> list =  new ArrayList<StudentDTO>();
		StudentDTO sdto = new StudentDTO();
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement("select name,father_name,intrestedcourse,phoneno,emailid,dob,date,preferbatchtime,college_compnay_name,counselor_name,status from student_details;");
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				sdto = new StudentDTO();
			
				sdto.setName(rs.getString("name"));
				sdto.setFatherName(rs.getString("father_name"));
				sdto.setCourse(rs.getString("intrestedcourse"));
				sdto.setPhoneno(rs.getString("phoneno"));
				sdto.setEmail(rs.getString("emailid"));
				sdto.setDob(rs.getDate("dob"));
				sdto.setDate(rs.getDate("date"));
				sdto.setPrefBatchTime(rs.getString("preferbatchtime"));
				sdto.setCollageName(rs.getString("counselor_name"));
				sdto.setCounselorName(rs.getString("counselor_name"));
				sdto.setStatus(rs.getString("status"));
				
				list.add(sdto);
				
			}
		
			
		}finally {
			
			if(rs != null)
			{
				
				rs.close();
			}
			if(ps != null)
			{
				ps.close();
			}
			if(con != null)
			{
				con.close();
			}
			
		}
		return list;
	}
}
