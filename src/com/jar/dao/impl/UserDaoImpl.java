package com.jar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.jar.dao.UserDao;
import com.jar.domain.User;
import com.jar.exception.DaoException;
import com.jar.utils.JdbcUtils;

public class UserDaoImpl implements UserDao {

	public void add(User user) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into users(id,name,password,cellphone,email,address,position,limitation) values(?,?,?,?,?,?,?,?);";
			st = conn.prepareStatement(sql);
			st.setString(1, user.getId());
			st.setString(2, user.getName());
			st.setString(3, user.getPassword());
			st.setString(4, user.getCellphone());
			st.setString(5, user.getEmail());
			st.setString(6, user.getAddress());
			st.setString(7, user.getPosition());
			st.setString(8, user.getLimitation());
			int num = st.executeUpdate();
			if (num < 1) {
				throw new RuntimeException("注册用户失败");
			}
		} catch (Exception e) {
			throw new DaoException(e); // gosling thinking in java spring
		} finally {
			JdbcUtils.release(conn, st, rs);
		}

	}

	public User find(String name, String password) {

		Connection conn = null;
		PreparedStatement st = null; // PreparedStatment
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from users where name=? and password=?";
			st = conn.prepareStatement(sql); // 预编译这条sql

			st.setString(1, name);
			st.setString(2, password);

			rs = st.executeQuery();
			if (rs.next()) {
				User user = new User();

				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setCellphone(rs.getString("cellphone"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("address"));
				user.setPosition(rs.getString("position"));
				user.setLimitation(rs.getString("limitation"));
				return user;
			}
			return null;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	public boolean find(String name) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from users where name=?";
			st = conn.prepareStatement(sql);
			st.setString(1, name);

			rs = st.executeQuery();
			if (rs.next()) {
				return true;
			}
			return false;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	public void delete(String name) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from users where name=?";
			st = conn.prepareStatement(sql);
			st.setString(1, name);
			st.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	@Override
	public void update(User user) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils.getConnection();
			String sql = "update users set id=?,name=?,password=?,cellphone=?,email=?,address=?,limitation=? where name=?";
			st = conn.prepareStatement(sql);
			st.setString(1, user.getId());
			st.setString(2, user.getName());
			st.setString(3, user.getPassword());
			st.setString(4, user.getCellphone());
			st.setString(5, user.getEmail());
			st.setString(6, user.getAddress());
			st.setString(7, user.getLimitation());
			st.setString(8, user.getName());
			st.executeUpdate();
		}catch (Exception e) {
			throw new DaoException(e);
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}


	public User findUser(String name) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from users where name=?";
			st = conn.prepareStatement(sql);
			st.setString(1, name);
			rs = st.executeQuery();
			if (rs.next()) {
				User user = new User();

				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setCellphone(rs.getString("cellphone"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("address"));
				user.setPosition(rs.getString("position"));
				user.setLimitation(rs.getString("limitation"));
				return user;
			}
			return null;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	public List<User> getAll() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils.getConnection();
			String sql = "select * from users";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			List<User> list = new ArrayList<User>();
			while(rs.next()){
				User user = new User();

				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setCellphone(rs.getString("cellphone"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("address"));
				user.setPosition(rs.getString("position"));
				user.setLimitation(rs.getString("limitation"));
				list.add(user);
			}
			return list;
		}catch (Exception e) {
			throw new DaoException(e);
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}


	/*
	//获取到页面数据和页面大小
		@SuppressWarnings("resource")
		public QueryResult pageQuery(int startindex,int pagesize){
			
			Connection conn = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			
			QueryResult qr = new QueryResult();
			try{
				conn = JdbcUtils.getConnection();
				String sql = "select * from users limit ?,?";
				st = conn.prepareStatement(sql);
				st.setInt(1, startindex);
				st.setInt(2, startindex);
				rs = st.executeQuery();
				List<User> list = new ArrayList<User>();
				while(rs.next()){
					User user = new User();

					user.setId(rs.getString("id"));
					user.setName(rs.getString("name"));
					user.setPassword(rs.getString("password"));
					user.setCellphone(rs.getString("cellphone"));
					user.setEmail(rs.getString("email"));
					user.setAddress(rs.getString("address"));
					user.setPosition(rs.getString("position"));
					user.setLimitation(rs.getString("limitation"));
					
					list.add(user);
				}
				qr.setList(list);
				
				sql = "select count(*) from users";
				st = conn.prepareStatement(sql);
				rs = st.executeQuery();
				if(rs.next()){
					qr.setTotalrecord(rs.getInt(1));
				}
				return qr;
				
			}catch (Exception e) {
				throw new DaoException(e);
			}finally{
				JdbcUtils.release(conn, st, rs);
			}
		}
	*/
	
	
}
