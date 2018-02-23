package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Generate Random Tests that tests TimeTable Class.
	 */

	@Test
	public void randomtestTimeTable1()  throws Throwable {

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		System.out.println("Start testing...");

		try {

			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis();
				Random random = new Random(randomseed);


				for (int i=0; i<NUM_TESTS; i++){

					int randDay = ValuesGenerator.getRandomIntBetween(random, 1, 30);
					int randDay2 = ValuesGenerator.getRandomIntBetween(random, 1, 30);
					int randMonth = ValuesGenerator.getRandomIntBetween(random, 0, 11);
					int randMonth2 = ValuesGenerator.getRandomIntBetween(random, 0, 11);


					GregorianCalendar first = new GregorianCalendar(2018, randMonth, randDay);
					GregorianCalendar last = new GregorianCalendar(2018, randMonth2, randDay2);

					LinkedList <Appt> apptList = new LinkedList<Appt>();

					int randNumAppt = ValuesGenerator.getRandomIntBetween(random, 1, 25);

					for(int z=0; i< randNumAppt; i++){
//						int startHour=ValuesGenerator.RandInt(random);
//						int startMinute=ValuesGenerator.RandInt(random);
//						int startDay=ValuesGenerator.RandInt(random);
//						int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
//						int startYear=ValuesGenerator.RandInt(random);

						int startHour=ValuesGenerator.getRandomIntBetween(random, 0, 11);
						int startMinute=ValuesGenerator.getRandomIntBetween(random, 0, 59);
						int startDay=ValuesGenerator.getRandomIntBetween(random, 0, 30);
						int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
						int startYear=ValuesGenerator.RandInt(random);

						String title="Birthday Party";
						String description="This is my birthday party.";
						//Construct a new Appointment object with the initial data
						Appt appt = new Appt(startHour,
								startMinute ,
								startDay ,
								startMonth ,
								startYear ,
								title,
								description);

						int randReccur = ValuesGenerator.getRandomIntBetween(random, 0, 1);
						if(randReccur == 1){
							int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
							int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
							int recur=ApptRandomTest.RandomSelectRecur(random);
							int recurIncrement = ValuesGenerator.RandInt(random);
							int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
							appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						}

						apptList.add(appt);
					}

					try{
						TimeTable table = new TimeTable();
						table.getApptRange(apptList, first, last);
					}catch(DateOutOfRangeException e){
						continue;
					}



				}

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if ((iteration % 10000) == 0 && iteration != 0)
					System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);

			}

		} catch (NullPointerException e) {

		}

		System.out.println("Done testing...");
	}

	@Test
	public void randomtestTimeTable2()  throws Throwable {
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		System.out.println("Start testing...");

		try {
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis();
				Random random = new Random(randomseed);

				for (int i=0; i<NUM_TESTS; i++){
					LinkedList <Appt> apptList = new LinkedList<Appt>();
					LinkedList <Appt> nullApptList = new LinkedList<Appt>();

					String title="Birthday Party";
					String description="This is my birthday party.";
					Appt appt1 = new Appt(1, 30 , 10 , 1 , 2018 , title, description);
					Appt appt2 = new Appt(3, 30 , 10 , 1 , 2018 , title, description);
					Appt appt3 = new Appt(2, 30 , 10 , 1 , 2018 , title, description);
					Appt appt4 = new Appt(4, 30 , 10 , 1 , 2018 , title, description);
					Appt badAppt = new Appt(-5, 30 , 10 , 1 , 2018 , title, description);

					apptList.add(appt1);
					apptList.add(appt2);
					apptList.add(appt3);

					TimeTable table = new TimeTable();
					assertEquals(null, table.deleteAppt(null, null));
					assertEquals(null, table.deleteAppt(nullApptList, appt1));
					assertEquals(null, table.deleteAppt(apptList, null));
					assertEquals(null, table.deleteAppt(apptList, badAppt));
					assertEquals(null, table.deleteAppt(apptList, appt4));
					table.deleteAppt(apptList, appt1);
				}
				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if ((iteration % 10000) == 0 && iteration != 0)
					System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);
			}
		} catch (NullPointerException e) {
		}

		System.out.println("Done testing...");
	}

	
}
