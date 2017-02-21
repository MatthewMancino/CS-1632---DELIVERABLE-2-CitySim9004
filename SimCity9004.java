//Driver for main program regarding SimCity9004
import java.util.*;

public class SimCity9004{

	public static void main(String [] args){
		int d = checkInput(args[0]);
		if (d == -2)
		{
			return;
		}
		Random randy = new Random(d);
		City Oakland = new City();


		Driver A,B,C,D,E;
		A = new Driver("1");
		B = new Driver("2");
		C = new Driver("3");
		D = new Driver("4");
		E = new Driver("5");

		Oakland.beginDrive(A,randy.nextInt(4),randy);
		A.laboonVisits();
		System.out.println(SimCity9004.dashes());

		Oakland.beginDrive(B,randy.nextInt(4),randy);
		B.laboonVisits();
		System.out.println(SimCity9004.dashes());

		Oakland.beginDrive(C,randy.nextInt(4),randy);
		C.laboonVisits();
		System.out.println(SimCity9004.dashes());

		Oakland.beginDrive(D,randy.nextInt(4),randy);
		D.laboonVisits();
		System.out.println(SimCity9004.dashes());

		Oakland.beginDrive(E,randy.nextInt(4),randy);
		E.laboonVisits();
		System.out.println(SimCity9004.dashes());
	}

	public static String dashes(){
		return "----->";
	}
	public static int checkInput(String inline)
	{
		int rand = 0;
		try{
			rand = Integer.parseInt(inline);
		}
		catch(Exception e){
			System.out.println("Command line was not a number");
			return -2;
		}
		if(rand < 0){
			System.out.println("Command line was a negative number");
			return -2;
		}
		return rand;
	}
}
