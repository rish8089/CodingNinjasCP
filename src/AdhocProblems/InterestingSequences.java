package AdhocProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InterestingSequences {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nkl = br.readLine().split(" ");
        int n = Integer.parseInt(nkl[0]);
        long k = Integer.parseInt(nkl[1]);
        long l = Integer.parseInt(nkl[2]);
        String[] str = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(str[i]);
        long minCost = -1;
        for (int i = 0; i < n; i++) {
            //a[i] is the target
            int decreaseOps = 0;
            int increaseOps = 0;
            for (int j = 0; j < n; j++) {
                if (a[j] < a[i])
                    increaseOps += a[i] - a[j];
                else
                    decreaseOps += a[j] - a[i];
            }
            if (decreaseOps <= increaseOps) {
                long cost = decreaseOps * k + (increaseOps - decreaseOps) * l;
                if (minCost == -1 || minCost > cost) {
                    minCost = cost;
                }
            }
        }
        System.out.println(minCost);
    }
}

