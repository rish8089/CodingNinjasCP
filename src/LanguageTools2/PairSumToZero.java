package LanguageTools2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PairSumToZero {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(str[i]);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(arr[i]);
        Collections.sort(list);
        int j = 0;
        int k = n - 1;
        int ans = 0;
        while (j < k) {
            if (list.get(j) + list.get(k) < 0)
                j++;
            else if (list.get(j) + list.get(k) > 0)
                k--;
            else {
                if (list.get(j).equals(list.get(k))) {
                    ans += (k - j + 1) * (k - j) / 2;
                } else {
                    int cnt1 = 1;
                    int cnt2 = 1;
                    while (j + 1 < k && list.get(j + 1).equals(arr[j])) {
                        cnt1 += 1;
                        j++;
                    }
                    while (k - 1 > j && list.get(k - 1).equals(arr[k])) {
                        cnt2 += 1;
                        k--;
                    }
                    ans += cnt1 * cnt2;
                    j++;
                    k--;
                }
            }
        }
        System.out.println(ans);

    }
}
