package com.retail.discount;

import java.util.HashMap;
import java.util.Map;

public class SubscribeDiscount implements Discount {
	private static Map<String, String> subscribeDetail=new HashMap<>();//key=mobile no, value=name
	private static final double disPer=5;
	private Discount discount;
	public SubscribeDiscount() {
		subscribeAdd();
	}
	@Override
	public void setNextDiscount(Discount discount) {
		this.discount=discount;

	}

	@Override
	public double getDiscount(String mblNo,double amt) {
		
		if(subscribeDetail.get(mblNo)!=null){
			return amt*disPer/100;
		}else{
			return discount.getDiscount(mblNo,amt);
		}
		

	}
	private static void subscribeAdd(){
		subscribeDetail.put("7000170001", "Pankaj");
		subscribeDetail.put("7000170002", "Raghav");
		subscribeDetail.put("7000170003", "Nilu");
		subscribeDetail.put("7000170004", "Pranjal");
	}

}
