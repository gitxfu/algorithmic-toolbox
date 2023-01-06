import java.util.*;
/*
* Find the minimum number of operations needed to get
* a positive integer n from 1 by using only three operations:
* add 1, multiply by 2, and multiply by 3.*/

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    private static List<Integer> optimal_sequence_dp(int n) {
        List<Integer> sequence = new ArrayList<>();
        int[] path = new int[n + 1];
        int[] minStep = new int[n + 1];
        // i start from 2 to n, minStep[1] = 0,
        for (int i = 2; i <= n; i++) {
            // assume +1 is the best
            minStep[i] = minStep[i - 1] + 1; // add 1 operation
            path[i] = i - 1;
            // assume *2 is the best
            // can be divided by 2 and the resulting minStep < previous one assuming +1
            if (i % 2 == 0 && minStep[i / 2] < minStep[i]) {
                // update minStep to the smaller one
                minStep[i] = minStep[i / 2] + 1; // add 1 operation
                path[i] = i / 2;
            }
            // assume *3 is the best
            // can be divided by 2 and the resulting minStep < previous one assuming +1
            if (i % 3 == 0 && minStep[i / 3] < minStep[i]) {
                // update minStep to the smaller one
                minStep[i] = minStep[i / 3] + 1; // add 1 operation
                path[i] = i / 3;
            }
        }
        // add the number itself
        sequence.add(n);
        // select path to sequence, follow path
        for (int i = n; i > 1; i = path[i]) {
            sequence.add(path[i]);
        }


        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence_dp(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

