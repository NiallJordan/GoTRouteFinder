package map;

import java.util.List;

import graph.Graph;
import graph.AbstractGraph;

public class MapGraph extends AbstractGraph<MapLocation, MapPath> implements Graph<MapLocation, MapPath> {

	public MapGraph() {
		super();
	}
	
	public MapGraph(List<MapLocation> nodes) {
		super(nodes);
	}
	
	public List<MapLocation> getNodes() {
		return super.getNodes();
	}
}
