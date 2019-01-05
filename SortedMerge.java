package crackingthecodinginterview6;

/**
 * Merges two sorted arrays and puts it inside the first array.
 * @author Michael Ning
 *
 */
public class SortedMerge {

    public static void main(String[] args) {
        
        int[] a = new int[15];
        int[] b = {1,3,5,6,7};
        a[0] = 1;
        a[1] = 2;
        a[2] = 4;
        a[3] = 5;
        a[4] = 9;
        a = merge(a,b,5,5);
        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    
    public static int[] merge(int[] a, int[] b, int lastA, int lastB) {
        int indexA = lastA-1;
        int indexB = lastB-1;
        int indexMerged = lastA + lastB -1;
        while(indexB >= 0 && indexA >=0) {
            if(b[indexB] > a[indexA]) {
                a[indexMerged] =b[indexB];
                indexB--;
            }
            else {
                a[indexMerged] = a[indexA];
                indexA--;
            }
            indexMerged--;
        }
        return a;
    }
}
