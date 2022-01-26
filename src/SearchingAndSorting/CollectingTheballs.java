package SearchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CollectingTheballs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            long n = Long.parseLong(br.readLine());
            long u = 1;
            long v = n;
            long ans = -1;
            while (u <= v) {
                long mid = u + (v - u) / 2;
                if (canTakeAtleastHalfCandies(n, mid)) {
                    ans = mid;
                    v = mid - 1;
                } else
                    u = mid + 1;
            }
            System.out.println(ans);
            t--;
        }
    }

    private static boolean canTakeAtleastHalfCandies(long n, long k) {
        long cnt = 0;
        long m = n;
        while (n > 0) {
            if (n < k) {
                cnt = cnt + n;
                break;
            }
            n = n - k;
            cnt += k;
            if (n > 0) {
                 n = n - n / 10;
            }
        }
        return cnt >= (m+1) / 2;
    }
}
