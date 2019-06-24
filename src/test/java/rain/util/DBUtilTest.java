package rain.util;

import com.rain.util.DBUtil;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/** 
* DBUtil Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 17, 2019</pre> 
* @version 1.0 
*/ 
public class DBUtilTest {
    DBUtil db;

@Before
public void before() throws Exception {

}

@AfterClass
public static void afterClass() throws Exception {
    System.out.println("getConnectDb success" );
    System.out.println("CloseDB success" );
}

/** 
* 
* Method: getConnectDb() 
* 
*/ 
@Test
public void testGetConnectDb() throws Exception { 
//TODO: Test goes here...
    db.getConnectDb();
} 

/** 
* 
* Method: CloseDB(ResultSet rs, PreparedStatement stm, Connection conn) 
* 
*/ 
@Test
public void testCloseDB() throws Exception { 
//TODO: Test goes here...
    String sql ="select * from admin where aid=1";
    Connection conn = DBUtil.getConnectDb();
    PreparedStatement stm = null;
    ResultSet rs = null;
    stm = conn.prepareStatement(sql);
    rs = stm.executeQuery();
    db.CloseDB(rs, stm, conn);
} 


} 
