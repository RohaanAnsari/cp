import java.util.*;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long ans = n * n;
        long low = 1, high = (long) n * n;
        long target = ((long) n * n + 1) / 2; 

        while (low <= high) {
            long mid = (low + high) / 2;

            if (possible(n, mid, target)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(ans);
        sc.close();
    }

    public static boolean possible(int n, long x, long target) {
        long count = 0;
        for (int i = 1; i <= n; i++) {
            count += Math.min(n, x / i);
        }
        return count >= target;
    }
}