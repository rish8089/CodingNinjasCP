package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {
    private static int[][] dd = {{-1, 1}, {-1, -1}, {1, -1}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n * n; i++) {
            list.add(0);
        }
        calculateConfigurations(lists, list, n, 0);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                ans.append(lists.get(i).get(j));
                if (j < lists.get(i).size() - 1) {
                    ans.append(" ");
                }

            }
            ans.append("\n");
        }
        if (ans.length() > 0)
            System.out.print(ans);
    }

    private static void calculateConfigurations(List<List<Integer>> lists, List<Integer> list, int n, int i) {
        if (i == n * n) {
            int cnt = 0;
            for (int elem : list) {
                if (elem == 1)
                    cnt++;
            }
            if (cnt == n)
                lists.add(new ArrayList<>(list));
            return;
        }
        //two choices, whether to place the queen or not

        if(canQueenBePlacedAtGivenPos(list, i, n)) {
            list.set(i, 1);
            calculateConfigurations(lists, list, n, i + 1);
            list.set(i, 0);
        }

        //not placing the queen
        boolean flag = false;
        int row = i / n;
        for (int k = row * n; k <= i; k++) {
            if (list.get(k) == 1) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            for (int k = i + 1; k < row * n + n; k++) {
                if (canQueenBePlacedAtGivenPos(list, k, n)) {
                    flag = true;
                    break;
                }
            }
        }
        if (flag)
            calculateConfigurations(lists, list, n, i + 1);
    }

    private static boolean canQueenBePlacedAtGivenPos(List<Integer> list, int i, int n){
        boolean hflag=true;
        int row = i / n;
        for (int k = row * n; k < row * n + n; k++) {
            if (list.get(k) == 1) {
                hflag=false;
                break;
            }
        }
        //check if the queen will get attacked vertically
        boolean vflag=true;
        int col = i % n;
        for (int k = col; k < n * n; k += n) {
            if (list.get(k) == 1) {
                vflag=false;
                break;
            }
        }
        boolean dflag=true;
        for (int k = 0; k < 4; k++) {
            int trow = row;//temp row
            int tcol = col;//temp col
            while (row >= 0 && col >= 0 && row < n && col < n) {
                if (list.get(row * n + col) == 1) {
                    dflag = false;
                    break;
                }
                row = row + dd[k][0];
                col = col + dd[k][1];
            }
            //assigning back
            row = trow;
            col = tcol;
            if(!dflag)
                break;
        }
        return hflag && vflag && dflag;
    }
}
