package trafficlight;
import trafficlight.*;


/**
 * TODO description
 */
public class Implementation extends Intersection {
	
	public int stepcount = 1;
	public int greencount = 1;
	public int flag = 0;
	private int LVC = 0; 
	private int LPC = 0;
	public String LRTColor = "g";
	public String LRPColor = "r";
	public String BTTColor = "r";
	public String BTPColor = "g";
	public boolean ped = false;
	public boolean isTimed = false;
	public boolean isorange = false; 
	public boolean onrequest = false;
	
	public void enqueueVehicle(Road road) {
		//check if road is "left" then add 1 vehicle in queue
		if(road.equals(Road.LEFT)) {
			LVC++;
		}
	}
	
	public void advanceTime() {
		//Timed - true; Orange - false implementation
		if(Boolean.compare(isTimed, isorange) > 0) 
		{
			switchingtimed(stepcount);
			stepcount++;
			if(LRTColor == "g" && LVC != 0) {
				LVC--;
			}
			if(LRPColor == "g" && LPC != 0) {
				LPC--;
			}
		}
		//Timed - true; Orange - true implementation
		if(isTimed == true &&  isorange == true)
		{
			LRswitchingtimedorange(stepcount);
			stepcount++;
			if(LRTColor == "g" && LVC != 0) {
				LVC--;
			}
			if(LRPColor == "g" && LPC != 0) {
				LPC--;
			}
		}
		//OnRequest - true; Orange - false implementation
		if(Boolean.compare(onrequest, isorange) > 0)
		{
			if(stepcount == 10 && BTTColor.equalsIgnoreCase("g"))
			{
				LRTColor = "g";
				LRPColor = "r";
				BTTColor = "r";
				BTPColor = "g";
			}
			if(LRTColor == "g" && LVC != 0) {
				LVC--;
			}
			if(LRPColor == "g" && LPC != 0) {
				LPC--;
			}
		}
		//OnRequest - true; Orange - true implementation
		if(onrequest == true && isorange == true)
		{
			if(BVC != 0 || TVC !=0 || LPC != 0 || RPC != 0)
			{
				onreqswitchorange(stepcount);
			}
			orangetogreen(stepcount);
			if(greencount == 11 && BTTColor.equalsIgnoreCase("g"))
			{
				BTTColor = "o";
				BTPColor = "r";
			}
			else if(greencount == 13 && BTTColor.equalsIgnoreCase("o"))
			{
				LRTColor = "o";
				LRPColor = "r";
				BTTColor = "r";
				BTPColor = "g";
			}
			else if(greencount == 15 && LRTColor.equalsIgnoreCase("o"))
			{
				LRTColor = "g";
				LRPColor = "r";
				greencount = 1;
				stepcount = 1;
				flag = 0;
			}
			stepcount++;
			if(flag == 1)
			{
				greencount++;
			}
			if(LRTColor == "g" && LVC != 0) {
				LVC--;
			}
			if(LRPColor == "g" && LPC != 0) {
				LPC--;
			}
		}
	}
	
	public String getIntersectionState() {
		
		if(ped)
			return "LV" + LRTColor + LVC + "P" + LRPColor + LPC;
		
		return "LV" + LRTColor + LVC;
	}
	
	public void enqueuePedestrian(Road road) {
		//check if pedestrian is "left" then add 1 pedestrian in queue
		if(road.equals(Road.LEFT)) {
			LPC++;
		}
	}
	
	public int switchingtimed(int step)
	{
		if ((step % 10) == 0)
		{
			if(LRTColor.equalsIgnoreCase("g"))
			{
				LRTColor = "r";
				LRPColor = "g";
				BTTColor = "g";
				BTPColor = "r";
				return step;
			}
			else
			{
				LRTColor = "g";
				LRPColor = "r";
				BTTColor = "r";
				BTPColor = "g";
				stepcount = 1;
				return step;
			}
		}
		return step;
	}
	public int LRswitchingtimedorange(int step)
	{
		if((step % 10) == 0 && LRTColor.equalsIgnoreCase("g"))
		{
			LRTColor = "o";
			LRPColor = "r";
			return step;
		}
		else if(((step - 2) % 10) == 0 && LRTColor.equalsIgnoreCase("o"))
		{
			LRTColor = "r";
			LRPColor = "g";
			return step;
		}
		else if(((step - 12) % 14) == 0 && LRTColor.equalsIgnoreCase("r"))
		{
			LRTColor = "o";
			LRPColor = "r";
			return step;
		}
		else if(((step + 2) % 10) == 0 && LRTColor.equalsIgnoreCase("o"))
		{
			LRTColor = "g";
			LRPColor = "r";
			stepcount = 1;
			return step;
		}
		return step;
	}
	public int onreqswitch(int step)
	{
		if(step >= 10)
		{
			if(LRTColor.equalsIgnoreCase("g"))
			{
				LRTColor = "r";
				LRPColor = "g";
				BTTColor = "g";
				BTPColor = "r";
				stepcount = 1;
				return step;
			}
		}
		return step;
	}
	public int onreqswitchorange(int step)
	{
		if(step >= 11 && LRTColor.equalsIgnoreCase("g"))
		{
			LRTColor = "o";
			LRPColor = "r";
			stepcount = 1;
			return step;
		}
		return step;
	}
	public int orangetogreen(int step)
	{
		if((step - 3) == 0 && LRTColor.equalsIgnoreCase("o"))
		{
			LRTColor = "r";
			LRPColor = "g";
			BTTColor = "o";
			BTPColor = "r";
			return step;
		}
		else if((step - 5) == 0 && BTTColor.equalsIgnoreCase("o"))
		{
			BTTColor = "g";
			BTPColor = "r";
			flag = 1;
			stepcount = 1;
			return step;
		}
		return step;
	}
}
