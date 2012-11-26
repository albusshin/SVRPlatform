package Junit.test.Jingxuan;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.dao.impl.BugDAOImpl;
import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.User;

public class TestForHibernate {
	static UserDAO userDAO;
	static AbstractApplicationContext ctx;
	static BugDAOImpl bugDAO;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ctx = new ClassPathXmlApplicationContext( "applicationContext-hibernate.xml", "Junit/test/Jingxuan/testBeans.xml" );
		userDAO = (UserDAO)ctx.getBean("userDAO");
		bugDAO = (BugDAOImpl)ctx.getBean("bugDAO");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ctx.close();
	}

	@Test
	public void test() {
		userDAO.addUser(new User("1234","fdsafdadddd"));
		
	}
	@Test public void testIf() { 
		assertTrue(userDAO.ifEmailExists("fdsafda"));
	}
	
	@Test public void testGet(){
		System.out.println(userDAO.getPasswordByEmail("fdsafda"));
	}
	@Test public void test2() {
		User u = new User("154655","my1");
		userDAO.addUser(u);
		Bug b = new Bug();
		b.setUser(u);
	}

}
