import java.util.*;
// https://codeforces.com/edu/course/2/lesson/6/4/practice/contest/285069/problem/A

public class MaximumAverage {
   static double leftIndex;
   static double rightIndex;

   public static boolean checker(double[] transformedArray, double d, int n) {
      double[] prefixSum = new double[n];
      double[][] minPrefixSum = new double[n][2]; // Stores {prefixSum, index}

      prefixSum[0] = transformedArray[0];
      minPrefixSum[0][0] = prefixSum[0];
      minPrefixSum[0][1] = 0;

      for (int i = 1; i < n; i++) {
         prefixSum[i] = prefixSum[i - 1] + transformedArray[i];
         if (prefixSum[i] < minPrefixSum[i - 1][0]) {
            minPrefixSum[i][0] = prefixSum[i];
            minPrefixSum[i][1] = i;
         } else {
            minPrefixSum[i][0] = minPrefixSum[i - 1][0];
            minPrefixSum[i][1] = minPrefixSum[i - 1][1];
         }
      }

      for (int i = (int) d - 1; i < n; i++) {
         if (i - d >= 0 && prefixSum[i] - minPrefixSum[i - (int) d][0] >= 0) {
            leftIndex = minPrefixSum[i - (int) d][1] + 1;
            rightIndex = i;
            return true;
         } else if (prefixSum[i] >= 0) {
            leftIndex = 0;
            rightIndex = i;
            return true;
         }
      }

      return false;
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int n = sc.nextInt();
      int d = sc.nextInt();
      double[] arr = new double[n];

      for (int i = 0; i < n; i++) {
         arr[i] = sc.nextDouble();
      }

      double left = 0;
      double right = 100;
      int iterations = 110;

      for (int it = 0; it < iterations; it++) {
         double mid = (left + right) / 2;
         double[] transformedArray = new double[n];

         for (int i = 0; i < n; i++) {
            transformedArray[i] = arr[i] - mid;
         }

         if (checker(transformedArray, d, n)) {
            left = mid;
         } else {
            right = mid;
         }
      }

      System.out.println((int) (leftIndex + 1) + " " + (int) (rightIndex + 1));
      sc.close();
   }

}
