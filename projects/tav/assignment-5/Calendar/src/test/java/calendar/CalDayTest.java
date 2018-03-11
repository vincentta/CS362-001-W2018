package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

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

		 int[] recurDays = new int[]{0};
		 appt.setRecurrence(recurDays, 1, 1, 0);

		 int startHourB=5;
		 int startMinuteB=30;
		 int startDayB=15;
		 int startMonthB=01;
		 int startYearB=2018;
		 String titleB="Birthday Party";
		 String descriptionB="This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 Appt apptB = new Appt(startHourB,
				 startMinuteB,
				 startDayB,
				 startMonthB,
				 startYearB,
				 titleB,
				 descriptionB);

		 int startHourC=120;
		 int startMinuteC=30;
		 int startDayC=15;
		 int startMonthC=01;
		 int startYearC=2018;
		 String titleC="Birthday Party";
		 String descriptionC="This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 Appt apptC = new Appt(startHourC,
				 startMinuteC,
				 startDayC,
				 startMonthC,
				 startYearC,
				 titleC,
				 descriptionC);

		 int startHourD=4;
		 int startMinuteD=30;
		 int startDayD=15;
		 int startMonthD=01;
		 int startYearD=2018;
		 String titleD="Birthday Party";
		 String descriptionD="This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 Appt apptD = new Appt(startHourD,
				 startMinuteD,
				 startDayD,
				 startMonthD,
				 startYearD,
				 titleD,
				 descriptionD);

		 int startHourE=4;
		 int startMinuteE=30;
		 int startDayE=15;
		 int startMonthE=01;
		 int startYearE=2018;
		 String titleE="Birthday Party";
		 String descriptionE="This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 Appt apptE = new Appt(startHourE,
				 startMinuteE,
				 startDayE,
				 startMonthE,
				 startYearE,
				 titleE,
				 descriptionE);

		 LinkedList<Appt> apptList= new LinkedList<Appt>();

		 calDay.addAppt(appt);
		 //calDay.addAppt(apptD);
		 calDay.addAppt(apptB);
		 calDay.addAppt(apptD);
		 calDay.addAppt(apptC);
		 calDay.addAppt(apptE);


		 assertEquals("\t --- 10/13/2018 --- \n --- -------- Appointments ------------ --- \n\t1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n \t1/15/2018 at 4:30am ,Birthday Party, This is my birthday party.\n \t1/15/2018 at 4:30am ,Birthday Party, This is my birthday party.\n \t1/15/2018 at 5:30am ,Birthday Party, This is my birthday party.\n \n", calDay.toString());
		 assertEquals(4, calDay.getSizeAppts());

		 assertEquals(true, calDay.iterator().hasNext());

	 }

	 @Test
	  public void test02()  throws Throwable  {
		 int thisYear=2018;
		 int thisMonth=10;
		 int thisDay=13;
		 GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		 GregorianCalendar tomorrow = (GregorianCalendar)today.clone();

		 CalDay day = new CalDay();

		 assertEquals(null, day.iterator());
		 assertEquals("", day.toString());
	 }

	@Test
	public void test03()  throws Throwable {
		int thisYear = 2018;
		int thisMonth = 10;
		int thisDay = 13;
		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar) today.clone();

		CalDay calDay = new CalDay(today);
		assertEquals(true, calDay.isValid());

		int startHour = 4;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);

		int[] recurDays = new int[]{0};
		appt.setRecurrence(recurDays, 1, 1, 0);

		int startHourB = 5;
		int startMinuteB = 30;
		int startDayB = 15;
		int startMonthB = 01;
		int startYearB = 2018;
		String titleB = "Birthday Party";
		String descriptionB = "This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt apptB = new Appt(startHourB,
				startMinuteB,
				startDayB,
				startMonthB,
				startYearB,
				titleB,
				descriptionB);

		int startHourC = 3;
		int startMinuteC = 30;
		int startDayC = 15;
		int startMonthC = 01;
		int startYearC = 2018;
		String titleC = "Birthday Party";
		String descriptionC = "This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt apptC = new Appt(startHourC,
				startMinuteC,
				startDayC,
				startMonthC,
				startYearC,
				titleC,
				descriptionC);

		int startHourD = 4;
		int startMinuteD = 30;
		int startDayD = 15;
		int startMonthD = 01;
		int startYearD = 2018;
		String titleD = "Birthday Party";
		String descriptionD = "This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt apptD = new Appt(startHourD,
				startMinuteD,
				startDayD,
				startMonthD,
				startYearD,
				titleD,
				descriptionD);

		int startHourE = 4;
		int startMinuteE = 30;
		int startDayE = 15;
		int startMonthE = 01;
		int startYearE = 2018;
		String titleE = "Birthday Party";
		String descriptionE = "This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt apptE = new Appt(startHourE,
				startMinuteE,
				startDayE,
				startMonthE,
				startYearE,
				titleE,
				descriptionE);

		LinkedList<Appt> apptList = new LinkedList<Appt>();

		calDay.addAppt(appt);
		//calDay.addAppt(apptD);
		calDay.addAppt(apptB);
		calDay.addAppt(apptD);
		calDay.addAppt(apptC);
		calDay.addAppt(apptE);

		assertEquals(5, calDay.getSizeAppts());
		assertEquals(true, calDay.isValid());
		assertEquals(true, calDay.iterator().hasNext());
	}
//add more unit tests as you needed	
}
