package com.kh.plant.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;

import com.kh.plant.model.dto.HousePlantDto;

public class PlantDao {
	
	public int save(SqlSession session, HousePlantDto hpd) {
		return session.insert("plantMapper.save", hpd);
	}
	
	public List<HousePlantDto> read(SqlSession session) {
		// 조회결과가 없으면 빈 리스트를 반환
		return session.selectList("plantMapper.read");
		
	}
	
	public int edit(SqlSession session, HousePlantDto hpd) {
		return session.update("plantMapper.edit", hpd);
	}
	
	public int remove(SqlSession session, int plantNo) {
		return session.delete("plantMapper.remove", plantNo);
	}
	
	public HousePlantDto oneRead(SqlSession session, int plantNo) {
		//selectOne은 조회결과가 없으면 null반환
		return session.selectOne("plantMapper.oneRead", plantNo);
	}
	
	public List<HousePlantDto> search(SqlSession session, String keyword) {
		return session.selectList("plantMapper.search", keyword);
	}
}



