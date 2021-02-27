package class10_graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @version 1.0
 * @program: dataStructure
 * @description:
 * @author: bifenglin
 * @create: 2021-02-23 14:33
 */
public class code05_Prim {

    public Set<Edge> prime(Graph graph) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight-o2.weight;
            }
        });

        HashSet<Edge> result = new HashSet<>();
        HashSet<Node> nodeSet = new HashSet<>();
        for (Node n : graph.nodes.values()) {
            if (!nodeSet.contains(n)) {
                nodeSet.add(n);
                priorityQueue.addAll(n.edges);
                while (!priorityQueue.isEmpty()) {
                    Edge edge = priorityQueue.poll();
                    Node toNode = edge.to;
                    if (!nodeSet.contains(toNode)) {

                    }
                }
            }
        }
        return result;
    }
}
