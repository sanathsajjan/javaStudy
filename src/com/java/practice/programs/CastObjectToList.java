package com.java.practice.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CastObjectToList {
public static void main(String[] args) {

    // First way
    Object objects1 = new ArrayList<Object>();
    
    if(objects1 instanceof List) {
    	((ArrayList<Object>) objects1).add("sanath");
    }
System.out.println(objects1);
}
}
