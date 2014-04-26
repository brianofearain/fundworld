package com.bttw.fundworld.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bttw.fundworld.domain.FundDetails;

@Repository(value = "fundDao")
public class FundDaoImpl implements FundDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int createFund(final FundDetails fundDetails) {
		sessionFactory.getCurrentSession().save(fundDetails);
		return fundDetails.getFundId();
	}

	@Override
	public void subtractFromFund(int fundId, int amount) {
		String hql = "from FundDetails as fundDetails where fundDetails.fundId ="
				+ fundId;
		FundDetails fundDetails = (FundDetails) sessionFactory
				.getCurrentSession().createQuery(hql).uniqueResult();
		fundDetails.setBalanceAmount(fundDetails
				.getBalanceAmount() - amount);
		sessionFactory.getCurrentSession().merge(fundDetails);
	}
}
