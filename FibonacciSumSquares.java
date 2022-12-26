import java.util.*;

public class FibonacciSumSquares {
    private static long getFibonacciSumSquaresNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current = 1;
        long sum = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current * current;
        }

        return sum % 10;
    }

    private static long getFibonacciSumSquaresFast(long n) {
        // Pisano period of module 10 is 60
        n = n % 60;
        if (n <= 1)
            return n;

        long previous = 0;
        long current = 1;
        long sum = 1;
        // note i < n not n-1
        for (long i = 0; i < n ; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % 10;
        }
        //(f0)^2 + (f1)^2 + (f2)^2 ...+ (fn)^2 = fib(n) * fib(n + 1)
        return (previous * current) % 10;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
//        long s = getFibonacciSumSquaresNaive(n);
        long s = getFibonacciSumSquaresFast(n);
        System.out.println(s);
    }
}

