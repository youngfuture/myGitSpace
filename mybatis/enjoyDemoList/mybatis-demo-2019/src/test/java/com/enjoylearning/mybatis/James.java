package com.enjoylearning.mybatis;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.enjoylearning.mybatis.factory.product.SmallMovie;
import com.enjoylearning.mybatis.factory.real.CangSmallMovieFactory;
import com.enjoylearning.mybatis.factory.real.SmallMovieFactory;
import com.enjoylearning.mybatis.factory.simple.SimpleSmallMovieFactory;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class James {
	
	@Resource(name="simpleSmallMovieFactoryImpl")
	private SimpleSmallMovieFactory factory1;
	
	@Resource(name="cangSmallMovieFactory")
	private SmallMovieFactory factory2;
	
	@Test
	public  void watchSmallMovie() {
		System.out.println("---------------简单工厂模式------------------");
		//简单工厂使用
		SmallMovie movie1 = factory1.createMovie("cang");
		movie1.watch();
		
		System.out.println("---------------工厂模式------------------");
		//工厂模式使用
		SmallMovie movie2 = factory2.createMovie();
		movie2.watch();
		
	}

}
