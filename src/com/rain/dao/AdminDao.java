package com.rain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.rain.bean.AdminBean;
import com.rain.bean.BookBean;
import com.rain.util.DBUtil;

public class AdminDao {
	
	/**
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean Login_verify(String username,String password){
		Connection conn = DBUtil.getConnectDb();
		String sql = "select * from admin where username='"+username+"' and password='"+password+"'";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.CloseDB(rs, stm, conn);
		}
		return false;
	}
	/**
	 * 娉ㄥ唽璐﹀彿鐨勫嚱鏁帮紝浼犲叆璐﹀彿锛屽瘑鐮侊紝濮撳悕锛岄偖绠憋紝鎵嬫満鍙凤紝鍊熼槄澶╂暟锛屽彲鍊熼槄鏁�
	 * @param username
	 * @param password
	 * @param name
	 * @param email
	 * @param phone
	 * @param lend_num
	 * @param max_num
	 */
	public void Register(String username, String password, String name, String email, String phone,int lend_num,int max_num) {
		// TODO Auto-generated method stub
				Connection conn = DBUtil.getConnectDb();
				String sql = "insert  into admin(status,username,password,name,email,phone,lend_num,max_num) values(?,?,?,?,?,?,?,?)";
				int rs = 0;
				PreparedStatement stm = null;
				try {
					stm = conn.prepareStatement(sql);
					stm.setInt(1, 1);
					stm.setString(2, username);
					stm.setString(3, password);
					stm.setString(4, name);
					stm.setString(5, email);
					stm.setString(6, phone);
					stm.setInt(7, lend_num);
					stm.setInt(8, max_num);
					rs = stm.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	/**
	 * 鏍规嵁浼犲叆鐨勮处鍙凤紝瀵嗙爜锛屾潵鏌ユ壘瀵瑰簲鐨勮鑰呬俊鎭紝杩斿洖涓�涓狝dminBean绫诲瀷锛�
	 * @param username
	 * @param password
	 * @return
	 */
	public AdminBean getAdminInfo(String username, String password) {
		// TODO Auto-generated method stub
		AdminBean adminbean = new AdminBean();
		Connection conn = DBUtil.getConnectDb();
		String sql = "select * from admin where username='"+username+"' and password='"+password+"'";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sql);
//			stm.setString(1,name);
			rs = stm.executeQuery();
			if(rs.next()){
				adminbean.setAid(rs.getInt("aid"));
				adminbean.setUsername(rs.getString("username"));
				adminbean.setName(rs.getString("name"));
				adminbean.setPassword(rs.getString("password"));
				adminbean.setEmail(rs.getString("email"));
				adminbean.setPhone(rs.getString("phone"));
				adminbean.setStatus(rs.getInt("status"));
				adminbean.setLend_num(rs.getInt("lend_num"));
				adminbean.setMax_num(rs.getInt("max_num"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.CloseDB(rs, stm, conn);
		}
		return adminbean;
	}
	/**
	 * 鑾峰彇鍏ㄩ儴鐢ㄦ埛鐨勪俊鎭紝鍏朵腑sql璇彞涓殑status=1锛岃〃绀哄彧鏌ユ壘璇昏�咃紝涓嶆樉绀虹鐞嗗憳鐨�
	 * @return
	 */
	public ArrayList<AdminBean> get_ListInfo(){
		ArrayList<AdminBean> tag_Array = new ArrayList<AdminBean>();
		Connection conn = DBUtil.getConnectDb();
		String sql = "select * from admin where status=1";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				AdminBean adminbean = new AdminBean();
				adminbean.setAid(rs.getInt("aid"));
				adminbean.setUsername(rs.getString("username"));
				adminbean.setName(rs.getString("name"));
				adminbean.setPassword(rs.getString("password"));
				adminbean.setEmail(rs.getString("email"));
				adminbean.setPhone(rs.getString("phone"));
				adminbean.setStatus(rs.getInt("status"));
				adminbean.setLend_num(rs.getInt("lend_num"));
				adminbean.setMax_num(rs.getInt("max_num"));
				tag_Array.add(adminbean);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.CloseDB(rs, stm, conn);
		}
		return tag_Array;
	}
	/**
	 * 鏍规嵁浼犲叆鐨刟id锛屾煡鎵惧埌瀵瑰簲鐨勮鑰呯殑鍏ㄩ儴淇℃伅锛岃繑鍥炰竴涓狝dminBean绫诲瀷鐨勬暟鎹�
	 * @param aid
	 * @return
	 */
	public AdminBean get_AidInfo(int aid){
		AdminBean adminbean = new AdminBean();
		Connection conn = DBUtil.getConnectDb();
		String sql = "select * from admin where aid="+aid;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			if(rs.next()){
				adminbean.setAid(rs.getInt("aid"));
				adminbean.setUsername(rs.getString("username"));
				adminbean.setName(rs.getString("name"));
				adminbean.setPassword(rs.getString("password"));
				adminbean.setEmail(rs.getString("email"));
				adminbean.setPhone(rs.getString("phone"));
				adminbean.setStatus(rs.getInt("status"));
				adminbean.setLend_num(rs.getInt("lend_num"));
				adminbean.setMax_num(rs.getInt("max_num"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.CloseDB(rs, stm, conn);
		}
		return adminbean;
	}
	/**
	 * 鏍规嵁浼犲叆鐨刟id锛屾煡鎵惧埌瀵瑰簲鐨勮鑰呯殑鍏ㄩ儴淇℃伅锛岃繑鍥炰竴涓狝dminBean绫诲瀷鐨勬暟鎹紝涓庝笂涓�涓浉浼硷紝鍙槸aid鐨勭被鍨嬩负String锛�
	 * @param aid
	 * @return
	 */
	public AdminBean get_AidInfo2(String aid){
		AdminBean adminbean = new AdminBean();
		Connection conn = DBUtil.getConnectDb();
		String sql = "select * from admin where aid="+aid;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			if(rs.next()){
				adminbean.setAid(rs.getInt("aid"));
				adminbean.setUsername(rs.getString("username"));
				adminbean.setName(rs.getString("name"));
				adminbean.setPassword(rs.getString("password"));
				adminbean.setEmail(rs.getString("email"));
				adminbean.setPhone(rs.getString("phone"));
				adminbean.setStatus(rs.getInt("status"));
				adminbean.setLend_num(rs.getInt("lend_num"));
				adminbean.setMax_num(rs.getInt("max_num"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.CloseDB(rs, stm, conn);
		}
		return adminbean;
	}
	/**
	 * 淇敼璇昏�呯殑淇℃伅锛�
	 */
	public void updateUser(int aid, String username, String password, String name, String email, String phone,
			int lend_num, int max_num) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnectDb();
		String sql = "update admin set username=?,name=?,email=?,phone=?,password=?,lend_num=?,max_num=? where aid=?";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, username);
			stm.setString(2, name);
			stm.setString(3, email);
			stm.setString(4, phone);
			stm.setString(5, password);
			stm.setInt(6, lend_num);
			stm.setInt(7, max_num);
			stm.setInt(8, aid);
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 鍒犻櫎鐢ㄦ埛鐨勪俊鎭紝鏍规嵁浼犲叆鐨刟id浣滀负鏉′欢
	 * @param aid
	 */
	public void deleteUser(int aid) {
		// TODO Auto-generated method stub
				Connection conn = DBUtil.getConnectDb();
				String sql = "delete from admin where aid=?";
				PreparedStatement stm = null;
				try {
					stm = conn.prepareStatement(sql);
					stm.setInt(1, aid);
					stm.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
	}
}
