package test;

import java.util.Arrays;

public class Task6 {

    static int[] denom = {50, 25, 10, 5, 1};

    public static int countWaysToProduceGivenAmountOfMoney(int cents) {
        /*
          Please implement this method to
          return the number of different combinations of US coins
          (penny: 1c, nickel: 5c, dime: 10c, quarter: 25c, half-dollar: 50c)
          which may be used to produce a given amount of money.

          For example, 11 cents can be produced with
          one 10-cent coin and one 1-cent coin,
          two 5-cent coins and one 1-cent coin,
          one 5-cent coin and six 1-cent coins,
          or eleven 1-cent coins.
          So there are four unique ways to produce 11 cents.
          Assume that the cents parameter is always positive.
         */


        int x = findCombinationsCount(cents, denom, 0);
    	return x;

    }

    static int findCombinationsCount(int amount, int denoms[], int indexCheck) {
        if (amount == 0)
            return 1;
        else if (amount < 0 || denoms.length == indexCheck)
            return 0;
        else {
            int comboFirstDenom = findCombinationsCount(amount-denoms[indexCheck], denoms, indexCheck);
            int comboWithoutFirstDenom = findCombinationsCount(amount, denoms, indexCheck+1);
            return comboFirstDenom + comboWithoutFirstDenom;
        }
    }

    public static void main(String args[]) {
        System.out.println(countWaysToProduceGivenAmountOfMoney(11));
        System.out.println(countWaysToProduceGivenAmountOfMoney(0));
        System.out.println(countWaysToProduceGivenAmountOfMoney(5));
        System.out.println(countWaysToProduceGivenAmountOfMoney(15));
    }


}
