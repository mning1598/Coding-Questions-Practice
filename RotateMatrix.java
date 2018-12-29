package crackingthecodinginterview6;

/**
 * Rotate a matrix 90 degrees counter-clockwise.
 * @author Michael Ning
 *
 */
public class RotateMatrix {
    public static void main(String[] args) {
        
        int x=5;
        int[][] m = new int[x][x];
        int count=0;
        for(int i=0; i<x; i++) {
            for(int j=0; j<x; j++) {
                m[i][j] =count;
                count++;
            }
        }
        m = rotateM(m, x);
        for(int i = 0; i<x;i++) {
            for(int j=0; j<x; j++) {
                System.out.print(m[i][j]+ " ");
            }
            System.out.println();
        }
        
        
        System.out.println();
    }
    
    public static int[][] rotateM(int[][] m, int x) {
        int temp;
        for(int i=0; i<x/2; i++) {
            for(int j=i; j<x-i-1; j++) {
                temp = m[i][j];
                m[i][j] = m[i][x-1-i];
                m[i][x-1-i] = m[x-1-i][x-1-j];
                m[x-1-i][x-1-j] = m[x-1-j][i];
                m[x-1-j][i] = temp;
            }
        }
        return m;
    }
}
