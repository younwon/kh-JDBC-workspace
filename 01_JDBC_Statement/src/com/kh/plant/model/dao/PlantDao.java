package com.kh.plant.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.plant.model.dto.HousePlantDto;

/*
 * JDBC용 인터페이스
 * - Connection : 데이터베이스와의 세션(연결)을 나타내는 인터페이스
 * -> 데이터베이스와의 통신 채널 연결
 * -> SQL문을 실행을 위한 Statement 객체 생성
 * -> 트랜잭션 관리
 * 
 * - Statement : SQL문을 실행하고 결과를 받아오기 위한 인터페이스
 * 1. Statement : 정적 SQL문(완성된 SQL문) 실행
 * 2. PreparedStatement : 파라미터화된 SQL문을 실행
 * 3. CallableStatment  : 저장 프로시저 호출
 * 
 * - ResultSet : SELECT문 수행결과를 담은 테이블 형태의 데이터 셋
 * -> 커서(cursor)라는 개념을 이용해서 데이터에 접근
 * -> 다양한 데이터타입을 변환해주는 메소드를 제공
 * 
 */

public class PlantDao {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//INSERT
	public int save(HousePlantDto hpd) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		
		String sql = "INSERT "
					+  "INTO "
					+		"HOUSEPLANT "
					+"VALUES "
					+ 		"("
					+		"SEQ_PLANT_NO.NEXTVAL"
					+	   ", '" + hpd.getType() + "'"
					+	   ", '" + hpd.getName() + "'"
					+	    ")";
		
		try {
			// JDBC Driver 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// DB서버와 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/XEPDB1", "HOSPITAL", "oracle");
			// 4. 서버가 안 열러(켜저)있을 수 있음
			// 5. 접속권한을 부여받지 못했을 경우
			// 6. 비밀번호 갱신을 안했을 수 있음
			// SQLException 발생
			
			//Statement 타입의 객체
			stmt = conn.createStatement();
			
			// SQL문 실행 요청 및 응답 반환
			result = stmt.executeUpdate(sql);
			//INSERT 시 자료형이 문제, 제약조건 위배, 데이터의 크기가 컬럼의 크기보다큼, DB서버에 문제
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	//SELECT
	public List<HousePlantDto> read() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		List<HousePlantDto> list = new ArrayList<HousePlantDto>();
		
		String sql = """
						SELECT
							   PLANT_NO
							 , PLANT_NAME
							 , PLANT_TYPE
						  FROM
						  	   HOUSEPLANT
						 ORDER
						 	BY
						 	   PLANT_NO DESC
					 """;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/XEPDB1", "HOSPITAL", "oracle");
			
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				// 현재 rset의 커서가 가리키고 있는 행의 데이터를
				// 하나씩 뽑아서 HousePlantDto객체의 필드에 대입
				HousePlantDto h = new HousePlantDto();
				
				//컬럼값이 정수여서 int로 매핑
				h.setNumber(rset.getInt("PLANT_NO"));
				//컬럼값이 문자열이면 String으로 매핑
				h.setName(rset.getString("PLANT_NAME"));
				h.setType(rset.getString("PLANT_TYPE"));
				//.getDate()는 컬럼값이 날짜값이면 java.sql.Date로 매핑
				
				// SELECT ORDER BY 정렬함 즉 순서가 보당되어야 함(그래서 List사용)
				list.add(h);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
		
		//SELECT문의 핵심
		// rest를 어떻게 할까
		// RDBMS(테이블형태)를 JAVA(객체형태)로 만든다
		// Mapping 매핑한다 (서로 다른 형태의 데이터 모델간의 연결을 정의하는 과정)
		// => 한 행씩 접근해서 데이터를 뽑아서 DTO/VO 필드에 담기
		// => 커서를 한 줄 아래로 옮기고 존재한다 true / 없다 false
		
	}
	
	public int edit(HousePlantDto hpd) {
		int result = 0;
		String sql = "UPDATE "
					+		"HOUSEPLANT "
					+	"SET "
					+		"PLANT_NAME = '" + hpd.getName() + "'"
					+	   ",PLANT_TYPE = '" + hpd.getType() + "' "
					+ "WHERE "
					+		"PLANT_NO = " + hpd.getNumber();
		
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/XEPDB1", "HOSPITAL", "oracle");
			 Statement stmt = conn.createStatement()){
			
			result = stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int remove(int plantNo) {
		int result = 0;
		
		String sql = """
						DELETE
						  FROM
						  	   HOUSEPLANT
						 WHERE
						 	   PLANT_NO = 
					 """;
		sql += plantNo;
		
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/XEPDB1", "HOSPITAL", "oracle");
			 Statement stat = conn.createStatement()) {
			
			result = stat.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public HousePlantDto oneRead(int plantNo) {
		
		String sql = """
						 SELECT
						 	    PLANT_NO
						 	  , PLANT_NAME
						 	  , PLANT_TYPE
						   FROM
						   	    HOUSEPLANT
						  WHERE
						  	    PLANT_NO =
					 """;
		sql += plantNo;
		HousePlantDto hpd = null;
		
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/XEPDB1", "HOSPITAL", "oracle");
			 Statement stat = conn.createStatement();
			 ResultSet rset = stat.executeQuery(sql)) {
			
			if (rset.next()) {
				//PK를 가지고 조회했을 때 결과가 존재한다
				hpd = new HousePlantDto(rset.getInt("PLANT_NO")
								 	   ,rset.getString("PLANT_TYPE")
								 	   ,rset.getString("PLANT_NAME")
								 	   );
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		return hpd;
	}
	
	public List<HousePlantDto> search(String keyword) {
		
		List<HousePlantDto> plants = new ArrayList<HousePlantDto>();
		
		String sql = """
						SELECT
							   PLANT_NO
							 , PLANT_NAME
							 , PLANT_TYPE
						 FROM  
						 	   HOUSEPLANT
						WHERE
					 """;
		sql += "PLANT_TYPE LIKE '%" + keyword + "%' ORDER BY PLANT_NO DESC";
		
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/XEPDB1", "HOSPITAL", "oracle");
			 Statement stat = conn.createStatement();
			 ResultSet rset = stat.executeQuery(sql)
			){
			
			while(rset.next()) {
				plants.add(new HousePlantDto(rset.getInt("PLANT_NO")
											,rset.getString("PLANT_TYPE")
											,rset.getString("PLANT_NAME")
											));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return plants;
	}
	
	
	
	
}



