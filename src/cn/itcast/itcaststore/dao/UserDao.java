package cn.itcast.itcaststore.dao;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.itcaststore.domain.Notice;
import cn.itcast.itcaststore.domain.User;
import cn.itcast.itcaststore.utils.DataSourceUtils;

public class UserDao {
	//添start
	//后台系统，查询所有用户
	public List<User> getAllUsers() throws SQLException {
		String sql = "select * from user order by registTime desc";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanListHandler<User>(User.class));
	}
	// 后台系统,添加用户
	public void addUser1(User u) throws SQLException {
		String sql = "insert into user(username,password,gender,email,telephone,introduce,activecode,role,state,registTime) values(?,?,?,?,?,?,?,?,?,?)";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		int row = runner.update(sql, u.getUsername(), u.getPassword(),
		u.getGender(), u.getEmail(), u.getTelephone(),
		u.getIntroduce(), u.getActiveCode(),
		u.getRole(),u.getRegistTime(),u.getState());
		if (row == 0) {
			throw new RuntimeException();
		}
	}
	//后台系统，根据id查找用户
	public User findUserById(String id) throws SQLException {
		String sql = "select * from user where id = ?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanHandler<User>(User.class),id);
	}
	//后台系统，根据id修改单个用户信息
	public void updateUser(User u) throws SQLException {
		String sql = "update user set username=?,password=?,gender=?,email=?,telephone=?,introduce=?,activeCode=?,role=?,state=?,registTime=? where id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql, u.getUsername(), u.getPassword(),
				u.getGender(), u.getEmail(), u.getTelephone(),
				u.getIntroduce(), u.getActiveCode(),
				u.getRole(),u.getState(),u.getRegistTime(),
				u.getId());
	}
	//后台系统，根据id删除用户
	public void deleteUser(String id) throws SQLException {
		String sql = "delete from user where id = ?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql, id);
	}
	
	//添end
	// 添加用户
	public void addUser(User user) throws SQLException {
		String sql = "insert into user(username,password,gender,email,telephone,introduce,activeCode) values(?,?,?,?,?,?,?)";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		int row = runner.update(sql, user.getUsername(), user.getPassword(),
				user.getGender(), user.getEmail(), user.getTelephone(),
				user.getIntroduce(), user.getActiveCode());
		if (row == 0) {
			throw new RuntimeException();
		}
	}

	// 根据激活码查找用户
	public User findUserByActiveCode(String activeCode) throws SQLException {
		String sql = "select * from user where activecode=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanHandler<User>(User.class), activeCode);

	}

	// 激活用戶
	public void activeUser(String activeCode) throws SQLException {
		String sql = "update user set state=? where activecode=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql, 1, activeCode);
	}
	
	//根据用户名与密码查找用户
	public User findUserByUsernameAndPassword(String username, String password) throws SQLException {
		String sql="select * from user where username=? and password=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanHandler<User>(User.class),username,password);
	}

}
