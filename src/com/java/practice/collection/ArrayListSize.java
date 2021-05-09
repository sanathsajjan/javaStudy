package com.java.practice.collection;

import java.util.ArrayList;
import java.util.List;

//Comviva
public class ArrayListSize {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(1);
        List<Integer> b = a;
        b.add(1);
        a.add(1);
        //Remove methods has been overridden 1. by index and 2. which object to delete
//        b.remove(new Integer(1));
//        b.remove(1);
        System.out.println(a.size());
        System.out.println(b.size());
    }
}
