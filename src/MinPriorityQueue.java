public class MinPriorityQueue<Key extends Comparable<Key>> {
    // from class powerpoint: 2.4 Priority Queues
    // changes:
    // delMax(): changed max var to min
    // swim(): changed to less(k,k/2)
    // sink(): changed less(j,j+1) to !(less(j,j+1))
    // changed if(!less(k,j)) to if(!less(j,k))
    private Key[] pq;
    private int n;

    public MinPriorityQueue(int capacity)
    {
        pq = (Key[]) new Comparable[capacity + 1];
    }
    public boolean isEmpty()
    {
        return n == 0;
    }
    public void insert(Key key)
    {
        pq[++n] = key;
        swim(n);
    }
    public Key delMin()
    {
        Key min = pq[1];
        exch(1, n--); // exchange element 1 with the last element in pq
        sink(1); // bring element 1 (previously last element) into minimum heap
        pq[n+1] = null; // make the place of the removed element null
        return min; // return min element (previously element 1 in binary heap)
    }
    public Key readMin() {
        return pq[1];
    }

    private void swim(int k)
    {
        while (k > 1 && less(k, k / 2)) // switched so that it exchanges when parent < child
        {
            exch(k, k / 2);
            k = k / 2;
        }
    }
    private void sink(int k)
    {
        while (2 * k <= n)
        {
            int j = 2 * k; // setting j as the left child
            if (j < n && !(less(j, j+1))) j++;
            if (!less(j, k)) break;
            exch(k, j);
            k = j;
        }
    }
    private boolean less(int i, int j)
    {
        return pq[i].compareTo(pq[j]) < 0;
    }
    private void exch(int i, int j)
    {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}
