package com.retail.discount;

import java.util.HashMap;
import java.util.Map;

public class AffiliateDiscount implements Discount {
	private static Map<String, String> affiliateDetail=new HashMap<>();//key=mobile no, value=name
	private static final double disPer=10;
	private Discount discount;
	public AffiliateDiscount() {
		affiliateAdd();
	}
	@Override
	public void setNextDiscount(Discount discount) {
		this.discount=discount;

	}

	@Override
	public double getDiscount(String mblNo,double amt) {
		
		if(affiliateDetail.get(mblNo)!=null){
			return amt*disPer/100;
		}else{
			return discount.getDiscount(mblNo,amt);
		}
		

	}
	private static void affiliateAdd(){
		affiliateDetail.put("8000180001", "Suraj");
		affiliateDetail.put("8000180002", "Asish");
		affiliateDetail.put("8000180003", "Samrat");
		affiliateDetail.put("8000180004", "Deep");
		affiliateDetail.put("8000180005", "Tarkesh");
	}

}
