package map;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import graph.Graph;
import graphanalysis.DijkstraGraphAnalyzer;
import graphanalysis.GraphAnalyzer;
import map.MapGraph;
import map.MapPath;
import map.MapPoint;

class DijkstraGraphAnalyzerTest {
	private List<MapPoint> testNodes;
	private Graph<MapPoint, MapPath> testGraph;
	private GraphAnalyzer<MapPoint, MapPath> testGraphAnalyzer;

	@BeforeEach
	void setup() {
		testNodes = new ArrayList<MapPoint>();
		for (int i = 0; i < 5; i++) {
			testNodes.add(new MapPoint(Integer.toString(i), 10, 10));
		}
		// Node 0's neighbors.
		testNodes.get(0).addBidirectionalPath(testNodes.get(1), 1, 2, 4);
		testNodes.get(0).addBidirectionalPath(testNodes.get(2), 6, 4, 5);

		// Node 1's neighbors.
		testNodes.get(1).addBidirectionalPath(testNodes.get(2), 2, 3, 4);
		testNodes.get(1).addBidirectionalPath(testNodes.get(3), 1, 6, 4);

		// Node 2's neighbors.
		testNodes.get(2).addBidirectionalPath(testNodes.get(3), 2, 7, 5);
		testNodes.get(2).addBidirectionalPath(testNodes.get(4), 5, 3, 6);

		// Node 3's neighbors.
		testNodes.get(3).addBidirectionalPath(testNodes.get(4), 5, 4, 5);

		testGraph = new MapGraph(testNodes);
		testGraphAnalyzer = new DijkstraGraphAnalyzer<MapPoint, MapPath>(testGraph);
	}

	@Test
	void testShortestPathBetween_long() {
		final List<MapPoint> path = testGraphAnalyzer.shortestPathBetween(testNodes.get(0), testNodes.get(4));
		assertEquals(4, path.size());
	}

	@Test
	void testShortestPathBetween_short() {
		testNodes.get(0).addBidirectionalPath(testNodes.get(4), 4, 2, 3);
		final List<MapPoint> path = testGraphAnalyzer.shortestPathBetween(testNodes.get(0), testNodes.get(4));
		assertEquals(2, path.size());
	}

	@Test
	void testShortestPathBetween_unidirectional() {
		testNodes.get(0).addUnidirectionalPath(testNodes.get(4), 4, 2, 3);
		final List<MapPoint> path = testGraphAnalyzer.shortestPathBetween(testNodes.get(0), testNodes.get(4));
		assertEquals(2, path.size());
	}

	@Test
	void testShortestPathBetween_unidirectionalSkip() {
		testNodes.get(4).addUnidirectionalPath(testNodes.get(0), 4, 2, 3);
		final List<MapPoint> path = testGraphAnalyzer.shortestPathBetween(testNodes.get(0), testNodes.get(4));
		assertEquals(4, path.size());
	}

}
