package com.jar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jar.dao.CustomerDao;
import com.jar.domain.Customer;
import com.jar.domain.User;
import com.jar.exception.DaoException;
import com.jar.utils.JdbcUtils;

public class CustomerDaoImpl implements CustomerDao {

	public List<Customer> getAllByType(String type) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from customers where type=?";
			st = conn.prepareStatement(sql);
			st.setString(1, type);
			rs = st.executeQuery();
			List list = new ArrayList();
			while (rs.next()) {
				Customer c = new Customer();
				c.setId(rs.getString("id"));
				c.setName(rs.getString("name"));
				c.setCharger(rs.getString("charger"));
				c.setType(rs.getString("type"));
				c.setCellphone(rs.getString("cellphone"));
				c.setLevel(rs.getString("level"));
				c.setIntroduction(rs.getString("introduction"));
				list.add(c);
			}
			return list;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	@Override
	public List<Customer> getAllBytLevel(String level) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from customers where level=?";
			st = conn.prepareStatement(sql);
			st.setString(1, level);
			rs = st.executeQuery();
			List list = new ArrayList();
			while (rs.next()) {
				Customer c = new Customer();
				c.setId(rs.getString("id"));
				c.setName(rs.getString("name"));
				c.setCharger(rs.getString("charger"));
				c.setType(rs.getString("type"));
				c.setCellphone(rs.getString("cellphone"));
				c.setLevel(rs.getString("level"));
				c.setIntroduction(rs.getString("introduction"));
				list.add(c);
			}
			return list;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	public void add(Customer c) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into customers(id,name,charger,type,cellphone,level,introduction) values(?,?,?,?,?,?,?);";
			st = conn.prepareStatement(sql);
			st.setString(1, c.getId());
			st.setString(2, c.getName());
			st.setString(3, c.getCharger());
			st.setString(4, c.getType());
			st.setString(5, c.getCellphone());
			st.setString(6, c.getLevel());
			st.setString(7, c.getIntroduction());
			int num = st.executeUpdate();
			if (num < 1) {
				throw new RuntimeException("添加失败");
			}
		} catch (Exception e) {
			throw new DaoException(e); // gosling thinking in java spring
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
			String sql = "delete from customers where name=?";
			st = conn.prepareStatement(sql);
			st.setString(1, name);
			st.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}

	}

	public void update(Customer c) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update customers set id=?,name=?,charger=?,type=?,cellphone=?,level=?,introduction=? where name=?";
			st = conn.prepareStatement(sql);
			st.setString(1, c.getId());
			st.setString(2, c.getName());
			st.setString(3, c.getCharger());
			st.setString(4, c.getType());
			st.setString(5, c.getCellphone());
			st.setString(6, c.getLevel());
			st.setString(7, c.getIntroduction());
			st.setString(8, c.getName());
			st.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}

	}

	public Customer findCustomer(String name) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from customers where name=?";
			st = conn.prepareStatement(sql);
			st.setString(1, name);
			rs = st.executeQuery();
			if (rs.next()) {
				Customer c = new Customer();
				c.setId(rs.getString("id"));
				c.setName(rs.getString("name"));
				c.setCharger(rs.getString("charger"));
				c.setType(rs.getString("type"));
				c.setCellphone(rs.getString("cellphone"));
				c.setLevel(rs.getString("level"));
				c.setIntroduction(rs.getString("introduction"));
				return c;

			}
			return null;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	@Override
	public List<Customer> getAll() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from customers";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			List list = new ArrayList();
			while (rs.next()) {
				Customer c = new Customer();
				c.setId(rs.getString("id"));
				c.setName(rs.getString("name"));
				c.setCharger(rs.getString("charger"));
				c.setType(rs.getString("type"));
				c.setCellphone(rs.getString("cellphone"));
				c.setLevel(rs.getString("level"));
				c.setIntroduction(rs.getString("introduction"));
				list.add(c);
			}
			return list;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	/*

	// 获取到页面数据和页面大小
	@SuppressWarnings("resource")
	public QueryResult pageQuery(int startindex, int pagesize) {

		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		QueryResult qr = new QueryResult();
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from customers limit ?,?";
			st = conn.prepareStatement(sql);
			st.setInt(1, startindex);
			st.setInt(2, startindex);
			rs = st.executeQuery();
			List<Customer> list = new ArrayList<Customer>();
			while (rs.next()) {
				Customer c = new Customer();

				c.setId(rs.getString("id"));
				c.setName(rs.getString("name"));
				c.setCellphone(rs.getString("cellphone"));
				c.setCharger(rs.getString("charger"));
				c.setLevel(rs.getString("level"));
				c.setType(rs.getString("type"));
				c.setIntroduction(rs.getString("introduction"));
				list.add(c);
			}
			qr.setList(list);

			sql = "select count(*) from customers";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			if (rs.next()) {
				qr.setTotalrecord(rs.getInt(1));
			}
			return qr;

		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	*/

}
