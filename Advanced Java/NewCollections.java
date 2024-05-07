
// import java.util.ArrayList;
// import java.util.Collection;
// import java.util.Collections;
import java.util.List;
import java.util.Collection;
import java.util.Collections;
// import java.util.HashMap;
import java.util.LinkedList;
// import java.util.Map;
// import java.util.Random;

public class NewCollections {
    public static void main(String[] args) {

        List<String> list = new LinkedList<>();

        list.add("What are you doing...");
        list.add("Shorter text");
        list.add("Shortest text");
        list.add("Not so short");

        System.out.println(list);
        for (int i = 0; i <= list.size(); i++) {
            try {
                System.out.print(list.get(i).length());
                if (!list.get(i + 1).isBlank())
                    System.out.print(", ");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("");
                break;
            }

        }

        Collections.sort(list);

        System.out.println(list);
        for (int i = 0; i <= list.size(); i++) {
            try {
                System.out.print(list.get(i).length());
                if (!list.get(i + 1).isBlank())
                    System.out.print(", ");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("");
                break;
            }

        }
    }
}

// for (String item : list) {
// System.out.print(item.length());
// if (!iterate.next().isEmpty())
// System.out.print(", ");
// }
// System.out.println("\n");

// Collections.sort(lis
// System.out.println(lis

// System.out.print(item.l

// System.out.print(", ");
// }

// List<Integer> nums = new LinkedLi
// Consumer<Integer> consumer

// Map<String, Integer> list = new HashM
// Map<String, Integer> list2 = new HashMap<>();

// // Linked list over an arraylist when manipu

// list.put("Hello", 1);

// list.put("Hello3", 3);

// list2.put("Hello0", 1
// list2.put("Hello2", 2)
// list2.put("Hello4", 3)

// evolve.putAll(list);
// evolve.putAll(list2);
// System.out.println(list

// List<Integer> arrayLi
// List<Integer> linkedlist

// arrayList.add(new Random().nextInt(10));
// linkedlist.add(new Random().nextInt(10));

// System.out.println(arrayList);
// System.out.println(linkedlist);

// Collections.sort(linkedlist);

// System.out.println(linkedlis
// arrayList.add(1);
// }
