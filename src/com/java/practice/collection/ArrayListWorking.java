package com.java.practice.collection;

import java.util.ArrayList;
import java.util.List;

//https://codenuclear.com/how-arraylist-works-internally-java/
public class ArrayListWorking {
    public static void test(){
        List<Integer> integerList = new ArrayList<>(10);
        integerList.add(0);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        integerList.add(6);
        integerList.add(7);
        integerList.add(8);
        integerList.add(9);
        integerList.add(10);
        integerList.add(11);
        integerList.stream().forEach(System.out::println);
    }
    public static void main(String[] args) {
        ArrayListWorking.test();

    }
}
