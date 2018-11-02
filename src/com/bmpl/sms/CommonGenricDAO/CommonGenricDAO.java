package com.bmpl.sms.CommonGenricDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bmpl.sms.CommonGenricDTO.CommonGenricDTO;
import com.bmpl.sms.utils.CommonDAO;
import com.bmpl.sms.utils.SQLConstants;

public class CommonGenricDAO {
	public boolean isUploaded(ArrayList<CommonGenricDTO> commonGenericDTO) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		boolean isuploaded = false;
		try {
			con = CommonDAO.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(SQLConstants.COMMON_GENRIC_INSERT_QUARY);
			for(CommonGenricDTO dto : commonGenericDTO) {
				ps.setString(1,dto.getDescription());
				ps.setString(2,dto.getValue());
				ps.setString(3,dto.getStatus());
				ps.setString(4,dto.getKey());
				ps.addBatch();
				}
			int result[] = ps.executeBatch();
			boolean fail = false;
			
			for(int r : result)
			{
				if(r<1)
				{
					fail = true;
					break;
				}
			}
			if(fail)
			{
				con.rollback();
			}
			else {
				con.commit();
				return true;
			}
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
		return isuploaded;		
	}
}
