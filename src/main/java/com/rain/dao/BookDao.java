package com.rain.dao;

import com.rain.bean.AdminBean;
import com.rain.bean.BookBean;
import com.rain.bean.HistoryBean;
import com.rain.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

public class BookDao {

	/**
	 * @param card
	 * @param name
	 * @param type
	 * @param autho
	 * @param press
	 * @param num
	 */
	public void addBook(String card, String name, String type, String autho, String press, int num) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnectDb();
		String sql = "insert  into book(card,name,type,autho,press,num) values(?,?,?,?,?,?)";
		int rs = 0;
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, card);
			stm.setString(2, name);
			stm.setString(3, type);
			stm.setString(4, autho);
			stm.setString(5, press);
			stm.setInt(6, num);
			rs = stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @return
	 */
	public ArrayList<BookBean> get_ListInfo(){
		ArrayList<BookBean> tag_Array = new ArrayList<BookBean>();
		Connection conn = DBUtil.getConnectDb();
		String sql = "select * from book";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				BookBean tag = new BookBean();
				tag.setBid(rs.getInt("bid"));
				tag.setName(rs.getString("name"));
				tag.setCard(rs.getString("card"));
				tag.setType(rs.getString("type"));
				tag.setAutho(rs.getString("autho"));
				tag.setPress(rs.getString("press"));
				tag.setNum(rs.getInt("num"));
				tag_Array.add(tag);
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
	 * @param status
	 * @return
	 */
	public ArrayList<HistoryBean> get_HistoryListInfo(int status,String aid){
		ArrayList<HistoryBean> tag_Array = new ArrayList<HistoryBean>();
		Connection conn = DBUtil.getConnectDb();
		String sql = "select * from history where aid='"+aid+"' and status='"+status+"'";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				HistoryBean tag = new HistoryBean();
				tag.setHid(rs.getInt("hid"));
				tag.setAid(rs.getInt("aid"));
				tag.setBid(rs.getInt("bid"));
				tag.setBookname(rs.getString("bookname"));
				tag.setCard(rs.getString("card"));
				tag.setAdminname(rs.getString("adminname"));
				tag.setUsername(rs.getString("username"));
				tag.setBegintime(rs.getString("begintime"));
				tag.setEndtime(rs.getString("endtime"));
				tag.setStatus(rs.getInt("status"));
				tag_Array.add(tag);
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
	 * @param status
	 * @return
	 */
	public ArrayList<HistoryBean> get_HistoryListInfo2(int status){
		ArrayList<HistoryBean> tag_Array = new ArrayList<HistoryBean>();
		Connection conn = DBUtil.getConnectDb();
		String sql = "select * from history where status='"+status+"'";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				HistoryBean tag = new HistoryBean();
				tag.setHid(rs.getInt("hid"));
				tag.setAid(rs.getInt("aid"));
				tag.setBid(rs.getInt("bid"));
				tag.setBookname(rs.getString("bookname"));
				tag.setCard(rs.getString("card"));
				tag.setAdminname(rs.getString("adminname"));
				tag.setUsername(rs.getString("username"));
				tag.setBegintime(rs.getString("begintime"));
				tag.setEndtime(rs.getString("endtime"));
				tag.setStatus(rs.getInt("status"));
				tag_Array.add(tag);
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
	 * @param bid
	 * @return
	 */
	public BookBean get_BookInfo(int bid){
		BookBean tag = new BookBean();
		Connection conn = DBUtil.getConnectDb();
		String sql = "select * from book where bid='"+bid+"'";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				tag.setBid(rs.getInt("bid"));
				tag.setName(rs.getString("name"));
				tag.setCard(rs.getString("card"));
				tag.setType(rs.getString("type"));
				tag.setAutho(rs.getString("autho"));
				tag.setPress(rs.getString("press"));
				tag.setNum(rs.getInt("num"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.CloseDB(rs, stm, conn);
		}
		return tag;
	}
	/**
	 */
	public void updateBook(int bid, String card, String name, String type, String autho, String press, int num) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnectDb();
		String sql = "update book set name=?,card=?,type=?,autho=?,press=?,num=? where bid=?";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, name);
			stm.setString(2, card);
			stm.setString(3, type);
			stm.setString(4, autho);
			stm.setString(5, press);
			stm.setInt(6, num);
			stm.setInt(7, bid);
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @param bid
	 */
	public void deleteBook(int bid) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnectDb();
		String sql = "delete from book where bid=?";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sql);
			stm.setInt(1, bid);
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(uid);
		
	}
	/**
	 * @param name
	 * @return
	 */
	public ArrayList<BookBean> getLikeList(String name) {
		// TODO Auto-generated method stub
		ArrayList<BookBean> tag_Array = new ArrayList<BookBean>();
		Connection conn = DBUtil.getConnectDb();
		String sql = "select * from book where name like '%"+name+"%'";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				BookBean tag = new BookBean();
				tag.setBid(rs.getInt("bid"));
				tag.setName(rs.getString("name"));
				tag.setCard(rs.getString("card"));
				tag.setType(rs.getString("type"));
				tag.setAutho(rs.getString("autho"));
				tag.setPress(rs.getString("press"));
				tag.setNum(rs.getInt("num"));
				tag_Array.add(tag);
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
	 * @param bid
	 * @param adminbean
	 */
	public void borrowBook(int bid, AdminBean adminbean) {
		// TODO Auto-generated method stub
		BookBean bookbean = new BookBean();
		bookbean = this.get_BookInfo(bid);
		//
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);  
		int month = c.get(Calendar.MONTH);   
		int day = c.get(Calendar.DATE);  
		//
		String begintime = ""+year+"-"+month+"-"+day;
		month = month + 1;
		//
		String endtime = ""+year+"-"+month+"-"+day;
		Connection conn = DBUtil.getConnectDb();
		String sql = "insert  into history(aid,bid,card,bookname,adminname,username,begintime,endtime,status) values(?,?,?,?,?,?,?,?,?)";
		int rs = 0;
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sql);
			stm.setInt(1, adminbean.getAid());
			stm.setInt(2, bookbean.getBid());
			stm.setString(3, bookbean.getCard());
			stm.setString(4, bookbean.getName());
			stm.setString(5, adminbean.getUsername());
			stm.setString(6, adminbean.getName());
			stm.setString(7, begintime);
			stm.setString(8, endtime);
			stm.setInt(9, 1);
			rs = stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @param hid
	 */
	public void borrowBook2(int hid) {
		// TODO Auto-generated method stub
		//
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);  
		int month = c.get(Calendar.MONTH);   
		int day = c.get(Calendar.DATE); 
		//
		String endtime = ""+year+"-"+month+"-"+day;
		Connection conn = DBUtil.getConnectDb();
		String sql = "update history set endtime=?,status=? where hid=?";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, endtime);
			stm.setInt(2, 0);
			stm.setInt(3, hid);
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
