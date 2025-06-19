import java.util.*;

class AggressiveCows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  

        while (t-- > 0) {
            int n = sc.nextInt(); 
            int c = sc.nextInt(); 

            int[] stalls = new int[n];
            for (int i = 0; i < n; i++) {
                stalls[i] = sc.nextInt();
            }

            Arrays.sort(stalls);
            int res = solve(n, c, stalls);
            System.out.println(res);
        }

        sc.close();
    }

    public static int solve(int n, int c, int[] stalls) {
        int low = 1;
        int high = stalls[n - 1] - stalls[0];
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (check(stalls, c, mid)) {
                ans = mid;  
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static boolean check(int[] arr, int c, int x) {
        int lastPlacedCow = arr[0];
        c--;  

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - lastPlacedCow >= x) {
                lastPlacedCow = arr[i];
                c--;
                if (c == 0) return true;
            }
        }

        return false;
    }
}
