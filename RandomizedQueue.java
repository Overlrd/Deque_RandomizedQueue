import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int n;
    private Item[] items;
    private final int INITIAL_ARRAY_SIZE = 20;

    public RandomizedQueue() {
        items = (Item[]) new Object[INITIAL_ARRAY_SIZE];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item is null");
        }
        items[n++] = item;
        if (n > 0 && n == items.length) {
            resize(items.length * 2);
        }
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Randomized Array is empty");
        }
        int idx = StdRandom.uniformInt(n);
        Item randomItem = items[idx];
        items[idx] = items[--n];
        items[n] = null;
        if (n == items.length / 4) {
            resize(items.length / 2);
        }
        return randomItem;
    }

    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException("Randomized Array is empty");
        }
        int idx = StdRandom.uniformInt(n);
        return items[idx];
    }

    private void resize(int newSize) {
        Item[] copy = (Item[]) new Object[newSize];
        System.arraycopy(items, 0, copy, 0, n);
        items = copy;
    }

    public Iterator<Item> iterator() {
        return new RandomizedIterator();
    }

    private class RandomizedIterator implements Iterator<Item> {
        private final int curr = 0;

        public boolean hasNext() {
            return curr < n;
        }

        public void remove() {
            throw new UnsupportedOperationException("Iterator.remove operation is not supported for randomized array");
        }

        public Item next() {
            int idx = StdRandom.uniformInt(curr, n);
            Item item = items[idx];
            items[idx] = items[--n];
            items[n] = null;
            return item;
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(719);
        queue.enqueue(65);
        queue.enqueue(994);
        queue.enqueue(222);
        queue.enqueue(228);
        queue.enqueue(231);
        System.out.println(queue.size());
        for (Integer i : queue) {
            System.out.println(i);
        }
        queue.enqueue(999);
        queue.enqueue(1006);
        queue.enqueue(1012);
        System.out.println(queue.dequeue());
        System.out.println(queue.sample());
        for (Integer i : queue) {
            System.out.println(i);
        }
    }
}
