package com.fjh.pay.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fjh.domain.Roommsg;
import com.fjh.utils.DBUtilManager;

public class payDatechange {
	public String updatedate(String roomid){
		
	  	  Connection conn = DBUtilManager.getconn();
	  	  Statement st = null;	  	
	  	  ResultSet rs = null;
	  	  String sql ="";	  	
	  	  String msg = "";
	  	  try {
				st = conn.createStatement();										
			    sql ="update rooms set state='0' where roomid = '"+roomid+"'";			
				int i =st.executeUpdate(sql);
				System.out.println(roomid+"�ķ����״̬�Ѹ���"+i);
				sql = "update customer set lidian='0',exittime='"+gettime()+"' where roomid = '"+roomid+"'";
				int ii =st.executeUpdate(sql);
				System.out.println(roomid+"�ķ���Ĺ˿��Ѹ���Ϊ���"+ii);
				
		
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	       finally{
				
			}
	  	  
	  	  return msg;
	    }
	public String gettime() {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = sdf.format(now);
		return s;
	}
}
