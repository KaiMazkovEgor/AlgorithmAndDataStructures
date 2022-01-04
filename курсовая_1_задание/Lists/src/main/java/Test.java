import java.util.*;

public class Test {
    public static void main(String[] args) throws IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<>();
        Lists my_lists = new Lists();

        list.add(3);
        list.add(2);
        list.add(21);
        list.add(22);
        list.add(23);
        list.add(27);
        list.add(28);

        my_lists.add(3);
        my_lists.add(2);
        my_lists.add(211);
        my_lists.add(21);

        my_lists.retainAll(list);
//        my_lists.removeAll(list);
        System.out.println(my_lists);
    }
}
