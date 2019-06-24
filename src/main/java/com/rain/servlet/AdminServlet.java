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
import java.io.PrintWriter;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
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
		PrintWriter out = response.getWriter();
		//璁剧疆缂栫爜绫诲瀷
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		BookDao bookdao = new BookDao();
		//杩欓噷涓轰簡绠�崟锛岃缃簡tip锛岀敤鏉ュ尯鍒嗘槸淇敼瀵嗙爜鍔熻兘锛岃繕鏄慨鏀逛釜浜鸿祫鏂欑殑鍔熻兘锛宼ip=1涓轰慨鏀瑰瘑鐮�		
		int tip = Integer.parseInt(request.getParameter("tip"));
		//鑾峰彇鍙戣捣璇锋眰椤甸潰鐨勬枃浠跺悕绉帮紝杩欎釜鍦ㄥ搴旂殑jsp閲岄潰鐨勮〃鍗曞～鍐欙紝淇敼瀹屾垚鍚庡氨鍙互鐩存帴杩斿洖瀵瑰簲鐨勯〉闈�		
		String url = request.getParameter("url");
		HttpSession session = request.getSession();
		AdminBean adminbean = new AdminBean();
		//鑾峰彇瀛樺埌session鐨刟id
		String aid = (String) session.getAttribute("aid");
		AdminDao admindao = new AdminDao();
		//閫氳繃aid鑾峰彇鍒拌鑰呯殑淇℃伅
		adminbean = admindao.get_AidInfo2(aid);
		//淇敼瀵嗙爜
		if(tip==1){
			//鑾峰彇鍒拌緭鍏ョ殑鏃у瘑鐮侊紝鏂板瘑鐮�			
			String password = request.getParameter("password");
			String password2 = request.getParameter("password2");
			//鑾峰彇璇昏�鏁版嵁琛ㄤ腑鐨勫瘑鐮�			
			String old_password = adminbean.getPassword();
			//瀵规棫瀵嗙爜杩涜姣旇緝锛屽鏋滅浉鍚屽氨淇敼锛屼笉鐩稿悓灏辩洿鎺ラ�鍑�			
			if(old_password.equals(password)){
				admindao.updateUser(adminbean.getAid(), adminbean.getUsername(), password2, adminbean.getName(),
						adminbean.getEmail(), adminbean.getPhone(), adminbean.getLend_num(), adminbean.getMax_num());
				response.sendRedirect("/books/"+url+".jsp");
			}else{
				out.write("<script type='text/javascript'>alert('password error');location.href='"+url+".jsp';  </script>");
				
			}
		}else{
			//淇敼涓汉璧勬枡
			//鑾峰彇杈撳叆鐨勪俊鎭�			
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			//淇敼杈撳叆鐨勪俊鎭埌鏁版嵁琛ㄤ腑
			admindao.updateUser(adminbean.getAid(), adminbean.getUsername(), adminbean.getPassword(), name,
					email, phone, adminbean.getLend_num(), adminbean.getMax_num());
			response.sendRedirect("/books/"+url+".jsp");
		}
	}

}
