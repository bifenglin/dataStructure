package class7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: dataStructure
 * @description:
 * @author: maple
 * @create: 2020-05-19 18:14
 **/
public class LevelTraversalBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static void level(Node head) {
        Queue<Node> queue = new LinkedList();
        Node cur = head;
        queue.add(cur);
        while (!queue.isEmpty()){
            cur = queue.poll();
            System.out.print(cur.value);
            if (cur.left!=null){
                queue.add(cur.left);
            }
            if (cur.right != null){
                queue.add(cur.right);
            }
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        level(head);
        System.out.println("========");
    }
}
