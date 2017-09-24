/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

/**
 *
 * @author mark8604
 */
public class Assignment4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println( "\n\n\n" );

        int testMonth = 9;
//        int testDay = 15;
        int testYear = 2017;
        printMonthCalendar(testMonth, testYear);
//        System.out.println(isLeapYear(testYear));
//        System.out.println(getNumDaysInMonth(testMonth, testYear));
        System.out.println( "\n\n\n" );

    }

    /****
      The method getStartDay() implements Zeller's Algorithm for determining the day of the
      week the first day of a month is. The method adjusts Zeller's numbering scheme
      for day of week ( 0=Saturday, ..., 6=Friday ) to conform to a day of week number
      that corresponds to ISO conventions (i.e., 1=Monday, ..., 7=Sunday)

      Pre-Conditions: The month value, m,  is 1-12
                            The day value, d, is 1-31, or 1-28, 1-29 for February
                            The year value, y, is the full year (e.g., 2012)

     Post-Conditions: A value of 1-7 is returned, representing the first day of the month
                            1 = Monday, ..., 7 = Sunday
    ****/
    // Returns the day of week number (1=Monday,…, 7= Sunday) for the specified month, day, and year. Note this only works for the 1st day of the month.
    public static int getStartDay( int m, int d, int y )
    {
        // Adjust month number & year to fit Zeller's numbering system
        if (m < 3)
        {
            m = m + 12;
            y = y - 1;
        }

        int k = y % 100;      // Calculate year within century
        int j = y / 100;      // Calculate century term
        int h = 0;            // Day number of first day in month 'm'

        h = ( d + ( 13 * ( m + 1 ) / 5 ) + k + ( k / 4 ) + ( j / 4 ) +
            ( 5 * j ) ) % 7;

        // Convert Zeller's value to ISO value (1 = Mon, ... , 7 = Sun )
        int dayNum = ( ( h + 5 ) % 7 ) + 1;

        return dayNum;
    }

    // Displays a calendar like the one above for a specified month and year.
    public static void printMonthCalendar( int m, int y )
    {
        printMonthHeader(m,y);
        printMonthBody(m,y);
    }
    // Displays the header information ( month, year, line separator, 3- character day names) for a calendar.
    public static void printMonthHeader( int m, int y )
    {
        System.out.println( "      " + getMonthName(m) + "  " + y);
        System.out.println( "-----------------------------");
        System.out.println( " Sun Mon Tue Wed Thu Fri Sat ");
    }
    // Displays the days in the calendar associated with the corresponding days of the week.
    public static void printMonthBody( int m, int y )
    {
        int startDay = getStartDay(m, y, 1);
        int dayCount = getNumDaysInMonth(m, y);        
        int weekCounter = startDay; 
        int monthCounter = 1;
        
        while (monthCounter < dayCount) {
            if (weekCounter < 8) {
                System.out.print("  " + monthCounter + " ");
            } else {
                weekCounter = 1;
                System.out.print("\n");
            }
            weekCounter++;
            monthCounter++;
        }
        
        System.out.println( "StartDate:" + startDay );
        System.out.println( "dayCount:" + dayCount );
        System.out.println( "------+++++++++++++++++++----");
    }
    // Returns the name of the month for a specified month number (e.g., returns March for m=3).
    public static String getMonthName( int m )
    {
        String month = "";
        switch (m) {
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
                break;
        }
        return month;
    }
    // Returns the number of days in a specified month and year. Leap years are accounted for.
    public static int getNumDaysInMonth( int m, int y)
    {
        int dayCount;
        switch (m) {
            case 2:
                if (isLeapYear(y)) {
                    dayCount = 29;
                } else {
                    dayCount = 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                dayCount = 30;
                break;
            default:
                dayCount = 31;
        }
        return dayCount;
    }
    // Returns true if the specified year is a leap year, and
    public static boolean isLeapYear( int y )
    {
        return y % 4 == 0;
    }
    // TODO document all code and method
    // TODO string up both programs
}
