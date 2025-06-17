import java.util.*;

public class AverageAndMedian {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
         arr[i] = sc.nextInt();
      }

      System.out.println(bestAverage(arr, n));
      System.out.println(bestMedian(arr, n));

      sc.close();
   }

   public static double bestAverage(int[] arr, int n) {
      double low = 0, high = 1e12;
      double error = 1e-5;
      double avg = 0;

      // no of iterations = log(ss * 10^precision);
      // => log(10^12 * 10^-5)
      // => log(10^7)
      // => 3.32 * 7 = 24.4 ~ 30

      for (int itr = 0; itr <= 50; itr++) {
         double mid = (low + high) / 2;
         double[] transformedArray = new double[n];

         for (int i = 0; i < n; i++) {
            transformedArray[i] = arr[i] - mid;
         }

         if (maxSumChecker(transformedArray, n)) {
            avg = mid;
            low = mid + error;
         } else {
            high = mid - error;
         }
      }

      return avg;
   }

   public static boolean maxSumChecker(double[] arr, int n) {
      double[] d = new double[n];
      d[0] = arr[0];
      d[1] = arr[1] + Math.max(0, d[0]);

      for (int i = 2; i < n; i++) {
         d[i] = arr[i] + Math.max(d[i - 1], d[i - 2]);
      }

      return Math.max(d[n - 1], d[n - 2]) >= 0;
   }

   public static int bestMedian(int[] arr, int n) {
      int low = 0, high = (int) 1e12;
      int median = 0;

      while (low <= high) {
         int mid = (low + high) / 2;
         int[] transformedArray = new int[n];
         for (int i = 0; i < n; i++) {
            transformedArray[i] = arr[i] >= mid ? 1 : -1;
         }

         if (maxMedianChecker(transformedArray, n) > 0) {
            median = mid;
            low = mid + 1;
         } else {
            high = mid - 1;
         }
      }

      return median;
   }

   public static int maxMedianChecker(int[] arr, int n) {
      int[] d = new int[n];
      d[0] = arr[0];
      d[1] = arr[1] + Math.max(0, d[0]);

      for (int i = 2; i < n; i++) {
         d[i] = arr[i] + Math.max(d[i - 1], d[i - 2]);
      }

      return Math.max(d[n - 1], d[n - 2]);

   }

}
