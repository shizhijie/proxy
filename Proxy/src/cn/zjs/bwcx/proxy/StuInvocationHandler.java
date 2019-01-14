package cn.zjs.bwcx.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import cn.zjs.bwcx.util.MonitorUtil;

public class StuInvocationHandler<T> implements InvocationHandler{
	
	private T Target;
	
	public StuInvocationHandler(T target) {
		super();
		Target = target;
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("代理执行"+method.getName()+"方法");
		MonitorUtil.start();
		Object result = method.invoke(Target, args);
		MonitorUtil.finish(method.getName());
		return result;
	}

}
