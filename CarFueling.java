//package AlgorithmicToolbox;

import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int n, int[] stops) {
        // Greedy:  stop there if we cannot reach the next one without running out of gas
        int location = 0;
        int minStop = 0;

        // case 1: can reach goal w/o refilling the tank
        if (tank + location >= dist) {
            return 0;
        }
        // case 2: stops empty or first stop too far to reach
        if (stops.length == 0 || stops[0] > tank) {
            return -1;
        }

        // case 3: last stop is not enough to reach dist
        if (dist - stops[stops.length - 1] > tank) {
            return -1;
        }

        // loop through stops
        int i = -1;
        while (i < stops.length - 1) {
            if (stops[i + 1] - location > tank) {
                location = stops[i];
                minStop++;

                if (stops[i + 1] - location <= tank) {
                    i++;
                    continue;
                } else {
                    return -1;
                }
            }
            i++;

        }
        // location ------ last stop ----- dist
        // location = last stop ----- dist
        // check last location to dist
        if (dist - location <= tank) {
            return minStop;
        } else {
            return minStop + 1;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

//        int dist = 500;
//        int tank = 200;
//        int n = 4;
//        int stops[] = {100, 200, 300, 400};

        System.out.println(computeMinRefills(dist, tank, n, stops));
    }
}
