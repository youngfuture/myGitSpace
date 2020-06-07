package com.enjoylearning.mybatis.session;

import java.lang.reflect.Proxy;
import java.util.List;

import com.enjoylearning.mybatis.binding.MapperProxy;
import com.enjoylearning.mybatis.config.Configuration;
import com.enjoylearning.mybatis.config.MappedStatement;
import com.enjoylearning.mybatis.excutor.DefaultExecutor;
import com.enjoylearning.mybatis.excutor.Executor;

/**
 * @author lison
 * 
 * mybaitis暴露给外部的接口，实现增删改查的能力
 * 
 * 1.对外提供数据访问的api
 * 2.对内将请求转发给executor
 * 3.？
 *
 */
public class DefaultSqlSession implements SqlSession {
	
	private final Configuration conf;
	
	private Executor executor;
	
	

	public DefaultSqlSession(Configuration conf) {
		super();
		this.conf = conf;
		executor = new DefaultExecutor(conf);
	}

	@Override
	public <T> T selectOne(String statement, Object parameter) {
		List<Object> selectList = this.selectList(statement, parameter);
		if(selectList == null || selectList.size()==0){
			return null;
		}
		if(selectList.size()==1){
			return (T) selectList.get(0);
		}else{
			throw new RuntimeException("Too Many Results!");
		}
	}
	
	@Override
	public <E> List<E> selectList(String statement, Object parameter) {
		MappedStatement ms = conf.getMappedStatements().get(statement);
		return executor.query(ms, parameter);
	}

	@Override
	public <T> T getMapper(Class<T> type) {
		MapperProxy mp = new MapperProxy(this);
		return (T) Proxy.newProxyInstance(type.getClassLoader(), new Class[]{type}, mp);
	}

}
