package class10_graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @version 1.0
 * @program: dataStructure
 * @description:
 * @author: bifenglin
 * @create: 2021-02-22 09:39
 */
public class code07_mergeUsers {

    public class User {
        public String a;
        public String b;
        public String c;
    }

    public class Node {
        User user;
        public Node(User user) {
            this.user = user;
        }
    }

    public class UnionSet {

        public HashMap<User, Node> nodes;
        public HashMap<Node, Node> parents;
        public HashMap<Node, Integer> sizeMap;

        public Node findFather(Node cur){
            Stack<Node> stack = new Stack<>();
            while (cur != parents.get(cur)) {
                stack.push(cur);
                cur = parents.get(cur);
            }

            while (!stack.isEmpty()) {
                parents.put(stack.pop(), cur);
            }
            return cur;
        }

        public boolean isSameSet(User a, User b) {
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return false;
            }
            return findFather(nodes.get(a)) == findFather(nodes.get(b));
        }

        public void union(User a, User b) {
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return;
            }
            Node aHead = findFather(nodes.get(a));
            Node bHead = findFather(nodes.get(b));
            if (aHead != bHead) {
                if (sizeMap.get(aHead) >= sizeMap.get(bHead)) {
                    parents.put(bHead, aHead);
                    sizeMap.put(aHead, sizeMap.get(aHead) + sizeMap.get(bHead));
                    sizeMap.remove(bHead);
                } else {
                    parents.put(bHead, aHead);
                    sizeMap.put(aHead, sizeMap.get(aHead) + sizeMap.get(bHead));
                    sizeMap.remove(aHead);
                }
            }
        }
    }

    public void mergeUsers(List<User> userList) {
        UnionSet unionSet = new UnionSet();
        HashMap<String, User> mapA = new HashMap<>();
        HashMap<String, User> mapB = new HashMap<>();
        HashMap<String, User> mapC = new HashMap<>();
        for (User user: userList) {
            if (mapA.containsKey(user.a)) {
                unionSet.union(user, mapA.get(user.a));
            } else {
                mapA.put(user.a, user);
            }
            if (mapB.containsKey(user.b)) {
                unionSet.union(user, mapB.get(user.b));
            } else {
                mapB.put(user.b, user);
            }
            if (mapC.containsKey(user.c)) {
                unionSet.union(user, mapC.get(user.c));
            } else {
                mapC.put(user.c, user);
            }
        }
    }
}
