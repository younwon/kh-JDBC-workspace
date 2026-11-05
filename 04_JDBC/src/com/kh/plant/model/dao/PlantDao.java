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
		return session.selectList("plantMapper.read");
		
	}
	

}



