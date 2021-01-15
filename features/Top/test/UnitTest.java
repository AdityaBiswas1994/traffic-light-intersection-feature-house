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
	public void TopImplementation()
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
	void TestForTopPedestrian() {
			a.enqueuePedestrian(Road.TOP);
			a.enqueuePedestrian(Road.TOP);
			a.advanceTime();
//			System.out.println(a.getIntersectionState());
			if(a.ped == false) {
				assertTrue(a.getIntersectionState().contains("TVr0"));
			}
//			else if (a.ped== true) {
//				assertTrue(a.getIntersectionState().contains("TVr0Pg1"));
//			}
		  }

	
	@Test
	void TestForTopVehicle() {
			a.enqueueVehicle(Road.TOP);
			a.enqueueVehicle(Road.TOP);
			a.advanceTime();
			if(a.isorange == true) {
				assertTrue(a.getIntersectionState().contains("TVr2"));
			}
			if(a.isTimed == true) {
				assertTrue(a.getIntersectionState().contains("TVr2"));
			}
			if(a.onrequest == true) {
				assertTrue(a.getIntersectionState().contains("TVr2"));
			}
			
		  
		}

	
	
	
	@Test
	void checkTop1() {
		a.enqueueVehicle(Road.TOP);
		a.enqueueVehicle(Road.TOP);
		a.advanceTime();
		if(a.isorange == false) {
			assertTrue(a.getIntersectionState().contains("TVr2"));
		}
		if(a.isTimed == true) {
			assertTrue(a.getIntersectionState().contains("TVr2"));
		}
		if(a.onrequest == false) {
			assertTrue(a.getIntersectionState().contains("TVr2"));
		}
		if(a.ped == false) {
			assertTrue(a.getIntersectionState().contains("TVr2"));
		}
	}

	
	
	@Test
	void checkTop2() {
		a.enqueueVehicle(Road.TOP);
		a.enqueueVehicle(Road.TOP);
		a.advanceTime();
		if(a.isorange == false) {
			assertTrue(a.getIntersectionState().contains("TVr2"));
		}
		if(a.isTimed == false) {
			assertTrue(a.getIntersectionState().contains("TVr2"));
		}
		if(a.onrequest == true) {
			assertTrue(a.getIntersectionState().contains("TVr2"));
		}
		if(a.ped == false) {
			assertTrue(a.getIntersectionState().contains("TVr2"));
		}
	}

}