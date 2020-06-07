package com.enjoylearning.mybatis.factory.real;

import org.springframework.stereotype.Component;

import com.enjoylearning.mybatis.factory.product.CangSmallMovie;
import com.enjoylearning.mybatis.factory.product.SmallMovie;

@Component
public class CangSmallMovieFactory implements SmallMovieFactory {

	@Override
	public SmallMovie createMovie() {
		SmallMovie smallMovie = new CangSmallMovie("cang");
		//拍摄电影的过程及其复杂，非专业人士请勿模仿
		//…………
		//此处省略一万字
		return smallMovie;
	}

}
