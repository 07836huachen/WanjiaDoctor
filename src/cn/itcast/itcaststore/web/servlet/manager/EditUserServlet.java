package cn.itcast.itcaststore.web.servlet.manager;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.itcaststore.domain.User;
import cn.itcast.itcaststore.service.UserService;

/**
 * 
 *	后台修改用户的servlet
 */
public class EditUserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		UserService uService = new UserService();
		User bean = new User();
		//获取表单参数
		int id = Integer.parseInt(req.getParameter("id"));   // null
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		String email = req.getParameter("email");
		String telephone = req.getParameter("telephone");
		String introduce = req.getParameter("introduce");
		String activecode = req.getParameter("activeCode");
		String role=req.getParameter("role");
		int state = Integer.parseInt(req.getParameter("state"));
		//将当前时间设为添加用户的时间
		String registTime= req.getParameter("registTime");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date regist = null;
		try {
			regist = sdf.parse(registTime);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		bean.setId(id);
		bean.setUsername(username);
		bean.setPassword(password);
		bean.setGender(gender);
		bean.setEmail(email);
		bean.setTelephone(telephone);
		bean.setIntroduce(introduce);
		bean.setActiveCode(activecode);
		bean.setRole(role);
		bean.setState(state);
		bean.setRegistTime(regist);
		System.out.println("username的值为："+username);
		System.out.println("bean的值为："+bean);
		//调用dao层方法
		uService.updateUser(bean);
		
		req.getRequestDispatcher("/manager/ListUserServlet").forward(req, resp);
	}
}
