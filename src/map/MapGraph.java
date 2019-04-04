package map;

import java.util.List;

import graph.Graph;
import graph.AbstractGraph;

public class MapGraph extends AbstractGraph<MapPoint, MapPath> implements Graph<MapPoint, MapPath> {

	public MapGraph() {
		super();
	}
	
	public MapGraph(List<MapPoint> nodes) {
		super(nodes);
	}
	
	public List<MapPoint> getNodes() {
		return super.getNodes();
	}
}
