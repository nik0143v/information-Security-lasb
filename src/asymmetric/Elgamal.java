/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package asymmetric;

import base.baseCoder;
import java.math.BigInteger;
import sun.security.util.BigInt;

/**
 *
 * @author Артём
 */
public class Elgamal implements baseCoder {
    private BigInteger p;
    private BigInteger g;
    private int x;
    private BigInteger y;
    
    private static Elgamal _instace = null;

    public static Elgamal getInstace()
    {
        if (_instace == null) {
            _instace = new Elgamal();
        }
        return _instace;
    }

    public void setPublicKey(int p, int g, int y) {
        this.g = new BigInteger(Integer.toString(g));
        this.p = new BigInteger(Integer.toString(p));
        this.y = new BigInteger(Integer.toString(y));
    }
    
    public void setPrivateKey(int x) {
        this.x = x;
    }
    
    @Override
    public String encode(String inputString) {
        char[] text = inputString.toCharArray();
        
        int k = (int)((p.intValue() - 2) * Math.random()) + 1;
        char[] result = new char[2 * text.length];
        for (int i = 0, j = 0; i < text.length; i++, j+=2) {
            
            result[j] = (char) (g.pow(k).mod(p).intValue());
            result[j + 1] = (char) y.pow(k).multiply(new BigInteger("" + Character.getNumericValue(text[i]))).mod(p).intValue();
        }
        
        return new String(result);
    }

    @Override
    public String decode(String inputString) {
        char code[] = inputString.toCharArray();
        

        char[] text = new char[code.length / 2];
        for (int i = 0, j = 0; i < code.length; i = i + 2, j++) {
            BigInteger ch = 
                    new BigInteger("" + (int)code[i+1]).
                    multiply(new BigInteger("" + Character.getNumericValue(code[i])).pow(p.intValue() - 1 - x)).mod(p);
            
            text[j] = (char)ch.intValue();
        }
        
        return new String(text);
    }
    
}
