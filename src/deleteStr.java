import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @program: dataStructure
 * @description:
 * @author: maple
 * @create: 2020-05-19 11:48
 **/
public class deleteStr {
    public static char[] getResult(char[] input) {
        char index;
        int i = 0;
        while (i < input.length) {
            index = input[i];
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] == index){
                    input[j] = '\0';
                }
            }
            i++;
        }
        return input;
    }

    public static void main(String[] args) {
        char[] input = new char[]{'a', 'a', 'a', 'c', 'b'};
        getResult(input);
        for (int i = 0; i < input.length; i++) {
            if (input[i] != '\0'){
                System.out.print(input[i] + ",");
            }
        }
    }
}
