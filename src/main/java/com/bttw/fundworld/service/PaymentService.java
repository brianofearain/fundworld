package com.bttw.fundworld.service;

import com.bttw.fundworld.domain.PaymentDetails;


public interface PaymentService {
	int createPayment(PaymentDetails fdd) throws Exception;
	PaymentDetails getPaymentDetails(int paymentId);
}
