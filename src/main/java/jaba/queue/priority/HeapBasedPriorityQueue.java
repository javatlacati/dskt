package jaba.queue.priority;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * Created by javatlacati on 30/06/2017.
 */
public class HeapBasedPriorityQueue implements Queue {
    //currentPos
    private int N;
    private Comparable<Object>[] pq;

    public HeapBasedPriorityQueue(int max) {
        pq = (Comparable<Object>[]) new Object[max + 1];
        N = 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * bottom up heapify
     */
    private boolean swim(int k) {
        while (k < 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k /= 2;
        }
        return true;
    }

    private void exch(int i, int j) {
        Comparable<Object> t=pq[i];
        pq[i]=pq[j];
        pq[j]=t;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }


    Comparable<Object> getMax(){
        exch(1,N);
        sink(1,N-1);
        Comparable<Object> result = pq[N];
        N--;
        return result;
    }
/**top down heapify*/
    private void sink(int k, int N) {
        while (2*k<=N){
            int j=2*k;
            if((j < N) && less(j, j + 1)){
                j++;
            }
            if(!less(k,j)){
                break;
            }
            exch(k,j);
            k=j;
        }

    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @NotNull
    @Override
    public Iterator iterator() {
        return null;
    }

    @NotNull
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @NotNull
    @Override
    public Object[] toArray(@NotNull Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        Comparable<Object> obj= (Comparable<Object>)o;
        ++N;
        pq[N] = obj;
        return swim(N);
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(@NotNull Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(@NotNull Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(@NotNull Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(@NotNull Collection c) {
        return false;
    }


    @Override
    public boolean offer(Object o) {
        return false;
    }

    @Override
    public Object remove() {
        return null;
    }

    @Override
    public Object poll() {
        return null;
    }

    @Override
    public Object element() {
        return null;
    }

    @Override
    public Object peek() {
        return null;
    }
}
