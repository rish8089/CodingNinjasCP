package LanguageTools2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TripletSumOptimised {
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
                int sum = x-arr[i];
                int j=i+1;
                int k=n-1;
                while(j<k){
                    if(arr[j]+arr[k]<sum)
                        j++;
                    else if(arr[j]+arr[k]>sum)
                        k--;
                    else{
                        if(arr[j]==arr[k]){
                            ans += (k - j + 1) * (k - j) / 2;
                        }else{
                            int cnt1 = 1;
                            int cnt2 = 1;
                            while (j + 1 < n && arr[j + 1] == arr[j]) {
                                cnt1 += 1;
                                j++;
                            }
                            while (k - 1 >= 0 && arr[k - 1] == arr[k]) {
                                cnt2 += 1;
                                k--;
                            }
                            ans+=cnt1*cnt2;
                            j++;
                            k--;
                        }
                    }
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
