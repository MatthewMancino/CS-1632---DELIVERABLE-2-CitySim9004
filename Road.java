public class Road
{
	Location Start,Dest;
	String NAME;

	public Road(String name,Location a, Location b)
	{
		NAME = name;
		Start = a;
		Dest = b;

	}
	public String getName()
	{
		return NAME;
	}
	public Road getConnectingRoads(Location source, Location destination)
	{
		if (Start.equals(source))
		{
			if(Dest.equals(destination))
			{
				return this;
			}
		}
		return null;
	}
}
