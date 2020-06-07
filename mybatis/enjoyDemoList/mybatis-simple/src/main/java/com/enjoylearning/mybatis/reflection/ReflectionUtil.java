package com.enjoylearning.mybatis.reflection;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import com.enjoylearning.mybatis.entity.TUser;

/**
 * 反射工具类
 * 
 * @author lison
 *
 */
public class ReflectionUtil {
	
	/**
	 *  为指定的bean的propName属性的值设为value
	 *  
	 * @param bean 目标对象
	 * @param propName 对象的属性名
	 * @param value  值
	 */
	public static void setPropToBean(Object bean,String propName,Object value){
		Field f;
		try {
			f = bean.getClass().getDeclaredField(propName);//获得对象指定的属性
	        f.setAccessible(true);//将字段设置为可通过反射进行访问
	        f.set(bean, value);//为属性设值
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	/**
	 * 
	 * 从resultSet中读取一行数据，并填充至指定的实体bean
	 * 
	 * @param entity  待填充的实体bean
	 * @param resultSet  从数据库加载的数据
	 * @throws SQLException
	 */
	public static void setPropToBeanFromResultSet(Object entity,ResultSet resultSet) throws SQLException {
			Field[] declaredFields = entity.getClass().getDeclaredFields();//通过反射获取对象的所有字段
			for (int i = 0; i < declaredFields.length; i++) {//遍历所有的字段，从resultSet中读取相应的数据，并填充至对象的属性中
				if(declaredFields[i].getType().getSimpleName().equals("String")){//如果是字符串类型数据
					setPropToBean(entity, declaredFields[i].getName(), resultSet.getString(declaredFields[i].getName()));
				}else if(declaredFields[i].getType().getSimpleName().equals("Integer")){//如果是int类型数据
					setPropToBean(entity, declaredFields[i].getName(), resultSet.getInt(declaredFields[i].getName()));
				}else if(declaredFields[i].getType().getSimpleName().equals("Long")){//如果是long类型数据
					setPropToBean(entity, declaredFields[i].getName(), resultSet.getLong(declaredFields[i].getName()));
				}
			}
		
	}
	
	
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class clazz = Class.forName("com.enjoylearning.mybatis.entity.TUser");
		Object user = clazz.newInstance();
		ReflectionUtil.setPropToBean(user, "userName", "lison");
		System.out.println(user);
		
//		Field[] declaredFields = user.getClass().getDeclaredFields();
//		for (Field field : declaredFields) {
//			System.out.println(field.getName());
//			System.out.println(field.getType().getSimpleName());
//		}
//		
		
	}




}
