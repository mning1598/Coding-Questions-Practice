package crackingthecodinginterview6;

/**
 * Replace the bits in n from start to end, with the bits in replace.
 * @author Michael Ning
 *
 */
public class BitInsertion {

    
    public static void main(String[] args) {
        int a = 2047;
        System.out.println(Integer.toString(a,2));
        int b = 8;
        System.out.println(Integer.toString(b,2));
        System.out.println(Integer.toString(insertBits(a,b,2, 6),2));

        
    }
    
    public static int insertBits(int n, int replace, int start, int end) {
        if(start >= 32 || end < start) {
            return 0;
        }
        
        int mask = ~0;
        mask = (mask << (end+1)) | ((1 << start) - 1); // 0's between start and end
        
        n = n & mask;
        replace = replace << start;
        
        return n | replace;
    }
}
