package class10_graph;

import java.util.*;

/**
 * @version 1.0
 * @program: dataStructure
 * @description:
 * @author: bifenglin
 * @create: 2021-02-22 17:23
 */
public class code03_sortedTopology {

    public List<Node> sortedTopolpgy(Graph graph){
        HashMap<Node, Integer> inMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        for (Node n :
                graph.nodes.values()) {
            if (n.in == 0) {
                queue.add(n);
            }
        }

        List<Node> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            result.add(node);
            for (Node cur :
                    node.nexts) {
                inMap.put(cur, inMap.get(cur) - 1);
                if (inMap.get(cur) == 0) {
                    queue.add(cur);
                }
            }
        }
        return result;
    }
}
