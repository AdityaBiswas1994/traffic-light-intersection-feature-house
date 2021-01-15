package trafficlight;

/**
 * TODO description
 */
public class Implementation extends Intersection{

	private int TVC = 0; 
	private int TPC = 0;
	
	public void enqueueVehicle(Road road) {
		//check if road is "top" then add 1 vehicle in queue
		original(road);
		if(road.equals(Road.TOP)) {
			TVC++;
		}
	}
	
	public void advanceTime() {
		original();
		//Timed - true; Orange - false implementation
		if(Boolean.compare(isTimed, isorange) > 0)
		{
			if(BTTColor == "g" && TVC != 0) 
			{
				TVC--;
			}
			if(BTPColor == "g" && TPC != 0) 
			{
				TPC--;
			}
		}
		//Timed - true; Orange - true implementation
		if(isTimed == true &&  isorange == true)
		{
			if(BTTColor == "g" && TVC != 0) 
			{
				TVC--;
			}
			if(BTPColor == "g" && TPC != 0) 
			{
				TPC--;
			}
		}
		//OnRequest - true; Orange - false implementation
		if(Boolean.compare(onrequest, isorange) > 0)
		{
			if(BTTColor == "g" && TVC != 0) 
			{
				TVC--;
			}
			if(BTPColor == "g" && TPC != 0) 
			{
				TPC--;
			}
		}
		//OnRequest - true; Orange - true implementation
		if(onrequest == true && isorange == true)
		{
			if(BTTColor == "g" && TVC != 0) 
			{
				TVC--;
			}
			if(BTPColor == "g" && TPC != 0) 
			{
				TPC--;
			}
		}
	}
	
	public String getIntersectionState() {
		original();
		if(ped)
			return original() + " TV" + BTTColor + TVC + "P" + BTPColor + TPC;
		
		return original() + " TV" + BTTColor + TVC;
	}
	
	public void enqueuePedestrian(Road road) {
		//check if pedestrian is "top" then add 1 pedestrian in queue
		if(road.equals(Road.TOP)) {
			TPC++;
		}
		original(road);
	}
}