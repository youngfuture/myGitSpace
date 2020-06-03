package com.enjoylearning.proxy.stat;

import com.enjoylearning.proxy.dynamic.WomanToolsFactory;


//代理对象，包含真实的对象，为真实对象的服务进行增强，和真实对象继承于同一个接口
public class Lison implements ManToolsFactory{
	
	//被包含的真实对象
	public ManToolsFactory factory;
	
	

	
	public Lison(ManToolsFactory factory) {
		super();
		this.factory = factory;
	}
	



	@Override
	public void saleManTools(String size) {
		dosomeThingBefore();//前置增强
		factory.saleManTools(size);
		dosomeThingEnd();//后置增强
	}


	//售前服务
	private void dosomeThingEnd() {
		System.out.println("精美包装，快递一条龙服务！");
	}

	//售后服务
	private void dosomeThingBefore() {
		System.out.println("根据您的需求，进行市场调研和产品分析！");
	}




}
