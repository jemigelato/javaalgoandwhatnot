package test;

public class Task6 {

    private static final int[] DEN = {50, 25, 10, 5, 1};

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


        int[] sol = new int[cents + 1];

        // Base case, if input = 0
        sol[0] = 1;

        for (int den : DEN) {
            for (int c = den; c <= cents; c++) {
                sol[c] += sol[c - den];
            }
        }

    	return sol[cents];
    }

    public static void main(String args[]) {
        System.out.println(countWaysToProduceGivenAmountOfMoney(0));
        System.out.println(countWaysToProduceGivenAmountOfMoney(5));
        System.out.println(countWaysToProduceGivenAmountOfMoney(11));
        System.out.println(countWaysToProduceGivenAmountOfMoney(15));
    }
}
