package asymmetric;

import base.baseCoder;
import java.math.BigInteger;

/**
 *
 * @author Артём
 */
public class Elgamal implements baseCoder {
    // public keys
    private BigInteger p;
    private BigInteger g;
    private BigInteger y;
    
    // private key
    private int x;
    
    private static Elgamal _instace = null;

    public static Elgamal getInstace()
    {
        if (_instace == null) {
            _instace = new Elgamal();
        }
        return _instace;
    }

    public void generateKeys() {
        int prime = 65551;
        int gg = (int)((prime - 2) * Math.random()) + 1;
        x = (int)((prime - 2) * Math.random()) + 1;
        
        g = new BigInteger(Integer.toString(gg));
        p = new BigInteger(Integer.toString(prime));
        y = g.pow(x).mod(p);
    }
    
    @Override
    public String encode(String inputString) {
        generateKeys();
        
        char[] text = inputString.toCharArray();
        
        int sqrtP = (int)Math.sqrt(p.intValue() - 4);
        int k = 0;
        char[] result = new char[2 * text.length];
        for (int i = 0, j = 0; i < text.length; i++, j+=2) {       
            k = (int)(sqrtP * Math.random()) + sqrtP + 1;
            
            result[j]     = (char) g.pow(k).mod(p).intValue();
            result[j + 1] = (char) y.pow(k).multiply(new BigInteger("" + (int)text[i])).mod(p).intValue();
        }
        
        return new String(result);
    }

    @Override
    public String decode(String inputString) {
        char code[] = inputString.toCharArray();

        char[] text = new char[code.length / 2];
        for (int i = 0, j = 0; i < code.length; i = i + 2, j++) {
            BigInteger a = new BigInteger("" + (int)code[i]);
            BigInteger b = new BigInteger("" + (int)code[i + 1]);
               
            text[j] = (char) b.multiply(a.pow(p.intValue() - 1 - x)).mod(p).intValue();
        }
        
        return new String(text);
    } 
}
