import java.util.*;

class FactoryMachines {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int minTime = Arrays.stream(arr).min().getAsInt();
        long ans = (long) minTime * t;
        long low = 0, high = (long) minTime * t;
        while (low <= high) {
            long mid = (low + high) / 2;

            if (possible(arr, t, mid)) {
                ans = Math.min(ans, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(ans);
        sc.close();
    }

    public static boolean possible(int[] arr, int t, long x) {
        long productsProduced = 0;
        for(int i = 0; i < arr.length; i++) {
            productsProduced += x / arr[i];
            if (productsProduced >= t) return true; // Early exit to prevent overflow
        }

        return productsProduced >= t;
    }
}