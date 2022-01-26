package SearchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Variation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []nk=br.readLine().split(" ");
        int n=Integer.parseInt(nk[0]);
        int k=Integer.parseInt(nk[1]);
        String []str=br.readLine().split(" ");
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(Integer.parseInt(str[i]));
        Collections.sort(list);
        long ans=0;
        for(int i=0;i<n;i++){
            int pos=bsearch(list, list.get(i)+k, i+1, n-1);
            if(pos!=-1){
                ans+=n-pos;
            }
        }
        System.out.println(ans);
    }
    private static int bsearch(List<Integer> list, int x, int i, int j){
        int u=i;
        int v=j;
        int pos=-1;
        while(u<=v){
            int mid=(u+v)/2;
            if(list.get(mid)>=x){
                pos=mid;
                v=mid-1;
            }
            else
                u=mid+1;
        }
        return pos;
    }
}
