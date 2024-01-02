import java.util.*;

public class Main {
    public static int findFirstPosition(int[] arr, int n, int key) {
        int lo = 0;
        int hi = n - 1;

        int pans = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] == key) {
                pans = mid;
                hi = mid - 1;
            } else if (arr[mid] < key) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return pans;
    }

    public static int findLastPostion(int[] arr, int n, int key) {
        int lo = 0;
        int hi = n - 1;

        int pans = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] == key) {
                pans = mid;
                lo = mid + 1;
            } else if (arr[mid] < key) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return pans;
    }

    // TC: O(log N), SC: O(1)
    public static void findPosition(int a[], int n,int k)
    {
        // Write code here
        int fp = findFirstPosition(a, n, k);
        int lp = findLastPostion(a, n, k);

        System.out.println(fp + " " + lp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        findPosition(array,n,k);
    }
}