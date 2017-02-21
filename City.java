import java.util.*;

public class City
{
	String Address;
	int numVisits;
	ArrayList<Location> pLocations;
	ArrayList<Road> roads;
	Location Hillman,Presby,Sennott,Union,Outside;

	//Using adjacency matrix to represent graph.
	boolean[][] matrix = new boolean[5][5];;


	// @Test
	public City()
	{
		this.createLocations();
		this.populateMatrix();
	}
	public int createLocations()
	{
		pLocations = new ArrayList<Location>();
		roads = new ArrayList<Road>();
		Hillman = new Location("Hillman",0);
		Presby = new Location("Presby",1);
		Sennott = new Location("Sennott",2);
		Union = new Location("Union",3);
		Outside = new Location("Outside",4);
		pLocations.add(Hillman);
		pLocations.add(Presby);
		pLocations.add(Sennott);
		pLocations.add(Union);
		pLocations.add(Outside);

		return 1; //successful creation;

	}
	public int populateMatrix()
	{
		for (int j = 0; j < 5; j++)
		{
			for(int i = 0; i < 5; i++)
			{
				switch(j)
				{
					case 0:
						if (i == 2) {
							matrix[j][i] = true;
							Road a = new Road("Fifth Ave",Hillman, Sennott);
							roads.add(a);
						}
						else if (i == 3){
							matrix[j][i] = true;
							Road a = new Road("Phil Ave",Hillman, Union);
							roads.add(a);
						}
						else{
							matrix[j][i] = false;
						}
					break;
					case 1:
						if (i == 2){
							Road a = new Road("Bill Ave",Presby, Sennott);
							roads.add(a);
							matrix[j][i] = true;
						}
						else if (i == 3){
							Road a = new Road("Fourth Ave",Presby, Union);
							roads.add(a);
							matrix[j][i] = true;
						}
						else{
							matrix[j][i] = false;
						}
						break;
					case 2:
						if (i == 4){
							Road a = new Road("Fifth Ave",Sennott, Outside);
							roads.add(a);
							matrix[j][i] = true;
						}
						else if (i == 1){
							Road a = new Road("Bill Ave",Sennott, Presby);
							roads.add(a);
							matrix[j][i] = true;
						}
						else{
							matrix[j][i] = false;
						}
						break;
					case 3:
						if (i == 4){
							Road a = new Road("Fourth Ave ",Union, Outside);
							roads.add(a);
							matrix[j][i] = true;
						}
						else if (i == 0){
							Road a = new Road("Phil Ave",Union, Hillman);
							roads.add(a);
							matrix[j][i] = true;
						}
						else{
							matrix[j][i] = false;
						}
						break;
					case 4:
						matrix[j][i] = false;
						break;

				}

			}
		}
		return 1;
	}

	public String beginDrive(Driver curr, int rando, Random go)
	{
		Location dest = null;
		if (rando != -1)
		{
			curr.setCurrLoc(pLocations.get(rando));
		}
		while (curr.currentLocation().getLocNum() < 4)
		{

			dest = this.travelTo(go.nextInt(),curr.currentLocation());
			if (rando == -1)
			{
				return dest.getName(); //Passing test value
			}
			Road output = determineRoad(curr.currentLocation(),dest);

			System.out.println("Driver "+curr.name()+" traveling from "+curr.currentLocation().toString()+" to "+dest.getName()+" on road "+output.getName());

			if (curr.currentLocation().getName() == "Sennott" && dest.getName() == "Outside")
			{
				System.out.println("Off to Cleveland!");
			}
			if (curr.currentLocation().getName() =="Union" && dest.getName() == "Outside")
			{
				System.out.println("Off to Philly!");
			}

			curr.setCurrLoc(dest);

			//For testing purposes, if -1 is passed as the random argument then all we do is print the destination name and leave.

		}
		return dest.getName();
	}



	public Location travelTo(int travel,Location cLoc)
	{
		//if the number is odd, the driver will travel to the location's 0 spot
		//if the number is even, the driver will travel to the location's 1 spot
		if (travel < 0){travel *= -1;}
		int d = travel % 2;
		Location destination = this.determineD(cLoc.getLocNum(),d);

		return destination;
	}
	private Location determineD(int num, int remain){
		int [] cite = new int[2];
		int u = 0;
		for (int t = 0; t < 5; t++){
			if (matrix[num][t] == true){
				cite[u] = t;
				u++;
			}
		}
		int lNum = cite[remain];
		for (Location temp : pLocations)
		{
			if (temp.getLocNum() == lNum){return temp;}
		}
		return null;
	}

	private Road determineRoad(Location cLoc, Location destin){
		for (int i = 0; i < roads.size(); i++){
			Road go = roads.get(i).getConnectingRoads(cLoc,destin);
			if (go != null)
			{

				return go;
			}
		}
		return null;
	}
}
