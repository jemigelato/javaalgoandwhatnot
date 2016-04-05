package test;

public class Task1 {

    private static final int[] DEN = {1, 5, 10, 25, 100};

    public static Change getCorrectChange(int cents) {
        /*
          Please implement this method to
          take cents as a parameter
          and return an equal amount in dollars and coins using the minimum number of
          coins possible.
          For example: 164 cents = 1 dollar, 2 quarters, 1 dime and 4 cents.
          Return null if the parameter is negative.

         */

        if (cents < 0) {
            return null;
        }

        int minCount[] = new int[cents + 1];
        int row[] = new int[cents + 1];

        // base case
        minCount[0] = 0; // 0 coins needed for 0 cents

        // initialize arrays
        for (int i = 1; i <= cents; i++){
            minCount[i] = Integer.MAX_VALUE - 1;
            row[i] = -1;
        }

        for (int d = 0; d < DEN.length; d++ ) {
            for (int c = 1; c <= cents; c++) {
                if (c >= DEN[d]) {
                    if ( minCount[c - DEN[d]] + 1 < minCount[c] ) {
                        minCount[c] = 1 + minCount[c - DEN[d]];
                        row[c] = d;
                    }
                }
            }
        }

        if (row[row.length - 1] == -1) {
            return null;
        }

        int dollars = 0;
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int ones = 0;

        int start = row.length - 1;

        while (start != 0) {
            int d = row[start];

            switch (DEN[d]) {
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
                    ones++;
                    break;
                default: break;
            }

            start = start - DEN[d];
        }

    	return new Change(dollars, quarters, dimes, nickels, ones);
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

    public static void main(String args[]) {
        Change c;
        c = getCorrectChange(0);
        c = getCorrectChange(1);
        printChange(c);
        c = getCorrectChange(6);
        printChange(c);
        c = getCorrectChange(11);
        printChange(c);
        c = getCorrectChange(164);
        printChange(c);
        c = getCorrectChange(120);
        printChange(c);
        c = getCorrectChange(141);
        printChange(c);
    }

    static void printChange(Change c) {
        if (c == null) {
            return;
        }
        int total = c.getDollars()*100 + c.getQuarters()*25
                + c.getDimes()*10 + c.getNickels()*5 + c.getCents();
        System.out.println("Change for: " + total + " cents");
        System.out.println("  Dollars: " + c.getDollars());
        System.out.println("  Quarters: " + c.getQuarters());
        System.out.println("  Dimes: " + c.getDimes());
        System.out.println("  Nickels: " + c.getNickels());
        System.out.println("  Cents: " + c.getCents());
    }

}
