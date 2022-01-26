package SearchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InversionCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        long[] a = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = Long.parseLong(str[i]);
        System.out.println(inversionCount(a, 0, n - 1));
    }

    private static long inversionCount(long[] a, int i, int j) {
        if (i < j) {
            int mid = (i + j) / 2;
            return inversionCount(a, i, mid) + inversionCount(a, mid + 1, j) + count(a, i, mid, j);
        }
        return 0;
    }

    private static long count(long[] a, int i, int mid, int j) {
        int u = i;
        int v = mid + 1;
        long cnt = 0;
        long[] temp = new long[j - i + 1];
        int idx = 0;
        while (u <= mid && v <= j) {
            if (a[u] > a[v]) {
                cnt += mid - u + 1;
                temp[idx++] = a[v];
                v++;
            } else {
                temp[idx++] = a[u];
                u++;
            }
        }
        while (u <= mid) {
            temp[idx++] = a[u++];
        }
        while (v <= j) {
            temp[idx++] = a[v++];
        }
        for (int k = i; k <= j; k++)
            a[k] = temp[k-i];
        return cnt;
    }

}
