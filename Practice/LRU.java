package Practice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;

public class LRU {

    private Deque<Integer> deque;
    private HashSet<Integer> hashSet;

    private final int CACHE_SIZE;


    public LRU(int cap) {
        CACHE_SIZE = cap;
        deque = new ArrayDeque<>();
        hashSet = new HashSet<>();
    }

    public void refer(int page){
        if(hashSet.contains(page)){
            deque.remove(page);
        }else{
            if(deque.size()==CACHE_SIZE){
                int val = deque.removeLast();
                hashSet.remove(val);
            }
        }
        deque.addFirst(page);
        hashSet.add(page);
    }

    public void display() {
        Iterator<Integer> itr = deque.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }


    public static void main(String[] args) {

        LRU cache = new LRU(4);
        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(1);
        cache.refer(4);
        cache.refer(5);
        cache.refer(2);
        cache.refer(2);
        cache.refer(1);
        cache.display();
    }
}
