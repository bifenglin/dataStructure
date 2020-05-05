package offer;

import java.util.Arrays;

/**
 * @program: dataStructure
 * @description:
 * @author: maple
 * @create: 2020-05-05 10:40
 * 题目描述
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 **/
public class replaceSpace {
    public static String replaceSpace(StringBuffer str) {
        int length = str.length();
        for (int i = 0; i < str.length(); i ++){
            if (str.charAt(i) == ' '){
                length+=2;
            }
        }
        char[] res = new char[length];
        int index = length - 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' '){
                res[index--] = '0';
                res[index--] = '2';
                res[index--] = '%';
            } else {
                res[index--] = str.charAt(i);
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("hello world");
        System.out.println(replaceSpace(stringBuffer));
    }
}
