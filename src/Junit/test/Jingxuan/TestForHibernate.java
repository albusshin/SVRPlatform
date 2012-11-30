package Junit.test.Jingxuan;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.orm.hibernate4.support.OpenSessionInViewFilter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.dao.impl.BugDAOImpl;
import com.SVRPlatform.dao.impl.SoftwareDAOImpl;
import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.Software;
import com.SVRPlatform.model.User;

public class TestForHibernate {
	static UserDAO userDAO;
	static AbstractApplicationContext ctx;
	static BugDAOImpl bugDAO;
	static SessionFactory sessionFactory;
	static SoftwareDAOImpl softwareDAO;
	static Session session;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ctx = new ClassPathXmlApplicationContext( "applicationContext-hibernate.xml", "Junit/test/Jingxuan/testBeans.xml" );
		userDAO = (UserDAO)ctx.getBean("userDAO");
		bugDAO = (BugDAOImpl)ctx.getBean("bugDAO");
		sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
		session = SessionFactoryUtils.openSession(sessionFactory);
		Session s = sessionFactory.openSession();  
		TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(s));
		softwareDAO = (SoftwareDAOImpl) ctx.getBean("softwareDAO");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		SessionHolder holder = (SessionHolder) TransactionSynchronizationManager.getResource(sessionFactory);  
		Session s = holder.getSession();  
		s.flush();  
		TransactionSynchronizationManager.unbindResource(sessionFactory);  
		SessionFactoryUtils.closeSession(s);  
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
		User u1 = new User("154655","my1");
		User u2 = new User("154655","my2");
		User u3 = new User("154655","my3");
		User u4 = new User("154655","my4");
		Set<User> su = new HashSet<User>();
		su.add(u1);
		su.add(u2);
		su.add(u3);
		su.add(u4);
		
		Bug b = new Bug();
		b.setUser(u1);
		//b.setUsers(su);
		
		userDAO.addUser(u1);
		userDAO.addUser(u2);
		userDAO.addUser(u3);
		userDAO.addUser(u4);
		
		bugDAO.addBug(b);
		
		bugDAO.bugWatched(b, u3);
	}
	
	@Test public void test3() {
		Session s = null;
		Transaction tx = null;
		try{
			Set<User> su = new HashSet<User>();
			Set<Bug> sb = new HashSet<Bug>();
			
			User u1 = new User("1234","u1");
			su.add(u1);
			
			User u2 = new User("1234","u2");
			su.add(u1);
			
			Bug b1 = new Bug();
			sb.add(b1);
			
			Bug b2 = new Bug();
			sb.add(b2);
			
			b1.setUsers(su);
			b2.setUsers(su);
			
			s =sessionFactory.openSession();
			tx = s.beginTransaction();
			s.save(b1);
			s.save(b2);
			s.save(u1);
			s.save(u2);
			tx.commit();
			
		} finally {
			if(s != null)
				s.close();
		}
	}
	@Test public void testSolution() {
		Bug b = new Bug();
		Software s = new Software();
		s.setCompany("qq");
		softwareDAO.addSoftware(s);
		b.setSoftware(s);
		bugDAO.addBug(b);
		
		Bug b2 = bugDAO.getBugbyId(7);
		System.out.println(b2.getSoftware().getCompany());
		//sessionFactory.getCurrentSession().close();
	}
}
