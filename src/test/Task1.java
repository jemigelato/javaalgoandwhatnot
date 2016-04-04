package test;

import java.util.Arrays;

public class Task1 {
    public static Change getCorrectChange(int cents) {
        /*
          Please implement this method to
          take cents as a parameter
          and return an equal amount in dollars and coins using the minimum number of
          coins possible.
          For example: 164 cents = 1 dollar, 2 quarters, 1 dime and 4 cents.
          Return null if the parameter is negative.

         */
//        int[] denom = {1, 5, 10, 25, 100};
        int[] denom = {1, 2, 3};
        int[] coins = minChange(denom, cents);
        System.out.println(cents + " cents:" + Arrays.toString(coins));

    	return null;
    }

    public static int[] minChange(int[] denom, int totalAmt) {
        int n = denom.length;
        int[] count = new int[totalAmt + 1];
        int[] from = new int[totalAmt + 1];

        count[0] = 1;
        for (int i = 0 ; i < totalAmt; i++) {
            if (count[i] > 0) {
                for (int j = 0; j < n; j++) {
                    int p = i + denom[j];
                    if (p <= totalAmt) {
                        if (count[p] == 0 || count[p] > count[i] + 1) {
                            count[p] = count[i] + 1;
                            from[p] = j;
                        }
                    }
                }
            }
        }



        // No solutions:
        if (count[totalAmt] == 0)
            return null;

        // Build answer.
        int[] result = new int[count[totalAmt] - 1];
        int k = totalAmt;
        while (k > 0) {
            result[count[k] - 2] = denom[from[k]];
            k = k - denom[from[k]];
        }

        return result;
    }

    public static void main(String args[]) {
        getCorrectChange(5);
//        getCorrectChange(11);
//        getCorrectChange(164);
    }


    // Please do not change this class
    static class Change {
        private final int _dollars;
        private final int _quarters; //25 cents
        private final int _dimes; // 10 cents
        private final int _nickels; // 5 cents
        private final int _cents; // 1 cent


        public Change(int dollars, int quarters, int dimes, int nickels, int cents) {
            _dollars = dollars;
            _quarters = quarters;
            _dimes = dimes;
            _nickels = nickels;
            _cents = cents;
        }


        public int getDollars() {
            return _dollars;
        }


        public int getQuarters() {
            return _quarters;
        }


        public int getDimes() {
            return _dimes;
        }


        public int getNickels() {
            return _nickels;
        }


        public int getCents() {
            return _cents;
        }
    }

}
