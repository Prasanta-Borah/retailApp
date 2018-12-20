package com.retail.discount;

import java.util.HashMap;
import java.util.Map;

public class EmpDiscount implements Discount {
	private static final double disPer=30;
	private static Map<String,String> empDetail=new HashMap<>();//key=mobile no, value=name
	private Discount discount;
	public EmpDiscount() {
		employeeAdd();
	}
	@Override
	public void setNextDiscount(Discount discount) {
		this.discount=discount;

	}

	@Override
	public double getDiscount(String mblNo,double amt) {
		//System.out.println("*************emp"+empDetail.get(mblNo)+"******"+mblNo);
		if(empDetail.containsKey(mblNo)){
			
			return amt*disPer/100;
		}else{
			return discount.getDiscount(mblNo,amt);
		}
		

	}
	private static void employeeAdd(){
		empDetail.put("9000190001", "Ram");
		empDetail.put("9000190002", "Ankit");
		empDetail.put("9000190003", "Ashok");
		empDetail.put("9000190004", "Raja");
		empDetail.put("9000190005", "Utpal");
		empDetail.put("9000190006", "Bito");
	}

}
