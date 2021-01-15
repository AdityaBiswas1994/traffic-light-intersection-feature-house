package trafficlight;
import trafficlight.*;

/**
 * TODO description
 */
public class Implementation extends Intersection{
	
	private int RVC = 0; 
	private int RPC = 0;
	
	public void enqueueVehicle(Road road) {
		//check if road is "right" then add 1 vehicle in queue
		original(road);
		if(road.equals(Road.RIGHT)) {
			RVC++;
		}
	}
	
	public void advanceTime() {
		original();
		//Timed - true; Orange - false implementation
		if(Boolean.compare(isTimed, isorange) > 0)
		{
			if(LRTColor == "g" && RVC != 0) 
			{
				RVC--;
			}
			if(LRPColor == "g" && RPC != 0) 
			{
				RPC--;
			}
		}
		//Timed - true; Orange - true implementation
		if(isTimed == true &&  isorange == true)
		{
			if(LRTColor == "g" && RVC != 0) {
				RVC--;
			}
			if(LRPColor == "g" && RPC != 0) {
				RPC--;
			}
		}
		//OnRequest - true; Orange - false implementation
		if(Boolean.compare(onrequest, isorange) > 0)
		{
			if(LRTColor == "g" && RVC != 0) {
				RVC--;
			}
			if(LRPColor == "g" && RPC != 0) {
				RPC--;
			}
		}
		//OnRequest - true; Orange - true implementation
		if(onrequest == true && isorange == true)
		{
			if(LRTColor == "g" && RVC != 0) {
				RVC--;
			}
			if(LRPColor == "g" && RPC != 0) {
				RPC--;
			}
		}
	}
	
	public String getIntersectionState() {
		original();
		if(ped)
			return original() + " RV" + LRTColor + RVC + "P" + LRPColor + RPC;
		
		return original() + " RV" + LRTColor + RVC;
	}
	
	public void enqueuePedestrian(Road road) {
		//check if pedestrian is "right" then add 1 pedestrian in queue
		if(road.equals(Road.RIGHT)) {
			RPC++;
		}
		original(road);
	}
}