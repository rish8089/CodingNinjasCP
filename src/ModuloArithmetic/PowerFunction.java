package ModuloArithmetic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PowerFunction {
    private static int MOD=1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            String []xy=br.readLine().split(" ");
            int x=Integer.parseInt(xy[0]);
            int y=Integer.parseInt(xy[1]);
            System.out.println(mypow(x,y));
            t--;
        }
    }
    private static long mypow(long x, int y){
        long res=1;
        while(y>0){
            if(y%2!=0)
                res=(res*x)%MOD;
            y=y/2;
            if(y>0)
                x=(x*x)%MOD;
        }
        return res;
    }
}
