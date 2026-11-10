package com.kh.subs.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.apache.ibatis.session.SqlSession;

import static com.kh.common.Template.getSqlSession;

import com.kh.subs.model.dao.SubsDao;
import com.kh.subs.model.dto.SubscriptionDto;

public class SubsService {
	private SubsDao sa = new SubsDao();
	
	public List<SubscriptionDto> selectAll() {
		
		try(SqlSession session = getSqlSession()) {
			List<SubscriptionDto> subs = sa.selectAll(session);
			return subs;
		}
	}
	
	public int insertSub(SubscriptionDto sd) {
		validateSubscription(sd);
		
		SqlSession session = getSqlSession();
		
		if (new SubsDao().countByName(session, sd.getSubName()) > 0) {
			session.close();
			throw new RuntimeException("이미 구독 중인 서비스입니다");
		}
		
		int result = sa.insertSub(session, sd);
		session.close();
		return result;
	}
	
	public SubscriptionDto selectOne(int subNo) {
		validateSunNo(subNo);
		
		SqlSession session = getSqlSession();
		SubscriptionDto result = sa.selectOne(session, subNo);
		session.close();
		return result;
	}
	
	public int updateFee(SubscriptionDto sd) {
		long num = sd.getSubNo();
		validateSunNo((int) num);
		
		SqlSession session = getSqlSession();
		int result = sa.updateFee(session, sd);
		session.close();
		return result;
	}
	
	public int deleteSub(int subNo) {
		validateSunNo(subNo);
		
		SqlSession session = getSqlSession();
		int result = sa.deleteSub(session, subNo);
		session.close();
		return result;
	}
	
	public List<SubscriptionDto> searchByCategory(String keyword) {
		SqlSession session = getSqlSession();
		List<SubscriptionDto> subs = sa.searchByCategory(session, keyword);
		session.close();
		return subs;
	}
	
	public List<SubscriptionDto> searchByCondition(String menuNo, String keyword) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("menuNo", menuNo);
		param.put("keyword", keyword);
		
		SqlSession session = getSqlSession();
		List<SubscriptionDto> subs = sa.searchByCondition(session, param);
		session.close();
		return subs;
	}
	
	
	
	
	
	
	private void validateSubscription(SubscriptionDto sd) {
		checkNull(sd);
		checkSubName(sd);
		checkMonthlyFee(sd);
		checkPaymentDay(sd);
	}
	
	private void checkNull(SubscriptionDto sd) {
		if (sd == null) {
			throw new RuntimeException("잠시 후 다시 시도해주세요");
		}
	}
	
	private void checkSubName(SubscriptionDto sd) {
		if (sd.getSubName().isBlank() || sd.getSubName().length() > 50) {
			throw new RuntimeException("유효하지 않은 서비스명입니다");
		}
	}
	
	private void checkMonthlyFee(SubscriptionDto sd) {
		if (sd.getMonthlyFee() <= 0) {
			throw new RuntimeException("월 요금은 0보다 커야합니다");
		}
	}
	
	private void checkPaymentDay(SubscriptionDto sd) {
		if (sd.getPaymentDay() < 1 || sd.getPaymentDay() > 31) {
			throw new RuntimeException("결제일은 1일부터 31일 사이여야 합니다");
		}
	}
	
	private void validateSunNo(int subNo) {
		if (subNo < 1) {
			throw new RuntimeException("구독번호는 1보다 작을 수 없습니다");
		}
	}

}
