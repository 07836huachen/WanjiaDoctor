package cn.itcast.itcaststore.web.servlet.manager;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.itcaststore.domain.User;
import cn.itcast.itcaststore.exception.ActiveUserException;
import cn.itcast.itcaststore.service.UserService;
import cn.itcast.itcaststore.utils.IdUtils;

/**
 *	后台添加用户的servlet
 */
public class AddUserServlet extends HttpServlet{

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
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		String email = req.getParameter("email");
		String telephone = req.getParameter("telephone");
		String introduce = req.getParameter("introduce");
		String activecode = req.getParameter("activecode");
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
		//调用addUser方法
		uService.addUser(bean);
		
		
		req.getRequestDispatcher("/manager/ListUserServlet").forward(req, resp);
	}
}
