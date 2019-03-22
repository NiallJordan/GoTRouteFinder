package graph;

public abstract class AbstractEdge<N extends Node<N, E>, E extends Edge<N, E>> implements Edge<N, E> {

	private final N from;
	private final N to;
	private final double weight;

	public AbstractEdge(final N from, final N to, final double weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public double weight() {
		return this.weight;
	}

	@Override
	public N from() {
		return this.from;
	}

	@Override
	public N to() {
		return this.to;
	}

	@Override
	public String toString() {
		return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
	}
}
