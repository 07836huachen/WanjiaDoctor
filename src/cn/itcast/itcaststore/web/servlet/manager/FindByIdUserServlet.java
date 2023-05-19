package cn.itcast.itcaststore.web.servlet.manager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.itcaststore.domain.User;
import cn.itcast.itcaststore.service.UserService;

/**
 * 
 *	后台根据id查询用户的servlet
 */
public class FindByIdUserServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UserService uService = new UserService();
		//获取用户id
		String id = req.getParameter("id");
		User user = uService.findUserById(id);
		
		req.setAttribute("u", user);
		
		req.getRequestDispatcher("/admin/users/edit.jsp").forward(req, resp);
	}
}
