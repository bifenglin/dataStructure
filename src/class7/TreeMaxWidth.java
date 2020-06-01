package class7;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @program: dataStructure
 * @description:
 * @author: maple
 * @create: 2020-05-29 16:23
 **/
public class TreeMaxWidth {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int maxWidthUseMap(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Map<Node, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        int curLevel = 1;
        int curLevelNodes = 0;
        int max = 0;
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);
            if (cur.left != null){
                levelMap.put(cur.left, curNodeLevel + 1);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                levelMap.put(cur.right, curNodeLevel + 1);
                queue.add(cur.right);
            }
            if (curLevel == curNodeLevel) {
                curLevelNodes ++;
            } else {
                max = Math.max(curLevelNodes, max);
                curLevel++;
                curLevelNodes = 1;
            }
        }
        max = Math.max(curLevelNodes, max);
        return max;
    }

    public static int maxWidthNoMap(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList();
        queue.add(head);
        Node curEnd = head;
        Node nextEnd = null;
        int res = 0;
        int tempNodes = 0;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if (node.left != null){
                queue.add(node.left);
                nextEnd = node.left;
            }
            if (node.right != null){
                queue.add(node.right);
                nextEnd = node.right;
            }
            tempNodes ++;
            if (curEnd == node){
                res = Math.max(tempNodes, res);
                curEnd = nextEnd;
                tempNodes = 0;
            }
        }
        res = Math.max(tempNodes, res);
        return res;
    }

    // for test
    public static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    public static void main(String[] args) {
        int maxLevel = 10;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            int useMap = maxWidthUseMap(head);
            int noMap = maxWidthNoMap(head);

            if (useMap != noMap) {
                System.out.println("Oops!");
                System.out.printf("use Map + %s, no Map + %s", useMap, noMap);
            }
        }
        System.out.println("finish!");

    }
}
