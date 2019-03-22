package graph;

/**
 * A weighted edge.
 * 
 * @author aidenkeating
 * 
 */
public interface Edge<N extends Node<N, E>, E extends Edge<N, E>> {
	/**
	 * Get the weight of the edge.
	 * 
	 * @return The weight of the edge.
	 */
	double weight();

	N from();

	N to();
}
