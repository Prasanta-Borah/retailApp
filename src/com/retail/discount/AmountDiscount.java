package com.retail.discount;

public class AmountDiscount implements Discount {
	private static final double disPer=5;
	private Discount discount;
	@Override
	public void setNextDiscount(Discount discount) {
		this.discount=discount;
	}

	@Override
	public double getDiscount(String mblNo,double amt) {
		
		if(amt>=100){
			return amt*disPer/100;
		}
		return 0;

	}

}
