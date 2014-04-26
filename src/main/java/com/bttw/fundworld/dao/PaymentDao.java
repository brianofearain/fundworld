package com.bttw.fundworld.dao;

import com.bttw.fundworld.domain.PaymentDetails;

public interface PaymentDao {
	int createPayment(PaymentDetails payment);
	PaymentDetails getPayment(int paymentId);
}
