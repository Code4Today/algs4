public class Transaction { 
    private final String name;
    private final SmartDate time;
    private final double money;
    
    public Transaction(String who, SmartDate when, double amount) {
        name = who;
        time = when;
        money = amount;
    }
    
    public String who()  {
        return name;
    }
    
    public SmartDate when() {
        return time;
    }
    
    public double amount() {
        return money;
    }
    
    public String toString() {
        return name + "\t" + time + "\t" + money;
    }
    
    public boolean equals(Object x) {
        if (this == x) return true;
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        Transaction that = (Transaction) x;
        if (this.name != that.name)            return false;
        if (this.money != that.money)        return false;
        if (this.time != that.time)          return false;
        return true;
    }
}