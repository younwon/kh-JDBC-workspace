package com.kh.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	// SqlSession 객체를 반환하는 메소드를 구현할 것
	
	public static SqlSession getSqlSession() {
		String config = "mybatis-config.xml";
		
		try {
			InputStream stream = Resources.getResourceAsStream(config);
			
			// 1. SqlSessionFatoryBuilder 만들기 => 기본 생성자 호출
			// 2. SqlSessionFatory 만들기 -> Builder를 참조해서 메소드를 호출
			// 3. SqlSession 만들기 -> Factory를 참조해서 메소드 호출
			SqlSession sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession();
			
			return sqlSession;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}
