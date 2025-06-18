import java.util.*;

public class Worms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] piles = new int[n];
        for(int i = 0; i < n; i++) piles[i] = sc.nextInt();

        int m = sc.nextInt();
        int[] queries = new int[m];
        for(int i = 0; i < m; i++) queries[i] = sc.nextInt();

        int[] presum = new int[n];
        presum[0] = piles[0];
        for(int i = 1; i < n; i++) {
            presum[i] = presum[i - 1] + piles[i];
        }



        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int q = queries[i];

            int low = 0, high = n - 1;
            while(low < high) {
                int mid = (low + high) / 2;
                if(presum[mid] >= q) high = mid;
                else low = mid + 1;
            }

            ans[i] = low + 1; // because it's 1 based indexing 
        }

        for(int i = 0; i < m; i++) System.out.println(ans[i]);

        sc.close();
    }
}