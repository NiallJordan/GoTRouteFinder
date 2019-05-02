package map;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MapGraphTest {

	private List<MapPoint> testMapPoints;
	
	@BeforeEach
	void setUp() {
		testMapPoints = new ArrayList<MapPoint>();
		for(int i = 0; i < 10; i++) {
			testMapPoints.add(new MapPoint(Integer.toString(i)));
		}
	}
	
	@Test
	void testConstructor() {
		MapGraph testMapGraph = new MapGraph(testMapPoints);
		assertEquals(10, testMapGraph.getNodes().size());
	}
}
