package graph;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractNode<N extends Node<N, E>, E extends Edge<N, E>> implements Node<N, E> {
	private final String name;
	private final List<E> edges;

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
