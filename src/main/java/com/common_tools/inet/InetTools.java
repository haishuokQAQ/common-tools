package com.common_tools.inet;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 网络相关的通用工具
 * @author haishuo_k
 *
 */
public class InetTools {
	/**
	 * 获取所有非回流有地址的的网卡ip
	 * @return
	 */
	public static List<String> getAllInetAddress(){
		List<String> result = new ArrayList<>();
		try {
			Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
			while(networkInterfaces.hasMoreElements()) {
				NetworkInterface ni = networkInterfaces.nextElement();
				Enumeration<InetAddress> addresses = ni.getInetAddresses();
				while(addresses.hasMoreElements()) {
					InetAddress address = addresses.nextElement();
					if (!address.isLoopbackAddress() && address.getHostAddress().indexOf(":") == -1) {
						result.add(address.getHostAddress());
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
