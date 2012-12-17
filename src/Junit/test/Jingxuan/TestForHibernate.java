package Junit.test.Jingxuan;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
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

import com.SVRPlatform.action.RetrievePassword;
import com.SVRPlatform.dao.HashForPasswordRetrieveDAO;
import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.dao.impl.BugDAOImpl;
import com.SVRPlatform.dao.impl.CommentDAOImpl;
import com.SVRPlatform.dao.impl.HashForPasswordRetrieveDAOImpl;
import com.SVRPlatform.dao.impl.SoftwareDAOImpl;
import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.Comment;
import com.SVRPlatform.model.Software;
import com.SVRPlatform.model.Solution;
import com.SVRPlatform.model.User;
import com.SVRPlatform.service.PasswordRetrieveService;
import com.SVRPlatform.service.SolutionSubmitService;
import com.SVRPlatform.service.impl.PasswordEncoder;
import com.SVRPlatform.service.impl.PasswordRetrieveServiceImpl;

public class TestForHibernate {
	static UserDAO userDAO;
	static AbstractApplicationContext ctx;
	static BugDAOImpl bugDAO;
	static SessionFactory sessionFactory;
	static SoftwareDAOImpl softwareDAO;
	static Session session;
	static CommentDAOImpl commentDAO;
	static PasswordRetrieveService passwordRetrieveService;
	static SolutionSubmitService solutionSubmitService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ctx = new ClassPathXmlApplicationContext( "Junit/test/Jingxuan/testBeans-hibernate.xml", "applicationContext.xml" );
		userDAO = (UserDAO)ctx.getBean("userDAO");
		bugDAO = (BugDAOImpl)ctx.getBean("bugDAO");
		sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
		session = SessionFactoryUtils.openSession(sessionFactory);
		Session s = sessionFactory.openSession();  
		TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(s));
		softwareDAO = (SoftwareDAOImpl) ctx.getBean("softwareDAO");
		commentDAO = (CommentDAOImpl) ctx.getBean("commentDAO");
		passwordRetrieveService = (PasswordRetrieveService) ctx.getBean("passwordretrieveservice");
		solutionSubmitService = (SolutionSubmitService) ctx.getBean("solutionSubmitService");
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
		userDAO.add(new User("1234","fdsafdadddd"));
		
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
//		Bug b = new Bug();
//		Software s = new Software();
//		s.setCompany("qq");
//		softwareDAO.add(s);
//		b.setSoftware(s);
//		bugDAO.add(b);
//		System.out.println(((Bug)bugDAO.getByID(3)).getSoftware());
		//sessionFactory.getCurrentSession().close();
		Solution so = new Solution();
	}
	
	@Test public void testBug() {
		Bug b = new Bug();
		bugDAO.add(b);
		
	}
	
	@Test public void testAddComment(){
		Bug bug = (Bug) bugDAO.getByID(new Integer(1));
		User user = (User) userDAO.getByID(new Integer(1));
		Comment[] c = new Comment[20];
		for(int i=0; i<20; i++){
			c[i] = new Comment();
			c[i].setBug(bug);
			c[i].setUser(user);
			commentDAO.add(c[i]);
		}
		System.out.println("finished add comments 10");
	}
	@Test public void testFindComment(){
//		Bug bug = (Bug) bugDAO.getByID(new Integer(1));
		User user = (User) userDAO.getByID(new Integer(1));
		System.out.println(user);
//		System.out.println(User.class.getSimpleName());
//		System.out.println(User.class.getCanonicalName());
		List<Comment> list = commentDAO.getByUserId(user, 100, 10);
		for(Comment c: list){
			System.out.println(c.getCommentId());
			System.out.println(c.getBug());
		}
		System.out.println("---"+commentDAO.getCountFromOneUser(user));
//		List<Comment> list2 = commentDAO.getByBugId(bug, 10, 10);
//		for(Comment c: list2){
//			System.out.println(c.getCommentId());
//		}
	}
	
	@Test public void testSendEmail() {
		HashForPasswordRetrieveDAOImpl hashForPasswordRetrieveDAO = new HashForPasswordRetrieveDAOImpl();
		hashForPasswordRetrieveDAO.setSessionFactory(sessionFactory);
		PasswordRetrieveServiceImpl prs = new PasswordRetrieveServiceImpl();
		prs.setHashForPasswordRetrieveDAO(hashForPasswordRetrieveDAO);
		prs.setUserDAO(userDAO);
		
		boolean b = prs.sendCheckingEmail("povergoing@gmail.com");
		System.out.println(b);
	}
	@Test public void testSendEmail2(){
		//System.out.println(passwordRetrieveService.checkHashValue("cf6c767bd7edac68a03857a1af83e275"));
		passwordRetrieveService.updatePassword("povergoing@gmail.com", "hanfdsaftfdsaf");
		System.out.println(PasswordEncoder.EncoderByMd5("fdaf"));
	}
	@Test public void testSolutionSubmitService(){
		solutionSubmitService.solutionSubmit("--1", "povergoing@gmail.com", "fdafdaferfeavzer");
	}
}
