package LanguageTools1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DifferentNames {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        Map<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            if (!mp.containsKey(s[i]))
                mp.put(s[i], 1);
            else
                mp.put(s[i], mp.get(s[i]) + 1);
        }
        boolean flag = false;
        for (String key : mp.keySet()) {
            if (mp.get(key) > 1) {
                flag = true;
                System.out.format("%s %d\n", key, mp.get(key));
            }
        }
        if (!flag)
            System.out.println(-1);
    }
}
