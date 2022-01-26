package SearchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TajMahalEntry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=Integer.parseInt(str[i]);
        int minNoOfRounds = -1;
        int idx = -1;
        for(int i=0;i<n;i++){
            int time = a[i];
            int noOfRounds = time/n;
            int rem = time%n;
            if(rem>i)
                noOfRounds++;
            if(minNoOfRounds == -1 || minNoOfRounds > noOfRounds) {
                minNoOfRounds = noOfRounds;
                idx= i;
            }
        }
        System.out.println(idx+1);
    }
}
