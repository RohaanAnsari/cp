
// https://codeforces.com/contest/1479/problem/A
import java.util.*;

public class SearchingLocalMinimum {
   public static int[] ask(int ind, int n, Scanner scanner) {
      int[] ans = new int[3]; // Stores values for a[ind-1], a[ind], a[ind+1]

      // Handle a[ind-1] (left neighbor)
      if (ind - 1 > 0) {
         System.out.println("? " + (ind - 1));
         ans[0] = scanner.nextInt();
      } else {
         ans[0] = Integer.MAX_VALUE; // Treat out-of-bounds as +∞
      }

      // Handle a[ind] (current index)
      System.out.println("? " + ind);
      ans[1] = scanner.nextInt();

      // Handle a[ind+1] (right neighbor)
      if (ind + 1 <= n) {
         System.out.println("? " + (ind + 1));
         ans[2] = scanner.nextInt();
      } else {
         ans[2] = Integer.MAX_VALUE; // Treat out-of-bounds as +∞
      }

      return ans; // Return the array of values
   }

   public static void tell(int idx) {
      System.out.println("! " + idx);
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();

      int low = 1, high = n;
      int ans = -1;

      while (low <= high) {
         int mid = (low + high) / 2;

         int[] val = ask(mid, n, sc);

         if (val[1] < val[2] && val[1] < val[0]) {
            ans = mid;
            break;
         } else if ((val[1] < val[2]) && (val[1] > val[0])) {
            high = mid - 1;
         } else {
            low = mid + 1;
         }
      }

      tell(ans);
      sc.close();
   }

}
