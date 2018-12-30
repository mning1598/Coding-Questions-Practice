package crackingthecodinginterview6;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Simulates stacks of plates, all in one stack. If a "stack of plates" gets too high, it will create a new stack of plates.
 * @author Michael Ning
 *
 */
public class StackOfPlates {
    ArrayList<Stack> stacks = new ArrayList<Stack>();
    private int capacity;
    
    public StackOfPlates(int max) {
        capacity = max;
    }
    
    public static void main(String[] args) {
        StackOfPlates sp = new StackOfPlates(4);
        for (int i = 0; i < 10; i++) {
            sp.push(i);
        }
        for( int i = 0; i < 11; i++) {
            System.out.println(sp.pop());
        }
        
    }
    
    public Stack getCurrentStack() {
        if(stacks.size() == 0) {
            return null;
        }
        return stacks.get(stacks.size() -1);
    }
    
    public void push(int val) {
        if(getCurrentStack() != null && getCurrentStack().size() < capacity) {
            getCurrentStack().push(val);
        }
        else {
            Stack s = new Stack();
            s.push(val);
            stacks.add(s);
        }
    }
    
    public int pop() {
        if(getCurrentStack() == null) {
            throw new EmptyStackException();
        }
        int val = (int)getCurrentStack().pop();
        if(getCurrentStack().size() ==0) {
            stacks.remove(stacks.size()-1);
        }
        return val;
    }
    
    public int popAtStack(int index) throws Exception {
        if(index > stacks.size()-1) {
            throw new Exception();
        }
        Stack curr = stacks.get(index);
        return (int)curr.pop();
    }
    
    
}
