package cn.zjs.bwcx.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import cn.zjs.bwcx.dao.CalculateLog;

public class CalculateLogProxy {
	
	// 创建一个要代理的对象
		private CalculateLog target;
		
		public CalculateLogProxy(CalculateLog target) {
			super();
			this.target = target;
		}

		@SuppressWarnings("rawtypes")
		public CalculateLog getLogProxy(){
			CalculateLog proxy = null;
			
			// 代理对象由哪一个类加载器负责加载
			ClassLoader loader = target.getClass().getClassLoader();
			
			// 代理对象的类型，即其中有哪些方法
			Class[] interfaces = new Class[]{CalculateLog.class};
			
			// 当调用代理对象其中的方法时，该执行的代码
			InvocationHandler h = new InvocationHandler() {
				/**
				 * 参数说明:
				 * proxy：正在返回的那个代理对象。一般情况下，在invoke方法中都不使用该对象.
				 * method：正在被调用的方法
				 * args：调用方法时传入的参数
				 */
				public Object invoke(Object proxy, Method method, Object[] args)
						throws Throwable {
					String methodName = method.getName();
					// 日志信息
					System.out.println(methodName + " 方法 begin 执行，" + Arrays.asList(args));
					// 执行方法
					Object result = method.invoke(target, args);
					System.out.println(methodName + " 方法 end 执行，" + Arrays.asList(args));
					return result;
				}
			};
			proxy = (CalculateLog)Proxy.newProxyInstance(loader, interfaces, h);
			return proxy;
		}
}
