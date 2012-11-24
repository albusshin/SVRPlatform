package Junit.test.Jingxuan;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.model.User;

public class TestForHibernate {
	static UserDAO userDAO;
	static AbstractApplicationContext ctx;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ctx = new ClassPathXmlApplicationContext( "applicationContext-hibernate.xml", "Junit/test/Jingxuan/testBeans.xml" );
		userDAO = (UserDAO)ctx.getBean("userDAO");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ctx.close();
	}

	@Test
	public void test() {
		userDAO.addUser(new User("1234","fdsafda"));
		
	}
	@Test public void testIf() {
		assertTrue(userDAO.ifEmailExists("fdsafda"));
	}
	
	@Test public void testGet(){
		System.out.println(userDAO.getPasswordByEmail("fdsafda"));
	}

}
