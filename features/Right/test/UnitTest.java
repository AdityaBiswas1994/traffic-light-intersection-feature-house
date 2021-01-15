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
	public void RightImplementation()
	{
		
		if(a.isTimed == true && a.isorange == false && a.ped == false)
		{
			for(int i = 1; i<22; i++)
			{
				a.enqueueVehicle(Road.RIGHT);
				a.advanceTime();
			}
			//System.out.println(a.getIntersectionState());
			assertTrue(a.getIntersectionState().contains("RVg10"));						
		}
		if(a.isTimed == true && a.isorange == false && a.ped == false)
		{
			for(int i = 1; i<22; i++)
			{
				a.enqueueVehicle(Road.RIGHT);
				a.enqueueVehicle(Road.LEFT);
				a.advanceTime();
			}
			//System.out.println(a.getIntersectionState());
			assertTrue(a.getIntersectionState().contains("LVg10 RVg20"));						
		}
	}
	@Test
	void checkright1() {
	a.enqueueVehicle(Road.RIGHT);
	a.enqueueVehicle(Road.RIGHT);
	a.enqueueVehicle(Road.RIGHT);
	a.enqueueVehicle(Road.RIGHT);
	a.enqueueVehicle(Road.RIGHT);	
	a.enqueueVehicle(Road.RIGHT);
	a.enqueueVehicle(Road.RIGHT);
	a.enqueueVehicle(Road.RIGHT);
	a.advanceTime();
//	System.out.println(a.getIntersectionState());
	if(a.isorange == false) {
	assertTrue(a.getIntersectionState().contains("RVg7"));
	}
	if(a.isTimed == true) {
		assertTrue(a.getIntersectionState().contains("RVg7"));
	}
	if(a.onrequest == false) {
		assertTrue(a.getIntersectionState().contains("RVg7"));
	}
	if(a.ped == false) {
		assertTrue(a.getIntersectionState().contains("RVg7"));
	}
}

	
	
	@Test
	void checkright2() {
		a.enqueueVehicle(Road.RIGHT);
		a.enqueueVehicle(Road.RIGHT);
		a.enqueueVehicle(Road.RIGHT);
		a.enqueueVehicle(Road.RIGHT);
		a.enqueueVehicle(Road.RIGHT);	
		a.enqueueVehicle(Road.RIGHT);
		a.enqueueVehicle(Road.RIGHT);
		a.enqueueVehicle(Road.RIGHT);
		a.advanceTime();
//		System.out.println(a.getIntersectionState());
		if(a.isorange == false) {
		assertTrue(a.getIntersectionState().contains("RVg7"));
		}
		if(a.isTimed == false) {
			assertTrue(a.getIntersectionState().contains("RVg7"));
		}
		if(a.onrequest == true) {
			assertTrue(a.getIntersectionState().contains("RVg7"));
		}
		if(a.ped == false) {
			assertTrue(a.getIntersectionState().contains("RVg7"));
		}
	}

	
	
	@Test
	void checkright3() {
		a.enqueueVehicle(Road.RIGHT);
		a.enqueueVehicle(Road.RIGHT);
		a.enqueueVehicle(Road.RIGHT);
		a.enqueueVehicle(Road.RIGHT);
		a.enqueueVehicle(Road.RIGHT);	
		a.enqueueVehicle(Road.RIGHT);
		a.enqueueVehicle(Road.RIGHT);
		a.enqueueVehicle(Road.RIGHT);
		a.advanceTime();
//		System.out.println(a.getIntersectionState());
		if(a.isorange == true) {
		assertTrue(a.getIntersectionState().contains("RVg7"));
		}
		if(a.isTimed == false) {
			assertTrue(a.getIntersectionState().contains("RVg7"));
		}
		if(a.onrequest == true) {
			assertTrue(a.getIntersectionState().contains("RVg7"));
		}
		if(a.ped == false) {
			assertTrue(a.getIntersectionState().contains("RVg7"));
		}
	}

	
	
	@Test
	void checkright4() {
		a.enqueueVehicle(Road.RIGHT);
		a.enqueueVehicle(Road.RIGHT);
		a.enqueueVehicle(Road.RIGHT);
		a.enqueueVehicle(Road.RIGHT);
		a.enqueueVehicle(Road.RIGHT);	
		a.enqueueVehicle(Road.RIGHT);
		a.enqueueVehicle(Road.RIGHT);
		a.enqueueVehicle(Road.RIGHT);
		a.advanceTime();
//		System.out.println(a.getIntersectionState());
		if(a.isorange == false) {
		assertTrue(a.getIntersectionState().contains("RVg7"));
		}
		if(a.isTimed == true) {
			assertTrue(a.getIntersectionState().contains("RVg7"));
		}
		if(a.onrequest == false) {
			assertTrue(a.getIntersectionState().contains("RVg7"));
		}
		if(a.ped == true) {
			assertTrue(a.getIntersectionState().contains("RVg7"));
		}
	}

	
	
	@Test
	void checkright5() {
		a.enqueueVehicle(Road.RIGHT);
		a.enqueueVehicle(Road.RIGHT);
		a.enqueueVehicle(Road.RIGHT);
		a.enqueueVehicle(Road.RIGHT);
		a.enqueueVehicle(Road.RIGHT);	
		a.enqueueVehicle(Road.RIGHT);
		a.enqueueVehicle(Road.RIGHT);
		a.enqueueVehicle(Road.RIGHT);
		a.advanceTime();
//		System.out.println(a.getIntersectionState());
		if(a.isorange == true) {
		assertTrue(a.getIntersectionState().contains("RVg7"));
		}
		if(a.isTimed == true) {
			assertTrue(a.getIntersectionState().contains("RVg7"));
		}
		if(a.onrequest == false) {
			assertTrue(a.getIntersectionState().contains("RVg7"));
		}
		if(a.ped == false) {
			assertTrue(a.getIntersectionState().contains("RVg7"));
		}
	}
}