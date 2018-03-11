package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		 GregorianCalendar today = new GregorianCalendar(2018,10,13);
		 GregorianCalendar tomorrow = new GregorianCalendar(2018,10,24);

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

		 int[] recurDays = new int[]{};
		 appt.setRecurrence(recurDays, 1, 1, 1);

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
		 int[] recurDaysB = new int[]{};
		 apptB.setRecurrence(recurDaysB, 2, 1, appt.RECUR_NUMBER_FOREVER);

		 int startHourC=12;
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

		 int[] recurDaysC = new int[]{3};
		 apptC.setRecurrence(recurDaysC, 3, 1, 1);


		 int startHourD=12;
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

		 int[] recurDaysD = new int[]{3};
		 apptC.setRecurrence(recurDaysD, 1, 1, 1);
		 TimeTable timeTable = new TimeTable();

		 LinkedList<Appt> apptList=new LinkedList<Appt>();
		 LinkedList<CalDay> calDays=new LinkedList<CalDay>();

		 CalDay calDay = new CalDay(today);
		 CalDay calDay2 = new CalDay(tomorrow);

		 apptList.add(appt);
		 apptList.add(apptB);
		 apptList.add(apptC);
		 apptList.add(apptD);

		 calDay.addAppt(appt);
		 calDay.addAppt(apptB);
		 calDay.addAppt(apptC);

		 calDay2.addAppt(appt);
		 calDay2.addAppt(apptB);
		 calDay2.addAppt(apptC);

		 calDays=timeTable.getApptRange(apptList, today, tomorrow);

		 LinkedList<Appt> apptNullList = null;
		 assertEquals(null, timeTable.deleteAppt(apptNullList, appt));
		 assertEquals(null, timeTable.deleteAppt(apptList, appt));
		 assertEquals(null, timeTable.deleteAppt(apptList, null));

	 }

	 @Test
	  public void test02()  throws Throwable  {
		 GregorianCalendar today = new GregorianCalendar(2018,10,13);
		 GregorianCalendar tomorrow = new GregorianCalendar(2018,10,14);

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

		 int[] recurDays = new int[]{3};
		 appt.setRecurrence(recurDays, 1, 1, 1);

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
		 int[] recurDaysB = new int[]{3};
		 apptB.setRecurrence(recurDaysB, 2, 1, 1);

		 int startHourC=12;
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

		 int[] recurDaysC = new int[]{3};
		 apptC.setRecurrence(recurDaysC, 3, 1, 1);


		 int startHourD=12;
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

		 int[] recurDaysD = new int[]{3};
		 apptC.setRecurrence(recurDaysD, 1, 1, 1);
		 TimeTable timeTable = new TimeTable();

		 LinkedList<Appt> apptList=new LinkedList<Appt>();
		 LinkedList<CalDay> calDays=new LinkedList<CalDay>();

		 CalDay calDay = new CalDay(today);
		 CalDay calDay2 = new CalDay(tomorrow);

		 apptList.add(appt);
		 apptList.add(apptB);
		 apptList.add(apptC);
		 //apptList.add(apptD);

		 calDay.addAppt(appt);
		 calDay.addAppt(apptB);
		 calDay.addAppt(apptC);

		 calDay2.addAppt(appt);
		 calDay2.addAppt(apptB);
		 calDay2.addAppt(apptC);

		 int[] pv = {0,1,2};
		 timeTable.permute(apptList, pv);
	 }

	@Test
	public void test03()  throws Throwable  {
		GregorianCalendar today = new GregorianCalendar(2018,10,13);
		GregorianCalendar tomorrow = new GregorianCalendar(2018,10,24);

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

		int[] recurDays = new int[]{};
		appt.setRecurrence(recurDays, 1, 1, 1);

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
		int[] recurDaysB = new int[]{};
		apptB.setRecurrence(recurDaysB, 2, 1, appt.RECUR_NUMBER_FOREVER);

		int startHourC=12;
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

		int[] recurDaysC = new int[]{};
		apptC.setRecurrence(recurDaysC, 3, 1, 1);


		int startHourD=12;
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

		int[] recurDaysD = new int[]{};
		apptC.setRecurrence(recurDaysD, 1, 1, 1);
		TimeTable timeTable = new TimeTable();

		LinkedList<Appt> apptList=new LinkedList<Appt>();
		LinkedList<CalDay> calDays=new LinkedList<CalDay>();
		CalDay calDay = new CalDay(today);
		CalDay calDay2 = new CalDay(tomorrow);

		apptList.add(appt);
		apptList.add(apptB);
		apptList.add(apptC);
		apptList.add(apptD);

		calDay.addAppt(appt);
		calDay.addAppt(apptB);
		calDay.addAppt(apptC);

		calDay2.addAppt(appt);
		calDay2.addAppt(apptB);
		calDay2.addAppt(apptC);

		calDays=timeTable.getApptRange(apptList, today, tomorrow);


		LinkedList<Appt> apptNullList = null;


	}

	@Test
	public void test04()  throws Throwable  {
		GregorianCalendar today = new GregorianCalendar(2018,10,13);
		GregorianCalendar tomorrow = new GregorianCalendar(2018,10,24);

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

		int[] recurDays = new int[]{};
		appt.setRecurrence(recurDays, 1, 1, 1);

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
		int[] recurDaysB = new int[]{};
		apptB.setRecurrence(recurDaysB, 2, 1, appt.RECUR_NUMBER_FOREVER);

		int startHourC=12;
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

		int[] recurDaysC = new int[]{};
		apptC.setRecurrence(recurDaysC, 3, 1, 1);


		int startHourD=12;
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

		int[] recurDaysD = new int[]{};
		apptC.setRecurrence(recurDaysD, 1, 1, 1);
		TimeTable timeTable = new TimeTable();

		LinkedList<Appt> apptList=new LinkedList<Appt>();
		LinkedList<CalDay> calDays=new LinkedList<CalDay>();

		CalDay calDay = new CalDay(today);
		CalDay calDay2 = new CalDay(tomorrow);

		calDays=timeTable.getApptRange(apptList, today, tomorrow);

	}

	@Test
	public void test05()  throws Throwable  {
		GregorianCalendar today = new GregorianCalendar(2018,10,13);
		GregorianCalendar tomorrow = new GregorianCalendar(2018,10,24);

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

		int[] recurDays = new int[]{};
		appt.setRecurrence(recurDays, 1, 1, 1);

		int startHourB=100;
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
		int[] recurDaysB = new int[]{};
		apptB.setRecurrence(recurDaysB, 2, 1, appt.RECUR_NUMBER_FOREVER);

		int startHourC=-1;
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

		int[] recurDaysC = new int[]{};
		apptC.setRecurrence(recurDaysC, 3, 1, 1);


		int startHourD=12;
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

		int[] recurDaysD = new int[]{};
		apptC.setRecurrence(recurDaysD, 1, 1, 1);
		TimeTable timeTable = new TimeTable();

		LinkedList<Appt> apptList=new LinkedList<Appt>();
		LinkedList<CalDay> calDays=new LinkedList<CalDay>();

		CalDay calDay = new CalDay(today);
		CalDay calDay2 = new CalDay(tomorrow);

		apptList.add(appt);
		apptList.add(apptB);
		apptList.add(apptC);

		calDays = timeTable.getApptRange(apptList, today, tomorrow);


	}

	@Test
	public void test06()  throws Throwable  {
		GregorianCalendar today = new GregorianCalendar(2018,10,13);
		GregorianCalendar tomorrow = new GregorianCalendar(2018,10,14);

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

		int[] recurDays = new int[]{3};
		appt.setRecurrence(recurDays, 1, 1, 1);

		int startHourB=3;
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
		int[] recurDaysB = new int[]{3};
		apptB.setRecurrence(recurDaysB, 2, 1, 1);

		int startHourC=10;
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

		int[] recurDaysC = new int[]{3};
		apptC.setRecurrence(recurDaysC, 3, 1, 1);


		int startHourD=-1;
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

		int[] recurDaysD = new int[]{3};
		apptC.setRecurrence(recurDaysD, 1, 1, 1);
		TimeTable timeTable = new TimeTable();

		LinkedList<Appt> apptList=new LinkedList<Appt>();
		LinkedList<CalDay> calDays=new LinkedList<CalDay>();

		CalDay calDay = new CalDay(today);
		CalDay calDay2 = new CalDay(tomorrow);

		apptList.add(appt);
		apptList.add(apptB);
		apptList.add(apptC);
		apptList.add(apptD);

		calDay.addAppt(appt);
		calDay.addAppt(apptB);
		calDay.addAppt(apptC);

		calDay2.addAppt(appt);
		calDay2.addAppt(apptB);
		calDay2.addAppt(apptC);


		assertEquals(4, apptList.size());
		int[] pv = {0,0,0,0};
		assertEquals(4, pv.length);
		assertEquals(apptList, timeTable.permute(apptList, pv));


		assertEquals(null, timeTable.deleteAppt(apptList, apptD));
		assertEquals(apptList, timeTable.deleteAppt(apptList, apptC));

	 }

	@Test
	public void test07()  throws Throwable  {
		GregorianCalendar today = new GregorianCalendar(2018,10,13);
		GregorianCalendar tomorrow = new GregorianCalendar(2020,10,24);

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

		int[] recurDays = new int[]{2};
		appt.setRecurrence(recurDays, 1, 1, 1);

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
		int[] recurDaysB = new int[]{0};
		apptB.setRecurrence(recurDaysB, 2, 1, appt.RECUR_NUMBER_FOREVER);

		int startHourC=12;
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

		int[] recurDaysC = new int[]{1};
		apptC.setRecurrence(recurDaysC, 3, 1, 1);


		int startHourD=12;
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

		int[] recurDaysD = new int[]{5};
		apptC.setRecurrence(recurDaysD, 1, 1, 1);
		TimeTable timeTable = new TimeTable();

		LinkedList<Appt> apptList=new LinkedList<Appt>();
		LinkedList<CalDay> calDays=new LinkedList<CalDay>();
		CalDay calDay = new CalDay(today);
		CalDay calDay2 = new CalDay(tomorrow);

		apptList.add(appt);
		apptList.add(apptB);
		apptList.add(apptC);
		apptList.add(apptD);

		calDay.addAppt(appt);
		calDay.addAppt(apptB);
		calDay.addAppt(apptC);

		calDay2.addAppt(appt);
		calDay2.addAppt(apptB);
		calDay2.addAppt(apptC);

		calDays=timeTable.getApptRange(apptList, today, tomorrow);
	}
//add more unit tests as you needed
}
