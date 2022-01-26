package AdvancedRecursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSortCode {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0) {
            int n=Integer.parseInt(br.readLine());
            int []a=new int[n];
            String []str=br.readLine().split(" ");
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            qsort(a, 0, n-1);
            StringBuilder ans=new StringBuilder();;
            for(int elem:a)
                ans.append(elem).append(" ");
            System.out.println(ans);
            t--;
        }

    }
    private static void qsort(int []a, int i, int j){
        if(i<j) {
            int pivot=a[j];
            int u = i;
            int v = j;
            while (i <= j) {
                if (a[i] <= pivot) {
                    i++;
                } else {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    j--;
                }
            }
            if(i>=v){
                qsort(a, u, v-1);
            }else {
                qsort(a, u, i - 1);
                qsort(a, i, v);
            }

        }
    }
}
