package com.fjh.roomtype.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RoomtypeAdd
 */
@WebServlet("/RoomtypeAdd")
public class RoomtypeAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomtypeAdd() {
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
		System.out.println("�������");
        String msg = "<form action='/HotelMS/servlet/RoomtypeAddSub' method='post'><tr><td><input type='text' name='type'></td><td><input type='text' name='typename'></td><td><input type='text' name='customernum'></td><td><input type='text' name='price'></td><td><select name='bath'><option value='��'>��</option> <option value='��'>��</option></select> <br></td><td><select name='reticle'><option value='��'>��</option><option value='��'>��</option></select><br></td><td><input type='text' name='mark'></td><td><input name='add' type='submit' value='�ύ'></td></tr></form>";
        System.out.println(msg);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaa");
        request.setAttribute("msg", msg);
		request.getRequestDispatcher("/mainFramertlist3-6.jsp").forward(request, response);
	}

}
