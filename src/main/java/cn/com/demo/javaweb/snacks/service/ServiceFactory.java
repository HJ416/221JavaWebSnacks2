package cn.com.demo.javaweb.snacks.service;

import java.io.InputStream;
import java.util.Properties;

import cn.com.demo.javaweb.snacks.dao.DAOFactory;

public class ServiceFactory {
    private static ServiceFactory factory;
    private Properties pros;
	private ServiceFactory() {
		try {
			this.init();
			System.out.println("init...");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static ServiceFactory buildFactory() {
		if (factory==null) {
			factory=new ServiceFactory();
		}
		return factory;
	}

	public IFoodService creaFoodService() {
		try {
			return (IFoodService)this.creatObject(pros.getProperty("foodService"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private Object creatObject(String clsName) throws Exception{
		Object obj=null;
		//加载类
		Class cls=Class.forName(clsName);
		//反射产生对象
		obj =cls.newInstance();
		return obj;
	}
	private void init() throws Exception{
		System.out.println("xxxx");
		//读配置文件
		InputStream in=DAOFactory.class.getClassLoader().getResourceAsStream("service.properties");
		pros=new Properties();
		//加载配置文件流
		pros.load(in);
		System.out.println(pros.get("foodService"));

	}
}
