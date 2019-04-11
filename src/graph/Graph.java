package graph;

import java.util.List;
import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public interface Graph<N extends Node<N, E>, E extends Edge<N, E>> {


	List<N> getNodes();
}
