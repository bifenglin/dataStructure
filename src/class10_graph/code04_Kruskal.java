package class10_graph;

import java.util.*;

/**
 * @version 1.0
 * @program: dataStructure
 * @description:
 * @author: bifenglin
 * @create: 2021-02-22 17:50
 */
public class code04_Kruskal {
    public class Node {
        public int value;
        public int in;
        public int to;
        public ArrayList<Node> nexts;
        public ArrayList<Edge> edges;
    }

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

    public class Graph {
        public HashMap<Integer, Node> nodes;
        public HashSet<Edge> edges;
    }

    public static class UnionFind {
        public HashMap<Integer, Node> nodes;
        public HashMap<Node, Node> parents;
        public HashMap<Node, Integer> sizeMaps;

        public UnionFind(Collection<Node> nodes) {
            parents.clear();
            sizeMaps.clear();
            for (Node node : nodes) {
                parents.put(node, node);
                sizeMaps.put(node, 1);
            }
        }

        public Node findFather(Node node) {
            Stack<Node> stack = new Stack<>();
            while (parents.get(node) != node) {
                stack.push(node);
                node = parents.get(node);
            }
            while (!stack.isEmpty()) {
                parents.put(stack.pop(), node);
            }
            return node;
        }

        public boolean isSameSet(Node a, Node b) {
            return findFather(a) == findFather(b);
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }

            Node aHead = findFather(a);
            Node bHead = findFather(b);
            if (aHead != bHead) {
                if (sizeMaps.get(aHead) >= sizeMaps.get(bHead)) {
                    parents.put(bHead, aHead);
                    sizeMaps.put(aHead, sizeMaps.get(aHead) + sizeMaps.get(bHead));
                    sizeMaps.remove(bHead);
                } else {
                    parents.put(aHead, bHead);
                    sizeMaps.put(bHead, sizeMaps.get(aHead) + sizeMaps.get(bHead));
                    sizeMaps.remove(aHead);
                }
            }
        }
    }

    public static void kruskal(Graph graph) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        UnionFind unionFind = new UnionFind(graph.nodes.values());
        HashSet<Edge> result = new HashSet<>();
        priorityQueue.addAll(graph.edges);
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if (!unionFind.isSameSet(edge.from, edge.to)) {
                result.add(edge);
                unionFind.union(edge.from, edge.to);
            }
        }
    }
}
