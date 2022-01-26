package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RatMazeProblem {
    private static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < n; j++)
                a[i][j] = Integer.parseInt(str[j]);
        }
        if (a[0][0] == 1) {
            List<List<Integer>> lists = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n * n; i++) {
                if (i == 0)
                    list.add(1);
                else
                    list.add(0);
            }
            boolean[][] visited = new boolean[n][n];
            visited[0][0] = true;
            computeAllPaths(lists, list, n, 0, 0, visited, a);
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
    }

    private static void computeAllPaths(List<List<Integer>> lists, List<Integer> list, int n, int i, int j, boolean[][] visited, int[][] a) {
        if (i == n - 1 && j == n - 1) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int k = 0; k < 4; k++) {
            if (i + d[k][0] >= 0 && i + d[k][0] < n && j + d[k][1] >= 0 && j + d[k][1] < n && a[i + d[k][0]][j + d[k][1]] == 1 && !visited[i + d[k][0]][j + d[k][1]]) {
                visited[i + d[k][0]][j + d[k][1]] = true;
                list.set(n * (i + d[k][0]) + (j + d[k][1]), 1);
                computeAllPaths(lists, list, n, i + d[k][0], j + d[k][1], visited, a);
                visited[i + d[k][0]][j + d[k][1]] = false;
                list.set(n * (i + d[k][0]) + (j + d[k][1]), 0);
            }
        }
    }
}
