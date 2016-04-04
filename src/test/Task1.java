package test;

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


        if (cents < 0) return null;

//        int[] coins = minChange(denom, cents);
//        System.out.println(cents + " cents: " + Arrays.toString(coins));

//        minCoins(cents, denom);

        System.out.println("Total amount: " + cents);
        int totalAmt = cents;
        int tCount[] = new int[totalAmt + 1];
        int R[] = new int[totalAmt + 1];
        tCount[0] = 0;
        for(int i=1; i <= totalAmt; i++){
            tCount[i] = Integer.MAX_VALUE-1;
            R[i] = -1;
        }
        for(int j=0; j < denom.length; j++){
            for(int i=1; i <= totalAmt; i++){
                if(i >= denom[j]){
                    if (tCount[i - denom[j]] + 1 < tCount[i]) {
                        tCount[i] = 1 + tCount[i - denom[j]];
                        R[i] = j;
                    }
                }
            }
        }
//        printCoinCombination(R, denom);
        int dollars = 0;
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int cts = 0;

        if (R[R.length - 1] == -1) {
            return null;
        }

        int start = R.length - 1;
        while ( start != 0 ) {
            int j = R[start];
            System.out.println(denom[j] + " ");

            switch (denom[j]) {
                case 100:
                    dollars++;
                    break;
                case 25:
                    quarters++;
                    break;
                case 10:
                    dimes++;
                    break;
                case 5:
                    nickels++;
                    break;
                case 1:
                    cts++;
            }

            start = start - denom[j];
        }


        Change change = new Change(dollars, quarters, dimes, nickels, cts);

    	return change;

    }

    public static int minCoins(int totalAmt, int denom[]){
        int tCount[] = new int[totalAmt + 1];
        int R[] = new int[totalAmt + 1];
        tCount[0] = 0;
        for(int i=1; i <= totalAmt; i++){
            tCount[i] = Integer.MAX_VALUE-1;
            R[i] = -1;
        }
        for(int j=0; j < denom.length; j++){
            for(int i=1; i <= totalAmt; i++){
                if(i >= denom[j]){
                    if (tCount[i - denom[j]] + 1 < tCount[i]) {
                        tCount[i] = 1 + tCount[i - denom[j]];
                        R[i] = j;
                    }
                }
            }
        }
        printCoinCombination(R, denom);
        return tCount[totalAmt];
    }

    public static int[] minChange(int[] denom, int totalAmt) {
        int n = denom.length;
        int[] tCount = new int[totalAmt + 1];
        int[] from = new int[totalAmt + 1];

        tCount[0] = 1;
        for (int i = 0 ; i < totalAmt; i++) {
            if (tCount[i] > 0) {
                for (int j = 0; j < n; j++) {
                    int p = i + denom[j];
                    if (p <= totalAmt) {
                        if (tCount[p] == 0 || tCount[p] > tCount[i] + 1) {
                            tCount[p] = tCount[i] + 1;
                            from[p] = j;
                        }
                    }
                }
            }
        }

        // No solution
        if (tCount[totalAmt] == 0)
            return null;

        // Construct result
        int[] result = new int[tCount[totalAmt] - 1];
        int k = totalAmt;
        while (k > 0) {
            result[tCount[k] - 2] = denom[from[k]];
            k = k - denom[from[k]];
        }

        return result;
    }

    private static void printCoinCombination(int R[], int coins[]) {
        if (R[R.length - 1] == -1) {
            System.out.print("No solution is possible");
            return;
        }
        int start = R.length - 1;
        System.out.print("Coins used to form total ");
        while ( start != 0 ) {
            int j = R[start];
            System.out.print(coins[j] + " ");
            start = start - coins[j];
        }
        System.out.print("\n");
    }

    public static void main(String args[]) {
        Change c = new Change(0,0,0,0,0);
//        c = getCorrectChange(0);
//        c = getCorrectChange(1);
//        printChange(c);
        c = getCorrectChange(5);
        printChange(c);
//        c = getCorrectChange(11);
//        printChange(c);
//        c = getCorrectChange(164);
//        printChange(c);
//        c = getCorrectChange(120);
//        printChange(c);
//        c = getCorrectChange(Integer.MAX_VALUE);
//        printChange(c);
    }

    static void printChange(Change c) {
        System.out.println("  Dollars: " + c.getDollars());
        System.out.println("  Quarters: " + c.getQuarters());
        System.out.println("  Dimes: " + c.getDimes());
        System.out.println("  Nickels: " + c.getNickels());
        System.out.println("  Cents: " + c.getCents());
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
