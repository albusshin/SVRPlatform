package Junit.test.Jingxuan;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.SVRPlatform.service.SolutionVoteService;

public class testAop {
	static AbstractApplicationContext ctx;
	static SolutionVoteService solutionVoteService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
//		ctx = new ClassPathXmlApplicationContext("Junit/test/Jingxuan/Beans.xml");
//		solutionVoteService = (SolutionVoteService) ctx.getBean("solutionVoteService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		System.out.println("2012-12-18 00:09:52.0".substring(0,16));
	}

}
