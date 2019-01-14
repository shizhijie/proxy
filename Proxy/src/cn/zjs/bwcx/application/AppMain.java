package cn.zjs.bwcx.application;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import cn.zjs.bwcx.dao.AppService;
import cn.zjs.bwcx.daoImpl.AppServiceImpl;
import cn.zjs.bwcx.proxy.LoggerInterceptor;

public class AppMain {
	
	public static void main(String[] args) {
		
		AppService target = new AppServiceImpl();
		
		InvocationHandler aHandler = new LoggerInterceptor<AppService>(target);
		
		AppService proxy = (AppService) Proxy.newProxyInstance(AppService.class.getClassLoader(), new Class[]{AppService.class}, aHandler);
		
		proxy.createApp("Kevin test");
	}
	
}
