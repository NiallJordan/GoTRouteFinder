package graph;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class AbstractNode<N extends Node<N, E>, E extends Edge<N, E>> implements Node<N, E> {

	@XmlID
	@XmlAttribute
	private String name;
	@XmlElementWrapper(name = "nodeEdges")
	@XmlElement(name = "nodeEdge", required = true)
	private List<E> edges;

	public AbstractNode() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEdges(List<E> edges) {
		this.edges = edges;
	}

	public AbstractNode(final String name) {
		this.name = name;
		this.edges = new ArrayList<E>();
	}

	@Override
	public List<N> getNeighbors() {
		final List<N> neighbors = new ArrayList<N>();
		for (final E e : this.edges) {
			neighbors.add(e.to());
		}
		return neighbors;
	}

	@Override
	public List<E> getEdges() {
		return this.edges;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		return this.name.equals(o);
	}

	@Override
	public String toString() {
		return "Node [name=" + name + "]";
	}
}
