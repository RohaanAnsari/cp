// https://codeforces.com/problemset/problem/1419/D2

import java.util.*;

public class SageBirthday {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int[] a = new int[n + 1];

      for (int i = 1; i <= n; i++) {
         a[i] = sc.nextInt();
      }

      Arrays.sort(a, 1, n + 1); // Sort from index 1 to n (1-based index)

      int ans = 0;
      int[] f_ans = new int[n + 1];
      int j = 1;

      // Fill even indices (1-based index, equivalent to odd indices in 0-based)
      for (int i = 2; i <= n; i += 2) {
         f_ans[i] = a[j++];
      }

      // Fill remaining indices
      for (int i = 1; i <= n; i++) {
         if (f_ans[i] == 0) {
            f_ans[i] = a[j++];
         }
      }

      // Count cheap ice spheres
      for (int i = 2; i < n; i += 2) {
         if (f_ans[i] < f_ans[i - 1] && f_ans[i] < f_ans[i + 1]) {
            ans++;
         }
      }

      System.out.println(ans);
      for (int i = 1; i <= n; i++) {
         System.out.print(f_ans[i] + " ");
      }
      System.out.println();

      sc.close();
   }
}
