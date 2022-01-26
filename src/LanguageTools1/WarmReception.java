package LanguageTools1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WarmReception {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        List<Node> ranges=new ArrayList<>();
        for(int i=0;i<n;i++)
            ranges.add(new Node());
        for(int i=0;i<n;i++)
            ranges.get(i).a=Integer.parseInt(str[i]);
        str=br.readLine().split(" ");
        for(int i=0;i<n;i++)
            ranges.get(i).d=Integer.parseInt(str[i]);
        Collections.sort(ranges, (n1,n2)->Integer.compare(n1.a, n2.a));
        int ans = 0;
        for (int i = 1; i < n; i++) {
            int cnt = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (ranges.get(i).a <= ranges.get(j).d) {
                    cnt += 1;
                }
            }
            //cnt indicates how many still occupying the chair
            if (ans < cnt + 1)
                ans = cnt + 1;
        }
        System.out.println(ans);
    }
    private static class Node {
        int a;
        int d;
    }
}
