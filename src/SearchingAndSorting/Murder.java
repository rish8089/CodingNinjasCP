package SearchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Murder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str= br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            System.out.println(sumOfSmallerNumbers(a, 0, n-1));
            t--;
        }
    }
    private static long sumOfSmallerNumbers(int [] a, int i, int j) {
        if (i < j) {
            int mid = (i + j) / 2;
            return sumOfSmallerNumbers(a, i, mid) + sumOfSmallerNumbers(a, mid + 1, j) + compute(a, i, mid, j);
        }
        return 0;
    }

    private static long compute(int[] a, int i, int mid, int j) {
        int u = i;
        int v = mid + 1;
        long sum = 0;
        int [] temp = new int[j - i + 1];
        int idx = 0;
        while (u <= mid && v <= j) {
            if(a[u]<a[v]){
                sum+=(long)a[u]*(j-v+1);
                temp[idx++]=a[u++];
            }else {
                temp[idx++]=a[v++];
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
        return sum;
    }
}
