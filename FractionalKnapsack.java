import java.util.Scanner;
// Maximum Value of the Loot
// Maximizing the Value of the Loot Problem Find the maximal value of items that fit into the backpack.
//Input: The capacity of a backpack W as well as the weights (w 1 ,...,w n )
// and costs (c 1 ,...,c n ) of n different compounds.
//Output: The maximum total value of fractions of items that fit into the backpack of the given capacity:
// i.e., the maximum value of c 1 · f 1 + ··· + c n · f n such that
//w 1 ·f 1 +···+w n ·f n ≤ W and 0 ≤ f i ≤ 1 for all i (f i is the fraction of the i-th item taken to the backpack).

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0.0;
        for (int i = 0; i < weights.length; i++) {
            if (capacity <= 0) {
                return value;
            }


            // initialize the most expensive (value/weight) ratio and index
            double maxPrice = 0.0;
            int maxPriceIndex = 0;
            // loop through non-empty items to find the index of the most expensive (value/weight)
            for (int j = 0; j < weights.length; j++) {
                // skip empty items
                // weights[j] > 0 has to be first in case weights[j] = 0
                if (weights[j] <= 0 ){
                    continue;
                }
                // double currPrice = values[j] / weights[j]; //wrong
                double currPrice = (double) values[j] / weights[j];
                if (currPrice > maxPrice) {
                    maxPrice = currPrice;
                    maxPriceIndex = j;
                }
            }

            // find the min of the most expensive capacity and total capacity
            int amountTaken = Math.min(weights[maxPriceIndex], capacity);
            // add value that was taken from the most expensive
            value += (double) values[maxPriceIndex] * amountTaken / weights[maxPriceIndex];
            // remove the most expensive item from weights
            weights[maxPriceIndex] -= amountTaken;
            // remove the most expensive item from bag capacity
            capacity -= amountTaken;
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        // The first line of the input contains the number n of compounds and the capacity W of a backpack.
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        // The next n lines define the costs and weights of the compounds.
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }

/*        // my test , output 180.0000
        int n = 3;
        int capacity = 50;
        int[] values = {60, 100, 120};
        int[] weights = {20, 50, 30};*/

        System.out.printf("%.4f\n", getOptimalValue(capacity, values, weights));
    }
} 
