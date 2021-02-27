package class10_graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @version 1.0
 * @program: dataStructure
 * @description:
 * @author: bifenglin
 * @create: 2021-02-22 15:19
 */
public class code02_BFS {

    public void BFS(Node node) {
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node n : cur.nexts) {
                if (!set.contains(n)) {
                    queue.add(n);
                    set.add(n);
                }
            }
        }
    }

}
