package com.bttw.fundworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bttw.fundworld.dao.FundDao;
import com.bttw.fundworld.dao.PaymentDao;
import com.bttw.fundworld.domain.PaymentDetails;

@Service(value = "paymentService")
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDao myPaymentDao;

	@Autowired
	private FundDao fundDao;

	@Override
	@Transactional
	public int createPayment(PaymentDetails fdd) throws Exception {
		// -- create fixed deposit
		fundDao.subtractFromFund(fdd.getFundId()
				.getFundId(), fdd.getPaymentAmount());
		return myPaymentDao.createPayment(fdd);
	}

	@Override
	@Transactional
	public PaymentDetails getPaymentDetails(int paymentId) {
		return myPaymentDao.getPayment(paymentId);
	}
}
