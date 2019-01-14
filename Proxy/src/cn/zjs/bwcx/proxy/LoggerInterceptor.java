package cn.zjs.bwcx.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggerInterceptor<T> implements InvocationHandler {
	
	private T target;////目标对象的引用，这里设计成Object类型，更具通用性  
	
	//private AppService target; 
	
	public LoggerInterceptor(T target) {
		this.target = target;
	}



	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		 System.out.println("Entered "+target.getClass().getName()+"-"+method.getName()+",with arguments{"+args[0]+"}");
		 boolean result = (boolean) method.invoke(target, args);
		 System.out.println("Before return:"+result);
		 return result;
	}

}
