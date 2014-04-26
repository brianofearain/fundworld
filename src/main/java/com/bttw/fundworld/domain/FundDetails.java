package com.bttw.fundworld.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "FundDetails")
@Table(name = "fund_details")
public class FundDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fund_id")
	private int fundId;

	@Column(name = "balance_amount")
	private int balanceAmount;

	@Column(name = "last_transaction_ts")
	private Date lastTransactionTimestamp;

	public int getFundId() {
		return fundId;
	}

	public void setFundId(int fundId) {
		this.fundId = fundId;
	}

	public int getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(int balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public Date getLastTransactionTimestamp() {
		return lastTransactionTimestamp;
	}

	public void setLastTransactionTimestamp(Date lastTransactionTimestamp) {
		this.lastTransactionTimestamp = lastTransactionTimestamp;
	}

	@Override
	public boolean equals(Object otherObject) {
		FundDetails otherFundDetails = (FundDetails) otherObject;
		if (otherFundDetails.getFundId() == this.fundId) {
			return true;
		} else {
			return false;
		}
	}
}
