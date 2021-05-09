package com.java.practice.testglider;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Read-only stub code{
class Person {

    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName(){
        return this.name;
    }

    int getAge(){
        return this.age;
    }

    @Override
    public String toString() {
        return this.getName()+","+this.getAge();
    }
}

class CensusData {

    private static Scanner sc = new Scanner(System.in);

    private static Stream<Person> getCensusData() {
        List<Person> censusData = new ArrayList<>();
        int numberOfRecords = sc.nextInt();
        for(int i =0;i< numberOfRecords;i++){
            String line =  sc.next();
            String values[] = line.split(",");
            Person person = new Person(values[0],Integer.parseInt(values[1]));
            censusData.add(person);
        }
        return censusData.stream();
    }

    private static int getThresholdData() {
        return sc.nextInt();
    }
//}  
    private static Predicate getFilterRule(int age){
        // TODO - Write a predicate functional interface implement as rule to filter people older than given age
    	Predicate<Person> predicateAge =  p -> p.getAge() > 10;
        return predicateAge;
    }
    private static List<Person> getFilteredCensusData(Stream<Person> peopleList, Predicate<Person> p){
        // TODO - Write code here to filter by the rule and return data as a List.
        List<Person> result = peopleList.filter(p).collect(Collectors.toList());

        return result;
    }
    public static void main(String args[]){
        Stream<Person> people = getCensusData();
        int age = getThresholdData();
        List<Person> filteredPeople = getFilteredCensusData(people, getFilterRule(age));
        filteredPeople.forEach(System.out::println);
    }
}