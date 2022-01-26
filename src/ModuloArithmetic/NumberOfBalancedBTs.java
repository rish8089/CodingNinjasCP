package ModuloArithmetic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfBalancedBTs {
    private static int MOD=1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(getNoOfBalancedBSTs(n));
            t--;
        }
    }

    private static long getNoOfBalancedBSTs(int h){
        if(h==0 || h==1)
            return 1;
        long x=getNoOfBalancedBSTs(h-1);
        long y=getNoOfBalancedBSTs(h-2);
        return ((x*x)%MOD + (2*x*y)%MOD)%MOD;
    }
}
