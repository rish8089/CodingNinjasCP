package LanguageTools1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TellThepositions {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            students.add(new Student());
            String[] s = br.readLine().split(" ");
            students.get(i).name = s[0];
            students.get(i).score = Integer.parseInt(s[1]) + Integer.parseInt(s[2]) + Integer.parseInt(s[3]);
            students.get(i).pos = i;
        }
        Collections.sort(students, (s1, s2) -> {
            if (s1.score > s2.score)
                return -1;
            else if (s1.score.equals(s2.score)) {
                return Integer.compare(s1.pos, s2.pos);
            } else
                return 1;
        });
        for (int i = 0; i < n; i++)
            System.out.format("%d %s\n", i+1, students.get(i).name);
    }

    private static class Student {
        String name;
        Integer score;
        int pos;
    }
}
