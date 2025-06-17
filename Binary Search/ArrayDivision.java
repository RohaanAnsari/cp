import java.util.*;

class ArrayDivision {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int n = sc.nextInt();
      int k = sc.nextInt();

      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      
      int ans = (int) 1e9;
      int low = 0, high = (int) 1e9;
      while(low <= high) {
        int mid = (low + high) / 2;

        if(possible(arr, k, mid)) {
          ans = Math.min(ans, mid);
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }

      System.out.println(ans);
      sc.close();
    }

    public static boolean possible(int[] arr, int k, int x) {
        int currentWork = 0;
        int workersUsed = 1;
        for (int i = 0; i < arr.length; i++) {
            if (currentWork + arr[i] <= x) {
                currentWork += arr[i]; 
            } else {
                if (workersUsed == k) return false;
                workersUsed++;

                if(currentWork > x) return false;
                currentWork = arr[i];
            }
        }

        return true;
    }
}