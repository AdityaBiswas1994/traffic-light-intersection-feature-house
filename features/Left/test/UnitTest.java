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
		public void TestForLeftPedestrian() {
				a.enqueuePedestrian(Road.LEFT);
				a.enqueuePedestrian(Road.LEFT);
				a.advanceTime();
//				System.out.println(a.getIntersectionState());
				if(a.ped == false) {
					assertTrue(a.getIntersectionState().contains("LVg0"));
				}
				if(a.ped == true) {
					assertTrue(a.getIntersectionState().contains("LVg0Pr2"));
				}
			  }

		
		
		@Test
		void forLeftOrangeLight() {
			a.enqueueVehicle(Road.LEFT);
			a.enqueueVehicle(Road.LEFT);
			a.advanceTime();
//			System.out.println(a.getIntersectionState());
			if(a.isorange == true) {
				assertTrue(a.getIntersectionState().contains("LVg1"));
			}
			
		}

		
		
		@Test
		void TestForLeftVehicle(){
				a.enqueueVehicle(Road.LEFT);
				a.enqueueVehicle(Road.LEFT);
				a.advanceTime();
//				System.out.println(a.getIntersectionState());
				if(a.isTimed == true) {
					assertTrue(a.getIntersectionState().contains("LVg1"));
				}
				if(a.onrequest == true) {
					assertTrue(a.getIntersectionState().contains("LVg1"));
				}
			}

		
		
		
		@Test
		void checkleft1() {
		a.enqueueVehicle(Road.LEFT);
		a.enqueueVehicle(Road.LEFT);
		a.advanceTime();
//		System.out.println(a.getIntersectionState());
		if(a.isorange == false) {
			assertTrue(a.getIntersectionState().contains("LVg1"));
			}
		if(a.isTimed == true) {
			assertTrue(a.getIntersectionState().contains("LVg1"));
		}
		if(a.onrequest == false) {
			assertTrue(a.getIntersectionState().contains("LVg1"));
		}
		if(a.ped == false) {
			assertTrue(a.getIntersectionState().contains("LVg1"));
		}
		
	}

		
		
		@Test
		void checkleft2() {
			a.enqueueVehicle(Road.LEFT);
			a.enqueueVehicle(Road.LEFT);
			a.advanceTime();
//			System.out.println(a.getIntersectionState());
			if(a.isorange == false) {
				assertTrue(a.getIntersectionState().contains("LVg1"));
				}
			if(a.isTimed == false) {
				assertTrue(a.getIntersectionState().contains("LVg1"));
			}
			if(a.onrequest == true) {
				assertTrue(a.getIntersectionState().contains("LVg1"));
			}
			if(a.ped == false) {
				assertTrue(a.getIntersectionState().contains("LVg1"));
			}
		}

		
		
		@Test
		void checkleft3() {
			a.enqueueVehicle(Road.LEFT);
			a.enqueueVehicle(Road.LEFT);
			a.advanceTime();
//			System.out.println(a.getIntersectionState());
			if(a.isorange == true) {
				assertTrue(a.getIntersectionState().contains("LVg1"));
				}
			if(a.isTimed == false) {
				assertTrue(a.getIntersectionState().contains("LVg1"));
			}
			if(a.onrequest == true) {
				assertTrue(a.getIntersectionState().contains("LVg1"));
			}
			if(a.ped == false) {
				assertTrue(a.getIntersectionState().contains("LVg1"));
			}
		}

}