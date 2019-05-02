package graph;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class contains the abstract methods used in the various other classes of
 * this project. It contains the information on a singular edge of a graph and
 * extends the node and edge interfaces.
 * 
 * @author Hubert Stefanski
 *
 * @param <N>
 * @param <E>
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class AbstractEdge<N extends Node<N, E>, E extends Edge<N, E>> implements Edge<N, E> {

	@XmlIDREF
	@XmlElement(name = "nodeFrom", required = true)
	private N from;
	@XmlIDREF
	@XmlElement(name = "nodeTo", required = true)
	private N to;
	private double weight, safety, distance;

	public AbstractEdge() {

	}

	public AbstractEdge(N from, N to, double weight, double safety, double distance) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
		this.safety = safety;
		this.distance = distance;
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
	public double weight() {
		return this.weight;
	}

	@Override
	public double safety() {
		return this.safety;
	}

	@Override
	public double distance() {
		return this.distance;
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

	public double getWeight() {
		return weight;
	}

	public double getSafety() {
		return safety;
	}

	public double getDistance() {
		return distance;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setSafety(double safety) {
		this.safety = safety;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
	}
}
