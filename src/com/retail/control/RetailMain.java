package com.retail.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.retail.discount.AffiliateDiscount;
import com.retail.discount.AmountDiscount;
import com.retail.discount.Discount;
import com.retail.discount.EmpDiscount;
import com.retail.discount.SubscribeDiscount;

public class RetailMain {

	
	
	
	private static Map<String, String> itemDetail=new HashMap<>();
	private static Map<String, Double> itemSale=new HashMap<>();
	private static Map<String, Double> itemWithoutgroceries=new HashMap<>();
	
	private Discount discountObj;
	public RetailMain(){
		this.discountObj=new EmpDiscount();
		Discount discountObj1=new AffiliateDiscount();
		Discount discountObj2=new SubscribeDiscount();
		Discount discountObj3=new AmountDiscount();
		discountObj.setNextDiscount(discountObj1);
		discountObj1.setNextDiscount(discountObj2);
		discountObj2.setNextDiscount(discountObj3);
	}
	
	public static void main(String[] args) throws IOException {
		RetailMain retailMain=new RetailMain();
		RetailMain.itemAdd();
		
		
		String check="y";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter customer mobile no");
		String mblNo = reader.readLine();
		System.out.println("Item Avaiable in store"+mblNo);
		RetailMain.itemList();
		do{
		System.out.println("Add item to sell: ");
		String item = reader.readLine();
		System.out.println("Price: ");
		double itemPrice = Double.parseDouble(reader.readLine());
		itemSale.put(item, itemPrice);
		if(!itemDetail.get(item).equalsIgnoreCase("groceries")){
			itemWithoutgroceries.put(item, itemPrice);
		}
		System.out.println("Do you want to continue(y/n)");
		check=reader.readLine();
		}while(check.equalsIgnoreCase("y"));
		System.out.println("================================================");
		System.out.println("Bill");
		itemSale();
		System.out.println("Total Amount:"+amountWithgroceries());
		
		double afterDiscount=retailMain.discountObj.getDiscount(mblNo,amountWithoutgroceries());
		System.out.println("discount.."+afterDiscount);
		System.out.println("Net Amount: "+(amountWithgroceries()-afterDiscount));
	}
	private static double amountWithoutgroceries(){
		double amount=0;
		for(Map.Entry<String, Double> item:itemWithoutgroceries.entrySet()){
			amount=amount+item.getValue();
		}
		return amount;
	}
	private static double amountWithgroceries(){
		double amountTotal=0;
		for(Map.Entry<String, Double> item:itemSale.entrySet()){
			amountTotal=amountTotal+item.getValue();
		}
		return amountTotal;
	}
	private static void itemWithoutgroceries(){
		for(Map.Entry<String, Double> item:itemWithoutgroceries.entrySet()){
			System.out.println("Item: "+item.getKey()+"....price: "+item.getValue());
		}
	}
	private static void itemSale(){
		for(Map.Entry<String, Double> item:itemSale.entrySet()){
			System.out.println("Item: "+item.getKey()+"....price: "+item.getValue());
		}
	} 
	private static void itemList(){
		for(Map.Entry<String, String> item:itemDetail.entrySet()){
			System.out.println("Name: "+item.getKey()+"....Category: "+item.getValue());
		}
	}
	private static void itemAdd(){
		itemDetail.put("Sugar", "groceries");
		itemDetail.put("Dal", "groceries");
		itemDetail.put("Oil", "groceries");
		itemDetail.put("Rice", "groceries");
		itemDetail.put("xyz", "x");
		itemDetail.put("abc", "y");
		itemDetail.put("pqr", "p");
		itemDetail.put("pill", "dish Cean");
	}
	
	
	
	

}
