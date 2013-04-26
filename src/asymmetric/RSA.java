/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package asymmetric;

import base.baseCoder;
import java.math.BigInteger;

/**
 *
 * @author Артём
 */
public class RSA implements baseCoder {
    private BigInteger n;
    private int e;
    private int d;

    private static RSA _instace = null;

    public static RSA getInstace()
    {
        if (_instace == null) {
            _instace = new RSA();
        }
        return _instace;
    }
    
    public void generateKeys() {
        int p = 379;
        int q = 173;
        
        n = new BigInteger(Integer.toString(p * q));
        
        int m = (p - 1) * (q - 1);
        
        int sqrtF = (int)Math.sqrt(m - 4);
        d = (int)(sqrtF * Math.random()) + sqrtF + 1;
        
        int a = m;
        int b = d;
        int[][] E = {{1, 0},
                     {0, 1}};
        while (true) {
            int r = a % b;
            
            if (r == 0) {
                e = E[1][1];
                break;
            }
            
            int qq = (a - r) / b;
            
            E[0][0] = E[0][1];
            E[0][1] = E[0][0] - E[0][1] * qq;
            E[1][0] = E[1][1];
            E[1][1] = E[1][0] - E[1][1] * qq;
            
            a = b;
            b = r;
        }
    }
    
    @Override
    public String encode(String inputString) {
        generateKeys();
        
        char code[] = inputString.toCharArray();

        for (int i = 0; i < code.length; i++) {
            BigInteger a = new BigInteger("" + (int)code[i]);       
            code[i] = (char) a.pow(e).mod(n).intValue();
        }
        
        return new String(code);
    }

    @Override
    public String decode(String inputString) {
        char code[] = inputString.toCharArray();

        for (int i = 0; i < code.length; i++) {
            BigInteger b = new BigInteger("" + (int)code[i]);       
            code[i] = (char) b.pow(d).mod(n).intValue();
        }
        
        return new String(code);
    }  
}
