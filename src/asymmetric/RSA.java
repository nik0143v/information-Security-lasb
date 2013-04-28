package asymmetric;

import base.baseCoder;
import java.math.BigInteger;
import java.security.SecureRandom;

/**
 *
 * @author Артём
 */
public class RSA implements baseCoder {
    private final static BigInteger   one    = new BigInteger("1");
    private final static SecureRandom random = new SecureRandom();
   
    private BigInteger modulus;
    private int        publicKey;
    private BigInteger privateKey;

    private static RSA _instace = null;

    public static RSA getInstace()
    {
        if (_instace == null) {
            _instace = new RSA();
        }
        return _instace;
    }
    
    public void generateKeys() {
        BigInteger p   = BigInteger.probablePrime(8, random);
        BigInteger q   = BigInteger.probablePrime(8, random);
        BigInteger phi = (p.subtract(one)).multiply(q.subtract(one));
        
        modulus    = p.multiply(q);
        publicKey  = 65537;
        privateKey = BigInteger.valueOf(publicKey).modInverse(phi);
    }
    
    @Override
    public String encode(String inputString) {
        generateKeys();
        
        char code[] = inputString.toCharArray();

        for (int i = 0; i < code.length; i++) {
            BigInteger a = BigInteger.valueOf((long)code[i]);       
            code[i] = (char) a.pow(publicKey).mod(modulus).intValue();
        }
        
        return new String(code);
    }

    @Override
    public String decode(String inputString) {
        char code[] = inputString.toCharArray();

        for (int i = 0; i < code.length; i++) {
            BigInteger b = BigInteger.valueOf((long)code[i]);       
            code[i] = (char) b.modPow(privateKey, modulus).intValue();
        }
        
        return new String(code);
    }  
}
