//package AdhocProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Equalize {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s1 = br.readLine();
        String s2 = br.readLine();
        List<Integer> zeroPos = new ArrayList<>();
        List<Integer> onePos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (s1.charAt(i) == '0')
                    zeroPos.add(i);
                else
                    onePos.add(i);
            }
        }
        int i=0,j=0;
        long cost=0;
        while (i < zeroPos.size() && j < onePos.size()) {
            int zpos = zeroPos.get(i);
            int opos = onePos.get(j);
            if (abs(zpos - opos) < 2) {
                cost += abs(zpos - opos);
                i++;
                j++;
            } else {
                cost += 1;
                if (zpos < opos)
                    i++;
                else
                    j++;
            }
        }
        System.out.println(cost+zeroPos.size()-i+onePos.size()-j);
    }

    private static int abs(int x) {
        return x < 0 ? -x : x;
    }
}
