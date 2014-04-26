package com.bttw.fundworld.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bttw.fundworld.domain.PaymentDetails;

@Repository(value = "paymentDao")
public class PaymentDaoImpl implements PaymentDao {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public int createPayment(final PaymentDetails fdd) {
		sessionFactory.getCurrentSession().save(fdd);
		return fdd.getPaymentId();
	}

	public PaymentDetails getPayment(final int paymentId) {
		String hql = "from PaymentDetails as paymentDetails where paymentDetails.paymentId ="
				+ paymentId;
		return (PaymentDetails) sessionFactory.getCurrentSession()
				.createQuery(hql).uniqueResult();
	}
}
