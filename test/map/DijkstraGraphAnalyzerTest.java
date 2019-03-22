package map;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import graph.Graph;
import graphanalysis.DijkstraGraphAnalyzer;
import graphanalysis.GraphAnalyzer;

class DijkstraGraphAnalyzerTest {
	private List<MapLocation> testNodes;
	private Graph<MapLocation, MapPath> testGraph;
	private GraphAnalyzer<MapLocation, MapPath> testGraphAnalyzer;

	@BeforeEach
	void setup() {
		testNodes = new ArrayList<MapLocation>();
		for (int i = 0; i < 5; i++) {
			testNodes.add(new MapLocation(Integer.toString(i), 10, 10));
		}
		// Node 0's neighbors.
		testNodes.get(0).addBidirectionalPath(testNodes.get(1), 1);
		testNodes.get(0).addBidirectionalPath(testNodes.get(2), 6);

		// Node 1's neighbors.
		testNodes.get(1).addBidirectionalPath(testNodes.get(2), 2);
		testNodes.get(1).addBidirectionalPath(testNodes.get(3), 1);

		// Node 2's neighbors.
		testNodes.get(2).addBidirectionalPath(testNodes.get(3), 2);
		testNodes.get(2).addBidirectionalPath(testNodes.get(4), 5);

		// Node 3's neighbors.
		testNodes.get(3).addBidirectionalPath(testNodes.get(4), 5);

		testGraph = new MapGraph(testNodes);
		testGraphAnalyzer = new DijkstraGraphAnalyzer<MapLocation, MapPath>(testGraph);
	}

	@Test
	void testShortestPathBetween_long() {
		final List<MapLocation> path = testGraphAnalyzer.shortestPathBetween(testNodes.get(0), testNodes.get(4));
		assertEquals(4, path.size());
	}

	@Test
	void testShortestPathBetween_short() {
		testNodes.get(0).addBidirectionalPath(testNodes.get(4), 4);
		final List<MapLocation> path = testGraphAnalyzer.shortestPathBetween(testNodes.get(0), testNodes.get(4));
		assertEquals(2, path.size());
	}

	@Test
	void testShortestPathBetween_unidirectional() {
		testNodes.get(0).addUnidirectionalPath(testNodes.get(4), 4);
		final List<MapLocation> path = testGraphAnalyzer.shortestPathBetween(testNodes.get(0), testNodes.get(4));
		assertEquals(2, path.size());
	}

	@Test
	void testShortestPathBetween_unidirectionalSkip() {
		testNodes.get(4).addUnidirectionalPath(testNodes.get(0), 4);
		final List<MapLocation> path = testGraphAnalyzer.shortestPathBetween(testNodes.get(0), testNodes.get(4));
		assertEquals(4, path.size());
	}

}
