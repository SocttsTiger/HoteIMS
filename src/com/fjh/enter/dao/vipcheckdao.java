package com.fjh.enter.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fjh.utils.DBUtilManager;

public class vipcheckdao {
	public String vipcheck(String vip){
		System.out.println("��Ա����֤..");
		Connection conn = DBUtilManager.getconn();
		String msg="��VIP�����ڣ�����ע���Ա�������ʷ���;";
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			String sql = "select * from vip Where idcard = '"+vip+"'";
			System.out.println("sql=" + sql);
			rs = st.executeQuery(sql);
			while(rs.next()){
				msg = "VIP����֤ͨ����";				
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			
		}
		
		return msg;
	}
}
