import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<Item> implements Iterable<Item> {
    public Node<Item> first;
    public int length;
    public class Node<Item> {
        Item item;
        Node<Item> next;
    }
    
    public boolean isEmpty() {  
        return first == null;                    
    }
    
    public int size() {
        return length;
    }

    public void reverse() {
        if (first == null || first.next == null){
            // 1 element
            return;
        } else if (first.next.next == null) {
            // 2 element
            Node<Item> a = first;
            first = first.next;
            first.next = a;
            a.next = null;
        } else {
            // >=3 element
            Node<Item> temp = first;
            Node<Item> n_pre = temp;
            Node<Item> n_itr = temp.next;
            Node<Item> n_next = temp.next.next;
            
            n_pre.next = null;
            n_itr.next = n_pre;
            
            while (n_next != null){
                n_pre = n_itr;
                n_itr = n_next;
                n_next = n_next.next;
                n_itr.next = n_pre;
            }
            first = n_itr;
        }
    }
    
    public Node<Item> showFirstNode() {
        return first;
    }
    
    public void remove(Item item) {
        if (null == item) {
            throw new UnsupportedOperationException("Trying to remove null");
        }
        while (first.item == item) {
            deleteFirstElement();
        }
        Node<Item> node_itr = first;
        Node<Item> last_itr = first;
        while (null != node_itr) {
            if (node_itr.item.equals(item)) {
                if (null == node_itr.next){
                    last_itr.next = null;
                    length--;
                    break;
                }
                else {
                    last_itr.next = node_itr.next;
                    node_itr = node_itr.next;
                    length--;
                }
            } else {
                last_itr = node_itr;
                node_itr = node_itr.next;
            }
        }
    }
    
    public void insertAfter(Node<Item> n1, Node<Item> n2) {
        n1.next = n2;
    }
    
    public void removeAfter(Node<Item> node_last) {
        node_last.next = null;
    }
    
    public boolean find(Item item) {
        Node<Item> node_itr = first;
        while (null != node_itr) {
//            StdOut.println("node_itr.item: " + node_itr.item);
//            StdOut.println("item: " + item);
            if (node_itr.item.equals(item)) {
                return true;
            }
            node_itr = node_itr.next;
        }
        return false;
    }
    
    public void delete(int k) {
        if (0 == k) {
            deleteFirstElement();
        } else {
            Node<Item> node_itr = first;
            int itr = 1;
            // find the previous element of element wants to delete
            while (itr != k) {
                itr++;
                node_itr = node_itr.next;
                if (null == node_itr.next) {
                    return;
                }
            }
            node_itr.next = node_itr.next.next;
        }
    }
    
    public void deleteLastElement() {
        if (first.next == null) {
            first.item = null;
        } else {
            Node<Item> node_itr = first;
            Node<Item> newlast = first;
            while (node_itr.next != null) {
                newlast = node_itr;
                node_itr = node_itr.next;
            }
            newlast.next = null;
        }
        length--;
    }
    
    public void addFirstElement(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        length++;
    }
    
    public Item deleteFirstElement() {
        Item item = first.item;
        first = first.next;
        length--;
        return item;
    }
    
    public Item showFirstElement() {
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
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.addFirstElement(543);
        ll.addFirstElement(345);
        ll.addFirstElement(45);
        ll.addFirstElement(983);
        ll.deleteFirstElement();
        StdOut.println(ll.showFirstElement());
        StdOut.println(ll.deleteFirstElement());
    }
    
}