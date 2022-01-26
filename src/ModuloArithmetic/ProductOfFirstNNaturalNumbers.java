package ModuloArithmetic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProductOfFirstNNaturalNumbers {
    private static int MOD=1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0) {
            int n = Integer.parseInt(br.readLine());
            long res=1;
            for(int i=1;i<=n;i++){
                res=(res*i)%MOD;
            }
            System.out.println(res);
            t--;
        }
    }
}
