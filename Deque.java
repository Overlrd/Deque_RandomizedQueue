import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
  private int n;
  private Node first, last;

  private class Node {
    private Item item;
    private Node next;
    private Node previous;
  }

  public Deque() {
    first = null;
    last = null;
    n = 0;
  }

  public boolean isEmpty() {
    return n == 0;
  }

  public int size() {
    return n;
  }

  public void addFirst(Item item) {
    if (item == null) {
      throw new IllegalArgumentException("Item is null");
    }
    Node oldFirst = first;
    first = new Node();
    first.item = item;
    first.next = oldFirst;
    first.previous = null;

    if (isEmpty()) {
      last = first;
    } else {
      oldFirst.previous = first;
    }
    n++;
  }

  public void addLast(Item item) {
    if (item == null) {
      throw new IllegalArgumentException("Item is null");
    }
    Node oldLast = last;
    last = new Node();
    last.item = item;
    last.next = null;
    last.previous = oldLast;

    if (isEmpty()) {
      first = last;
    } else {
      oldLast.next = last;
    }
    n++;
  }

  public Item removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException("Deque is empty");
    }
    Item item = first.item;
    first = first.next;
    if (first == null) {
      last = null;
    } else {
      first.previous = null;
    }
    n--;
    return item;
  }

  public Item removeLast() {
    if (isEmpty()) {
      throw new NoSuchElementException("Deque is empty");
    }
    Item item = last.item;
    last = last.previous;

    if (last == null) {
      first = null;
    } else {
      last.next = null;
    }
    n--;
    return item;
  }

  public Iterator<Item> iterator() {
    return new DequeIterator();
  }

  private class DequeIterator implements Iterator<Item> {
    private Node curr = first;

    public boolean hasNext() {
      return curr != null;
    }

    public void remove() {
      throw new UnsupportedOperationException("Iterator.Remove not supported for Deque");
    }

    public Item next() {
      if (!hasNext()) {
        throw new NoSuchElementException("Iterator is empty");
      }
      Item item = curr.item;
      curr = curr.next;
      return item;
    }
  }

  public static void main(String[] args) {
    Deque<Integer> deque = new Deque<>();
    System.out.println(deque.isEmpty());
    deque.addFirst(2);
    System.out.println(deque.removeLast());
    deque.addFirst(4);
    deque.addLast(5);
    System.out.println(deque.removeLast());
    deque.addFirst(7);
    for (Integer i : deque) {
      System.out.println(i);
    }
    System.out.println(deque.size());
    System.out.println(deque.removeLast());
    System.out.println(deque.removeFirst());
    System.out.println(deque.isEmpty());
    assert deque.size() == 0 : "Size should be 0";
  }
}
