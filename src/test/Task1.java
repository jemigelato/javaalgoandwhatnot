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

    	return null;
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
        int[] denoms =  {25, 10, 5, 1};
        findMinCoins(5, denoms);
    }

    static int findMinCoins (int Sum, int denoms [])
    {
        int[] lookup = new int[Sum+1];
        lookup[0] = 0;
        int[] biggestDenomAtSumK = new int[Sum+1];
        biggestDenomAtSumK[0] = -1;

        for (int i=0; i<denoms.length; i++)
        {
            for (int S=1; S<=Sum; S++)
            {
                if (S > denoms[i])
                {
                    int minCoinsWithNewCoin = lookup[S-denoms[i]] + 1;
                    if (minCoinsWithNewCoin < lookup[S] || lookup[S]==0)
                    {
                        lookup[S] = minCoinsWithNewCoin;
                        biggestDenomAtSumK[S] = denoms[i];
                    }
                }
            }
        }

        int S=Sum;
        while (S > 0)
        {
            System.out.println (biggestDenomAtSumK[S]);
            S = S - biggestDenomAtSumK[S];
        }

        return lookup[Sum];
    }

}
