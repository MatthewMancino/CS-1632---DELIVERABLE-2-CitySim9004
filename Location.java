import java.util.*;

public class Location
{
	String locationName;
 	int locNum;

	public Location(String name, int num){
		locationName = name;
		locNum = num;
	}

	public String getName(){
		return locationName;
	}

	public int getLocNum(){
		return locNum;
	}
	public void setLoc(String location){
		locationName = location;
	}
	public String toString()
	{
		StringBuilder B = new StringBuilder();
		B.append(locationName);
		return B.toString();
	}

}
