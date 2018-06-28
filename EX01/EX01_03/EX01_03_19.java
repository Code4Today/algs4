public class EX01_03_19 {

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.addFirstElement(543);
        ll.addFirstElement(345);
        ll.addFirstElement(45);
        ll.addFirstElement(983);
        StdOut.println(ll);
        ll.deleteLastElement();
        StdOut.println(ll);
    }
}

