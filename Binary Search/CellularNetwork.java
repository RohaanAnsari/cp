import java.util.*;

public class CellularNetwork {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        long[] cities = new long[n];
        long[] towers = new long[m];

        for (int i = 0; i < n; i++) cities[i] = sc.nextLong();
        for (int i = 0; i < m; i++) towers[i] = sc.nextLong();

        Arrays.sort(towers);  

        long low = 0, high = (long) 2e9;
        while (low < high) {
            long mid = (low + high) / 2;
            if (check(cities, towers, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(low);
        sc.close();
    }

    public static boolean check(long[] cities, long[] towers, long r) {
        for (long city : cities) {
            int lb = lowerBound(towers, city);
            long minDist = Long.MAX_VALUE;

            if (lb < towers.length) {
                minDist = Math.min(minDist, Math.abs(towers[lb] - city));
            }
            if (lb > 0) {
                minDist = Math.min(minDist, Math.abs(towers[lb - 1] - city));
            }

            if (minDist > r) return false;
        }
        return true;
    }

    public static int lowerBound(long[] arr, long target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low; // first index where arr[i] >= target
    }
}
