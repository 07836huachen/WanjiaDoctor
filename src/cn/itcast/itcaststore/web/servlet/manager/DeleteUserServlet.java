package cn.itcast.itcaststore.web.servlet.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.itcaststore.service.UserService;


/**
 * 
 *	后台删除用户的servlet
 */
public class DeleteUserServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UserService uService = new UserService();
		//获取请求参数，用户id
		String id = req.getParameter("id");

		//调用dao层方法
		uService.deleteUser(id);
		
		req.getRequestDispatcher("/manager/ListUserServlet").forward(req, resp);
	}
}
