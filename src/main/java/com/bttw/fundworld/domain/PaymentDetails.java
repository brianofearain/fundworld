package com.bttw.fundworld.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "PaymentDetails")
@Table(name = "payment_details")
public class PaymentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "payment_id")
	private int paymentId;

	@ManyToOne
	@JoinColumn(name = "FUND_ID", referencedColumnName = "FUND_ID", nullable = false)
	private FundDetails fundId;

	@Column(name = "payment_creation_date")
	private Date paymentCreationDate;

	@Column(name = "amount")
	private int paymentAmount;

	@Column(name = "tenure")
	private int tenure;

	@Column(name = "active")
	private String active;

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public Date getPaymentCreationDate() {
		return paymentCreationDate;
	}

	public void setPaymentCreationDate(Date paymentCreationDate) {
		this.paymentCreationDate = paymentCreationDate;
	}

	public int getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public FundDetails getFundId() {
		return fundId;
	}

	public void setFundId(FundDetails fundId) {
		this.fundId = fundId;
	}

	@Override
	public String toString() {
		return "PaymentDetails [paymentId=" + paymentId
				+ ", fundId=" + fundId + ", paymentCreationDate="
				+ paymentCreationDate + ", paymentAmount=" + paymentAmount + ", tenure="
				+ tenure + ", active=" + active + "]";
	}

	@Override
	public boolean equals(Object obj) {
		PaymentDetails other = (PaymentDetails) obj;
		if (other.getPaymentId() == this.paymentId) {
			return true;
		} else {
			return false;
		}
	}
}