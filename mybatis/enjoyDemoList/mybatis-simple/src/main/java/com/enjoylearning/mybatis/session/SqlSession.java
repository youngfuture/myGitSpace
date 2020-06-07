package com.enjoylearning.mybatis.session;

import java.util.List;

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
public interface SqlSession {
	
	  /**
	   * 根据传入的条件查询单一结果
	   * 
	 * @param statement  方法对应的sql语句， namespace + id
	 * @param parameter  要传入到sql语句中的查询参数
	 * @return  返回指定的结果对象
	 */
	<T> T selectOne(String statement, Object parameter);

	  
	  /**
	   * 
	   * 根据条件经过查询，返回泛型集合
	   * 
	 * @param statement  方法对应的sql语句， namespace + id
	 * @param parameter  要传入到sql语句中的查询参数
	 * @return  返回指定的结果对象的list
	 */
	<E> List<E> selectList(String statement, Object parameter);
	  
	  
	 
	  /**
	   * 
	   *  根据mapper接口获取接口对应的动态代理实现
	   * 
	 * @param type 指定的mapper接口
	 * @return
	 */
	<T> T getMapper(Class<T> type);


}
