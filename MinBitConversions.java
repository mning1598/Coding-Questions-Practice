package crackingthecodinginterview6;

public class MinBitConversions {

    public static void main(String[] args) {
        int a = 29;
        int b = 1;
        int c = flippedBits(a,b);
        System.out.println(c);
    }
    
    public static int flippedBits(int a, int b) {
        int b1;
        int count = 0;
        while(!(a == 0 && b == 0)) {
            b1 = (b & 1) ^ (a & 1);
            count = count + b1;
            a = a >> 1;
            b = b >> 1;
        }
        return count;
        
        
    }
}
