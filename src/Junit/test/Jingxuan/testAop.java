package Junit.test.Jingxuan;

import static org.junit.Assert.*;

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
		ctx = new ClassPathXmlApplicationContext("Junit/test/Jingxuan/Beans.xml");
		solutionVoteService = (SolutionVoteService) ctx.getBean("solutionVoteService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		solutionVoteService.voteUp(12, "1234455435");
	}

}
