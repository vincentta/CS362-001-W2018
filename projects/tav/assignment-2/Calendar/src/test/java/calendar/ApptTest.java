package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
	/**
	 * Test that the gets methods work as expected.
	 */
	@Test
	public void test01()  throws Throwable  {
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
		int[] days = {};
		// assertions
		assertTrue(appt.getValid());
		assertEquals(21, appt.getStartHour());
		assertEquals(30, appt.getStartMinute());
		assertEquals(15, appt.getStartDay());
		assertEquals(01, appt.getStartMonth());
		assertEquals(2018, appt.getStartYear());
		assertEquals("Birthday Party", appt.getTitle());
		assertEquals("This is my birthday party.", appt.getDescription());

        assertEquals(0, appt.getRecurNumber());
        assertEquals(2, appt.getRecurBy());
		assertEquals(0, appt.getRecurIncrement());
		assertArrayEquals(days, appt.getRecurDays());
		assertFalse(appt.isRecurring());

	}

	@Test
	public void test02()  throws Throwable  {
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
		// assertions
		assertEquals("\t1/15/2018 at 9:" + appt.getStartMinute() + "pm ," + appt.getTitle() + ", " + appt.getDescription() + "\n", appt.toString());

		appt.setStartHour(9);

		assertEquals("\t1/15/2018 at 9:" + appt.getStartMinute() + "am ," + appt.getTitle() + ", " + appt.getDescription() + "\n", appt.toString());

		int [] zerArray= new int [0];
		appt.setRecurrence(null, appt.RECUR_BY_WEEKLY, 1, appt.RECUR_NUMBER_FOREVER);

	}

	@Test
	public void test03()  throws Throwable  {
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title=null;
		String description=null;
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);
		// Set variables
		appt.setStartHour(startHour);
		appt.setStartMinute(startMinute);
		appt.setStartDay(startDay);
		appt.setStartMonth(startMonth);
		appt.setStartYear(startYear);
		appt.setDescription(description);
	}

	@Test
	public void test04()  throws Throwable  {
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
		// Set variables
		appt.setStartDay(40);
		assertEquals(false, appt.getValid());
		appt.setStartDay(-2);
		assertEquals(false, appt.getValid());
		appt.setStartDay(15);

		appt.setStartMinute(63);
		assertEquals(false, appt.getValid());
		appt.setStartMinute(-2);
		assertEquals(false, appt.getValid());
		appt.setStartMinute(30);

		appt.setStartHour(30);
		assertEquals(false, appt.getValid());
		appt.setStartHour(-2);
		assertEquals(false, appt.getValid());
		appt.setStartHour(21);


	}

	@Test
	public void test05()  throws Throwable  {
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
		// Set variables
		assertNotNull(appt.compareTo(appt));
	}

//add more unit tests as you needed

}
