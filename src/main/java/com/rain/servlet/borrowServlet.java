package com.rain.servlet;

import com.rain.bean.AdminBean;
import com.rain.dao.AdminDao;
import com.rain.dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class borrowServlet
 */
@WebServlet("/borrowServlet")
public class borrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public borrowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		//璁剧疆缂栫爜绫诲瀷
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		BookDao bookdao = new BookDao();
		//涓轰簡鍖哄垎鍊熶功鍜岃繕涔︾殑鍔熻兘锛岃缃畉ip锛宼ip涓�锛岃〃绀哄�涔�		
		int tip = Integer.parseInt(request.getParameter("tip"));
		if(tip==1){
			//鑾峰彇鍥句功id
			int bid = Integer.parseInt(request.getParameter("bid"));
			HttpSession session = request.getSession();
			AdminBean admin = new AdminBean();
			//鑾峰彇鍒板瓨鍏ession鐨刟id璇昏�id
			String aid = (String)session.getAttribute("aid");
			AdminDao admindao = new AdminDao();
			//閫氳繃aid鑾峰彇鍒拌鑰呯殑淇℃伅
			admin = admindao.get_AidInfo2(aid);
			//灏嗗�闃呰褰曞瓨鍏ユ暟鎹〃
			bookdao.borrowBook(bid,admin);
			response.sendRedirect("/books/select.jsp");
		}else{
			//杩樹功鍔熻兘锛岃幏鍙栧�闃呰褰曠殑hid
			int hid = Integer.parseInt(request.getParameter("hid"));
			/**
			 * 杩樹功鍦ㄧ鐞嗗憳鍜岃鑰呯晫闈㈤兘鏈夛紝涓轰簡鍖哄垎锛岃缃簡show瀛楁锛宻how涓�琛ㄧず璇昏�鐣岄潰
			 */
			int show = Integer.parseInt(request.getParameter("show"));
			//璋冪敤杩樹功鍑芥暟锛屾敼鍙榮tatus瀛楁
			bookdao.borrowBook2(hid);
			if(show==1){
				response.sendRedirect("/books/borrow.jsp");
			}else{
				response.sendRedirect("/books/admin_borrow.jsp");
			}
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
