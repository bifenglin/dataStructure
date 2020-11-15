package dynamic;

import java.util.ArrayList;

/**
 * @version 1.0
 * @program: dataStructure
 * @description: 点结构
 * @author: bifenglin
 * @create: 2020-11-15 11:36
 */
public class Node {
    public int value;
    public int in;
    public int out;
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
