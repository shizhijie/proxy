package cn.zjs.bwcx.application;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import cn.zjs.bwcx.dao.Person;
import cn.zjs.bwcx.daoImpl.Student;
import cn.zjs.bwcx.proxy.StuInvocationHandler;

public class ProxyTest {
	
	public static void main(String[] args) {
		
		//创建一个实例对象，这个对象是被代理的对象
		Person person = new Student("shizhijie");
		
		//创建一个与代理对象相关联的InvocationHandler
		InvocationHandler sHandler = new StuInvocationHandler<Person>(person);
		
		//创建一个代理对象stuProxy来代理zhangsan，代理对象的每个执行方法都会替换执行Invocation中的invoke方法
		Person stuProxyInstance = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, sHandler);
		
		//代理执行上交班费的方法
		stuProxyInstance.giveMoney();
	}
	
}
