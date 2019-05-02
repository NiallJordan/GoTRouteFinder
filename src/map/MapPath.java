package map;

import graph.Edge;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import graph.AbstractEdge;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MapPath extends AbstractEdge<MapPoint, MapPath> implements Edge<MapPoint, MapPath> {

	@Override
	public String toString() {
		return "MapPath [from()=" + from() + ", getFrom()=" + getFrom() + ", getTo()="
				+ getTo() + ", to()=" + to() + ", weight()=" + weight() + ", safety()="+ safety() + ", distance()=" +distance() + "]";
	}

	public MapPath() {
		super();
	}

	public MapPath(MapPoint from, MapPoint to, double weight, double safety, double distance) {
		super(from, to, weight, safety, distance);
	}
}
