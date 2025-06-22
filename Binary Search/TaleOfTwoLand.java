import java.util.*;

public class TaleOfTwoLand {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            int val = sc.nextInt();
            arr[i] = Math.abs(val);
        }

        Arrays.sort(arr);

        long ans = 0;
        for(int i = 0; i < n; i++) {
            long itr = upperBound(arr, 2 * arr[i]);
            ans += itr - i - 1;
        }

        System.out.println(ans);
        sc.close();

    }

    public static int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low; // index of first element > target
    }
}


 