package test;

public class Task1 {

    static int[] denom = {1, 5, 10, 25, 100};

    public static Change getCorrectChange(int cents) {
        /*
          Please implement this method to
          take cents as a parameter
          and return an equal amount in dollars and coins using the minimum number of
          coins possible.
          For example: 164 cents = 1 dollar, 2 quarters, 1 dime and 4 cents.
          Return null if the parameter is negative.

         */

        if (cents < 0) return null;

        int total = cents;
        int minCount[] = new int[total + 1];
        int row[] = new int[total + 1];

        // base case
        minCount[0] = 0; // 0 coins needed for 0 cents

        // initialize arrays
        for( int i = 1; i <= total; i++ ){
            minCount[i] = Integer.MAX_VALUE - 1;
            row[i] = -1;
        }

        for( int d = 0; d < denom.length; d++ ) {
            for( int t = 1; t <= total; t++ ) {
                if( t >= denom[d] ) {
                    if ( minCount[t - denom[d]] + 1 < minCount[t] ) {
                        minCount[t] = 1 + minCount[t - denom[d]];
                        row[t] = d;
                    }
                }
            }
        }

        if ( row[row.length - 1] == -1 ) {
            return null;
        }

        int dollars = 0;
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int ones = 0;

        int start = row.length - 1;

        while ( start != 0 ) {
            int d = row[start];

            switch (denom[d]) {
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
            }

            start = start - denom[d];
        }

        Change change = new Change(dollars, quarters, dimes, nickels, ones);

    	return change;
    }


    public static void main(String args[]) {
        Change c = new Change(0,0,0,0,0);
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
    }

    static void printChange(Change c) {
        if (c == null) return;
        int total = c.getDollars()*100 + c.getQuarters()*25
                + c.getDimes()*10 + c.getNickels()*5 + c.getCents();
        System.out.println("Change for: " + total);
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
