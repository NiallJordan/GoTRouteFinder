package map;

import graph.Edge;

import graph.AbstractEdge;

public class MapPath extends AbstractEdge<MapPoint, MapPath> implements Edge<MapPoint, MapPath> {

	public MapPath(MapPoint from, MapPoint to, double weight) {
		super(from, to, weight);
	}
}
