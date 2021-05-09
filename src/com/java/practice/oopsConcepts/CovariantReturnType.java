package com.java.practice.oopsConcepts;

/**
 * @author sanath.bt
 * Covariant return type refers to return type of an
 * overriding method. It allows to narrow down return type of an
 * overridden method without any need to cast the type or check the
 * return type. Covariant return type works only for non-primitive
 * return types.
 * <p>
 * From Java 5 onwards, we can override a method by changing its return
 * type only by abiding the condition that return type is a subclass of
 * that of overridden method return type.
 */
public class CovariantReturnType {
    public static void main(String[] args) {
        SuperClass tester = new Tester();
        tester.get();
    }
}

class SuperClass {
    SuperClass get() {
        System.out.println("SuperClass");
        return this;
    }
}

class Tester extends SuperClass {
    @Override
    Tester get() {
        System.out.println("SubClass");
        return this;
    }

}