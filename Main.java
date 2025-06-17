import java.util.*;

public class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t-- > 0) {
         int n = sc.nextInt();
         int[] a = new int[n];

         for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
         }

         int low = 1, high = (int) 1e9;
         int ans = 0;

         while (low <= high) {
            int mid = (low + high) / 2;
            if (possible(mid, a)) {
               ans = mid;
               low = mid + 1;
            } else {
               high = mid - 1;
            }
         }

         System.out.println(ans);

      }
      sc.close();
   }

   public static boolean possible(int x, int[] h) {
      int n = h.length;
      int[] a = Arrays.copyOf(h, n);

      for (int i = n - 1; i >= 0; i--) {
         if (a[i] < x)
            return false;
         else {
            int y = (a[i] - x) / 3;
            y = Math.min(y, a[i] / 3);

            a[i] -= 3 * y;

            if (i > 0)
               a[i - 1] += y;
            if (i > 1)
               a[i - 2] += 2 * y;
         }
      }

      return true;
   }
}
