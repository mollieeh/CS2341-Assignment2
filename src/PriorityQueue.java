public class PriorityQueue<Integer extends Comparable<Integer>> {
    // from class powerpoint: 2.4 Priority Queues
    private Integer[] pq;
    private int n;

    public PriorityQueue(int cap)
    {
        pq = (Integer[]) new Comparable[cap + 1];
    }
    public boolean isEmpty()
    {
        return n==0;
    }
    public void insert(Integer key)
    {
        pq[++n] = key;
        swim(n);
    }
    public Integer delMax()
    {
        Integer max = pq[1]; //the element with the greatest value
        exch(1, n--); // exchange element 1 with the last element in pq
        sink(1); // bring element 1 (previously last element) into binary heap order
        pq[n+1] = null; // make the place of the removed element null
        return max; // return max element (previously element 1 in binary heap)
    }
    private void swim(int k)
    {
        while (k > 1 && less(k / 2, k))
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
            if (j < n && less(j, j+1)) j++; // if the child is less than
            if (!less(k, j)) break;
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
        Integer t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}
