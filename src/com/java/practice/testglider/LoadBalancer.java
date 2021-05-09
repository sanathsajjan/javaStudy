package com.java.practice.testglider;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class LoadBalancer {

public static List<List<Integer>> getSubarrayWithLoad(List<Integer> workList, int load){
        
        if (workList == null)
            return new ArrayList<List<Integer>>();
 
        Collections.sort(workList);
 
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
 
        for (int i = 0; i < workList.size(); i++) {
            List<List<Integer>> temp = new ArrayList<>();
 
            for (List<Integer> a : result) {
                temp.add(new ArrayList<Integer>(a));
            }
 
            for (List<Integer> a : temp) {
                a.add(workList.get(i));
            }
 
            List<Integer> single = new ArrayList<>();
            single.add(workList.get(i));
            temp.add(single);
            
            int sum=0;
            for(int outer=0;outer<temp.size();outer++){
                sum=0;
                for(int inner=0;inner<temp.get(outer).size();inner++){
                    sum = sum + temp.get(outer).get(inner);
                }
                if(sum == load){
                    output.add(temp.get(outer));
                }
            }
            result.addAll(temp);
        }
 
        //add empty set
        result.add(new ArrayList<Integer>());
        output.forEach(System.out::println);
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String list_string = in.nextLine();
        List<Integer> list = Stream.of(list_string.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String sum_string = in.nextLine();
        int load = Integer.parseInt(sum_string);
        System.out.println(getSubarrayWithLoad(list, load));
    }
}
