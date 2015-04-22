package com.snail.algorithm.chapter3;

public class InsertSort {
	public static void insertSort(int[] data){
		for(int i=1;i<data.length;i++){
			int j=i,cur=data[i];
			while(j>0 && data[j-1]>cur){
				data[j] = data[j-1];
				j--;
			}
			data[j] = cur;
		}
	}
	
	public static void main(String[] args) {
		int[] data = {22,1,21,23,65,34,74,2};
		insertSort(data);
		for(int i=0;i<data.length;i++){
			System.out.print(data[i]+"   ");
		}
		System.out.println();
	}
}
