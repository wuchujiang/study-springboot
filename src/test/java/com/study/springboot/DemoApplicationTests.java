package com.study.springboot;

import com.study.springboot.util.TestUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DemoApplicationTests extends DefaultTest {

	@Autowired
	TestUtils testUtils;

	@Test
	public void test111() {


		System.out.println(testUtils.getInt("1212"));

		Assert.assertSame("相等","111", "111");

		System.out.println("test111~~~");
	}

	@Test
	public void test222() {
		Assert.assertSame("不相等","111", "222");

		System.out.println("test2221~~~");
	}

}
