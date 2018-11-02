package com.bmpl.sms.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bmpl.sms.utils.CommonDAO;
import com.bmpl.sms.utils.SQLConstants;

public class ImagePicker {

	//to get the image from the database by using the url of the image.
	public ImagePickerDTO pickImage() throws ClassNotFoundException, SQLException {

		String imagename = "leppywithheadphone";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ImagePickerDTO imagepickerdto = null;
	
		try {
		con = CommonDAO.getConnection();
		ps = con.prepareStatement(SQLConstants.PICKIMAGE_QUARY);
		ps.setString(1, imagename);
		rs = ps.executeQuery();
		
		if(rs.next())
		{
		imagepickerdto	=  new ImagePickerDTO();
		imagepickerdto.setConame(rs.getString("coname"));
		imagepickerdto.setDescription(rs.getString("description"));
		imagepickerdto.setImage(rs.getString("image"));
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
	
		return imagepickerdto;
	}

}
