package com.fjh.vip.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fjh.domain.vip;
import com.fjh.vip.dao.VipDao;

/**
 * Servlet implementation class VipAdd
 */
@WebServlet("/VipAdd")//�޸Ļ�Ա��Ϣ
public class VipAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public VipAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("�����޸�");
		vip v  = new vip();
		v = null;
		VipDao rd = new VipDao();
		ResultSet rs = rd.selectvip2(v);
		String msg = "";
		try {
			while (rs.next()) {
				msg += "</form>"//�Ȱ�����Ǹ�������
					+"<form action='VipAlter' method='get'><tr>"
						+ "<td><input type='text' name='vipid' value='"+rs.getString(1)+"'</td>"
						+ "<td><input type='text' name='name' value='"+rs.getString(2)+"'></td>"
						+ "<td><input type='text' name='sex' value='"+rs.getString(3)+"'></td>"
						+ "<td><input type='text' name='mima' value='"+rs.getString(4)+"'></td>"
						+ "<td><input type='text' name='phone' value='"	+rs.getString(5)+"'></td>"
						+ "<td><input type='text' name='idcard' value='"+rs.getString(6)+"'></td>"
						+ "<td>"+rs.getString(7)+"</td>"
					+ "<td><input type='submit' value='�ύ'></td></tr></form>";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(msg);
		request.setAttribute("msg", msg);
		// session.setAttribute("msg", msg);
		request.getRequestDispatcher("/mainFramertlist3-3.jsp").forward(request, response);
	}
}
