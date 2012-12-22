package Junit.test.Jingxuan;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.SVRPlatform.Utils.StringEncoder;

public class testForPasswdEncodeing {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		String str="svrb-2012-00000045";
		int i = Integer.parseInt(str.split("-")[2]);
		System.out.println(i);
	}

}
