package AdvancedRecursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReturnKeypadCode {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Map<String,String> mp=new HashMap<>();
        mp.put("0","");
        mp.put("1","");
        mp.put("2","abc");
        mp.put("3","def");
        mp.put("4","ghi");
        mp.put("5","jkl");
        mp.put("6","mno");
        mp.put("7","pqrs");
        mp.put("8","tuv");
        mp.put("9","wxyz");
        while(t>0) {
            String s=br.readLine();
            List<String> sols=new ArrayList<>();
            computeAllPossibleCombinations(s, sols, 0, mp, "");
            for(int i=0;i<sols.size();i++){
                System.out.println(sols.get(i));
            }
            t--;
        }
    }

    private static void computeAllPossibleCombinations(String s, List<String> sols, int idx, Map<String, String> mp, String res){
        if(idx==s.length()) {
            if(!res.equals(""))
                sols.add(res);
            return;
        }
        String mv = mp.get(String.valueOf(s.charAt(idx)));
        if(mv.length()>0) {
            for (int i = 0; i < mv.length(); i++) {
                computeAllPossibleCombinations(s, sols, idx + 1, mp, res + mv.charAt(i));
            }
        }else {
            computeAllPossibleCombinations(s, sols, idx + 1, mp, res);
        }
    }

}
