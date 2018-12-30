package crackingthecodinginterview6;
import java.util.EmptyStackException;

/**
 * Stores three stacks in one array. The stacks are of equal size.
 * @author Michael Ning
 *
 */
public class ThreeStacksInOne {
    
    private int[] values;
    private int[] stackSizes;
    private int capacity;
    
    public static void main(String[] args) throws Exception {
        ThreeStacksInOne s = new ThreeStacksInOne(4);
        s.push(0, 1);
        s.push(1, 2);
        s.push(2, 3);
        s.push(0, 4);
        s.push(1, 5);
        s.push(2, 6);
        s.push(0, 7);
        s.push(1, 8);
        s.push(2, 9);
        displayContent(s);
        System.out.println("------");
        s.pop(0);
        displayContent(s);
        System.out.println("------");
        s.pop(1);
        displayContent(s);
        System.out.println("------");
        s.pop(2);
        displayContent(s);
        System.out.println("------");
        s.push(2, 9);
        s.push(2, 9);
        s.push(2, 9);
        displayContent(s);
        
    }
    
    
    public ThreeStacksInOne(int size) {
        capacity = size;
        values = new int[3*size];
        stackSizes = new int[3];
    }
    
    public void push(int stack, int value) throws Exception {
        if(isFull(stack)) {
            throw new Exception();
        }
        stackSizes[stack]++;
        values[findTop(stack)] = value;
    }
    
    public int pop(int stack) throws Exception {
        if(isEmpty(stack)) {
            throw new EmptyStackException();
        }
        int val = values[findTop(stack)];
        values[findTop(stack)]= 0;
        stackSizes[stack]--;

        
        return val;
    } 
    public int peek(int stack) {
        if(isEmpty(stack)) {
            throw new EmptyStackException();
        }
        return values[findTop(stack)];
    }
    
    public int findTop(int stack) {
        int index = stack * capacity;
        index = index + stackSizes[stack] -1;
        return index;
    }
    
    public boolean isEmpty(int stack) {
        return (stackSizes[stack] == 0);
    }
    
    public boolean isFull(int stack) {
        return (stackSizes[stack] == capacity);
    }
    
    public int[] getVals() {
        return values;
    }
    
    public int[] getStackVals(int stack) {
        int[] vals = new int[stackSizes[stack]];
        for(int i = 0; i < stackSizes[stack]; i++) {
            vals[i] = values[(stack*capacity)+i];
        }
        return vals;
    }
    
    public static void displayContent(ThreeStacksInOne t) {
        for(int i = 0; i < t.values.length; i++) {
            System.out.println(t.values[i]);
        }
    }
}
