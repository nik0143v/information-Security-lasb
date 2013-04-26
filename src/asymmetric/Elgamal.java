/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package asymmetric;

import base.baseCoder;

/**
 *
 * @author Артём
 */
public class Elgamal implements baseCoder {
    private int p;
    private int g;
    private int x;
    private int y;
    
    private static Elgamal _instace = null;

    public static Elgamal getInstace()
    {
        if (_instace == null) {
            _instace = new Elgamal();
        }
        return _instace;
    }

    public void setPublicKey(int p, int g, int y) {
        this.p = p;
        this.g = g;
        this.y = y;
    }
    
    public void setPrivateKey(int x) {
        this.x = x;
    }
    
    @Override
    public String encode(String inputString) {
        char[] text = inputString.toCharArray();
        int k = (int)((p - 2) * Math.random()) + 1;
        
        char[] result = new char[2 * text.length];
        for (int i = 0, j = 0; i < text.length; i++, j+=2) {
            result[j] = (char) (Math.pow(g, k) % p);
            result[j + 1] = (char) ((Math.pow(y, k) * text[i]) % p);
        }
        
        return new String(result);
    }

    @Override
    public String decode(String inputString) {
        char code[] = inputString.toCharArray();
        
        char[] text = new char[code.length / 2];
        for (int i = 0, j = 0; i < code.length; i = i + 2, j++) {
            text[j] = (char) ((int)(code[i + 1] / Math.pow(code[i], x)) % p);
        }
        
        return new String(text);
    }
    
}
