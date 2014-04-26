package com.bttw.fundworld;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bttw.fundworld.domain.FundDetails;
import com.bttw.fundworld.domain.PaymentDetails;
import com.bttw.fundworld.service.FundService;
import com.bttw.fundworld.service.PaymentService;

public class FundController {
	private static Logger logger = Logger.getLogger(FundController.class);

	public static void main(String args[]) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/spring/applicationContext.xml");

		FundService fundService = context
				.getBean(FundService.class);
		FundDetails fundDetails = new FundDetails();
		fundDetails.setBalanceAmount(1000);
		fundDetails.setLastTransactionTimestamp(new Date());

		int fundId = fundService
				.createFund(fundDetails);

		logger.info("Created fund with id - " + fundId);

		PaymentService paymentService = context
				.getBean(PaymentService.class);

		PaymentDetails payment = new PaymentDetails();
		payment.setActive("Y");
		payment.setFundId(fundDetails);
		payment.setPaymentCreationDate(new Date());
		payment.setPaymentAmount(500);
		payment.setTenure(12);
		int paymentId = paymentService.createPayment(payment);
		logger.info("Created payment with id - " + paymentId);

		logger.info(paymentService.getPaymentDetails(paymentId));
	}
}
