public class EX01_03_26<Item> {
    
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.addFirstElement(78);
        ll.addFirstElement(78);
        ll.addFirstElement(543);
        ll.addFirstElement(345);
        ll.addFirstElement(78);
        ll.addFirstElement(78);
        ll.addFirstElement(78);
        ll.addFirstElement(983);
        ll.addFirstElement(65);
        ll.addFirstElement(78);
        ll.addFirstElement(19);
        ll.addFirstElement(78);
//        ll.addFirstElement(78);
        StdOut.println(ll);
        
        ll.remove(78);
        StdOut.println(ll);

    }
}
