package rain.dao;

import com.rain.dao.AdminDao;
import com.rain.bean.AdminBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/** 
* AdminDao Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 17, 2019</pre> 
* @version 1.0 
*/ 
public class AdminDaoTest {
    AdminDao dao = new AdminDao();


@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: Login_verify(String username, String password) 
* 
*/ 
@Test
public void testLogin_verify() throws Exception { 
//TODO: Test goes here...

    dao.Login_verify("gdtop","qwer12345");
    //dao.Login_verify("gdtop","qwer1234");
    System.out.println("Login_verify success" + " 登陆信息（获取数据库信息并验证）");

} 

/** 
* 
* Method: Register(String username, String password, String name, String email, String phone, int lend_num, int max_num) 
* 
*/ 
@Test
public void testRegister() throws Exception { 
//TODO: Test goes here...
    dao.Register("gdtop","qwer12345","wjh","jhwang0517@gmail.com","16643945170",30,100);
    dao.Register("bigbro","111","jhw","99681563@gmail.com","15923659865",30,100);
    System.out.println("Register success" + " 注册用户信息（增加一条用户信息）");
}

/** 
* 
* Method: getAdminInfo(String username, String password) 
* 
*/ 
@Test
public void testGetAdminInfo() throws Exception { 
//TODO: Test goes here...
    AdminBean AdminInfo = new AdminBean();
    AdminInfo = dao.getAdminInfo("gdtop","qwer12345");
    //String[] names = AdminInfo.getBeanDefinitionNames();
    System.out.println(AdminInfo.getAid()+" "+AdminInfo.getName()+" "+AdminInfo.getEmail()+" "+AdminInfo.getPhone());
    System.out.println("getAdminInfo success" + " 根据用户登陆的姓名密码获取用户信息");
} 

/** 
* 
* Method: get_ListInfo() 
* 
*/ 
@Test
public void testGet_ListInfo() throws Exception { 
//TODO: Test goes here...
    AdminBean AdminInfo;
    ArrayList<AdminBean> tag_Array;
    tag_Array = dao.get_ListInfo();
    System.out.println("Aid Name Email Phone");
    for(int i = 0 ; i<tag_Array.size();i++){
        AdminInfo = tag_Array.get(i);
        System.out.println(AdminInfo.getAid()+" "+AdminInfo.getName()+" "+AdminInfo.getEmail()+" "+AdminInfo.getPhone());
    }
    System.out.println("get_ListInfo success" + " 根据status用户状态获取所有用户信息");
} 

/** 
* 
* Method: get_AidInfo(int aid) 
* 
*/ 
@Test
public void testGet_AidInfo() throws Exception { 
//TODO: Test goes here...
    AdminBean AdminInfo;
    AdminInfo = dao.get_AidInfo(1);
    System.out.println(AdminInfo.getAid()+" "+AdminInfo.getName()+" "+AdminInfo.getEmail()+" "+AdminInfo.getPhone());
    System.out.println("get_AidInfo success" + " 根据id获取用户信息");
} 

/** 
* 
* Method: get_AidInfo2(String aid) 
* 
*/ 
@Test
public void testGet_AidInfo2() throws Exception { 
//TODO: Test goes here...
    AdminBean AdminInfo;
    AdminInfo = dao.get_AidInfo2("1");
    System.out.println(AdminInfo.getAid()+" "+AdminInfo.getName()+" "+AdminInfo.getEmail()+" "+AdminInfo.getPhone());
    System.out.println("get_AidInfo2 success" + " 根据aid获取用户信息");
} 

/** 
* 
* Method: updateUser(int aid, String username, String password, String name, String email, String phone, int lend_num, int max_num) 
* 
*/ 
@Test
public void testUpdateUser() throws Exception { 
//TODO: Test goes here...
    AdminBean AdminInfo;
    dao.updateUser(1,"kk","l25","cl","951376191@qq.com","16525615121",30,100);
    AdminInfo = dao.get_AidInfo2("1");
    System.out.println(AdminInfo.getAid()+" "+AdminInfo.getName()+" "+AdminInfo.getEmail()+" "+AdminInfo.getPhone());
    System.out.println("updateUser success" + " 根据aid更新用户信息");
} 

/** 
* 
* Method: deleteUser(int aid) 
* 
*/ 
@Test
public void testDeleteUser() throws Exception { 
//TODO: Test goes here...
    dao.deleteUser(6);
    System.out.println("updateUser success" + " 根据aid删除一条用户信息");
} 


} 
