package LanguageTools1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoveForCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String str=br.readLine();
        int a,s,p;
        a=0;
        s=0;
        p=0;
        for(int i=0;i<n;i++){
            char c=str.charAt(i);
            if(c=='a')
                a+=1;
            else if(c=='s')
                s+=1;
            else if(c=='p')
                p+=1;
        }
        System.out.format("%d %d %d\n", a, s, p);
    }
}
