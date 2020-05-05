package class5;

import javax.xml.soap.Node;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: dataStructure
 * @description:
 * @author: maple
 * @create: 2020-05-05 10:09
 **/
public class TrieTree {
    static class Node1 {
        char v;
        int pass = 0;
        int end = 0;
        Map<Character, Node1> next = new HashMap<>();

        public Node1() {
        }

        public Node1(char v) {
            this.v = v;
        }
    }

    static class TrieTree1{

        Node1 root = new Node1();

        public void insert(String s){
            if (s == null) {
                return;
            }
            char[] chars = s.toCharArray();
            Node1 cur = root;
            cur.pass++;
            for (int i = 0; i < chars.length; i++) {
                if (cur.next.get(chars[i]) == null){
                    cur.next.put(chars[i], new Node1(chars[i]));
                }
                cur = cur.next.get(chars[i]);
                cur.pass++;
            }
            cur.end++;

//            if (word == null) {
//                return;
//            }
//            char[] chs = word.toCharArray();
//            Node2 node = root;
//            node.pass++;
//            int index = 0;
//            for (int i = 0; i < chs.length; i++) {
//                index = (int) chs[i];
//                if (!node.nexts.containsKey(index)) {
//                    node.nexts.put(index, new Node2());
//                }
//                node = node.nexts.get(index);
//                node.pass++;
//            }
//            node.end++;
        }

        public void delete(String s){
            char[] chars = s.toCharArray();
            Node1 cur = root;
            if (search(s) == 0){
                return;
            }
            cur.pass--;
            for (int i = 0; i < chars.length; i++) {
                Node1 temp = cur.next.get(chars[i]);
                if (--temp.pass == 0){
                    cur.next.remove(chars[i]);
                    return;
                }
                cur = temp;
            }
            cur.end--;



//            if (search(s) != 0) {
//                char[] chs = s.toCharArray();
//                Node1 node = root;
//                node.pass--;
//                for (int i = 0; i < chs.length; i++) {
//                    if (--node.next.get(s.charAt(i)).pass == 0) {
//                        node.next.remove(s.charAt(i));
//                        return;
//                    }
//                    node = node.next.get(s.charAt(i));
//                }
//                node.end--;
//            }
        }
        // word这个单词之前加入过几次
        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] chs = word.toCharArray();
            Node1 cur = root;
            for (int i = 0; i < chs.length; i++) {
                cur = cur.next.get(chs[i]);
                if (cur == null){
                    return 0;
                }
            }
            return cur.end;
        }
        // 所有加入的字符串中，有几个是以pre这个字符串作为前缀的
        public int prefixNumber(String pre) {
            if (pre == null){
                return 0;
            }
            char[] chars = pre.toCharArray();
            Node1 cur = root;
            for (int i = 0; i < chars.length; i++) {
                cur = cur.next.get(chars[i]);
                if (cur == null){
                    return 0;
                }
            }
            return cur.pass;
        }
    }

    public static class Right {

        private HashMap<String, Integer> box;

        public Right() {
            box = new HashMap<>();
        }

        public void insert(String word) {
            if (!box.containsKey(word)) {
                box.put(word, 1);
            } else {
                box.put(word, box.get(word) + 1);
            }
        }

        public void delete(String word) {
            if (box.containsKey(word)) {
                if (box.get(word) == 1) {
                    box.remove(word);
                } else {
                    box.put(word, box.get(word) - 1);
                }
            }
        }

        public int search(String word) {
            if (!box.containsKey(word)) {
                return 0;
            } else {
                return box.get(word);
            }
        }

        public int prefixNumber(String pre) {
            int count = 0;
            for (String cur : box.keySet()) {
                if (cur.startsWith(pre)) {
                    count += box.get(cur);
                }
            }
            return count;
        }
    }

    // for test
    public static String generateRandomString(int strLen) {
        char[] ans = new char[(int) (Math.random() * strLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            int value = (int) (Math.random() * 6);
            ans[i] = (char) (97 + value);
        }
        return String.valueOf(ans);
    }

    // for test
    public static String[] generateRandomStringArray(int arrLen, int strLen) {
        String[] ans = new String[(int) (Math.random() * arrLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = generateRandomString(strLen);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arrLen = 100;
        int strLen = 20;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            String[] arr = generateRandomStringArray(arrLen, strLen);
            TrieTree1 trie1 = new TrieTree1();
            Right right = new Right();
            for (int j = 0; j < arr.length; j++) {
                double decide = Math.random();
                if (decide < 0.25) {
                    trie1.insert(arr[j]);
//                    trie2.insert(arr[j]);
                    right.insert(arr[j]);
                } else if (decide < 0.5) {
                    trie1.delete(arr[j]);
//                    trie2.delete(arr[j]);
                    right.delete(arr[j]);
                } else if (decide < 0.75) {
                    int ans1 = trie1.search(arr[j]);
//                    int ans2 = trie2.search(arr[j]);
                    int ans3 = right.search(arr[j]);
                    if (ans1 != ans3) {
                        System.out.println(ans1 + " search--- "+ ans3);

//                    if (ans1 != ans2 || ans2 != ans3) {
                        System.out.println("Oops!");
                    }
                } else {
                    int ans1 = trie1.prefixNumber(arr[j]);
//                    int ans2 = trie2.prefixNumber(arr[j]);
                    int ans3 = right.prefixNumber(arr[j]);
                    if (ans1 != ans3) {
                        System.out.println(ans1 + " --- "+ ans3);
//                    if (ans1 != ans2 || ans2 != ans3) {
                        System.out.println("Oops!");
                    }
                }
            }
        }
        System.out.println("finish!");

    }

}
