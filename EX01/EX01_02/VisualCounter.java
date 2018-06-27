public class VisualCounter {
    private final int max_operate;
    private final int max_value;
    private int operate;
    private int count;
    
    public VisualCounter(int N, int max) {
        max_operate = N;
        max_value = Math.abs(max);
        operate = 0;
        count = 0;
    }
    
    public void increment() {
        operate++;
        if (operate < max_operate) {
            if (count + 1 <= max_value){
                count++;
                showCount();
            }
        }
    }
    
    public void decrement() {
        operate++;
        if (operate < max_operate) {
            if (count - 1 >= -max_value){
                count--;
                showCount();
            }
        }
    }
    
    public void showCount() {
        StdDraw.clear(StdDraw.WHITE);
        StdDraw.text(0.5, 0.5, count + "");
//        StdOut.println("Count: " + count);
    }
    
    public int tally() {
        return count;
    }
    
    public String toString() {
        return count + "";
    }
}