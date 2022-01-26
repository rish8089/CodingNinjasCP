package SearchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChefRestaurant {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String []nm=br.readLine().split(" ");
            int n=Integer.parseInt(nm[0]);
            int m=Integer.parseInt(nm[1]);
            List<Node> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                String []lr=br.readLine().split(" ");
                int l=Integer.parseInt(lr[0]);
                int r=Integer.parseInt(lr[1]);
                list.add(new Node(l,r));
            }
            Collections.sort(list, (n1,n2)->Integer.compare(n1.st, n2.st));
            StringBuilder ans=new StringBuilder();
            while(m>0){
                int time=Integer.parseInt(br.readLine());
                if(time>=list.get(list.size()-1).et)
                    ans.append(-1);
                else{
                    int pos=bsearch(list, time);
                    if(pos==-1)
                        ans.append(list.get(0).st-time);
                    else {
                        if(time<list.get(pos).et){
                            ans.append(0);
                        }else
                            ans.append(list.get(pos+1).st-time);
                    }
                }
                ans.append("\n");
                m--;
            }
            System.out.println(ans);
            t--;
        }
    }
    private static class Node{
        int st;
        int et;
        Node(int st, int et){
            this.st=st;
            this.et=et;
        }
    }

    private static int bsearch(List<Node> list, int time){
        int u=0;
        int v=list.size()-1;
        int pos=-1;
        while(u<=v){
            int mid=(u+v)/2;
            if(time>=list.get(mid).st){
                u=mid+1;
                pos=mid;
            }
            else{
                v=mid-1;
            }

        }
        return pos;
    }
}
