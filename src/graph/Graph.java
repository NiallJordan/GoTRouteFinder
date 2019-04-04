package graph;

import java.util.List;


public interface Graph<N extends Node<N, E>, E extends Edge<N, E>> {


	List<N> getNodes();
}
