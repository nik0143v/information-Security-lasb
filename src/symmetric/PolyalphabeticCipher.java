/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package symmetric;

import base.baseCoder;

/**
 *
 * @author Артём
 */
public class PolyalphabeticCipher implements baseCoder{
    private char[] key = "key".toCharArray();

    public PolyalphabeticCipher() {
    }

    @Override
    public String encode(String text) {   
        char[] code = text.toCharArray();
 
        for (int i = 0; i < text.length(); i++) {
            code[i] = (char)((code[i] + key[i % key.length]) % Character.MAX_VALUE);
        }

        return new String(code);
    }
    
    @Override
    public String decode(String code) {
        char decode[] = code.toCharArray();
        
        for (int i = 0; i < decode.length; i++) {
            decode[i] = (char)((decode[i] - key[i % key.length]) % Character.MAX_VALUE);
        }
        
        return new String(decode);
    }
}
