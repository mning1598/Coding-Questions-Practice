package crackingthecodinginterview6;

/**
 * Finds the index of a string in a string array that has empty strings dispersed in the array.
 * @author Michael Ning
 *
 */
public class SparseSearchStrings {

    
    public static void main(String[] args) {
        String[] a = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        System.out.println(search(a, "car",0, a.length-1));
    }
    
    public static int search(String[] a, String target, int start, int end) {
        int mid = (start+end)/2;
        if(a[mid].equals("")) {
            int left = mid-1;
            int right = mid+1;
            while(true) {
                
                if(left >= start && !(a[left].equals(""))) {
                    mid = left;
                    break;
                }
                else if (right <= end && !(a[right].equals(""))){
                    mid = right;
                    break;
                }
                else if (left < start && right > start){
                    return -1;
                }
                left--;
                right++;
            }
            
        }
        if(start < end) {
            if(target.compareTo(a[mid]) <0) {
                return search(a, target, start, mid-1);
            }
            else if(target.compareTo(a[mid]) > 0) {
                return search(a, target, mid+1, end);
            }
            else if(target.compareTo(a[mid]) == 0) {
                return mid;
            }
        }
        return -1;
    }
    
}
