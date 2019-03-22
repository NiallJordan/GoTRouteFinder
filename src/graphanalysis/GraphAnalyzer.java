package graphanalysis;

import java.util.List;

import graph.Edge;
import graph.Node;

public interface GraphAnalyzer<N extends Node<N, E>, E extends Edge<N, E>> {
	List<N> shortestPathBetween(N from, N to);
}
