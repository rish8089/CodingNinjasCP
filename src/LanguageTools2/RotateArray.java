package LanguageTools2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotateArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []arr=new int[n];
            for(int i=0;i<n;i++)
                arr[i]=Integer.parseInt(str[i]);
            int d=Integer.parseInt(br.readLine());
            reverse(arr, d, n-1);
            reverse(arr, 0, d-1);
            reverse(arr, 0, n-1);
            for(int elem:arr)
                System.out.print(elem+" ");
            System.out.println();
            t--;
        }
    }
    private static void reverse(int []arr, int i, int j){
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}
