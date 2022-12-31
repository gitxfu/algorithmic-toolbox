import java.util.Scanner;
// 3-1: Money Change
// implement a simple greedy algorithm
// Money Change Problem Compute the minimum number of coins needed to
// change the given value into coins with denominations 1, 5, and 10.

public class Change {
    private static int getChange(int m) {
        int numCoins = 0;
        while (m > 0) {
            if (m >= 10){
                m = m - 10;
            } else if (m >= 5){
                m = m - 5;
            } else {
                m = m - 1;
            }
            numCoins++;
        }
        return numCoins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

