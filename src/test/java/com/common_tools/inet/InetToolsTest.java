package com.common_tools.inet;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

public class InetToolsTest {

	@Test
	public void test() {
		List<String> ips = InetTools.getAllInetAddress();
		assertNotNull(ips);
		for (String ip : ips) {
			System.out.println(ip);
		}
	}

}
