package class10_graph;

import java.util.ArrayList;

/**
 * @version 1.0
 * @program: dataStructure
 * @description:
 * @author: bifenglin
 * @create: 2021-02-22 09:31
 */
public class Node {
    int value;
    int in;
    int out;
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }

}
