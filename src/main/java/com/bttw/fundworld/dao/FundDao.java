package com.bttw.fundworld.dao;

import com.bttw.fundworld.domain.FundDetails;

public interface FundDao {
	int createFund(FundDetails fundDetails);
	void subtractFromFund(int fundId, int amount);
}
