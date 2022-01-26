package SearchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DistributeCandies {
    private static int LIM=1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String []nk=br.readLine().split(" ");
            int n=Integer.parseInt(nk[0]);
            int k=Integer.parseInt(nk[1]);
            String []str=br.readLine().split(" ");
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++)
                list.add(Integer.parseInt(str[i]));
            Collections.sort(list);
            int u=1;
            int v=LIM;
            int ans=-1;
            while(u<=v){
                int mid=u+(v-u)/2;
                if(checkIfXNoOfCandiesCanBeDistributed(list, mid, k)){
                    u=mid+1;
                    ans=mid;
                }else
                    v=mid-1;
            }
            System.out.println(ans);
            t--;
        }

    }

    private static boolean checkIfXNoOfCandiesCanBeDistributed(List<Integer> list, int x, int k){
        for(int i=list.size()-1;i>=0 && k>0;i--){
            k-=list.get(i)/x;
        }
        return k<=0;
    }

}
