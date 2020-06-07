package com.enjoylearning.mybatis.binding;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;

import com.enjoylearning.mybatis.session.SqlSession;

public class MapperProxy implements InvocationHandler {
	
	private SqlSession session;
	
	

	public MapperProxy(SqlSession session) {
		super();
		this.session = session;
	}



	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Class<?> returnType = method.getReturnType();
		if(Collection.class.isAssignableFrom(returnType)){
			return session.selectList(method.getDeclaringClass().getName()+"."+method.getName(), args==null?null:args[0]);
		}else{
			return session.selectOne(method.getDeclaringClass().getName()+"."+method.getName(), args==null?null:args[0]);
		}
		
	}

}
