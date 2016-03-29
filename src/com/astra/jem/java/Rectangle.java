package com.astra.jem.java;

import java.math.BigInteger;

/**
 * Created by Jem on 2016/03/26.
 */
public class Rectangle {
    public int solution (int k, int l, int m, int n, int p, int q, int r, int s){

        int intx1 = Math.max(k,p);
        int intx2 = Math.min(m,r);
        int inty1 = Math.max(l,q);
        int inty2 = Math.min(n,s);
        int areaInt;
        if (intx1 >= intx2 || inty1 >= inty2){
            areaInt = 0;
        } else {
            areaInt = area(intx1, intx2, inty1, inty2);
        }


        if (areaInt == -1) return -1;

        int areaA = area(k,m,l,n);
        if (areaA == -1) return -1;

        int areaB = area(p,r,q,s);
        if (areaB == -1) return -1;

        int areaT = areaA + areaB - areaInt;
        return areaT;
    }

    public int area(int x1, int x2, int y1, int y2) {
        long x= (long)x2-(long)x1;
        long y = (long)y2-(long)y1;

        int a = safeMultiply(x,y);
        return a;
    }

    static final int safeMultiply(long left, long right) {
        if (right > 0 ? left > Integer.MAX_VALUE/right
                || left < Integer.MIN_VALUE/right
                : (right < -1 ? left > Integer.MIN_VALUE/right
                || left < Integer.MAX_VALUE/right
                : right == -1
                && left == Integer.MIN_VALUE) ) {
//            throw new ArithmeticException("Integer overflow");
            return -1;
        }
        return (int)(left * right);
    }
}
