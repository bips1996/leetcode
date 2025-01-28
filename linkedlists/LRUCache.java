package linkedlists;

import java.util.HashMap;
import java.util.LinkedList;

class LRU {
    HashMap<Integer, Integer> map;
    LinkedList<Integer> list;
    int capacity;

    public LRU(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        list = new LinkedList<>();
    }


    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int value = map.get(key);
        list.remove(key);
        list.addFirst(key);
        return value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            list.remove(key);
            map.put(key, value);
            list.addFirst(key);
            return;
        }

        map.put(key, value);
        list.addFirst(key);

        if (map.size() > capacity) {
            map.remove(list.removeFirst());
            list.removeLast();
        }
    }
}

public class LRUCache {
    public static void main(String[] args) {
        LRU cache = new LRU(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }
}
