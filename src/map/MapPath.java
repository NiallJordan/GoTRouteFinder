package map;

import graph.Edge;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import graph.AbstractEdge;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MapPath extends AbstractEdge<MapPoint, MapPath> implements Edge<MapPoint, MapPath> {

	public MapPath() {
		super();
	}

	public MapPath(MapPoint from, MapPoint to, double weight) {
		super(from, to, weight);
	}
}
