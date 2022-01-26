package LanguageTools2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestConsecutiveSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        int []arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=Integer.parseInt(str[i]);
        List<Node> list=new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(new Node(arr[i], i));
        Collections.sort(list, (n1,n2)->Integer.compare(n1.val, n2.val));
        List<Integer> answer=new ArrayList<>();
        int l = -1, r = -1;
        int maxlen = 0;
        for (int i = 0; i < n; i++) {
            int j=i;
            while (i + 1 < n && list.get(i + 1).val == list.get(i).val + 1) {
                i++;
            }
            if(maxlen < i-j+1){
                maxlen = i-j+1;
                l = j;
                r = i;
            }else if(maxlen == i-j+1){
                if(list.get(l).idx > list.get(j).idx){
                    l = j;
                    r = i;
                }
            }
        }
        if(l==r)
            answer.add(list.get(l).val);
        else {
            answer.add(list.get(l).val);
            answer.add(list.get(r).val);
        }
        for(int elem:answer){
            System.out.print(elem+" ");
        }
        System.out.println();
    }
    private static class Node{
        int val;
        int idx;
        Node(int v, int i){
            this.val=v;
            this.idx=i;
        }
    }
}
