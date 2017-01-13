package TimeLoggerDemo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane; 

public class TestTheSample {

    public static void main (String [] args){

        String test1;
        
        Date date = new Date();   // given date
        Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
        calendar.setTime(date);   // assigns calendar to given date 
        calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
        calendar.get(Calendar.HOUR);        // gets hour in 12h format
        calendar.get(Calendar.MONTH); 
        test1= JOptionPane.showInputDialog("Log time for slot: "+ calendar.get(Calendar.HOUR_OF_DAY)+":00" + " -- " +calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE));

        System.out.println("test1: "+test1);
    
    }

}