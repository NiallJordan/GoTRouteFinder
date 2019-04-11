package graph;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class AbstractGraph<N extends Node<N, E>, E extends Edge<N, E>> implements Graph<N, E> {
	@XmlElementWrapper(name = "graphNodes")
	@XmlElement(name = "graphNode",required = true)
	private List<N> nodes;
	
	

	public AbstractGraph() {
		this.nodes = new ArrayList<N>();
	}
	
	public AbstractGraph(List<N> nodes) {
		this.nodes = nodes;
	}

	public List<N> getNodes() {
		return nodes;
	}
	
	public void setNodes(final List<N> nodes) {
		this.nodes = nodes;
	}

	public void addNode(final N node) {
		this.nodes.add(node);
	}

	@Override
	public String toString() {
		return "Graph [nodes=" + nodes + "]" ;
	}
}
