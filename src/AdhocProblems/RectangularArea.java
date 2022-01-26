package AdhocProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RectangularArea {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Node> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            String []ab=br.readLine().split(" ");
            list.add(new Node(Integer.parseInt(ab[0]),Integer.parseInt(ab[1])));
        }
        Collections.sort(list, (n1,n2)->{
            return Integer.compare(n2.x, n1.x);
        });
        int maxh=0;
        for(int i=0;i<n;i++){
            if(maxh<list.get(i).y/2)
                maxh=list.get(i).y/2;
        }
        long squares=0;
        int maxhTillNow=0;
        for(int i=0;i<n-1;i++){
            int x1=list.get(i).x/2;
            int x2=list.get(i+1).x/2;
            if(maxhTillNow<list.get(i).y/2)
                maxhTillNow = list.get(i).y/2;
            squares+=(long)(x1-x2)*(maxh-maxhTillNow);
        }
        System.out.println((long)list.get(0).x*(maxh*2)-squares*4);
    }
    static class Node{
        int x;
        int y;
        Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}
