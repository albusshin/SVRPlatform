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
		pastDate.set(2012, 11, 6, 23, 4, 5);
		System.out.println(formatDate(pastDate.getTime()));;
	}
	protected static String formatDate(Date date){
		Calendar pastDate = Calendar.getInstance();
		pastDate.setTime(date);
		Calendar nowDate = Calendar.getInstance();
		nowDate.setTime(new Date());
		int years = nowDate.get(Calendar.YEAR) - pastDate.get(Calendar.YEAR);
		if(years !=0 )
			return "years:"+years;
		int months = nowDate.get(Calendar.MONTH) - pastDate.get(Calendar.MONTH);
		if(months != 0)
			return "months:"+months;
		int weeks = nowDate.get(Calendar.WEEK_OF_YEAR) - pastDate.get(Calendar.WEEK_OF_YEAR);
		if(weeks != 0)
			return "weeks:"+weeks;
		int days = nowDate.get(Calendar.DAY_OF_YEAR) - pastDate.get(Calendar.DAY_OF_YEAR);
		if(days !=0 )
			return "days:"+days;
		int hours = nowDate.get(Calendar.HOUR_OF_DAY)- pastDate.get(Calendar.HOUR_OF_DAY);
		if(hours != 0)
			return "hours:"+hours;
		int minutes = nowDate.get(Calendar.MINUTE) - pastDate.get(Calendar.MINUTE);
		if(minutes !=0)
			return "minutes:"+minutes;
		int seconds = nowDate.get(Calendar.SECOND) - pastDate.get(Calendar.SECOND);
			return "seconds:"+seconds;
	}

}
