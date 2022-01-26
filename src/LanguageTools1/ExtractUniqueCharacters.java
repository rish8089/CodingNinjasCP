package LanguageTools1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExtractUniqueCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        boolean []hash=new boolean[26];
        StringBuilder ans=new StringBuilder();
        for(int i=0;i< str.length();i++){
            char c= str.charAt(i);
            if(!hash[c-'a']){
                ans.append(c);
                hash[c-'a']=true;
            }
        }
        System.out.println(ans);
    }
}
