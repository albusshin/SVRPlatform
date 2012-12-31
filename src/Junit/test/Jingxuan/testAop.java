package Junit.test.Jingxuan;

import static org.junit.Assert.*;

import java.util.Calendar;
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
	@Test
	public void test2(){
		Calendar pastDate = Calendar.getInstance();
		pastDate.set(2012, 11, 31, 18, 50, 0);
		System.out.println(formatDate(pastDate.getTime()));;
	}
	protected static String formatDate(Date date){
		long between = (new Date().getTime() - date.getTime()) / 1000;
		long minute = 60;
		long hour = 60 * minute;
		long day  = 24 * hour;
		long year = 365 * day;
		long month = 30 * day;
		long week = 7 * day;
		
		
		long years = between / year;
		if(years > 0)
			return "years:"+years;
		
		long months = between / month;
		if(months > 0)
			return "months:"+months;
		
		long weeks = between / week;
		if(weeks > 0)
			return "weeks:"+weeks;
		
		long days = between / day;
		if(days > 0)
			return "days:"+days;
		
		long hours = between / hour;
		if(hours > 0)
			return "hours:"+hours;
		
		long minutes = between / minute;
		if(minutes > 0)
			return "minutes:" + minutes;
		
		return "seconds:"+ between;
		
	}

}
