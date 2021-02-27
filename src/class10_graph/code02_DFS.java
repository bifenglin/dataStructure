package class10_graph;

import java.util.HashSet;
import java.util.Stack;

/**
 * @version 1.0
 * @program: dataStructure
 * @description:
 * @author: bifenglin
 * @create: 2021-02-22 16:59
 */
public class code02_DFS {

    public void DFS(Node node) {
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.push(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node n :
                    cur.nexts) {
                stack.push(cur);
                stack.push(n);
                set.add(n);
                System.out.println(n.value);
                break;
            }
        }
    }
}
