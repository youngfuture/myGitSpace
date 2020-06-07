package com.enjoylearning.mybatis.excutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.enjoylearning.mybatis.config.Configuration;
import com.enjoylearning.mybatis.config.MappedStatement;
import com.enjoylearning.mybatis.reflection.ReflectionUtil;

public class DefaultExecutor implements Executor {
	
	private final Configuration conf;
	
	

	public DefaultExecutor(Configuration conf) {
		super();
		this.conf = conf;
	}




	  /**
	   * 
	   * 查询接口
	   * 
	 * @param ms  封装sql语句的MappedStatement对象
	 * @param parameter 传入sql的参数
	 * @return  将数据转换成指定对象结果集返回
	 */
	@Override
	public <E> List<E> query(MappedStatement ms, Object parameter){
		List<E> ret = new ArrayList<E>();//定义返回结果集
		try {
			Class.forName(conf.getJdbcDriver());//加载驱动程序
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection=null;
		PreparedStatement prepareStatement=null;
		ResultSet resultSet=null;
		try {
			//获取连接，从MappedStatement中获取数据库信息
			connection = DriverManager.getConnection(conf.getJdbcUrl(), conf.getJdbcUsername(), conf.getJdbcPassword());
			//创建prepareStatement，从MappedStatement中获取sql语句
			prepareStatement = connection.prepareStatement(ms.getSql());
			//处理sql语句中的占位符
			parameterize(prepareStatement,parameter);
			//执行查询操作获取resultSet
			resultSet = prepareStatement.executeQuery();
			//将结果集通过反射技术，填充到list中
			handlerResultSet(resultSet,ret,ms.getResultType());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				resultSet.close();
				prepareStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return ret;
	}


  //对prepareStatement中的占位符进行处理
	private void parameterize(PreparedStatement prepareStatement,Object parameter) throws SQLException {
		if(parameter instanceof Integer){
			prepareStatement.setInt(1,(int)parameter);
		}else if(parameter instanceof Long){
			prepareStatement.setLong(1, (long)parameter);
		}else if(parameter instanceof String){
			prepareStatement.setString(1, (String)parameter);
		}
		
	}
	//读取resultset中的数据，并转换成目标对象
	private <E> void handlerResultSet(ResultSet resultSet,List<E> ret,String className){
		Class<E> clazz=null;
		try {
			//通过反射获取类对象
			clazz = (Class<E>) Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(resultSet.next()){
				//通过反射实例化对象
				Object entity = clazz.newInstance();
				//使用反射工具将resultSet中的数据填充到entity中
				ReflectionUtil.setPropToBeanFromResultSet(entity, resultSet);
				//对象加入返回集合中
				ret.add((E) entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
