/*
 * @(#)Sort.java 2019-1-15 下午3:09:14
 * PrcWeb
 * Copyright 2019 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.binmma.algorithm;

import org.junit.Test;

/**
 * 排序算法
 * 
 * Sort
 * @author mabin
 * @version 1.0
 *
 */
public class Sort {
    @Test
    public void testSort() {
        int[] numbers = new int[] { 1, 5, 2, 7, 1, 9, 10 };
        System.out.println("排序前结果" + toString(numbers));
        //        bubbleSort(numbers);
        selectSort(numbers);
        System.out.println("排序后结果" + toString(numbers));
    }
    /**
     * 冒泡排序
     * @param numbers
     */
    public void bubbleSort(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return;
        }
        for (int i = 0; i < numbers.length - 1; i++) {//减一 最后一趟不需要自己和自己再比较了
            for (int j = 0; j < numbers.length - i - 1; j++) {//每一趟最后一个数没有他下面的数了 第一趟尤为明显 直接数组越界
                if (numbers[j] < numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * @param numbers
     */
    public void selectSort(int [] numbers){
        if (numbers == null || numbers.length == 0) {
            return;
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < numbers.length; j++) {
                if (numbers[j] > numbers[i]) {
                    minIndex = j;
                }
            }
            int temp = numbers[minIndex];
            numbers[minIndex] = numbers[i];
            numbers[i] = temp;
        }
    }

    public String toString(int[] numbers) {
        StringBuffer print = new StringBuffer("[");
        for (int i = 0; i < numbers.length; i++) {
            print.append(numbers[i] + ",");
        }
        print.deleteCharAt(print.length() - 1);
        print.append("]");
        return print.toString();
    }

}
