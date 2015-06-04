package org.study.java.thread;

import java.util.concurrent.Semaphore;

public class Restaurant {
	private Semaphore tables;
	
	public Restaurant(int tablesCount){
		this.tables = new Semaphore(tablesCount);
	}
	
	public void getTable(int customerId){
		try{
			System.out.println("Customer #"+customerId +" is trying to get a talbe");
			
			tables.acquire();
			
			System.out.println("Customer #"+customerId +" got a table.");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public void returnTable(int customerId){
		System.out.println("Customer #"+customerId+" returned a table.");
		tables.release();
	}
	
	public static void main(String[] args) {
		Restaurant restaurant = new Restaurant(2);
		
		for(int i=1;i<10;i++){
			RestaurantCustomer c = new RestaurantCustomer(restaurant,i);
			c.start();
		}
	}
}
