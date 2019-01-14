package cn.zjs.bwcx.application;

import cn.zjs.bwcx.dao.CalculateLog;
import cn.zjs.bwcx.daoImpl.CalculateLogImpl;
import cn.zjs.bwcx.proxy.CalculateLogProxy;

public class CalculateTest {
	
	public static void main(String[] args) {
		
		CalculateLog target = new CalculateLogImpl();
		
		CalculateLogProxy calculateLogProxy = new CalculateLogProxy(target); 
		CalculateLog logProxy = calculateLogProxy.getLogProxy();
		int add = logProxy.add(4, 1);
		System.out.println(add);
		
		logProxy.sub(4, 1);
		System.out.println(add);
		
		logProxy.mul(4, 1);
		System.out.println(add);
		
		logProxy.div(4, 1);
		System.out.println(add);
		
	}
	
}
