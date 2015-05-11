package com.task.task16;

import java.util.*;

/**
 * It's overrided implementation of ArrayList. Main difference: overrided method "add" uses binarySearch() method to input a data 
 * into a sorted list for 
 * @param <E> type of data
 */
public class SortedArrayList<E extends Comparable<E>> implements List<E> {
    private List<E> list;
    public SortedArrayList() {
        list = new ArrayList<E>();
    }
 
    public SortedArrayList(Collection<E> collection) {
        list = new ArrayList<E>(collection);
        Collections.sort(list);
    }
 
    @Override
    public int size() {
        return list.size();
    }
 
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
 
    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }
 
    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
 
    @Override
    public Object[] toArray() {
        return list.toArray();
    }
 
    @Override
    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }
 
    @Override
    public boolean add(E e) {
        int position = Collections.binarySearch(list, e);
        
        position = (position < 0) ? -position - 1 : position;
        list.add(position, e);
        
        return true;
    }
 
    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }
 
    @Override
    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }
 
    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E element : c) {
            add(element);
        }
        return c.size() > 0;
    }
 
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("Class " + getClass().getName() +
            " does not support method addAll(int index, Collection<? extends E> c).");
    }
 
    @Override
    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }
 
    @Override
    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }
 
    @Override
    public void clear() {
        list.clear();
    }
 
    @Override
    public E get(int index) {
        return list.get(index);
    }
 
    @Override
    public E set(int index, E element) {
        E previous = get(index);
        
        list.remove(previous);
        list.add(element);
        
        return previous;
    }
 
    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Class " + getClass().getName() +
                " does not support method add(int index, E element).");
    }
 
    @Override
    public E remove(int index) {
        return list.remove(index);
    }
 
    @Override
    public int indexOf(Object o) {
        return list.indexOf(o);
    }
 
    @Override
    public int lastIndexOf(Object o) {
        return list.lastIndexOf(o);
    }
 
    @Override
    public ListIterator<E> listIterator() {
        return list.listIterator();
    }
 
    @Override
    public ListIterator<E> listIterator(int index) {
        return list.listIterator(index);
    }
 
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Class " + getClass().getName() +
                " does not support method subList(int fromIndex, int toIndex).");
    }
}