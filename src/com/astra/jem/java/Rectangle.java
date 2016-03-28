package com.astra.jem.java;

import java.math.BigInteger;

/**
 * Created by Jem on 2016/03/26.
 */
public class Rectangle {
    public int solution (int k, int l, int m, int n, int p, int q, int r, int s){
        int MAX = 2147483647;
//        long areaA = area(k,m,l,n);
//        long areaB = area(p,r,q,s);
        BigInteger areaA = area(k,m,l,n);
        BigInteger areaB = area(p,r,q,s);
        int intx1 = Math.max(k,p);
        int intx2 = Math.min(m,r);
        int inty1 = Math.max(l,q);
        int inty2 = Math.min(n,s);
        BigInteger areaInt;
        if (intx1 > intx2 || inty1 > inty2){
            areaInt = new BigInteger("0");
        } else {
            areaInt = area(intx1, intx2, inty1, inty2);
        }

//        if (k>r || q>n || p>m || l>s) {
//            areaInt = 0;
//        } else {
//            if (k<p) {
//                intx1 = p;
//                intx2 = m;
//            } else {
//                intx1 = k;
//                intx2 = r;
//            }
//            if (l<q) {
//                inty1 = q;
//                inty2 = n;
//            } else {
//                inty1 = l;
//                inty2 = s;
//            }
//            areaInt = area(intx1, intx2, inty1, inty2);
//        }

//        long areaT = areaA + (areaB - areaInt);
        BigInteger areaT = areaA.add(areaB.subtract(areaInt));
        BigInteger limit = new BigInteger("2147483647");
//        if (areaT > 2147483647) return -1;
//        return (int)areaT;
        if (areaT.compareTo(limit) == 1) return -1;
        return areaT.intValue();
    }

    public BigInteger area(int x1, int x2, int y1, int y2) {
        BigInteger x = BigInteger.valueOf(x2).subtract(BigInteger.valueOf(x1));
        BigInteger y = BigInteger.valueOf(y2).subtract(BigInteger.valueOf(y1));
//        long x= ((long)x2-(long)x1);
//        long y = ((long)y2-(long)y1);
//        BigInteger a = (long)x * (long)y;

        BigInteger a = x.multiply(y);
        return a;
    }
}
