package com.kh.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	public static SqlSession getSqlSession() {
		String config = "mybatis-config.xml";
		
		try {
			//바이트입력스트림으로 xml파일을 입력받고
			InputStream stream = Resources.getResourceAsStream(config);
			
			//Builder가 XML를 읽고 설정을 구성해서 fectory를 반환하고 그걸로 session생성
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession();
			
			return session;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
