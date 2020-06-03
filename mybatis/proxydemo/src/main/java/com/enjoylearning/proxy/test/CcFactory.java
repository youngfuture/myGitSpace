package com.enjoylearning.proxy.test;

public class CcFactory implements MilkFactory {

	@Override
	public void saleMilk(int money) {
		System.out.println("您购买牛奶的费用为："+money);

	}

}
