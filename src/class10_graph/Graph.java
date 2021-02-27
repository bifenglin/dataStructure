package class10_graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @version 1.0
 * @program: dataStructure
 * @description:
 * @author: bifenglin
 * @create: 2021-02-22 09:31
 */
public class Graph {
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;
    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
