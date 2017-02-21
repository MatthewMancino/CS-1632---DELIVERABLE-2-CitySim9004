import org.junit.Test;
import static org.junit.Assert.*;

import org.mockito.*;
import org.mockito.Mockito.*;
import java.util.*;

public class simCityTest{


	//test #1 0 tests the happy path that nothing will be displayed
	@Test
	public void testSennottVisits(){
		Driver here = new Driver("A");
		here.setSenn(2);
		assertEquals(here.laboonVisits(),1);
	}

	@Test //#2 - tests that laboonVisits will display nothing
	public void testUnderSenVisits(){
		Driver here = new Driver("B");
		here.setSenn(0);
		assertEquals(here.laboonVisits(),0);
	}

	@Test //#3
	public void testOverSenVisits(){
		Driver here = new Driver("C");
		here.setSenn(3);
		assertEquals(here.laboonVisits(),2);
	}


	//#4 tests the instantiation and completion of the "Happy path"
	@Test
	public void testsMain(){
		//SimCity9004.main((String [])"500");
		//Mockito.assertEqual();
	}



	//Test#5 - tests whether the program will correctly display that you have left outside of philadelphia
	@Test
	public void testOutsidePhiladelphia(){

		int d;
		City Oakland = new City();
		Random mockRandom = Mockito.mock(Random.class);
		Driver mockDriver = Mockito.mock(Driver.class);

		Mockito.when(mockDriver.currentLocation()).thenReturn(new Location("Union",3));
		Mockito.when(mockRandom.nextInt()).thenReturn(4);
		String test = Oakland.beginDrive(mockDriver,-1,mockRandom);
		if (test.equals("Outside"))
		{
			d = 1;
		}
		else {d = 0;}
		assertEquals(d,1);

	}

	//TEST #6 - tests to see if person lands outside cleveland
	@Test
	public void testOutsideCleveland(){
		int d;
		City Oakland = new City();
		Random mockRandom = Mockito.mock(Random.class);
		Driver mockDriver = Mockito.mock(Driver.class);

		Mockito.when(mockDriver.currentLocation()).thenReturn(new Location("Sennott",2));
		Mockito.when(mockRandom.nextInt()).thenReturn(4);
		String test = Oakland.beginDrive(mockDriver,-1,mockRandom);
		System.out.println(test);
		if (test.equals("Outside"))
		{
			d = 1;
		}
		else{
			d = 0;
		}
		assertEquals(d,1);

	}
	//TEST #7 - Tests that you can go from Presby to Union
	@Test
	public void testFifthAvePresby(){
		int d;
		City Oakland = new City();
		Driver mockDriver = Mockito.mock(Driver.class);
		Random mockRandom = Mockito.mock(Random.class);

		Mockito.when(mockDriver.currentLocation()).thenReturn(new Location("Presby",1));
		Mockito.when(mockRandom.nextInt()).thenReturn(3);
		String test = Oakland.beginDrive(mockDriver,-1,mockRandom);
		if (test.equals("Union"))
		{
			d = 1;
		}
		else{
			d = 0;
		}
		assertEquals(d,1);

	}

	//Test #8 - EDGE CASE: tests that you shouldn't be able to go backwards from the Union towards Presby
	@Test
	public void testFifthAveUnion(){
		int d;
		City Oakland = new City();
		Driver mockDriver = Mockito.mock(Driver.class);
		Random mockRandom = Mockito.mock(Random.class);

		Mockito.when(mockDriver.currentLocation()).thenReturn(new Location("Union",3));
		Mockito.when(mockRandom.nextInt()).thenReturn(1);

		String test = Oakland.beginDrive(mockDriver,-1,mockRandom);
		if (test.equals(null))
		{
			d = 1;
		}
		else{
			d = 0;
		}
		assertEquals(d,1);
	}

