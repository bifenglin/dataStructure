package class10_graph;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @version 1.0
 * @program: dataStructure
 * @description:
 * @author: bifenglin
 * @create: 2021-02-20 21:19
 */
public class code01_UnionFind {

    public static class Node<V> {
        V value;
        public Node(V v) {
            value = v;
        }
    }

    public static class UnionSet<V> {
        public HashMap<V, Node<V>> nodes;
        public HashMap<Node<V>, Node<V>> parents;
        public HashMap<Node<V>, Integer> sizes;

        public UnionSet(List<V> list) {
            for (V cur: list) {
                Node<V> node = new Node(cur);
                nodes.put(cur, node);
                parents.put(node, node);
                sizes.put(node, 1);
            }
        }

        public Node<V> findFather(Node<V> cur){
            Stack<Node<V>> stack = new Stack<>();
            while (cur != parents.get(cur)) {
                stack.push(cur);
                cur = parents.get(cur);
            }
            while (!stack.isEmpty()){
                parents.put(stack.pop(), cur);
            }
            return cur;
        }

        public boolean isSameSet(V v1, V v2){
            if (nodes.get(v1) == null || nodes.get(v2) == null) {
                return false;
            }
            return findFather(nodes.get(v1)) == findFather(nodes.get(v2));
        }

        public void union(V a, V b){
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return;
            }
            Node<V> aHead = findFather(nodes.get(a));
            Node<V> bHead = findFather(nodes.get(b));
            if (aHead != bHead) {
                int aSetSize = sizes.get(aHead);
                int bSetSize = sizes.get(bHead);
                if (aSetSize >= bSetSize) {
                    parents.put(bHead, aHead);
                    sizes.put(aHead, aSetSize + bSetSize);
                    sizes.remove(bHead);
                } else {
                    parents.put(aHead, bHead);
                    sizes.put(bHead, bSetSize + aSetSize);
                    sizes.remove(aHead);
                }
            }
        }
    }
}
