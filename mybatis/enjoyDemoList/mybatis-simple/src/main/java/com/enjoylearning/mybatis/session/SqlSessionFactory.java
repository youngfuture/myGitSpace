package com.enjoylearning.mybatis.session;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.enjoylearning.mybatis.config.Configuration;
import com.enjoylearning.mybatis.config.MappedStatement;

//1.生成sqlsession
//2.在实例化的时候生成config
public class SqlSessionFactory {
	
	private final Configuration conf = new Configuration();
	
	private final int i = 0;

	public SqlSessionFactory() {
		loadDbInfo();
		loadMappersInfo();
	}
	
	

	//记录mapper xml文件存放的位置
	public static final String MAPPER_CONFIG_LOCATION = "mappers";
	//记录数据库连接信息文件存放位置
	public static final String DB_CONFIG_FILE = "db.properties";


	//加载数据库配置信息
	private void loadDbInfo() {
		//加载数据库信息配置文件
		InputStream dbIn = SqlSessionFactory.class.getClassLoader().getResourceAsStream(DB_CONFIG_FILE);
		 Properties p = new Properties();
		 try {
			p.load(dbIn);//将配置信息写入Properties对象
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //将数据库配置信息写入conf对象
		 conf.setJdbcDriver(p.get("jdbc.driver").toString());
		 conf.setJdbcPassword(p.get("jdbc.password").toString());
		 conf.setJdbcUrl(p.get("jdbc.url").toString());
		 conf.setJdbcUsername(p.get("jdbc.username").toString());
	}
	
	//加载指定文件夹下的所有mapper.xml
	private void loadMappersInfo() {
		URL resources =null;
		resources = SqlSessionFactory.class.getClassLoader().getResource(MAPPER_CONFIG_LOCATION);
		File mappers = new File(resources.getFile());//获取指定文件夹信息
		if(mappers.isDirectory()){
			File[] listFiles = mappers.listFiles();
			//遍历文件夹下所有的mapper.xml，解析信息后，注册至conf对象中
			for (File file : listFiles) {
				loadMapperInfo(file);
			}
		}
	}
	
	
	
	//加载指定的mapper.xml文件
	private void loadMapperInfo(File file) {
		// 创建saxReader对象  
		SAXReader reader = new SAXReader();  
		// 通过read方法读取一个文件 转换成Document对象  
		Document document=null;
		try {
			document = reader.read(file);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		//获取根节点元素对象  <mapper>
		Element root = document.getRootElement();
		//获取命名空间
		String namespace = root.attribute("namespace").getData().toString();
		//获取select子节点列表
		List<Element> selects = root.elements("select");
		//遍历select节点，将信息记录到MappedStatement对象，并登记到configuration对象中
		for (Element element : selects) {
			MappedStatement mappedStatement = new MappedStatement();//实例化mappedStatement
			String id = element.attribute("id").getData().toString();//读取id属性
			String resultType = element.attribute("resultType").getData().toString();//读取resultType属性
			String sql = element.getData().toString();//读取SQL语句信息
			String sourceId = namespace+"."+id;
			//给mappedStatement属性赋值
			mappedStatement.setSourceId(sourceId);
			mappedStatement.setResultType(resultType);
			mappedStatement.setSql(sql);
			mappedStatement.setNamespace(namespace);
			//注册到configuration对象中
			conf.getMappedStatements().put(sourceId, mappedStatement);
		}
	}
	
	public SqlSession openSession(){
		return new DefaultSqlSession(conf);
	}

	

}
