package AdhocProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WinningStrategy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(str[i]);
            int totalExchanges = 0;
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (a[i] == i + 1) {
                    //two neighbors exist
                    if (i - 1 >= 0 && i + 1 < n) {
                        if (a[i - 1] == i + 2 && a[i + 1] == i) {
                            totalExchanges += 2;
                        }
                    }
                } else {
                    int exchanges = abs(a[i] - i - 1);
                    if (exchanges > 2) {
                        flag = false;
                        break;
                    }
                    totalExchanges += exchanges;
                }
            }
            if (flag) {
                System.out.println("YES");
                System.out.println(totalExchanges / 2);
            } else {
                System.out.println("NO");
            }
            t--;
        }
    }

    private static int abs(int x) {
        return x < 0 ? -x : x;
    }
}
