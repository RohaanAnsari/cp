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

      for (int i = 0; i < 50; i++) { // Binary search for precision
         double mid = (low + high) / 2;

         if (check(mid, k, arr)) {
            low = mid; // If possible, move low up
         } else {
            high = mid; // Otherwise, move high down
         }
      }

      System.out.printf("%.6f%n", low); // Print with required precision
   }

   public static boolean check(double x, int k, int[] arr) {
      int c = 0;
      for (int i = 0; i < arr.length; i++) {
         c += (int) (arr[i] / x);
      }

      return c >= k;
   }
}
