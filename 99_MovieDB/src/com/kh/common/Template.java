package com.kh.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	private static SqlSessionFactory factory;
	
	public static SqlSession getSqlSession() {
		if (factory == null) {
			try {
				InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
				factory = new SqlSessionFactoryBuilder().build(stream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return factory.openSession();
	}
}
