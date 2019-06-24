package rain.servlet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.rain.servlet.LoginServlet;
import static org.junit.Assert.*;
import java.lang.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpSession;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import javax.servlet.*;
import javax.servlet.http.*;
import org.easymock.*;
import junit.framework.*;
import org.junit.*;
import org.junit.Test;
import java.lang.String;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import org.easymock.*;
import junit.framework.TestCase;

/** 
* LoginServlet Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 17, 2019</pre> 
* @version 1.0 
*/
@WebServlet("/LoginServlet")
public class LoginServletTest extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private HttpServletRequest request;
    private LoginServlet servlet;
    private ServletContext context;
    private RequestDispatcher dispatcher;
    @Before
    //setup用于环境的建立，在其中mock需要用到的接口
    public void setUp() throws Exception{
        request = EasyMock.createMock(HttpServletRequest.class);
        context = EasyMock.createMock(ServletContext.class);
        dispatcher = EasyMock.createMock(RequestDispatcher.class);
        servlet = new LoginServlet();
    }
    @After
    //好像没什么要释放的，可以不写，这里为了完整性
    public void tearDown() {

    }
    @Test
    public void testLoginFailed() throws Exception {
        //设置期望得到的值
        expect(request.getParameter("username")).andReturn("admin");
        expect(request.getParameter("password")).andReturn("1234");
        //setup完成激活mock
        replay(request);
        try {
            servlet.doPost(request, null);
            fail("Not caught exception!");
        }
        catch(RuntimeException re) {
            assertEquals("Login failed.", re.getMessage());
        }
        //检查mock对象的状态
        verify(request);
    }

    @Test
    public void testLoginOK() throws Exception {
        //设置期望得到的值，最好按照doPost的语句顺序来
        expect(request.getParameter("username")).andReturn("admin");
        expect(request.getParameter("password")).andReturn("123456");
        expect(context.getNamedDispatcher("dispatcher")).andReturn(dispatcher);
        dispatcher.forward(request, null);
        //setup完成激活mock
        replay(request);
        replay(context);
        replay(dispatcher);
        /*为了让getServletContext()方法返回我们创建的ServletContext Mock对象，
         我们定义一个匿名类并覆写getServletContext()方法*/
        LoginServlet servlet = new LoginServlet() {
            public ServletContext getServletContext() {
                return context;
            }
        };
        //测试doPost方法
        servlet.doPost(request, null);
        //检查mock对象的状态
        verify(request);
        verify(context);
        verify(dispatcher);
    }

/**
    private LoginServlet servlet;

    private HttpServletRequest mockRequest;

    private HttpServletResponse mockRespones;

    private ServletContext mockServletContext;

    private RequestDispatcher mockDispathcher;

    private HttpSession mocksession;

    @Before
    public void setUp() throws Exception {
        mockRequest = EasyMock.createMock(HttpServletRequest.class);
        mockRespones = EasyMock.createMock(HttpServletResponse.class);
        mockServletContext = EasyMock.createMock(ServletContext.class);
        mockDispathcher = EasyMock.createMock(RequestDispatcher.class);
        mocksession = EasyMock.createMock(HttpSession.class);

        servlet = new LoginServlet() {

            private static final long serialVersionUID = 1L;

            public ServletContext getServletContext() {
                return mockServletContext;
            }
        };

    }


    @Test
    public void testDoGetHttpServletRequestHttpServletResponse() throws ServletException, IOException {
        EasyMock.expect(mockRequest.getParameter("username")).andReturn("gdtop").times(1);
        EasyMock.expect(mockRequest.getParameter("password")).andReturn("qwer12345").times(1);
        //EasyMock.expect(mockRequest.setCharacterEncoding("UTF-8").times(1);
        EasyMock.expect(mockRequest.getSession()).andReturn(mocksession).times(1);
        EasyMock.expect(mockServletContext.getRequestDispatcher("dispather")).andReturn(mockDispathcher).times(1);
        mockDispathcher.forward(mockRequest, mockRespones);
        EasyMock.expectLastCall();
        EasyMock.replay(mockRequest, mockServletContext, mockDispathcher);

        servlet.doPost(mockRequest, mockRespones);
        EasyMock.verify(mockDispathcher);
        EasyMock.verify(mocksession);
    }

    @Test
    public void testDoGetFailed() throws ServletException, IOException {
        EasyMock.expect(mockRequest.getParameter("username")).andReturn("test").times(1);
        EasyMock.expect(mockRequest.getParameter("password")).andReturn("123458").times(1);
        EasyMock.replay(mockRequest);
        try {
            servlet.doGet(mockRequest, mockRespones);
        } catch (Exception e) {
            assertEquals("Login error", e.getMessage());
        }
        EasyMock.verify(mockRequest);

    }
    */
} 
