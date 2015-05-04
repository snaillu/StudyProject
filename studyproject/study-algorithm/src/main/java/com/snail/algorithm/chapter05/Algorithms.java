package com.snail.algorithm.chapter05;

import java.io.File;

public class Algorithms {
	//factorial
	public static int factorial(int n) throws IllegalArgumentException{
		if(n<0)
			throw new IllegalArgumentException();
		else if(n==0)
			return 1;
		else
			return n*factorial(n-1);
	}
	
	//draw English ruler
	public static void drawRuler(int nInches,int majorLength){
		drawLine(majorLength,0);
		for(int j=1;j<=nInches;j++){
			drawInterval(majorLength-1);
			drawLine(majorLength,j);
		}
	}
	
	private static void drawInterval(int centralLength){
		if(centralLength>=1){
			drawInterval(centralLength-1);
			drawLine(centralLength);
			drawInterval(centralLength-1);
		}
	}
	
	private static void drawLine(int tickLength,int tickLabel){
		for(int j=0;j<tickLength;j++)
			System.out.print("-");
		if(tickLabel>=0)
			System.out.print(" "+tickLabel);
		System.out.print("\n");
	}
	
	private static void drawLine(int tickLength){
		drawLine(tickLength,-1);
	}
	
	//binary search
	public static boolean binarySearch(int[] data,int target,int low,int high){
		if(low>high)
			return false;
		else{
			int mid = (low+high)/2;
			if(target==data[mid])
				return true;
			else if(target<data[mid])
				return binarySearch(data,target,low,mid-1);
			else
				return binarySearch(data,target,mid+1,high);
		}
	}
	
	public static long diskUsage(File root){
		long total = root.length();
		if(root.isDirectory()){
			for(String childname:root.list()){
				File child = new File(root,childname);
				total += diskUsage(child);
			}
		}
		System.out.println(total+"\t"+root);
		return total;
	}
	
	public static void main(String[] args) {
//		int result = factorial(5);
//		System.out.println("result="+result);
		
//		drawRuler(5,2);
		
//		int[] data = {1,2,3,4,5,6,7,8,11,19,54,56,78};
//		boolean result = binarySearch(data,19,0,data.length);
//		System.out.println("result="+result);
		
		File file = new File("D:\\Code");
		diskUsage(file);
	}
}
