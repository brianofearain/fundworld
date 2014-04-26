package com.bttw.fundworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bttw.fundworld.dao.FundDao;
import com.bttw.fundworld.domain.FundDetails;

@Service(value = "fundService")
public class FundServiceImpl implements FundService {

	@Autowired
	private FundDao fundDao;

	@Override
	@Transactional
	public int createFund(FundDetails fundDetails) {
		return fundDao.createFund(fundDetails);
	}

}
