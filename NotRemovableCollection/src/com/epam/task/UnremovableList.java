package com.epam.task;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;

public class UnremovableList<E> implements Serializable, Cloneable,
        Iterable<E>, RandomAccess {

    private int size = 0;
    public final static int DEFAULT_CAPACITY = 10;
    private E [] elements;

    public UnremovableList(){
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public void add(E e) {
        if(size == elements.length){
            ensureCapacity();
        }
        elements[size++] = e;
    }

    private void ensureCapacity(){
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public E get(int i){
        if(i >= size || i < 0){
            throw new IndexOutOfBoundsException("Index: " + i + " unreachable!");
        }
        return elements[i];
    }

    public boolean contains(E obj){
        boolean contains = false;
        for (E e: this) {
            if (e.equals(obj)) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    public int size(){
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {
        return new UnremovableIterator();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Iterable.super.forEach(action);
    }

    class UnremovableIterator implements Iterator<E> {
        int current = 0;

        @Override
        public boolean hasNext() {
            return current < UnremovableList.this.elements.length && UnremovableList.this.elements[current] != null;
        }

        @Override
        public E next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            return elements[current++];
        }
    }
}
