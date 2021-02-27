package test1;

/**
 * @version 1.0
 * @program: dataStructure
 * @description:
 * @author: bifenglin
 * @create: 2021-02-27 17:25
 */
import java.util.*;

public class FenJieYinShu {

        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            Integer left = s.nextInt();
            Integer right = s.nextInt();
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            for(int i = 2; i <= right; i++) {
                boolean flag = false;
                for (int j = 2; j < i; j++) {
                    if ( i % j == 0) {
                        if (map.containsKey(i / j)) {
                            flag = true;
                            ArrayList<Integer> list = new ArrayList<>();
                            list.add(j);
                            list.addAll(map.get(i / j));
                            map.put(i, list);
                        } else {
                            flag = true;
                            ArrayList<Integer> list = new ArrayList<>();
                            list.add(i / j);
                            list.add(j);
                            map.put(i, list);
                        }
                        break;
                    }
                }
                if (!flag) {
                    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(i));
                    map.put(i, list);
                }
            }
            for (int i = left; i <= right; i++) {
                StringBuffer sb = new StringBuffer();
                sb.append(i).append("=");
                for (Integer temp :map.get(i)) {
                    sb.append(temp).append("*");
                }
                System.out.println(sb.substring(0, sb.length() - 1));
            }
        }
}
