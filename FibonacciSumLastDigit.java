import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current = 1;
        long sum = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }

    private static long getFibonacciSumFast(long n) {
        if (n <= 1)
            return n;

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
            next = previous + current;
            previous = current;
            current = next;
        }

        return (next - 1) % 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumFast(n);
        System.out.println(s);
    }
}

