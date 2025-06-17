// https://codeforces.com/edu/course/2/lesson/6/2/practice/contest/283932/problem/B
import java.util.*;

public class ropes {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int k = sc.nextInt();

      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
         arr[i] = sc.nextInt();
      }

      solve(n, k, arr);
      sc.close();
   }

   public static void solve(int n, int k, int[] arr) {
      double low = 0, high = 1e7;
      double precision = 1e6;

      //  Search Space = log(high - low) * log(10^precision)
      //  log(10^7) * log(10^6) => log(10 ^ 13) => 13 * log(10)
      //  13 * 3.322 => 43.186 ~ 50 iterations.

      for(int i = 1; i <= 50; i++) {
         double mid = (low + high) / 2;
         if(check(arr, mid, k)) {
            low = mid;
         } else {
            high = mid;
         }
      }

      System.out.printf("%.6f%n", low); // Print with required precision
   }

   public static boolean check(int[] arr, double x, int k) {
      int cnt = 0;
      for(int i = 0; i < arr.length; i++) {
         cnt += (int) arr[i] / x;
      }

      return cnt >= k; 
   }

}
