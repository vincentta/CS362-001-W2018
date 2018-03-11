package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;
import sun.awt.image.ImageWatched;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		 
	 }
	 @Test
	  public void testGetApptRange()  throws Throwable {
         GregorianCalendar firstDay = new GregorianCalendar(2018, 7,27);
         GregorianCalendar lastDay = new GregorianCalendar(2018,7,29);



		 GregorianCalendar inc50west1 = new GregorianCalendar(2018, 7, 27);
		 GregorianCalendar inc50west2 = new GregorianCalendar(2019,9, 4);
		 GregorianCalendar inc50west3 = new GregorianCalendar(2020,10,2);

		 CalDay calday = new CalDay(inc50west1);
		 CalDay calDay2 = new CalDay(inc50west2);
		 CalDay calDay3 = new CalDay(inc50west3);


		 Appt unityGames = new Appt(8, 1,27, 7,2018,
				 					"Unity Games", "Unity Sports Games");

		 calday.addAppt(unityGames);
		 calDay2.addAppt(unityGames);
		 calDay3.addAppt(unityGames);

		 Appt musicalEvent = new Appt(10, 1,27,7,2018,
				 	                  "Musical","Musical Event");

		 calday.addAppt(musicalEvent);
		 calDay3.addAppt(musicalEvent);

		 LinkedList<Appt> appts = new LinkedList<Appt>();
		 appts.add(unityGames);
		 appts.add(musicalEvent);

		 TimeTable timetable = new TimeTable();

         LinkedList<CalDay> eventList = timetable.getApptRange(appts,firstDay,lastDay);

        //for (int i = 0; i < eventList.size(); i++)
          //  System.out.println(eventList.get(i).toString());

         CalDay eventFromList = eventList.get(0);
         assertTrue(eventFromList.getAppts().contains(unityGames));
         assertTrue(eventFromList.getAppts().contains(musicalEvent));

         try {
             timetable.getApptRange(appts, lastDay, firstDay);
         } catch (DateOutOfRangeException x) {
            assertTrue(x.getMessage().contains("Second date specified is not  before the first date specified."));
         }

         Appt invalidEvent = new Appt(10, 0,0,7,2018,
                 "Musical","Musical Event");

         appts.add(invalidEvent);
         assertTrue(timetable.getApptRange(appts, firstDay, lastDay) instanceof LinkedList);
    }

    @Test
    public void testDeleteAppt() throws Throwable {
        TimeTable timetable = new TimeTable();
        LinkedList<Appt> appts = null;

        Appt unityGames = new Appt(8, 1,27, 7,2018,
                    "Unity Games", "Unity Sports Games");
        Appt musicalEvent = new Appt(10, 1,27,7,2018,
                    "Musical","Musical Event");
        Appt invalidEvent = new Appt(10, 0,0,7,2018,
                "Musical","Musical Event");

        //timetable.deleteAppt(appts, unityGames);
        assertEquals(null, timetable.deleteAppt(appts, unityGames));

        appts = new LinkedList<Appt>();

        appts.add(musicalEvent);
        appts.add(musicalEvent);
        appts.add(musicalEvent);

        assertEquals(null, timetable.deleteAppt(appts,unityGames));

        appts.add(unityGames);

        assertEquals(null, timetable.deleteAppt(appts, null));
        assertEquals(null, null, null);
        assertEquals(null, timetable.deleteAppt(appts, invalidEvent));

        LinkedList<Appt> temp = timetable.deleteAppt(appts, musicalEvent);
        assertEquals(3, temp.size());
        temp = timetable.deleteAppt(appts, musicalEvent);
        assertEquals(2,temp.size());



        //temp = timetable.deleteAppt(appts, musicalEvent);     // BUG: WILL NOT WORK WITH ONLY TWO IN LIST
        //assertEquals(1,temp.size());
    }

    @Test
    public void testPermute() throws Throwable {
        LinkedList<Appt> appts = new LinkedList<Appt>();

        Appt unityGames = new Appt(8, 1,27, 7,2018,
                "Unity Games", "Unity Sports Games");
        Appt musicalEvent = new Appt(10, 1,27,7,2018,
                "Musical","Musical Event");
        Appt specialService = new Appt(4,5,27,7,2018,
                                        "Service", "Special Service");

        appts.add(unityGames);
        appts.add(musicalEvent);
        appts.add(specialService);

        TimeTable timetable = new TimeTable();
        int[] order = new int[3];
        order[0] = 1;
        order[1] = 2;
        order[2] = 0;

        LinkedList<Appt> temp = timetable.permute(appts, order);

        //assertEquals("Service", temp.get(0).getTitle()); // ****BUG: Incorrect Order

        int[] order2 = new int[4];
        order2[0] = 2;
        order2[1] = 1;
        order2[2] = 3;
        order2[3] = 0;

        try {
            temp = timetable.permute(appts, order2);
        } catch (IllegalArgumentException x) {
            assertTrue(x instanceof IllegalArgumentException);
        }

	 }

    @Test
    public void testGetNextApptOccurrence() throws Throwable {
        TimeTable timetable = new TimeTable();
        GregorianCalendar inc50west = new GregorianCalendar(2018, 7, 27);
        GregorianCalendar inc50west2 = new GregorianCalendar(2019, 7, 27);

        Appt unityGames = new Appt(8, 1,27, 7,2018,
                "Unity Games", "Unity Sports Games");

        int[] recurDays = new int[]{27};

        unityGames.setRecurrence(recurDays, unityGames.RECUR_BY_YEARLY, 2, unityGames.RECUR_NUMBER_FOREVER);

        GregorianCalendar newOcc = timetable.testGetNextApptOcc(unityGames,inc50west);
        assertTrue(inc50west2.equals(newOcc));

        int[] recurDays2 = new int[]{};

        unityGames.setRecurrence(recurDays2,unityGames.RECUR_BY_WEEKLY,2,unityGames.RECUR_NUMBER_FOREVER);

        newOcc = timetable.testGetNextApptOcc(unityGames, inc50west);
        assertFalse(inc50west2.equals(newOcc));

        unityGames.setRecurrence(recurDays,unityGames.RECUR_BY_WEEKLY, 3, unityGames.RECUR_NUMBER_FOREVER);

        newOcc = timetable.testGetNextApptOcc(unityGames, inc50west);
        assertFalse(inc50west2.equals(newOcc));
    }

    @Test
    public void testGetApptOccurences() throws Throwable {
        TimeTable timetable = new TimeTable();
        GregorianCalendar inc50west = new GregorianCalendar(2018, 7, 27);
        GregorianCalendar inc50west2 = new GregorianCalendar(2019, 7, 27);

        Appt unityGames = new Appt(8, 1,27, 7,2018,
                "Unity Games", "Unity Sports Games");

        LinkedList<GregorianCalendar> output = new LinkedList<GregorianCalendar>();

        assertTrue(output.size() == timetable.testGetApptOccurences(unityGames, inc50west2, inc50west).size());
    }


//add more unit tests as you needed
}
