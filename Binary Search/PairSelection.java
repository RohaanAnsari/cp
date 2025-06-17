
// https://codeforces.com/edu/course/2/lesson/6/4/practice/contest/285069/problem/C
import java.util.*;

public class PairSelection {

   public static class Pair {
      int a, b;

      public Pair(int a, int b) {
         this.a = a;
         this.b = b;
      }
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int n = sc.nextInt();
      int k = sc.nextInt();
      Pair[] arr = new Pair[n];

      for (int i = 0; i < n; i++) {
         int first = sc.nextInt();
         int second = sc.nextInt();
         Pair p = new Pair(first, second);
         arr[i] = p;
      }

      double res = solve(arr, n, k);
      System.out.println(res);

      sc.close();
   }

   public static double solve(Pair[] arr, int n, int k) {
      double error = 1e-7;
      double low = error, high = 1e6;
      double ans = 0;

      // log2(high - low) * 10^precision => log2(10^6 - 10^-7) * 10^6
      // log2(10^15) => 3.322 * 15 => 49.83 -> no of iterations
      for (int itr = 0; itr < 60; itr++) {
         double mid = (low + high) / 2;
         double[] transformedArr = new double[n];
         for (int i = 0; i < n; i++) {
            transformedArr[i] = arr[i].a - mid * arr[i].b; // Fixed property names
         }

         if (checker(transformedArr, k, n)) {
            ans = mid;
            low = mid + error;
         } else {
            high = mid - error;
         }
      }

      return ans;
   }

   public static boolean checker(double[] transformedArr, int k, int n) {
      Arrays.sort(transformedArr); // Sorting transformed array directly
      double sum = 0;

      // Select the top `k` largest elements
      for (int i = 0; i < k; i++) {
         sum += transformedArr[n - i - 1];
      }

      return sum >= 0;
   }
}
