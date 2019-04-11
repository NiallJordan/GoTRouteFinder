package map;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import graph.Graph;
import graph.AbstractGraph;

@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
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
