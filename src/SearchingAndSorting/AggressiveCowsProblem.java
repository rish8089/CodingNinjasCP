package SearchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AggressiveCowsProblem {
    private static int LIM=1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String []nc=br.readLine().split(" ");
            int n=Integer.parseInt(nc[0]);
            int c=Integer.parseInt(nc[1]);
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
                if(canMinimumDistanceBeGreaterThanEqualToX(list, mid, c)){
                    ans=mid;
                    u=mid+1;
                }else{
                    v=mid-1;
                }
            }
            System.out.println(ans);
            t--;
        }
    }
    private static boolean canMinimumDistanceBeGreaterThanEqualToX(List<Integer> list, int x, int c){
        int lastPosIdx = 0;
        c=c-1;
        for(int i=1;i<list.size() && c>0;i++){
            if(list.get(i)-list.get(lastPosIdx)>=x){
                lastPosIdx = i;
                c-=1;
            }
        }
        return c==0;
    }
}
