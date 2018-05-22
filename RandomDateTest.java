/*
 * RandomDateGenerator.java
 *
 */

import java.util.*;

/**
 *
 * @author shariqx
 */
public class RandomDateTest {
    
    private Date dMin = null;
    private Date dMax = null;
    /** Creates a new instance of RandomDateGenerator */
    public RandomDateTest(Date min, Date max) {
        dMin = min;
        dMax = max;
    }
    
    public Date generate() {
        long MILLIS_PER_DAY = 1000*60*60*24;
        GregorianCalendar s = new GregorianCalendar();
        s.setTimeInMillis(dMin.getTime());
        GregorianCalendar e = new GregorianCalendar();
        e.setTimeInMillis(dMax.getTime());
        
        // Get difference in milliseconds
        long endL   =  e.getTimeInMillis() +  e.getTimeZone().getOffset(e.getTimeInMillis());
        long startL = s.getTimeInMillis() + s.getTimeZone().getOffset(s.getTimeInMillis());
        long dayDiff = (endL - startL) / MILLIS_PER_DAY;
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(dMin);
        cal.add(Calendar.DATE, new Random().nextInt((int)dayDiff));          
        return cal.getTime();
    }
    
    // =========
    // Test it:
    // =========
    public static void main(String args[]) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1); // today minus one year
        Date dMin = cal.getTime();
        cal.add(Calendar.MONTH, 1); // today plus one year
        Date dMax = cal.getTime();
        
        RandomDateTest rnd = new RandomDateTest(dMin, dMax);
        for (int i=1; i<=10; i++)
            System.out.println("Date = " + rnd.generate());
    }
}