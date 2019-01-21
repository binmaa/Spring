/*
 * @(#)NULL.java 2019-1-15 下午5:59:24
 * PrcWeb
 * Copyright 2019 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.binmma.prac;

import org.junit.Test;

/**
 * NULL
 * @author mabin
 * @version 1.0
 *
 */
public class NULL {
    public static void main(String[] args) {
        ((NULL) null).hh();
    }

    /**
     * 
     */
    private void hh() {
        System.out.println("hh");
    }

    public void s() {
        String s = null;
        System.out.println(s);
    }

    @Test
    public void sum() {
        //        System.out.println(1.0 / 2);
        //        System.out.println(sum(1.0));
        sum2();
    }

    public double sum(double i) {
        System.out.println("第" + i + "次调用，1.0/" + i + "本次结果：" + 1.0 / i);
        if (i >= 100) {
            return 1.0 / 100;
        }
        return sum(1.0 + i) + 1.0 / i;
    }

    public void sum2() {
        double sum = 0.0;
        for (int i = 1; i < 100; i++) {
            sum += 1.0 / i;
        }
        System.out.println("sum=" + sum);
    }
}
