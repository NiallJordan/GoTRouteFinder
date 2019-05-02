package map;

import graph.Node;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import graph.AbstractNode;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MapPoint extends AbstractNode<MapPoint, MapPath> implements Node<MapPoint, MapPath> {
	private int xCoord;
	private int yCoord;

	public MapPoint() {
		super();
	}

	public MapPoint(final String name, final int xCoord, final int yCoord) {
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

	public void addUnidirectionalPath(final MapPoint to, final double distance) {
		this.getEdges().add(new MapPath(this, to, distance));
	}

	public void addBidirectionalPath(final MapPoint to, final double distance) {
		addUnidirectionalPath(to, distance);
		to.addUnidirectionalPath(this, distance);
	}

	@Override
	public String toString() {
		return " \n MapPoint [ Name=" + super.getName() + " xCoord=" + xCoord + ", yCoord=" + yCoord + "]";
	}

}
