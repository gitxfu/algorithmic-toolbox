import java.util.*;
import java.io.*;

public class MajorityElement {

    private static int countElement(int[] arr, int target, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (arr[i] == target) {
                count++;
            }
        }
        return count;
    }

    private static int getMajorityElement(int[] a, int left, int right) {
        // base case: 1 element array
        if (left == right) {
            return a[left];
        }

        int mid = left + (right - left) / 2;
        // recurse on left and right halves
        int leftMajor = getMajorityElement(a, left, mid);
        int rightMajor = getMajorityElement(a, mid + 1, right);


        // if the two halves agree on the majority element, return it.
        if (leftMajor == rightMajor) {
            return leftMajor;
        }

        // count each element in range and return the one with higher freq
        int leftCount = countElement(a, leftMajor, left, right);
        int rightCount = countElement(a, rightMajor, left, right);

        return leftCount > rightCount ? leftMajor : rightMajor;
    }


    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
//        int[] a = {2, 3, 9, 2, 2};
        int majorElement = getMajorityElement(a, 0, a.length-1);
        int count = countElement(a, majorElement, 0, a.length-1);
//        System.out.println(count);
        if (count <= 1.0 * a.length/2) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

