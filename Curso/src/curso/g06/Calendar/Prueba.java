package curso.g06.Calendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Prueba {
	public static void main(String arg[]){
		
		
		
		{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String date = sdf.format(new Date()); 
		System.out.println(date);
		}
		
		{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		String dateInString = "31-08-2000 10:20:56";
		Date date = null;
		try {
			date = sdf.parse(dateInString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(date); 
		}
		
		{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String dateInString = "31-08-1982";
		Date date = null;
		try {
			date = sdf.parse(dateInString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(date); 
		}
		
		
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");	
			Calendar calendar = new GregorianCalendar(2013,0,31);
			System.out.println(sdf.format(calendar.getTime()));
		}
		
		
		{
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");	
			Calendar calendar = new GregorianCalendar(2016,4,22,0,0,0);

			int year       = calendar.get(Calendar.YEAR);
			int month      = calendar.get(Calendar.MONTH); // Jan = 0, dec = 11
			int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH); 
			int dayOfWeek  = calendar.get(Calendar.DAY_OF_WEEK);
			int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
			int weekOfMonth= calendar.get(Calendar.WEEK_OF_MONTH);

			int hour       = calendar.get(Calendar.HOUR);        // 12 hour clock
			int hourOfDay  = calendar.get(Calendar.HOUR_OF_DAY); // 24 hour clock
			int minute     = calendar.get(Calendar.MINUTE);
			int second     = calendar.get(Calendar.SECOND);
			int millisecond= calendar.get(Calendar.MILLISECOND);
				
			System.out.println(sdf.format(calendar.getTime()));
				
			System.out.println("year \t\t: " + year);
			System.out.println("month \t\t: " + month);
			System.out.println("dayOfMonth \t: " + dayOfMonth);
			System.out.println("dayOfWeek \t: " + dayOfWeek);
			System.out.println("weekOfYear \t: " + weekOfYear);
			System.out.println("weekOfMonth \t: " + weekOfMonth);
				
			System.out.println("hour \t\t: " + hour);
			System.out.println("hourOfDay \t: " + hourOfDay);
			System.out.println("minute \t\t: " + minute);
			System.out.println("second \t\t: " + second);
			System.out.println("millisecond \t: " + millisecond);
			
		}
		
		{
			SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
			String dateInString = "30-11-2015";
			

		    Calendar calendar = Calendar.getInstance();
		    //calendar.setLenient(true);
		    //sdf.setLenient(true);
			try {
				calendar.setTime(sdf.parse(dateInString));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("*************************"+sdf.format(calendar.getTime()));
			System.out.println(dateInString.compareTo(sdf.format(calendar.getTime())));
		}
		
		
		
		{
			Calendar someCalendar1 = Calendar.getInstance(); // current date/time
		    someCalendar1.add(Calendar.DATE, -11);

		    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		    Date someDate = null;
			try {
				someDate = df.parse("10/08/2009");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		    Calendar someCalendar2 = Calendar.getInstance();
		    someCalendar2.setTime(someDate);

		    String cal1 = df.format(someCalendar1.getTime());
		    String cal2 = df.format(someCalendar2.getTime());

		    if (someCalendar1.equals(someCalendar2))
		        System.out.println( cal1 + " is the same as " + cal2);
		    if (someCalendar1.after(someCalendar2))
		        System.out.println(cal1 + " is after " + cal2);
		    if (someCalendar1.before(someCalendar2))
		        System.out.println(cal1 + " is before " + cal2);

		    }
		}
	}

