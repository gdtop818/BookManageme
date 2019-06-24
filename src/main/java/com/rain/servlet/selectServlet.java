package com.rain.servlet;

import com.rain.bean.BookBean;
import com.rain.dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class selectServlet
 */
@WebServlet("/selectServlet")
public class selectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//鍥犱负鍦ㄧ鐞嗗憳鐣岄潰鍜岃鑰呯晫闈㈤兘鏈夋煡鎵惧姛鑳斤紝涓轰簡灏嗘煡鎵剧殑缁撴灉杩斿洖姝ｇ‘鐨勯〉闈紝璁剧疆浜唗ip锛宼ip=1琛ㄧず绠＄悊鍛樼晫闈�		
		int tip = Integer.parseInt(request.getParameter("tip"));
		String name = request.getParameter("name");
		BookDao bookdao = new BookDao();
		ArrayList<BookBean> data = bookdao.getLikeList(name);
		//灏嗚幏鍙栫殑缁撴灉瀛樺叆璇锋眰涓�		
		request.setAttribute("data", data);
		String url = "";
		//杞彂涓嶅悓鐨勭晫闈�		
		if(tip==1){
			url = response.encodeURL("admin_book.jsp");
		}else{
			url = response.encodeURL("select.jsp");
		}
		//灏嗚姹傝浆鍙�	    
		request.getRequestDispatcher(url).forward(request, response);
	}

}
