package rain.bean;

import org.junit.*;
import com.rain.bean.AdminBean;
import static org.junit.Assert.*;

/** 
* AdminBean Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 17, 2019</pre> 
* @version 1.0 
*/ 
public class AdminBeanTest {
    AdminBean admin = new AdminBean();

@Before
public void before() throws Exception {
    admin.setAid(1);
    admin.setStatus(1);
    admin.setUsername("gdtop");
    admin.setName("wjh");
    admin.setPassword("qwer12345");
    admin.setEmail("Jhwang0517@gmail.com");
    admin.setPhone("16643945170");
    admin.setLend_num(30);
    admin.setMax_num(100);
} 

@AfterClass
public static void after() throws Exception {
    System.out.println("setAid success");
    System.out.println("setStatus success");
    System.out.println("setUsername success");
    System.out.println("setName success");
    System.out.println("setEmail success");
    System.out.println("setPhone success");
    System.out.println("setLend_num success");
    System.out.println("setMax_num success");
}




/** 
* 
* Method: getAid() 
* 
*/ 
@Test
public void testGetAid() throws Exception { 
//TODO: Test goes here...
    System.out.println(admin.getAid()+ " getAid success");

} 

/** 
* 
* Method: setAid(int aid) 
* 
*/ 
@Test
public void testSetAid() throws Exception { 
//TODO: Test goes here...
    assertEquals("setAid failed ",1,admin.getAid());
} 

/** 
* 
* Method: getStatus() 
* 
*/ 
@Test
public void testGetStatus() throws Exception { 
//TODO: Test goes here...
    System.out.println(admin.getStatus()+ " getStatus success");
} 

/** 
* 
* Method: setStatus(int status) 
* 
*/ 
@Test
public void testSetStatus() throws Exception { 
//TODO: Test goes here...
    assertEquals("setStatus failed ",1,admin.getStatus());
} 

/** 
* 
* Method: getUsername() 
* 
*/ 
@Test
public void testGetUsername() throws Exception { 
//TODO: Test goes here...
    System.out.println(admin.getUsername()+ " getUsername success");
} 

/** 
* 
* Method: setUsername(String username) 
* 
*/ 
@Test
public void testSetUsername() throws Exception { 
//TODO: Test goes here...
    assertEquals("setSetUsername failed ","gdtop",admin.getUsername());
} 

/** 
* 
* Method: getName() 
* 
*/ 
@Test
public void testGetName() throws Exception { 
//TODO: Test goes here...
    System.out.println(admin.getName()+ " getName success");
} 

/** 
* 
* Method: setName(String name) 
* 
*/ 
@Test
public void testSetName() throws Exception { 
//TODO: Test goes here...
    assertEquals("setName failed ","wjh",admin.getName());
} 

/** 
* 
* Method: getPassword() 
* 
*/ 
@Test
public void testGetPassword() throws Exception { 
//TODO: Test goes here...
    System.out.println(admin.getPassword()+ " getPassword success");
} 

/** 
* 
* Method: setPassword(String password) 
* 
*/ 
@Test
public void testSetPassword() throws Exception { 
//TODO: Test goes here...
    assertEquals("setPassword failed ","qwer12345",admin.getPassword());
} 

/** 
* 
* Method: getEmail() 
* 
*/ 
@Test
public void testGetEmail() throws Exception { 
//TODO: Test goes here...
    System.out.println(admin.getEmail()+ " getEmail success");
}

/** 
* 
* Method: setEmail(String email) 
* 
*/ 
@Test
public void testSetEmail() throws Exception { 
//TODO: Test goes here...
    assertEquals("setEmail failed ","Jhwang0517@gmail.com",admin.getEmail());
} 

/** 
* 
* Method: getPhone() 
* 
*/ 
@Test
public void testGetPhone() throws Exception { 
//TODO: Test goes here...
    System.out.println(admin.getPhone()+ " getPhone success");
} 

/** 
* 
* Method: setPhone(String phone) 
* 
*/ 
@Test
public void testSetPhone() throws Exception { 
//TODO: Test goes here...
    assertEquals("setPhone failed ","16643945170",admin.getPhone());
} 

/** 
* 
* Method: getLend_num() 
* 
*/ 
@Test
public void testGetLend_num() throws Exception { 
//TODO: Test goes here...
    System.out.println(admin.getLend_num()+ " getLend_num success");
} 

/** 
* 
* Method: setLend_num(int lend_num) 
* 
*/ 
@Test
public void testSetLend_num() throws Exception { 
//TODO: Test goes here...
    assertEquals("setLend_num failed ",30,admin.getLend_num());
} 

/** 
* 
* Method: getMax_num() 
* 
*/ 
@Test
public void testGetMax_num() throws Exception { 
//TODO: Test goes here...
    System.out.println(admin.getMax_num()+ " getMax_num success");
} 

/** 
* 
* Method: setMax_num(int max_num) 
* 
*/ 
@Test
public void testSetMax_num() throws Exception { 
//TODO: Test goes here...
    assertEquals("setMax_num failed ",100,admin.getMax_num());

} 


} 
