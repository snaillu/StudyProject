package com.snail.algorithm.sort;

public class QuickSort {
	private static int[] data = {32,1,3,43,32,2,9,8,13,54};
	
	public static void quickSort(int[] data,int low,int high){
		
		
		if(low<high){
			int i = low,j=high,pivot=data[low];
			while(i<j){
				while(i<j && data[j]>pivot)
					j--;
				if(i<j)
					data[i++]=data[j];
				
				while(i<j && data[i]<pivot)
					i++;
				if(i<j)
					data[j--] = data[i];
			}
			data[i] = pivot;
			quickSort(data,low,i-1);
			quickSort(data,i+1,high);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("before sort:");
		print();
		quickSort(data,0,data.length-1);
		System.out.println("after sort:");
		print();
	}
	
	public static void print(){
		for(int i=0;i<data.length;i++){
			System.out.print(data[i]+"  ");
		}
	}
}
