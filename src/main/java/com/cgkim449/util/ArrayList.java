package com.cgkim449.util;

import java.util.Arrays;

public class ArrayList<E> {
    static final int DEFAULT_CAPACITY = 3;
    Object[] list;
    int size = 0;

    public ArrayList() {
        list = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int initialCapacity) {
        if (initialCapacity <= DEFAULT_CAPACITY) {
            list = new Object[DEFAULT_CAPACITY];
        } else {
            list = new Object[initialCapacity];
        }
    }

    public void add(E obj) {
        if (size == list.length) {
            int oldCapacity = list.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            list = Arrays.copyOf(list, newCapacity);
        }
        list[size++] = obj;
    }

    public E[] toArray(Class<E[]> arrayType) {
        return Arrays.copyOf(list, size, arrayType);
    }
}
