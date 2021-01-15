package test;
import trafficlight.*;
//import junit assertions
import static org.junit.jupiter.api.Assertions.assertTrue;
//import junit test annotation
import org.junit.jupiter.api.Test;

/**
 * TODO description
 */
public class UnitTest {
	
	Implementation a = new Implementation();
	@Test
	public void BottomImplementation()
	{
		
		if(a.isTimed == true && a.isorange == false && a.ped == false)
		{
			for(int i = 1; i<22; i++)
			{
				a.enqueueVehicle(Road.LEFT);
				a.enqueueVehicle(Road.BOTTOM);
				a.enqueueVehicle(Road.RIGHT);
				a.enqueueVehicle(Road.TOP);
				a.advanceTime();
			}
			//System.out.println(a.getIntersectionState());
			assertTrue(a.getIntersectionState().contains("LVg10 RVg10 BVr11 TVr11"));						
		}
	}
	@Test
	void TestForBottomVehicle() {
			a.enqueueVehicle(Road.BOTTOM);
			a.enqueueVehicle(Road.BOTTOM);
			a.advanceTime();
			if(a.isorange == true) {
				assertTrue(a.getIntersectionState().contains("BVr2"));
			}
			
			if(a.isTimed == true) {
				if(a.ped == false) {
					assertTrue(a.getIntersectionState().contains("BVr2"));
				}
				else if (a.ped == true) {
					assertTrue(a.getIntersectionState().contains("BVr2Pg0"));
				}
				
			}
			if(a.onrequest == true) {
				if(a.ped == false) {
					assertTrue(a.getIntersectionState().contains("BVr2"));
				}
				else if (a.ped == true) {
					assertTrue(a.getIntersectionState().contains("BVr2Pg0"));
				}
			}
			
		  }
}