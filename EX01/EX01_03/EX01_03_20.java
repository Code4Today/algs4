public class EX01_03_20 {

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.addFirstElement(543);
        ll.addFirstElement(345);
        ll.addFirstElement(45);
        ll.addFirstElement(983);
        ll.addFirstElement(65);
        ll.addFirstElement(78);
        ll.addFirstElement(19);
        StdOut.println(ll);
        ll.delete(6);
        StdOut.println(ll);
        ll.delete(0);
        StdOut.println(ll);
        ll.delete(2);
        StdOut.println(ll);
    }
}

