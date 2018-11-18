package com.bmpl.sms.utils;

public interface SQLConstants {
//	String LOGIN_QUARY = "select userid,password,checkfirstlogin from user_mst where userid = ? and password = ?;";
	
	String LOGIN_QUARY = "select user_mst.userid,user_mst.password,role_mst.rolename,"
			+ "right_mst.rightname,right_mst.screen,user_mst.checkfirstlogin from user_mst,role_mst,right_mst,"
			+ "user_role_mapping,role_right_mapping where user_mst.uid = "
			+ "user_role_mapping.uid and role_mst.roleid = user_role_mapping.roleid "
			+ "and role_mst.roleid = role_right_mapping.roleid and right_mst.rightid "
			+ "= role_right_mapping.rightid and userid = ? and password = ? ;";

	String CHECK_FRIST_LOGIN_QUARY = "update user_mst set userid = ?,password = ?,checkfirstlogin = 'true' where uid=1;";
	String PICKIMAGE_QUARY = "select image,description,coname from company where imagename = ?";
	String COMMON_GENRIC_INSERT_QUARY = "insert into common_genric(description,value,status,key) values (?,?,?,?);";
}
