package dynamic;

/**
 * @version 1.0
 * @program: dataStructure
 * @description: 边结构
 * @author: bifenglin
 * @create: 2020-11-15 11:37
 */
public class Edge {
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
