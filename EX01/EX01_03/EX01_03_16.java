public class EX01_03_16 {
    
    public static SmartDate[] readDates(String s) {
        Queue<SmartDate> q  = new Queue<SmartDate>();
        String[] date_str = s.split("\\s+");
        for (int i = 0 ; i < date_str.length; i++) {
            q.enqueue(parseDate(date_str[i]));
        }
        int N = q.size();
        SmartDate[] dates = new SmartDate[N];
        for (int i = 0 ; i < N; i++) {
            dates[i] = q.dequeue();
        }
        return dates; 
    }
    public static SmartDate parseDate(String s) {
        String[] fields = s.split("/");
        return new SmartDate(Integer.parseInt(fields[0]), 
                         Integer.parseInt(fields[1]), 
                         Integer.parseInt(fields[2]));
    }
    
    
    public static void main(String[] args) {
        SmartDate[] dates = readDates("3/4/1592  2/27/1845\n 9/24/2016");
        for (SmartDate date: dates) {
            StdOut.println(date);
        }
    }
}

