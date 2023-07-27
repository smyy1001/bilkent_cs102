import java.util.Set;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class collectionsExamples {
    public static void main(String[] args) {
        
        Set<String> hash = new HashSet<>();
        Set<Integer> tree = new TreeSet<>();
        
        // hashSet
        hash.add("Walter");
        hash.add("Jesse");
        hash.add("Skyler");
        hash.add("Mike");
        hash.add("Saul");
        hash.forEach(System.out::println);
        
        // treeSet
        tree.add(5);
        tree.add(5);
        tree.add(8);
        tree.add(-5);
        tree.add(2);
        tree.add(0);
        tree.add(79);
        tree.forEach(System.out::println);

        Map<String, Integer> hashMap = new HashMap<>();
        Map<Integer, String> treeMap = new TreeMap<>();

        // hashMap
        hashMap.put("bengi", 20);
        hashMap.put("bengi", 20);
        hashMap.put("sumeyye", 19);
        hashMap.put("gokce", 21);
        System.out.println(hashMap);

        // TreeMap
        treeMap.put(19, "sumeyye");
        treeMap.put(20,"bengi");
        treeMap.put(21, "gokce");
        System.out.println(treeMap);

        // Stack
        Stack<Integer> stack = new Stack<>(); // adding order matters!
        stack.add(3);
        stack.add(3);
        stack.add(0);
        stack.add(1);
        stack.add(2);

        System.out.println(stack);
        System.out.println(stack.pop()); // show and remove the top value
        System.out.println(stack);
        System.out.println(stack.peek()); // show the top value
        System.out.println(stack);
        System.out.println(stack.push(6)); // adds to the top
        System.out.println(stack);
        System.out.println(stack.search(Integer.valueOf("10")));
        System.out.println(stack);
        stack.add(0,Integer.valueOf(7));
        System.out.println(stack);

        // Queue
        Queue<Integer> queue = new LinkedList<>();
        queue.add(5);
        queue.add(5);
        queue.add(6);
        queue.add(4);
        queue.add(3);

        System.out.println(queue);
        System.out.println(queue.offer(2));
        System.out.println(queue);
        System.out.println(queue.poll()); // shows and removes the first element
        System.out.println(queue);
        System.out.println(queue.peek()); // shows the first element
        System.out.println(queue);
        System.out.println(queue.offer(1));
        System.out.println(queue);
        System.out.println(queue.peek()); // peek doesn't change here!
        System.out.println(queue);
        System.out.println(queue.remove()); // just like poll()
        System.out.println(queue);
        System.out.println(queue.remove(4)); // not the index, the element
        System.out.println(queue);

        // Linked List and Iterator
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        Iterator<Integer> iterator = linkedList.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
