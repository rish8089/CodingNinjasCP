package LanguageTools2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TripletSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(str[i]);
            int x = Integer.parseInt(br.readLine());
            Arrays.sort(arr);
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int rem = x - arr[i] - arr[j];
                    //searh for rem from j+1 to n-1
                    int lpos = leftMostPos(arr, j + 1, n - 1, rem);
                    int rpos = rightMostPos(arr, j + 1, n - 1, rem);
                    if (lpos != -1 && rpos != -1)
                        ans += rpos - lpos + 1;
                }
            }
            System.out.println(ans);
            t--;
        }

    }

    private static int leftMostPos(int[] arr, int u, int v, int target) {
        int pos = -1;
        while (u <= v) {
            int mid = (u + v) / 2;
            if (arr[mid] == target) {
                pos = mid;
                v = mid - 1;
            } else if (arr[mid] < target)
                u = mid + 1;
            else
                v = mid - 1;
        }
        return pos;
    }

    private static int rightMostPos(int[] arr, int u, int v, int target) {
        int pos = -1;
        while (u <= v) {
            int mid = (u + v) / 2;
            if (arr[mid] == target) {
                pos = mid;
                u = mid + 1;
            } else if (arr[mid] < target)
                u = mid + 1;
            else
                v = mid - 1;
        }
        return pos;
    }
}
