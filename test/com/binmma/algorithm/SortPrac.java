package com.binmma.algorithm;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortPrac {

	@Test
	public void test() {
		int[] arr = {6,1,2,5,9,18,4,7,10,8};
//        quickSort(arr, 0, arr.length-1);
//        bubbleSort(arr);
        selectSort(arr);
        System.out.println(toString(arr));
	}
	private void selectSort(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			int minIndex = i;
			for(int j=i;j<arr.length;j++){
				if(arr[j]<arr[minIndex]){
					minIndex = j;
				}
			}
			swap(arr,i,minIndex);
		}
		
	}
	private void bubbleSort(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			for(int j = 0;j<arr.length-i-1;j++){
				if(arr[j]>arr[j+1]){
					swap(arr, j, j+1);
				}
			}
		}
	}
	private void quickSort(int[] arr, int start, int end) {
		if(arr==null){
			return;
		}
		int i = start;
		int j = end;
		if(i>j){//递归结束条件
			return;
		}
		int pivot = arr[start];//取参照点
		while(i<j){
			while(i<j&&pivot<=arr[j]){//从左往右遍历 查找小于参照点的位置
				j--;
			}
			while(i<j&&pivot>=arr[i]){//从右往左遍历 查找大雨参照点的位置
				i++;
			}
			if(i<j)
				swap(arr,i,j);
		}
		//交换参照点与中轴位置 使得参照点左侧小于参照点，右侧大雨参照点
		swap(arr,start,i);
		//分治 处理中轴左侧
		quickSort(arr, start, i-1);
		//分治 处理中轴右侧
		quickSort(arr, j+1, end);
	}
	/**
	 * 交换i j
	 * @param arr
	 * @param i
	 * @param j
	 */
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i ]=arr[j];
		arr[j]=temp;
	}
	private String toString(int[] numbers) {
        StringBuffer print = new StringBuffer("[");
        for (int i = 0; i < numbers.length; i++) {
            print.append(numbers[i] + ",");
        }
        print.deleteCharAt(print.length() - 1);
        print.append("]");
        return print.toString();
    }

}
