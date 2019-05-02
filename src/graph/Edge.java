package graph;

import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public interface Edge<N extends Node<N, E>, E extends Edge<N, E>> {

	double weight();

	double safety();

	double distance();

	N from();

	N to();
}
