public class Driver
{
	int SennottVisits, HillmanVisits, UnionVisits, PresbyVisits;
	Location currentLocation;
	String Name;

	public Driver(String name){
		Name = name;
	}

	public Location currentLocation()
	{
		return currentLocation;
	}
	public void setCurrLoc(Location param)
	{
		if (param.getName().equals("Sennott")){
			SennottVisits++;
		}
		currentLocation = param;
	}
	public int laboonVisits()
	{
		int code = 0;
		if (SennottVisits >= 3)
		{
			System.out.println("Wow that student needed alot of CS help!");
			code = 2;
		}
		else if (SennottVisits == 0)
		{
			System.out.println("That student must have missed out!");
			code = 0;
		}
		else if (SennottVisits > 0 && SennottVisits < 3)
		{
			code = 1;
		}

		System.out.println("Driver: "+Name+" visited Professor Laboon "+SennottVisits+" times");
		return code;

	}
	public void setSenn(int vis)
	{
		SennottVisits = vis;
	}
	public String name()
	{
		return Name;
	}

	/*public String determineRoad(Location currentLocation, Location destination)
	{
		switch (currentLocation.getName())
		{
			case "Hillman":
				if (destination.getName().equals("Outside"))
				{

				}
				else
				{

				}
			break;
			case "Presby":
				if (destination.getName().equals("Outside"))
				{

				}
				else
				{

				}
			break;
			case "Sennott":
				if (destination.getName().equals("Outside"))
				{

				}
				else
				{

				}
			break;
			case "Union":
				if (destination.getName().equals("Outside"))
				{

				}
				else
				{

				}
			break;
			case "Outside":
				if (destination.getName().equals("Outside"))
				{

				}
				else
				{

				}
			break;

		}
	}
	*/
}
