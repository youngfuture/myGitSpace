package com.enjoylearning.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LisonCompany implements InvocationHandler {
	
	//被代理的对象
	private Object factory;
	

	public Object getFactory() {

		return factory;
	}



	public void setFactory(Object factory) {
		this.factory = factory;
	}
	
	//通过Proxy获取动态代理的对象
	public Object getProxyInstance(){
		return Proxy.newProxyInstance(factory.getClass().getClassLoader(), factory.getClass().getInterfaces(), this);
	}



	@Override
	//通过动态代理对象对方法进行增强
	public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {
		dosomeThingBefore();
		Object ret = method.invoke(factory, args);
		dosomeThingEnd();
		return ret;
	}
	
	
	//售后服务
	private void dosomeThingEnd() {
		System.out.println("精美包装，快递一条龙服务！");
	}

	//售前服务
	private void dosomeThingBefore() {
		System.out.println("根据您的需求，进行市场调研和产品分析！");
		
	}


}
