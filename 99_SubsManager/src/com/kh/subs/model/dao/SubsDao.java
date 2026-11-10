package com.kh.subs.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.subs.model.dto.SubscriptionDto;

public class SubsDao {
	
	public List<SubscriptionDto> selectAll(SqlSession session) {
		return session.selectList("subsMapper.selectAll");
	}
	
	public int insertSub(SqlSession session, SubscriptionDto sd) {
		return session.insert("subsMapper.insertSub", sd);
	}
	
	public SubscriptionDto selectOne(SqlSession session, int subNO) {
		return session.selectOne("subsMapper.selectOne", subNO);
	}
	
	public int updateFee(SqlSession session, SubscriptionDto sd) {
		return session.update("subsMapper.updateFee", sd);
	}
	
	public int deleteSub(SqlSession session, int subNo) {
		return session.delete("subsMapper.deleteSub", subNo);
	}
	
	public List<SubscriptionDto> searchByCategory(SqlSession session, String keyword) {
		return session.selectList("subsMapper.searchByCategory", keyword);
	}
	
	public int countByName(SqlSession session, String subName) {
		return session.selectOne("subsMapper.countByName", subName);
	}
	
	public List<SubscriptionDto> searchByCondition(SqlSession session, Map<String, Object> param) {
		return session.selectList("subsMapper.searchByCondition", param);
	}
}
