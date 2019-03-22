package map;

import graph.Edge;

import graph.AbstractEdge;

public class MapPath extends AbstractEdge<MapLocation, MapPath> implements Edge<MapLocation, MapPath> {

	public MapPath(MapLocation from, MapLocation to, double weight) {
		super(from, to, weight);
	}
}
