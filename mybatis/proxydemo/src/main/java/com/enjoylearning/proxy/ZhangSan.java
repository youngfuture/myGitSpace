package com.enjoylearning.proxy;

import com.enjoylearning.proxy.dynamic.BbFactory;
import com.enjoylearning.proxy.dynamic.LisonCompany;
import com.enjoylearning.proxy.dynamic.WomanToolsFactory;
import com.enjoylearning.proxy.stat.AaFactory;
import com.enjoylearning.proxy.stat.Lison;
import com.enjoylearning.proxy.stat.ManToolsFactory;
import com.enjoylearning.proxy.test.CcFactory;
import com.enjoylearning.proxy.test.MilkFactory;
import com.enjoylearning.proxy.utils.ProxyUtils;

public class ZhangSan {
	
	public static void main(String[] args) {
//		//1.从前有个日本的公司生产娃娃，质量不错
//		ManToolsFactory factory = new AaFactory();
//		//2.lison老师代理这个公司的产品
//		Lison lison = new Lison(factory);
//		//3.张三有需求来找我，买了一个D size的娃娃
//		lison.saleManTools("D");
		
//		
		//1.日本有个A公司生产男性用品
		ManToolsFactory aFactory = new AaFactory();
		//2.日本有个B公司生产女性用品
		WomanToolsFactory bFactory = new BbFactory();
		//3.lison成立了一个代购公司
		LisonCompany lisonComp = new LisonCompany();
		//4.张三来找我，说要我代购男性用品
		lisonComp.setFactory(aFactory);
		//5.一号员工对这个行业很熟悉，我委派一号员工为他服务
		ManToolsFactory lison1 = (ManToolsFactory) lisonComp.getProxyInstance();
		//6.一号员工为他服务，完成代购
		lison1.saleManTools("D");
		
		System.out.println("-----------------------------");
		
		//7.张三老婆来找我，说要我代购女性用品
		lisonComp.setFactory(bFactory);
		//8.二号员工对这个行业很熟悉，我委派二号员工为他服务
		WomanToolsFactory lison2 = (WomanToolsFactory) lisonComp.getProxyInstance();
		//9.二号员工为他服务，完成代购
		lison2.saleWomanTools(1.8f);
//		ProxyUtils.generateClassFile(aFactory.getClass(), lison1.getClass().getSimpleName());
//		ProxyUtils.generateClassFile(bFactory.getClass(), lison2.getClass().getSimpleName());
		
		System.out.println("-----------------------------");
		
		
		
		
		
		
		
//		//10.有人要买牛奶，我代购牛奶公司产品
//		MilkFactory cFactory = new CcFactory();
//		lisonComp.setFactory(cFactory);
//		//11.三号员工对这个行业很熟悉，我委派三号员工为他服务
//		MilkFactory lison3 = (MilkFactory) lisonComp.getProxyInstance();
//		//912.三号员工为他服务，完成代购
//		lison3.saleMilk(100);

	}

}
