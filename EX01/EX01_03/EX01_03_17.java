public class EX01_03_17 {
    
    public static Transaction[] readTrans(String s) {
        Queue<Transaction> q  = new Queue<Transaction>();
        String[] date_str = s.split("\t");
        for (int i = 0 ; i < date_str.length; i++) {
            q.enqueue(parseTran(date_str[i]));
        }
        int N = q.size();
        Transaction[] trans = new Transaction[N];
        for (int i = 0 ; i < N; i++) {
            trans[i] = q.dequeue();
        }
        return trans; 
    }
    public static Transaction parseTran(String s) {
        String[] fields = s.split(" ");
        return new Transaction(fields[0], 
                         parseDate(fields[1]), 
                         Double.parseDouble(fields[2]));
    }
    
    
    public static SmartDate parseDate(String s) {
        String[] fields = s.split("/");
        return new SmartDate(Integer.parseInt(fields[0]), 
                         Integer.parseInt(fields[1]), 
                         Integer.parseInt(fields[2]));
    }
    
    public static void main(String[] args) {
        Transaction[] trans = readTrans("Bob 3/4/1592 1954.5\tTony 2/27/1845 292\tJohn 9/24/2016 984");
        for (Transaction tran: trans) {
            StdOut.println(tran);
        }
    }
}

