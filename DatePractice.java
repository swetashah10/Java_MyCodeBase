import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DatePractice {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time = in.next();
        
        DateFormat inFormat = new SimpleDateFormat("hh:mm:ssaa");
        DateFormat outFormat = new SimpleDateFormat("HH:mm:ss");
        
        Date date = null;
        try
    	{
    	    date = inFormat.parse(time);
    	    
    	}
    	catch ( ParseException e )
    	{
    	        e.printStackTrace();
    	}
    	if( date != null )
    	{
    	    String myDate = outFormat.format(date);
    	   
    	    System.out.println(myDate);
    	  
    	}
    }
}