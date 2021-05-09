package com.java.practice.programs;

import java.util.LinkedHashSet;
import java.util.Set;


/**
 * LinkedHashSet is suited for LRU because it will store in insertion order.
 */
public class LRUCacheUsingLinkedHashSet {
    Set<Integer> set;
    int capacity;

    public LRUCacheUsingLinkedHashSet(int capacity) {
        this.capacity = capacity;
        set = new LinkedHashSet<>(capacity);
    }

    /**
     * @param input
     * @return
     * Checking whether element present or not
     * If present removing from cache and adding again, so that it will be saved last (Recently used)
     */
    public Integer getElement(Integer input){
        if(!set.contains(input)){
            return null;
        } else {
            set.remove(input);
            set.add(input);
            return input;
        }
    }

    /**
     * @param input
     * Adding element to the cache
     * If cache is full, we need to remove an element from cache which is used at last.
     * We are doing it by using iterator().next
     * And adding the element
     */
    public void addElement(Integer input){
        if(set.size() == capacity){
            set.remove(set.iterator().next());
        }
        set.add(input);
    }

    /**
     * To display
     */
    public void displayCache(){
        set.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        LRUCacheUsingLinkedHashSet cache = new LRUCacheUsingLinkedHashSet(4);
        cache.addElement(1);
        cache.addElement(2);
        cache.addElement(3);
        cache.addElement(4);
        cache.getElement(1);
        cache.addElement(5);
        cache.addElement(9);
        cache.displayCache();
    }
}
