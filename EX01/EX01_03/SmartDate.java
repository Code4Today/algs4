public class SmartDate { 
    private final int month;
    private final int day;
    private final int year;
    
    public SmartDate(int m, int d, int y) {
        if (!isValid(m, d, y)){
            throw new IllegalArgumentException("Illegal date!");
        }
        month = m;
        day = d;
        year = y;
    }
    
    public int month()  {
        return month;
    }
    
    public int day() {
        return day;
    }
    
    public int year() {
        return year;
    }
    
    public String dayOfTheWeek() {
        // 1/1/2000 Saturday 6/24/2018 Sunday
        int interval = dayInterval(month, day, year, 6, 24, 2018);
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        interval %= 7;
        if (interval < 0) {
            interval += 7;
        }
        return week[interval];
    }
    
    // day1 - day2
    public int dayInterval(int month1, int day1, int year1, int month2, int day2, int year2) {
        int day_interval = 0;
        // protect raw data
        int m1 = month1;
        int m2 = month2;
        int d1 = day1;
        int d2 = day2;
        int y1 = year1;
        int y2 = year2;
        if (y1 > y2 || (y1 == y2 && m1 > m2) || (y1 == y2 && m1 == m2 && d1 >= d2)) {
            // date 1 > date 2, the day is incoming
            while (m2 != m1 || d2 != d1 || y2 != y1){
                day_interval++;
                d2++;
                if (!isValid(m2, d2, y2)){
                    // refresh day
                    d2 = 1;
                    m2++;
                    if (!isValid(m2, d2, y2)){
                        // refresh month
                        m2 = 1;
                        y2++;
                    }
                }
            }
        } else {
            // date 1 < date 2, the day is preceding
            while (m2 != m1 || d2 != d1 || y2 != y1){
                day_interval--;
                d1++;
                if (!isValid(m1, d1, y1)){
                    // refresh day
                    d1 = 1;
                    m1++;
                    if (!isValid(m1, d1, y1)){
                        // refresh month
                        m1 = 1;
                        y1++;
                    }
                }
            }
        }
        return day_interval;
    }
    
    public Boolean isValid(int m, int d, int y) {
        if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12){
            if (d < 1 || d > 31) {
                return false;
            }
        } else if (m == 4 || m == 6 || m == 9 || m == 11){
            if (d < 1 || d > 30) {
                return false;
            }
        } else if (m == 2) {
            if (0 == y % 400 || (0 == y % 4 && 0 != y % 100)) {
                //leap year
//                StdOut.println("leap year");
                if (d < 1 || d > 29) {
                    return false;
                }
            } else {
                //non-leap year
//                StdOut.println("non-leap year");
                if (d < 1 || d > 28) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
    
    public String toString() {
        return month() + "/" + day() + "/" + year();
    }
    
    public boolean equals(Object x) {
        if (this == x) return true;
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        SmartDate that = (SmartDate) x;
        if (this.day != that.day)            return false;
        if (this.month != that.month)        return false;
        if (this.year != that.year)          return false;
        return true;
    }
}