	//Test #9 tests that Bill Ave can correcly be traversed between Presby and Sennott Square
	@Test
	public void testBillAve(){
		int d;
		City Oakland = new City();
		Driver mockDriver = Mockito.mock(Driver.class);
		Random mockRandom = Mockito.mock(Random.class);

		Mockito.when(mockDriver.currentLocation()).thenReturn(new Location("Presby",1));
		Mockito.when(mockRandom.nextInt()).thenReturn(2);
		String test = Oakland.beginDrive(mockDriver,-1,mockRandom);
		if (test.equals("Sennott"))
		{
			d = 1;
		}
		else{
			d = 0;
		}
		assertEquals(d,1);
	}
	//#10
	@Test
	public void testBillAve2(){
		int d;
		City Oakland = new City();
		Driver mockDriver = Mockito.mock(Driver.class);
		Random mockRandom = Mockito.mock(Random.class);

		Mockito.when(mockDriver.currentLocation()).thenReturn(new Location("Sennott",2));
		Mockito.when(mockRandom.nextInt()).thenReturn(1);
		String test = Oakland.beginDrive(mockDriver,-1,mockRandom);
		if (test.equals("Presby"))
		{
			d = 1;
		}
		else{
			d = 0;
		}
		assertEquals(d,1);

	}
	//Test #11 tests that Phil Ave can correctly be traversed between Hillman and the Union
	@Test
	public void testPhilAveUniontoHillman(){
		int d;
		City Oakland = new City();
		Driver mockDriver = Mockito.mock(Driver.class);
		Random mockRandom = Mockito.mock(Random.class);

		Mockito.when(mockDriver.currentLocation()).thenReturn(new Location("Union",3));
		Mockito.when(mockRandom.nextInt()).thenReturn(0);
		String test = Oakland.beginDrive(mockDriver,-1,mockRandom);
		if (test.equals("Hillman"))
		{
			d = 1;
		}
		else{
			d = 0;
		}
		assertEquals(d,1);

	}
	//#12
	@Test
	public void testPhilAveHillmantoUnion(){
		int d;
		City Oakland = new City();
		Driver mockDriver = Mockito.mock(Driver.class);
		Random mockRandom = Mockito.mock(Random.class);

		Mockito.when(mockDriver.currentLocation()).thenReturn(new Location("Hillman",0));
		Mockito.when(mockRandom.nextInt()).thenReturn(3);
		String test = Oakland.beginDrive(mockDriver,-1,mockRandom);
		if (test.equals("Hillman"))
		{
			d = 1;
		}
		else{
			d = 0;
		}
		assertEquals(d,1);

	}

		//Test #13 - Testing that you CAN go from Hillman to Sennott
		@Test
		public void testFourthAveHillman(){
			int d;
			City Oakland = new City();
			Driver mockDriver = Mockito.mock(Driver.class);
			Random mockRandom = Mockito.mock(Random.class);

			Mockito.when(mockDriver.currentLocation()).thenReturn(new Location("Hillman",0));
			Mockito.when(mockRandom.nextInt()).thenReturn(2);
			String test = Oakland.beginDrive(mockDriver,-1,mockRandom);
			if (test.equals("Sennott"))
			{
				d = 1;
			}
			else{
				d = 0;
			}
			assertEquals(d,1);
		}

		//Test #14 - Testing that you can't go back to Hillman from Sennott in a car
		@Test
		public void testFourthAveSennott(){
			int d;
			City Oakland = new City();
			Driver mockDriver = Mockito.mock(Driver.class);
			Random mockRandom = Mockito.mock(Random.class);

			Mockito.when(mockDriver.currentLocation()).thenReturn(new Location("Sennott",2));
			Mockito.when(mockRandom.nextInt()).thenReturn(0);
			String test = Oakland.beginDrive(mockDriver,-1,mockRandom);
			if (test.equals(null))
			{
				d = 1;
			}
			else{
				d = 0;
			}
			assertEquals(d,1);
		}
		//TEST #15 - Tests normal function Mockito.when entering a regular number
		@Test
		public void testCommandLineRegularNumber(){
			String [] ags = new String[1];
			ags[0] = "20";
			SimCity9004.main(ags);
			int returncode = SimCity9004.returnCode(0);
			assertEquals(returncode,0);

		}
		//Test #16 - Tests what happens Mockito.when a negative number is passed in
		@Test
		public void testCommandLineNegativeNumber(){
			String [] ags = new String[1];
			ags[0] = "-5";
			SimCity9004.main(ags);
			int returncode = SimCity9004.returnCode(0);
			assertEquals(returncode,0);
		}

		//Test #17 - Tests the production of dashes;
		@Test
		public void testDashes(){
			City mockCity = Mockito.mock(City.class);
			Driver mockDriver = Mockito.mock(Driver.class);
			Random mockRandom = Mockito.mock(Random.class);

			Mockito.when(mockDriver.currentLocation()).thenReturn(new Location("Sennott",2));
			Mockito.when(mockRandom.nextInt()).thenReturn(0);
			Mockito.when(mockCity.beginDrive(mockDriver,-1,mockRandom)).thenReturn("Done");
			mockCity.beginDrive(mockDriver,-1,mockRandom);
			assertSame(SimCity9004.dashes(), "----->");

		}

		//Test #18 - No Arguments
		@Test
		public void testNoArgs(){
			try{
				new SimCity9004();
			}
			catch (Exception e)
			{
				boolean x = false;
				assertTrue(x);
			}
		}

		//There is no variable input on this test so it is just making sure that the instantion of the locations and the setting up of the availibility matrix was a success
		@Test
		public void testPopulateMatrix()
		{
			City Oakland = new City();
			assertEquals(Oakland.populateMatrix(),1);

		}
		@Test
		public void testCreateLocations()
		{
			City Oakland = new City();
			assertEquals(Oakland.createLocations(),1);
		}
}
