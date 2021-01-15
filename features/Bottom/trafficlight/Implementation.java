package trafficlight;

/**
 * TODO description
 */
public class Implementation extends Intersection{
	
	public int stepcount1 = 1;
	private int BVC = 0; 
	private int BPC = 0;
	
	public void enqueueVehicle(Road road) {
		//check if road is "bottom" then add 1 vehicle in queue
		original(road);
		if(road.equals(Road.BOTTOM)) {
			BVC++;
		}
	}
	
	public void advanceTime() {
		original();
		//Timed - true; Orange - false implementation
		if(Boolean.compare(isTimed, isorange) > 0)
		{
			if(BTTColor == "g" && BVC != 0) 
			{
				BVC--;
			}
			if(BTPColor == "g" && BPC != 0) 
			{
				BPC--;
			}
		}
		//Timed - true; Orange - true implementation
		if(isTimed == true &&  isorange == true)
		{
			BTswitchingtimedorange(stepcount1);
			stepcount1++;
			if(BTTColor == "g" && BVC != 0) 
			{
				BVC--;
			}
			if(BTPColor == "g" && BPC != 0) 
			{
				BPC--;
			}
		}
		//OnRequest - true; Orange - false implementation
		if(Boolean.compare(onrequest, isorange) > 0)
		{
			if(BVC != 0 || TVC !=0 || LPC != 0 || RPC != 0)
			{
				onreqswitch(stepcount);
			}
			stepcount++;
			if(BTTColor == "g" && BVC != 0) 
			{
				BVC--;
			}
			if(BTPColor == "g" && BPC != 0) 
			{
				BPC--;
			}
		}
		//OnRequest - true; Orange - true implementation
		if(onrequest == true && isorange == true)
		{
			if(BTTColor == "g" && BVC != 0) 
			{
				BVC--;
			}
			if(BTPColor == "g" && BPC != 0) 
			{
				BPC--;
			}
		}
	}
	
	public String getIntersectionState() {
		original();
		if(ped)
			return original() + " BV" + BTTColor + BVC + "P" + BTPColor + BPC;
		
		return original() + " BV" + BTTColor + BVC;
	}
	
	public void enqueuePedestrian(Road road) {
		//check if pedestrian is "bottom" then add 1 pedestrian in queue
		if(road.equals(Road.BOTTOM)) {
			BPC++;
		}
		original(road);
	}
	
	public int BTswitchingtimedorange(int step)
	{
		if((step % 12) == 0 && BTTColor.equalsIgnoreCase("r"))
		{
			BTTColor = "o";
			BTPColor = "r";
			return step;
		}
		else if((step % 14) == 0 && BTTColor.equalsIgnoreCase("o"))
		{
			BTTColor = "g";
			BTPColor = "r";
			return step;
		}
		else if((step % 24) == 0 && BTTColor.equalsIgnoreCase("g"))
		{
			BTTColor = "o";
			BTPColor = "r";
			return step;
		}
		else if((step % 26) == 0 && BTTColor.equalsIgnoreCase("o"))
		{
			BTTColor = "r";
			BTPColor = "g";
			stepcount1 = 1;
			return step;
		}
		return step;
	}
}