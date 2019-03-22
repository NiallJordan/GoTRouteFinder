package graphanalysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import graph.Edge;
import graph.Graph;
import graph.Node;

public class DijkstraGraphAnalyzer<N extends Node<N, E>, E extends Edge<N, E>> implements GraphAnalyzer<N, E> {

	private final Graph<N, E> graph;
	// Store the default node/distance mapping for efficiency.
	private final Map<N, Double> defaultNodeDistanceMapping;
	private final Map<N, N> defaultPreviousNodeMapping;

	public DijkstraGraphAnalyzer(final Graph<N, E> graph) {
		this.graph = graph;
		this.defaultNodeDistanceMapping = new HashMap<N, Double>();
		this.defaultPreviousNodeMapping = new HashMap<N, N>();
		for (final N n : this.graph.getNodes()) {
			this.defaultNodeDistanceMapping.put(n, Double.MAX_VALUE);
			this.defaultPreviousNodeMapping.put(n, null);
		}
	}

	@Override
	public List<N> shortestPathBetween(N from, N to) {
		final Map<N, Double> nodeDistanceMapping = buildNodeDistanceMapping(from);
		final Map<N, N> previousNodeMapping = new HashMap<N, N>(defaultPreviousNodeMapping);

		final Set<N> unsettled = new HashSet<N>();
		unsettled.add(from);

		final Set<N> settled = new HashSet<N>();

		while (unsettled.size() != 0) {
			final N currentNode = getLowestDistanceNode(unsettled, nodeDistanceMapping);
			final double currentDistance = nodeDistanceMapping.get(currentNode);
			unsettled.remove(currentNode);

			for (final E e : currentNode.getEdges()) {
				final double currentNeighorDistance = nodeDistanceMapping.get(e.to());
				final double newNeighborDistance = currentDistance + e.weight();
				if (!settled.contains(e.to()) && newNeighborDistance < currentNeighorDistance) {
					nodeDistanceMapping.put(e.to(), newNeighborDistance);
					previousNodeMapping.put(e.to(), currentNode);
					unsettled.add(e.to());
				}
			}
			settled.add(currentNode);
		}

		final List<N> path = new ArrayList<N>();
		for (N n = to; n != null; n = previousNodeMapping.get(n)) {
			path.add(n);
		}
		Collections.reverse(path);
		return path;
	}

	private N getLowestDistanceNode(final Set<N> unsettled, final Map<N, Double> distances) {
		final Iterator<N> iter = unsettled.iterator();
		if (!iter.hasNext()) {
			return null;
		}
		N selected = iter.next();
		while (iter.hasNext()) {
			final N n = iter.next();
			if (distances.get(n) < distances.get(selected)) {
				selected = n;
			}
		}
		return selected;
	}

	private Map<N, Double> buildNodeDistanceMapping(final N source) {
		final Map<N, Double> mappings = new HashMap<N, Double>(this.defaultNodeDistanceMapping);
		mappings.put(source, 0.00);
		return mappings;
	}
}
