
// https://codeforces.com/edu/course/2/lesson/6/3/practice/contest/285083/problem/A
import java.util.*;

public class GetTogether {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int n = sc.nextInt();
      List<double[]> persons = new ArrayList<>();
      for (int i = 0; i < n; i++) {
         double[] pairs = new double[2];
         pairs[0] = sc.nextInt();
         pairs[1] = sc.nextInt();
         persons.add(pairs);
      }

      double res = solve(persons, n);
      System.out.println(res);

      sc.close();
   }

   public static double solve(List<double[]> persons, int n) {
      double low = 0, high = 1e9;
      double ans = 0;

      // log2(high - low) * 10^precicison => log2[(10^9 - 0) * 10^6]
      // log2(10^15) => 3.322 * 15 => = 49.83 -> no of iterations
      for (int i = 0; i < 60; i++) {
         double mid = (low + high) / 2;

         if (check(persons, mid)) {
            ans = mid;
            high = mid;
         } else {
            low = mid;
         }
      }

      return ans;
   }

   public static boolean check(List<double[]> persons, double time) {
      double minX = -1e18, maxX = 1e18;

      for (int i = 0; i < persons.size(); i++) {
         double[] seg = persons.get(i);
         double initialPos = seg[0];
         double velocity = seg[1];
         minX = Math.max(minX, initialPos - (velocity * time));
         maxX = Math.min(maxX, initialPos + (velocity * time));

         if (minX > maxX) {
            return false;
         }
      }
      return true;
   }
}
