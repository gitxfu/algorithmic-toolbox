import java.util.*;
// failed
public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }

        return sum % 10;
    }

    private static long getFibonacciSumFast(long n) {
        if (n == -1) {
            return 0;
        } else if (n <= 1) {
            return n;
        }

        // Pisano period of module 10 is 60
        long reminder = n % 60;
        if (reminder == 0)
            return 0;

        // Sum of Fib(1) + Fib(2) + ... + Fib(n) = Fib(n+2) - 1
        long previous = 0;
        long current = 1;
        long next = 0;
        long sum = 1;
        // loop from 2 to reminder+2
        for (long i = 2; i < reminder + 3; ++i) {
            next = (previous + current) % 60;
            previous = current;
            current = next;
        }

        return (current - 1) % 10;
    }

    private static long getFibonacciPartialSumFast(long from, long to) {
        long sum = 10 + getFibonacciSumFast(to) - getFibonacciSumFast(from - 1);
        return sum % 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumFast(from, to));
    }
}

