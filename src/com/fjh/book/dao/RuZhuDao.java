package com.fjh.book.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fjh.domain.RoomtypeAdds;
import com.fjh.domain.YuDing;
import com.fjh.utils.DBUtilManager;

public class RuZhuDao {
	
	//������סע�ᡣ����
	  public void fangkeruzhu(YuDing yd){
		  
		   Statement st = null;
		   ResultSet rs = null;
		   //Statement st2 = null;
		   Statement st1 = null;
		   ResultSet rs1 = null;
		   Connection conn = DBUtilManager.getconn();
		   
		   try {
			st = conn.createStatement();
			st1 = conn.createStatement();
			//st2 = conn.createStatement();
			System.out.println("yd.getId()"+yd.getId());
			System.out.println("yd.getEnterState()="+yd.getEnterstate());
			String sql2 = "Update book Set enterstate = '"+yd.getEnterstate()+"' where bookid = "+yd.getId()+" ";
			
			String sql = "insert into customer(id,name,sex,idcard,entertime,exittime,roomid,phone,breakfirst,vip,lidian)values(sequence1.nextval,'"+yd.getNamee()+"','"+yd.getSex()+"','"+yd.getIdcard()+"','"+gettime()+"',null,'"+yd.getRoomid()+"','"+yd.getPhone()+"','"+yd.getBreakfirst()+"','"+yd.getVip()+"','1') "; 
			System.out.println("sqlruzhu="+sql);
			System.out.println("sql2="+sql2);		
			int num = st.executeUpdate(sql);// ���ص��Ǹ��µ�����
		   if (num > 0) {
			         System.out.println("���͸���ע����" + num + "������");	   				         
		 }	
		    int num1 = st1.executeUpdate(sql2);// ���ص��Ǹ��µ�����
		    if (num1 > 0) {
			         System.out.println("���ͳɹ�����ע����" + num + "������");	   				         
		 }	
		    sql = "update rooms set state = '3',time = '"+gettime()+"' where roomid='"+yd.getRoomid()+"'";
		   int i= st.executeUpdate(sql);
		    System.out.println("״̬�Ѹ���"+i);
			
		 } catch (SQLException e) {
			 
			e.printStackTrace();
		}finally {
			 try {			 
				 st.close();
				 conn.close();
			} catch (SQLException e1) {
				 
				e1.printStackTrace();
			}
	  
		}		

}
	  public String gettime() {
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String s = sdf.format(now);
			return s;
		}
}
