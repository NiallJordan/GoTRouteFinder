package graph;


public interface Edge<N extends Node<N, E>, E extends Edge<N, E>> {

	double weight();

	N from();

	N to();
}
