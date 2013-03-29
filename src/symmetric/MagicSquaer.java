/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package symmetric;

import base.baseCoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author egor
 */
public class MagicSquaer  implements baseCoder
{
    private int _matrix[][];
    private int MidLen;
    private int wallSize;
    private static MagicSquaer _instace = null;

    static public MagicSquaer getInstace()
    {
        if(_instace == null) _instace = new MagicSquaer();
        return _instace;
    }
    

    private int[][] CalcMatrix(int MaxSize)throws Throwable
    {
        System.out.println("2");
        if(MaxSize == 0)throw new Exception("invalid string");
        int tmp = (int)Math.round(Math.sqrt((double)MaxSize));
        tmp += tmp < Math.sqrt((double)MaxSize) ? 1 : 0;
        tmp = tmp% 2 == 0 ? tmp += 1 : tmp;
        if(MidLen == tmp)return _matrix;
        System.out.println("3");
        MidLen = tmp;
        wallSize = MidLen * 2 - 1;
        _matrix = new int[wallSize][wallSize];
        int LenDiv4 = (MidLen - 1)/2;
        for(int y = MidLen -1 , x = 0, num = 1; x < MidLen ; y++,x++)
        {
            for(int yy = y, xx = x; yy > y - MidLen ;yy--,xx++,num++)
            {
                if(xx < LenDiv4)_matrix[yy][xx+MidLen] = num;
                else if(xx > wallSize - 1 - LenDiv4)_matrix[yy][xx-MidLen] = num;
                else if(yy < LenDiv4)_matrix[yy+MidLen][xx] = num;
                else if(yy > wallSize - 1 - LenDiv4)_matrix[yy-MidLen][xx] = num;
                else _matrix[yy][xx] = num;
            }
        }
        
        /*System.out.println("Начальный квадрат");
        for (int i = 0; i < wallSize; i++) {
            for (int j = 0; j < wallSize; j++) {
                System.out.print(_instance[i][j]);
                System.out.print("\t");
            }
            System.out.print("\n");//this is spartaaaaaaaaaaa!
        }*/
        return _matrix;
    }
    
    @Override
    public String decode(String inputString)
    {
        String result = "";
        try {
            for(int[] string : CalcMatrix(inputString.length()))
            {
                for(int index : string)
                {
                    if(index == 0)continue;
                    if(index > inputString.length())continue;
                    result += inputString.charAt(index-1);
                }
            }
            return result;
        } catch (Throwable ex) {
            Logger.getLogger(MagicSquaer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    @Override
    public String encode(String inputString)
    {
        System.out.println("1");
        try {
            char[] result = new char[inputString.length()];
            CalcMatrix(inputString.length());
            System.out.println(inputString.length());
            int MidLenDiv2 = (MidLen-1)/2;
            for(int i = MidLenDiv2, index = 0; i < wallSize - MidLenDiv2; i++)
            {
                for(int ii = MidLenDiv2; ii < wallSize - MidLenDiv2; ii++)
                {
                    if(_matrix[i][ii] > inputString.length())continue;
                    result[_matrix[i][ii]-1] = inputString.charAt(index);
                    index++;
                }
            }
            return new String(result);
        } catch (Throwable ex) {
            Logger.getLogger(MagicSquaer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
}
