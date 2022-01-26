package AdvancedRecursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0) {
            int n=Integer.parseInt(br.readLine());
            int []a=new int[n];
            String []str=br.readLine().split(" ");
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            mergeSort(a, 0, n-1);
            StringBuilder ans=new StringBuilder();;
            for(int elem:a)
                ans.append(elem).append(" ");
            System.out.println(ans);
            t--;
        }
    }
    private static void mergeSort(int[] a, int i, int j) {
        if (i < j) {
            int mid = (i + j) / 2;
            mergeSort(a, i, mid);
            mergeSort(a, mid+1, j);
            merge(a, i, mid, j);
        }
    }

    private static void merge(int[] a, int i, int mid, int j) {
        int u = i;
        int v = mid + 1;
        int[] temp = new int[j - i + 1];
        int idx = 0;
        while (u <= mid && v <= j) {
            if (a[u] > a[v]) {
                temp[idx++] = a[v];
                v++;
            } else {
                temp[idx++] = a[u];
                u++;
            }
        }
        while (u <= mid) {
            temp[idx++] = a[u++];
        }
        while (v <= j) {
            temp[idx++] = a[v++];
        }
        for (int k = i; k <= j; k++)
            a[k] = temp[k-i];
    }


}


