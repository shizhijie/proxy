package cn.zjs.bwcx.application;

import java.lang.reflect.Proxy;

import cn.zjs.bwcx.annotion.Annotion;
import cn.zjs.bwcx.dao.Sell;
import cn.zjs.bwcx.daoImpl.Vendor;
import cn.zjs.bwcx.proxy.DynamicProxy;

@Annotion
public class Test {
	
	public static void main(String[] args) {
		
		//创建中介类实例 
		DynamicProxy dProxy = new DynamicProxy(new Vendor());
		//加上这句将会产生一个$Proxy0.class文件，这个文件即为动态生成的代理类文件
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true"); 
		//获取代理类实例sell 
		Sell sell = (Sell) Proxy.newProxyInstance(Sell.class.getClassLoader(), new Class[] {Sell.class}, dProxy);
		//通过代理类对象调用代理类方法，实际上会转到invoke方法调用 
		sell.sell();
		sell.ad();
	}
	
}
