package crackingthecodinginterview6;

/**
 * Write a program to swap odd and even bits in an integer with as few 
 * instructions as possible (e.g., bit O and bit 1 are swapped, bit 2 
 * and bit 3 are swapped, and so on).
 * @author Michael Ning
 *
 */
public class PairwiseSwap {

    public static void main(String[] args) {
        int a = 0xE07A;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(swapPairs(a)));
    }
    
    public static int swapPairs(int n) {
        int evenMask = 0xAAAAAAAA; //10101010
        int oddMask = 0x55555555; //01010101
        return ((n & evenMask)>>1) | ((n & oddMask) << 1);
        
    }
}
