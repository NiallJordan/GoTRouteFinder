package map;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MapPointTest {

	@Test
	void testConstructor() {
		String to = "nodeOne";
		int xCoord = 545;
		int yCoord = 1230;
		MapPoint mp = new MapPoint(to, xCoord, yCoord);
		assertEquals(to, mp.getName());
		assertEquals(0, mp.getEdges().size());
	}
	
	@Test 
	void testAddUnidirectionalPath() {
		String to = "nodeOne";
		String from = "nodeTwo";
		double testWeight = 4.0;
		double testSafety = 3.0;
		double testDistance = 273.5634;
		
		MapPoint mp1 = new MapPoint(to);
		MapPoint mp2 = new MapPoint(from);
		
		mp1.addUnidirectionalPath(mp2, testWeight, testSafety, testDistance);
		assertEquals(1, mp1.getEdges().size());
		assertEquals(1, mp1.getNeighbors().size());
		assertEquals(testWeight, mp1.getEdges().get(0).getWeight());
		assertEquals(from, mp1.getNeighbors().get(0).getName());
		
	}
	
	@Test 
	void testAddBidirectionalPath() {
		String to = "nodeOne";
		String from = "nodeTwo";
		double testWeight = 4.0;
		double testSafety = 3.0;
		double testDistance = 273.5634;
		
		MapPoint mp1 = new MapPoint(to);
		MapPoint mp2 = new MapPoint(from);
		
		mp1.addBidirectionalPath(mp2, testWeight, testSafety, testDistance);
		assertEquals(1, mp1.getEdges().size());
		assertEquals(1, mp1.getNeighbors().size());
		assertEquals(1, mp2.getEdges().size());
		assertEquals(1, mp2.getNeighbors().size());
		
	}
	
	
	
}
