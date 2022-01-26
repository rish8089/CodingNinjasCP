package SearchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MomosMarket {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=Integer.parseInt(str[i]);
        long []prefixSum = new long [n];
        for(int i=0;i<n;i++){
            if(i==0)
                prefixSum[i]=a[i];
            else
                prefixSum[i]=prefixSum[i-1]+a[i];
        }
        StringBuilder ans=new StringBuilder();
        int q=Integer.parseInt(br.readLine());
        while(q>0){
            int x=Integer.parseInt(br.readLine());
            int pos=posWithValueLTE(prefixSum, x);
            if(pos!=-1)
                ans.append(pos+1).append(" ").append(x-prefixSum[pos]);
            else
                ans.append(0).append(" ").append(x);
            ans.append("\n");
            q--;
        }
        System.out.println(ans);
    }
    private static int posWithValueLTE(long []arr, int x){
        int u=0;
        int v=arr.length-1;
        int pos=-1;
        while(u<=v){
            int mid=(u+v)/2;
            if(arr[mid]<=x){
                pos=mid;
                u=mid+1;
            }else
                v=mid-1;
        }
        return pos;
    }
}
