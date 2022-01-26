package AdhocProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LightUpTheBulbs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []nxy=br.readLine().split(" ");
        int n=Integer.parseInt(nxy[0]);
        long x=Integer.parseInt(nxy[1]);
        long y=Integer.parseInt(nxy[2]);
        String s=br.readLine();
        int cnt=0;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='0'){
                cnt++;
                while(i+1<s.length() && s.charAt(i+1)=='0') {
                    i++;
                }
            }
        }
        System.out.println(cnt==0?0:x<y?(cnt-1)*x+y:cnt*y);
    }
}
