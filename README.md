Write a generic data type for a deque and a randomized queue. The goal of this assignment is to implement elementary data structures using arrays and linked lists, and to introduce you to generics and iterators.

**Dequeue.** A _double-ended queue_ or _deque_ (pronounced “deck”) is a generalization of a stack and a queue that supports adding and removing items from either the front or the back of the data structure. Create a generic data type `Deque` that implements the following API:

> ```
> public class Deque<Item> implements Iterable<Item> {
> 
>     
>     public Deque()
> 
>     
>     public boolean isEmpty()
> 
>     
>     public int size()
> 
>     
>     public void addFirst(Item item)
> 
>     
>     public void addLast(Item item)
> 
>     
>     public Item removeFirst()
> 
>     
>     public Item removeLast()
> 
>     
>     public Iterator<Item> iterator()
> 
>     
>     public static void main(String[] args)
> 
> }
> ```

_Corner cases._  Throw the specified exception for the following corner cases:

-   Throw an `IllegalArgumentException` if the client calls either `addFirst()` or `addLast()` with a `null` argument.
-   Throw a `java.util.NoSuchElementException` if the client calls either `removeFirst()` or `removeLast` when the deque is empty.
-   Throw a `java.util.NoSuchElementException` if the client calls the `next()` method in the iterator when there are no more items to return.
-   Throw an `UnsupportedOperationException` if the client calls the `remove()` method in the iterator.

_Unit testing._  Your `main()` method must call directly every public constructor and method to help verify that they work as prescribed (e.g., by printing results to standard output).

_Performance requirements._  Your deque implementation must support each deque operation (including construction) in _constant worst-case time_. A deque containing _n_ items must use at most 48_n_ + 192 bytes of memory. Additionally, your iterator implementation must support each operation (including construction) in _constant worst-case time_.

**Randomized queue.** A _randomized queue_ is similar to a stack or queue, except that the item removed is chosen uniformly at random among items in the data structure. Create a generic data type `RandomizedQueue` that implements the following API:

> ```
> public class RandomizedQueue<Item> implements Iterable<Item> {
> 
>     
>     public RandomizedQueue()
> 
>     
>     public boolean isEmpty()
> 
>     
>     public int size()
> 
>     
>     public void enqueue(Item item)
> 
>     
>     public Item dequeue()
> 
>     
>     public Item sample()
> 
>     
>     public Iterator<Item> iterator()
> 
>     
>     public static void main(String[] args)
> 
> }
> ```

_Iterator_.  Each iterator must return the items in uniformly random order. The order of two or more iterators to the same randomized queue must be _mutually independent_; each iterator must maintain its own random order.

_Corner cases._  Throw the specified exception for the following corner cases:

-   Throw an `IllegalArgumentException` if the client calls `enqueue()` with a `null` argument.
-   Throw a `java.util.NoSuchElementException` if the client calls either `sample()` or `dequeue()` when the randomized queue is empty.
-   Throw a `java.util.NoSuchElementException` if the client calls the `next()` method in the iterator when there are no more items to return.
-   Throw an `UnsupportedOperationException` if the client calls the `remove()` method in the iterator.

_Unit testing._  Your `main()` method must call directly every public constructor and method to verify that they work as prescribed (e.g., by printing results to standard output).

_Performance requirements._  Your randomized queue implementation must support each randomized queue operation (besides creating an iterator) in _constant amortized time_. That is, any intermixed sequence of _m_ randomized queue operations (starting from an empty queue) must take at most _cm_ steps in the worst case, for some constant _c_. A randomized queue containing _n_ items must use at most 48_n_ + 192 bytes of memory. Additionally, your iterator implementation must support operations `next()` and `hasNext()` in _constant worst-case time_; and construction in _linear time_; you may (and will need to) use a linear amount of extra memory per iterator.

**Client.** Write a client program `Permutation.java` that takes an integer _k_ as a command-line argument; reads a sequence of strings from standard input using `StdIn.readString()`; and prints exactly _k_ of them, uniformly at random. Print each item from the sequence at most once.

> <table><tbody><tr><td><pre><span>~/Desktop/queues&gt;</span> <span>cat distinct.txt</span>
> A B C D E F G H I
> 
> <span>~/Desktop/queues&gt;</span> <span>java Permutation 3 &lt; distinct.txt</span>
> C
> G
> A
> 
> <span>~/Desktop/queues&gt;</span> <span>java Permutation 3 &lt; distinct.txt</span>
> E
> F
> G
> </pre></td><td><pre><span>~/Desktop/queues&gt;</span> <span>cat duplicates.txt</span>
> AA BB BB BB BB BB CC CC
> 
> <span>~/Desktop/queues&gt;</span> <span>java Permutation 8 &lt; duplicates.txt</span>
> BB
> AA
> BB
> CC
> BB
> BB
> CC
> BB
> </pre></td></tr></tbody></table>

Your program must implement the following API:

> ```
> public class Permutation {
>    public static void main(String[] args)
> }
> ```

_Command-line argument._  You may assume that 0 ≤ _k_ ≤ _n_, where _n_ is the number of string on standard input. Note that you are not given _n_.

_Performance requirements._  The running time of `Permutation` must be linear in the size of the input. You may use only a constant amount of memory plus either one `Deque` or `RandomizedQueue` object of maximum size at most _n_. (For an extra challenge and a small amount of extra credit, use only one `Deque` or `RandomizedQueue` object of maximum size at most _k_.)

<small>This assignment was developed by Bob Sedgewick and Kevin Wayne.<br>Copyright © 2005.</small>
