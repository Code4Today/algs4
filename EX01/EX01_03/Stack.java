import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
    private Node<Item> first;
    private int N;
    private class Node<Item> {
        Item item;
        Node<Item> next;
    }

    public Stack() {
        first = null;
        N = 0;
    }

    public Stack(Stack<Item> stack){
        Stack<Item> copy = new Stack<Item>();
        while(!stack.isEmpty()) {
            copy.push(stack.pop());
        }
        while(!copy.isEmpty()) {
            Item itr = copy.pop();
            this.push(itr);
            stack.push(itr);
        }
    }

    public boolean isEmpty() {  
        return first == null;                    
    }
    
    public int size() {
        return N;
    }
    
    public void push(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    
    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
    
    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return first.item;
    }
    
    public String toString () {
        String stack_sum = "";
        Node<Item> itr = first;
        while (itr != null) {
            stack_sum = stack_sum + itr.item + " ";
            itr = itr.next;
        }
        return stack_sum;
    }
    
    public Iterator<Item> iterator() { 
        return new ListIterator(); 
    }
    
    public class ListIterator implements Iterator<Item> {
        private Node<Item> current = first;
        
        public boolean hasNext() {
            return current != null;
        }
        
        public Item next() { 
            if (!hasNext()) 
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(543);
        stack.push(345);
        stack.push(45);
        stack.push(983);
        stack.pop();
        StdOut.println(stack.peek());
        StdOut.println(stack.pop());
    }
    
}