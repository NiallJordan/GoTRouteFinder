package map;

import graph.Node;

import graph.AbstractNode;

public class MapLocation extends AbstractNode<MapLocation, MapPath> implements Node<MapLocation, MapPath> {
	private int xCoord;
	private int yCoord;
	
	public MapLocation(final String name, final int xCoord, final int yCoord) {
		super(name);
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}
	
	public int getxCoord() {
		return xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void addUnidirectionalPath(final MapLocation to, final double distance) {
		this.getEdges().add(new MapPath(this, to, distance));
	}
	
	public void addBidirectionalPath(final MapLocation to, final double distance) {
		addUnidirectionalPath(to, distance);
		to.addUnidirectionalPath(this, distance);
	}
}
