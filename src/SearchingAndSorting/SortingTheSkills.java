//package SearchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortingTheSkills {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            int min=a[n-1];
            boolean flag=true;
            for(int i=n-2;i>=0;i--){
                if(a[i]>min){
                    if(a[i]-min>1){
                        flag=false;
                        break;
                    }
                }
                min = Integer.min(min, a[i]);
            }
            System.out.println(flag?"Yes":"No");
            t--;
        }
    }
}
