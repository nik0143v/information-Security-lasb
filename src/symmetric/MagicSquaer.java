/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package symmetric;

/**
 *
 * @author egor
 */
public class MagicSquaer 
{
    private static int _instance[][];
    private int Max;
    private int wallSize;
    
    public MagicSquaer(int MaxSize)
    {
        Max = MaxSize % 2 == 0 ? MaxSize += 1 : MaxSize;
        wallSize = Max * 2 - 1;
        MagicSquaer._instance = new int[wallSize][wallSize];
        for(int y= Max-1, x = 0, number = 1; y <= Max + 1; y++,x++)
        {
            for(int xx = x, yy = y; xx < Max + x; xx++, yy--, number++)
            {
                MagicSquaer._instance[yy][xx] = number;
            }
        }
        for(int y = (Max-1)/2; y < wallSize-1; y++)
        {
            for(int x = (Max-1)/2; x < wallSize-1; x++)
            {
                if(MagicSquaer._instance[y][x] != 0)continue;
                if( x + Max < wallSize )
                { MagicSquaer._instance[y][x] = MagicSquaer._instance[y][x + Max]; }
                else if( x - Max > 0 )
                { MagicSquaer._instance[y][x] = MagicSquaer._instance[y][x - Max]; }
                else if( y + Max < wallSize )
                { MagicSquaer._instance[y][x] = MagicSquaer._instance[y + Max][x]; }
                else 
                { MagicSquaer._instance[y][x] = MagicSquaer._instance[y - Max][x]; }
            }
        }
        
    }
    
}
