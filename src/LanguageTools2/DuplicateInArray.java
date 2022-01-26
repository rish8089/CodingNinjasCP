package LanguageTools2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DuplicateInArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            int xor=0;
            for(int i=0;i<=n-2;i++){
                xor=xor^i;
            }
            for(int i=0;i<n;i++)
                xor=xor^a[i];
            System.out.println(xor);
            t--;
        }
    }
}
