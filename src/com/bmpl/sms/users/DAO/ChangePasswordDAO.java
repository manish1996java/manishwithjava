package com.bmpl.sms.users.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bmpl.sms.users.DTO.RightDTO;
import com.bmpl.sms.users.DTO.UserDTO;
import com.bmpl.sms.utils.CommonDAO;
import com.bmpl.sms.utils.SQLConstants;

public class ChangePasswordDAO {

	public void changePass(String userid,String password) throws ClassNotFoundException, SQLException {

		
		Connection con = null;
		PreparedStatement ps = null; 
		
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(SQLConstants.CHECK_FRIST_LOGIN_QUARY);
			ps.setString(1, userid);
			ps.setString(2, password);
			ps.executeUpdate();
		
		}finally {
			
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
}
