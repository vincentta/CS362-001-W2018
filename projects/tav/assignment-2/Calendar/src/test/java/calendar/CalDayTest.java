package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
		 int thisYear=2018;
		 int thisMonth=10;
		 int thisDay=13;
		 GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		 GregorianCalendar tomorrow = (GregorianCalendar)today.clone();

		 CalDay calDay = new CalDay(today);
		 assertEquals(true, calDay.isValid());

		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour,
				 startMinute,
				 startDay,
				 startMonth,
				 startYear,
				 title,
				 description);

		 calDay.addAppt(appt);
		 assertEquals("\t --- 10/13/2018 --- \n --- -------- Appointments ------------ --- \n\t1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n \n", calDay.toString());
		
	 }
	 @Test
	  public void test02()  throws Throwable  {

	 }
//add more unit tests as you needed	
}
