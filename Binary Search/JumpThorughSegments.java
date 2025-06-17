
// https://codeforces.com/problemset/problem/1907/D
import java.util.*;

public class JumpThorughSegments {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();

      while (t-- > 0) {
         int n = sc.nextInt();
         List<int[]> list = new ArrayList<>();
         for (int i = 0; i < n; i++) {
            int[] seg = new int[2];
            seg[0] = sc.nextInt();
            seg[1] = sc.nextInt();
            list.add(seg);
         }

         int res = solve(list, n);
         System.out.println(res);
      }

      sc.close();
   }

   public static int solve(List<int[]> list, int n) {
      int low = 0, high = (int) 1e9;
      int ans = 0;

      while (low <= high) {
         int mid = (low + high) / 2;

         if (check(mid, n, list)) {
            ans = mid;
            high = mid - 1;
         } else {
            low = mid + 1;
         }
      }

      return ans;
   }

   public static boolean check(int x, int n, List<int[]> list) {
      double posMin = 0, posMax = 0;
      for (int i = 0; i < n; i++) {
         int[] seg = list.get(i);
         posMin = Math.max(posMin - x, seg[0]);
         posMax = Math.min(posMax + x, seg[1]);

         if (posMin > posMax) {
            return false;
         }
      }
      return true;
   }
}
