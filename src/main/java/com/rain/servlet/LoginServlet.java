package com.rain.servlet;

import com.rain.bean.AdminBean;
import com.rain.dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if("admin".equals(username) && "123456".equals(password)) {
			ServletContext context = getServletContext();
			RequestDispatcher dispatcher = context.getNamedDispatcher("dispatcher");
			dispatcher.forward(req, res);
		}else {
			throw new RuntimeException("Login failed.");
		}
	}

	/**
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);

		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		AdminDao userdao = new AdminDao();
		boolean result = userdao.Login_verify(username, password);
		HttpSession session = request.getSession();
		if(result){
			AdminBean adminbean = new AdminBean();
			AdminDao admindao = new AdminDao();
			adminbean = admindao.getAdminInfo(username,password);
			session.setAttribute("aid", ""+adminbean.getAid());
			session.setMaxInactiveInterval(6000);
			if(adminbean.getStatus()==1){
				response.sendRedirect("/books/index2.jsp");
			}else{
				response.sendRedirect("/books/admin.jsp");
			}
		}else{
			session.setAttribute("state", "管理员");
			response.sendRedirect("/books/login.jsp");
		}*/

	}

