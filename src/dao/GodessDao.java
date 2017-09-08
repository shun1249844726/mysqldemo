package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import javatest.DBUtil;
import javatest.DBUtil;
import model.Goddess;

public class GodessDao {

	public void addGoddess(Goddess g) throws SQLException {
		Connection conn = DBUtil.getConnection();

		String sql = "" + "insert into imooc_goddess" + "(user_name,sex,age,birthday,email,mobile,"
				+ "create_user,create_date,update_user,update_date,isdel)" + "values("
				+ "?,?,?,?,?,?,?,current_date(),?,current_date,?)";
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);

		ptmt.setString(1, g.getUser_name());
		ptmt.setInt(2, g.getSex());
		ptmt.setInt(3, g.getAge());
		ptmt.setDate(4, new Date(g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMobile());
		ptmt.setString(7, g.getCreate_user());
		;
		ptmt.setString(8, g.getUpdate_user());
		ptmt.setInt(9, g.getIsdel());
		ptmt.execute();
	}

	public void updateGoddess(Goddess g) throws SQLException {
		Connection conn = DBUtil.getConnection();

		String sql = "" +
		" update imooc_goddess " + 
		" set user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?, "+
		" update_user=?,update_date=current_date(),isdel=?  " +
		" where id=? ";
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);

		ptmt.setString(1, g.getUser_name());
		ptmt.setInt(2, g.getSex());
		ptmt.setInt(3, g.getAge());
		ptmt.setDate(4, new Date(g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMobile());
		ptmt.setString(7, g.getUpdate_user());
		ptmt.setInt(8, g.getIsdel());
		ptmt.setInt(9, g.getId());

		ptmt.execute();
	}

	public void delGoddess(Integer id) throws SQLException {
		Connection conn = DBUtil.getConnection();

		String sql = "" + " delete from imooc_goddess " + " where id=? ";
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
		ptmt.setInt(1, id);
		ptmt.execute();
	}

	public List<Goddess> query() throws Exception {

		Connection conn = DBUtil.getConnection();
		Statement stmt = null;

		// 执行查询
		System.out.println(" 实例化Statement对...");
		stmt = conn.createStatement();
		String sql;
		sql = "SELECT USER_NAME,AGE FROM imooc_goddess";
		ResultSet rs = stmt.executeQuery(sql);

		List<Goddess> gs = new ArrayList<Goddess>();
		Goddess g = null;
		// 展开结果集数据库
		while (rs.next()) {
			g = new Goddess();
			// 通过字段检索
			// int id = rs.getInt("id");
			String name = rs.getString("USER_NAME");
			g.setUser_name(name);
			gs.add(g);
		}
		return gs;
	}

	public Goddess get(Integer id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		Goddess g = null;
		String sql = "" + 
		" select * from imooc_goddess " + 
		" where id=? ";
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
		ptmt.setInt(1, id);
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()){
			g = new Goddess();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			g.setSex(rs.getInt("sex"));
			g.setBirthday(rs.getDate("birthday"));
			g.setEmail(rs.getString("email"));
			g.setMobile(rs.getString("mobile"));
			g.setCreate_date(rs.getDate("create_date"));
			g.setCreate_user(rs.getString("create_user"));
			g.setUpdate_date(rs.getDate("update_date"));
			g.setUpdate_user(rs.getString("update_user"));
			g.setIsdel(rs.getInt("isdel"));
		}
		return g;
	}
}
