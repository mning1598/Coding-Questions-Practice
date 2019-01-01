package crackingthecodinginterview6;

/**
 * You have an integer and you can flip exactly one bit from a O to a 1. 
 * Write code to find the length of the longest sequence of 1's you could create.
 * @author Michael Ning
 *
 */
public class FlipBitToWin {

    public static void main(String[] args) {
        int a = 238;
        System.out.println(Integer.toString(a,2));

        System.out.println(flip(a));
        
    }
    
    public static int flip(int n) {
        if(~n == 0) {
            return Integer.BYTES * 8;
        }
        int currLen = 0;
        int prevLen = 0;
        int max = 1;
        while(n !=0) {
            if((n & 1) == 1) {
                currLen++;
            }
            else if((n & 1) == 0) {
                prevLen = currLen;
                currLen = 0;
            }
            if(prevLen + currLen + 1 > max) {
                max = prevLen+currLen + 1;
            }
            n = n >> 1;
        }
        return max;

    }
}
