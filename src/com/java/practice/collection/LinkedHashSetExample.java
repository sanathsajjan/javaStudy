package com.java.practice.collection;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

//Uses LRU:Lease recently used cache
public class LinkedHashSetExample {
    public static void main(String[] args) {
        Set<Integer> linkedHashSet = new LinkedHashSet<>(10);
        linkedHashSet.add(1);
        linkedHashSet.add(2);
        linkedHashSet.add(3);
        linkedHashSet.add(4);
        linkedHashSet.add(5);
        linkedHashSet.add(6);
        linkedHashSet.add(7);
        linkedHashSet.add(8);
        linkedHashSet.add(9);
        linkedHashSet.add(10);

        System.out.println(linkedHashSet.iterator().next());

    }
}

