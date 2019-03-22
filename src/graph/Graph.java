package graph;

import java.util.List;

/**
 * A graph of connected nodes.
 * 
 * @author aidenkeating
 *
 */
public interface Graph<N extends Node<N, E>, E extends Edge<N, E>> {

	/**
	 * Get the nodes in the graph.
	 * 
	 * @return A list of nodes in the graph.
	 */
	List<N> getNodes();
}
