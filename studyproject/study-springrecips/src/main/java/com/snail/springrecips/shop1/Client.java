package com.snail.springrecips.shop1;

import org.springframework.context.ApplicationContext;

import com.snail.springrecips.utils.SpringUtils;

public class Client {
	public static void main(String[] args) {
		ApplicationContext context = SpringUtils.getContext();
		
//		Battery battery = (Battery)context.getBean("aaa");
//		Disc disc = (Disc)context.getBean("cdrm");
//		
//		System.out.println(battery);
//		System.out.println(disc);
		
		
		Product aaa = (Product)context.getBean("aaa");
		Product cdrw = (Product)context.getBean("cdrm");
		Product dvdrw = (Product)context.getBean("dvdrm");
		
		ShoppingCart cart1 = (ShoppingCart)context.getBean("shoppingCart");
		cart1.addItem(aaa);
		cart1.addItem(cdrw);
		
		System.out.println("Shopping cart 1 contains "+cart1.getItems());
		
		ShoppingCart cart2 = (ShoppingCart)context.getBean("shoppingCart");
		cart2.addItem(dvdrw);
		
		System.out.println("Shopping cart2 contains "+cart2.getItems());
	}
}
