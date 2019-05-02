package map;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
class MapPathTest {

	@Test
	void testConsructor() {
		String from = "nodeOne";
		String to = "nodeTwo";
		MapPoint mp1 = new MapPoint(from);
		MapPoint mp2 = new MapPoint(to);
		double testWeight = 4.0;
		double testSafety = 2.0;
		double testDistance = 487.9231;
		
		MapPath testMapPath = new MapPath(mp1,mp2,testWeight,testSafety,testDistance);
		
		assertEquals(from, testMapPath.getFrom().getName());
		assertEquals(to, testMapPath.getTo().getName());
		assertEquals(testWeight, testMapPath.getWeight());
		assertEquals(testSafety, testMapPath.getSafety());
		assertEquals(testDistance, testMapPath.getDistance());
		
	}
}
