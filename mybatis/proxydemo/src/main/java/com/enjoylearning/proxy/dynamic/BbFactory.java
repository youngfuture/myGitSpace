package com.enjoylearning.proxy.dynamic;

public class BbFactory implements WomanToolsFactory {

	@Override
	public void saleWomanTools(float length) {
		System.out.println("根据您的需求，为您定制了一个高度为:"+length+"的男模特");
	}

}
