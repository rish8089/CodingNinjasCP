package AdvancedRecursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReplaceCharactersRecursively {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            String s=br.readLine();
            String []chars=br.readLine().split(" ");
            char ch1=chars[0].charAt(0);
            char ch2=chars[1].charAt(0);
            StringBuilder sb=new StringBuilder(s);
            replaceRecursively(sb, ch1, ch2, 0);
            System.out.println(sb);
            t--;
        }
    }

    private static void replaceRecursively(StringBuilder sb, char c1, char c2, int idx){
        if(idx==sb.length())
            return;
        if(sb.charAt(idx)==c1){
            sb.setCharAt(idx, c2);
        }
        replaceRecursively(sb, c1, c2, idx+1);
    }
}
