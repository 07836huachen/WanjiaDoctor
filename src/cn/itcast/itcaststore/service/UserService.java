package cn.itcast.itcaststore.service;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.security.auth.login.LoginException;
import cn.itcast.itcaststore.dao.UserDao;
import cn.itcast.itcaststore.domain.Notice;
import cn.itcast.itcaststore.domain.User;
import cn.itcast.itcaststore.exception.ActiveUserException;
import cn.itcast.itcaststore.exception.RegisterException;
import cn.itcast.itcaststore.utils.MailUtils;

public class UserService {
	private UserDao dao = new UserDao();
	//添start
	//后台系统，查询所有用户
	public List<User> getAllUsers() {
		try {
			return dao.getAllUsers();
		} catch (SQLException e) {
			throw new RuntimeException("查询所有的用户失败！");
		}
	}
	
	// 添加用户(包括后台系统)
	public void addUser(User user) {
		try {
			dao.addUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加用户失败");
		}
	}
	//后台系统，根据id查找用户
	public User findUserById(String id) {
		try {
			return dao.findUserById(id);
		} catch (SQLException e) {
			throw new RuntimeException("根据id查找用户失败！");
		}
	}
	//后台系统，根据id修改用户
	public void updateUser(User bean) {
		try {
			System.out.print("bean的值为:"+bean);
			dao.updateUser(bean);
		} catch (SQLException e) {
//	throw new RuntimeException("根据id修改用户失败！");
			e.printStackTrace();
		}
	}	
	//后台系统，根据id删除用户
	public void deleteUser(String id) {
		try {
			dao.deleteUser(id);
		} catch (SQLException e) {
			throw new RuntimeException("根据id删除用户失败！");
		}
	}
	//添end
	
	// 注册操作
	public void register(User user) throws RegisterException {
		// 调用dao完成注册操作
		try {
			dao.addUser(user);
			// 发送激活邮件
			String emailMsg = "感谢您注册网上书城，点击"
					+ "<a href='http://localhost:8080/itcaststore/activeUser?activeCode="
					+ user.getActiveCode() + "'>&nbsp;激活&nbsp;</a>后使用。"
							+ "<br />为保障您的账户安全，请在24小时内完成激活操作";
			MailUtils.sendMail(user.getEmail(), emailMsg);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RegisterException("注冊失败");
		}
	}
	// 激活用户
	public void activeUser(String activeCode) throws ActiveUserException {
		try {
			// 根据激活码查找用户
			User user = dao.findUserByActiveCode(activeCode);
			if (user == null) {
				throw new ActiveUserException("激活用户失败");
			}
			// 判断激活码是否过期 24小时内激活有效.
			// 1.得到注册时间
			Date registTime = user.getRegistTime();//Date->String
			// 2.判断是否超时
			long time = System.currentTimeMillis() - registTime.getTime();
			if (time / 1000 / 60 / 60 > 24) {
				throw new ActiveUserException("激活码过期");
			}
			// 激活用户，就是修改用户的state状态
			dao.activeUser(activeCode);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ActiveUserException("激活用户失败");
		}
	}
	// 登录操作
	public User login(String username, String password) throws LoginException {
		try {
			//根据登录时表单输入的用户名和密码，查找用户
			User user = dao.findUserByUsernameAndPassword(username, password);
			//如果找到，还需要确定用户是否为激活用户
			if (user != null) {
				// 只有是激活才能登录成功，否则提示“用户未激活”
				if (user.getState() == 1) {
					return user;
				}
				throw new LoginException("用户未激活");
			}
			throw new LoginException("用户名或密码错误");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LoginException("登录失败");
		}
	}
}
