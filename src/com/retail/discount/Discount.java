package com.retail.discount;

public interface Discount {
	void setNextDiscount(Discount discount);
	double getDiscount(String mblNo,double amt);
}
