package com.fjh.vip.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fjh.domain.vip;
import com.fjh.utils.DBUtilManager;

public class VipDao {
	public ResultSet selectvip(vip v) {//��Ա��ѯ
		Connection conn = DBUtilManager.getconn();
		Statement st = null;
		ResultSet rs = null;
       System.out.println(v.getName()+v.getPhone());
		if (v.getName().equals("")) {//���ݵ绰��
			try {
				st = conn.createStatement();
				String sql = "select * from vip Where phone ='" + v.getPhone()+ "'";
				System.out.println("sql=" + sql);
				rs = st.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
			}
		} 
		else {

			try {//��������ģ����
				st = conn.createStatement();
				String sql = "select * from vip where name like '%"+v.getName()+"%'";
				System.out.println("sql=" + sql);
				rs = st.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
			}
		}

		return rs;
	}

	public ResultSet selectvip2(vip v) {//ȫԱ��
		Connection conn = DBUtilManager.getconn();
		Statement st = null;
		ResultSet rs = null;
		System.out.println("��ѯȫԱ");
		if (v == null) {
			try {
				st = conn.createStatement();
				String sql = "select * from vip ";
				System.out.println("sql=" + sql);
				rs = st.executeQuery(sql);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				

			}
		}
		return rs;
	}


	public ResultSet selectvip3(vip v) {//�޸�
		Connection conn = DBUtilManager.getconn();
		Statement st = null;
		ResultSet rs = null;
		System.out.println("�޸Ļ�Ա��Ϣ");
			try {
				st = conn.createStatement();
				String sql = "Update vip Set  name='"+v.getName() +"',sex='"+v.getSex()+"' , mima = '"+v.getMima()+"' , phone = '"+v.getPhone()+"' , idcard = '"+v.getIdcard()+"'    Where vipid ="+v.getVipid()+"";
				System.out.println("sql=" + sql);
				int num = st.executeUpdate(sql);
			    if (num > 0) {
				         System.out.println("��Ա�Ѿ��޸���" + num + "������");
			   	 
			 }					
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {			 
					 st.close();
					 conn.close();
				} catch (SQLException e1) {
					 
					e1.printStackTrace();
				}
	
			}
		
		return rs;
	}
	

    public void deletevip(vip v){//ɾ��
    	Connection conn = DBUtilManager.getconn();
    	Statement st = null;
    	    try {
				st = conn.createStatement();
		        String sql = "delete vip where name = '"+v.getName()+"'";
				System.out.println(sql);
				  int a = st.executeUpdate(sql);
				
				System.out.println("�ɹ�ɾ��"+a+"����¼");
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			finally {
				
			}		
    	   
    	   
       }


}