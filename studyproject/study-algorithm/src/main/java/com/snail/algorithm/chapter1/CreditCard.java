package com.snail.algorithm.chapter1;

import com.sun.istack.internal.logging.Logger;

public class CreditCard {
	private static Logger logger = Logger.getLogger(CreditCard.class);
	
	private String customer;
	private String bank;
	private String account;
	private int limit;
	protected double balance;
	
	public CreditCard(String cust,String bk,String acnt,int lim,double initialBal){
		customer = cust;
		bank = bk;
		account = acnt;
		limit = lim;
		balance = initialBal;
	}
	
	public CreditCard(String cust,String bk,String acnt,int lim){
		this(cust,bk,acnt,lim,0.0);
	}
	
	//Accessor method
	public String getCustomer(){return customer;}
	public String getBank(){return bank;}
	public String getAccount(){return account;}
	public int getLimit(){return limit;}
	public double getBalance(){return balance;}
	
	//Update methods
	public boolean charge(double price){
		if(price+balance>limit){
			return false;
		}
		balance += price;
		
		return true;
	}
	
	public void makePayment(double amount){
		balance -= amount;
	}
	
	public static void printSummary(CreditCard card){
		logger.info("Customer = "+card.customer);
		logger.info("Bank = "+card.bank);
		logger.info("Account = "+card.balance);
		logger.info("Limit = "+card.limit);
	}
	
	public static void main(String[] args) {
		CreditCard[] wallet = new CreditCard[3];
		wallet[0] = new CreditCard("Snail","Bank of China","321323",20000);
		wallet[1] = new CreditCard("Snail","Bank of UK","321323",3000);
		wallet[2] = new CreditCard("Snail","Bank of USA","321323",2400);
		
		for(int val=1;val<=16;val++){
			wallet[0].charge(3*val);
			wallet[1].charge(2*val);
			wallet[2].charge(val);
		}
		
		for(CreditCard card: wallet){
			CreditCard.printSummary(card);
			while(card.getBalance()>200.0){
				card.makePayment(200);
				logger.info("New Balance = "+card.getBalance());
			}
		}
	}
}
