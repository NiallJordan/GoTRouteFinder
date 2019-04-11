package graph;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class AbstractEdge<N extends Node<N, E>, E extends Edge<N, E>> implements Edge<N, E> {

	@XmlIDREF
	@XmlElement(name = "nodeFrom", required = true)
	private N from;
	@XmlIDREF
	@XmlElement(name = "nodeTo", required = true)
	private N to;
	private double weight;

	public AbstractEdge() {

	}

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

	public N getFrom() {
		return from;
	}

	public void setFrom(N from) {
		this.from = from;
	}

	public N getTo() {
		return to;
	}

	public void setTo(N to) {
		this.to = to;
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
