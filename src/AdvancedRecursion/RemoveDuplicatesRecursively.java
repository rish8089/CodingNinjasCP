package AdvancedRecursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveDuplicatesRecursively {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0) {
            String s = br.readLine();
            System.out.println(removeDuplicates(s, 0, (char)0));
            t--;
        }
    }

    private static StringBuilder removeDuplicates(String s, int idx, char prev){
        if(idx==s.length())
            return null;
        if(s.charAt(idx)!=prev){
            StringBuilder res = removeDuplicates(s, idx+1, s.charAt(idx));
            if(res!=null)
                res=res.insert(0, s.charAt(idx));
            else {
                res = new StringBuilder();
                res.append(s.charAt(idx));
            }
            return res;
        }else
            return removeDuplicates(s, idx+1, s.charAt(idx));
    }
}
