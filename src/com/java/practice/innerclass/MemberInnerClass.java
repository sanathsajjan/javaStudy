package com.java.practice.innerclass;

/**
 * @author sanath.bt
 * <pre>
 *
 * Why do we need nested class?
 *
 * As per Oracle's official page:
 *
 * If a class is useful to only one other class then it seems logical to embed this class as a nested class. For example if a class RedBlackNode (represents node of a Red Black Tree) is used only by class RedBlackTree then it makes sense to make RedBlackNode a nested class in the class RedBlackTree.So it is a  way of logically grouping classes that are only used in one place.
 * A nested class increases encapsulation. Consider a class A whose members are declared private,
 * but class B needs to access them. In that case we can hide class B in A and B can access members of A in spite of the fact that they are private. Also B can be hidden from outside world when declared private.
 * It can lead to more readable and maintainable code.
 *
 * HomeCore JavaInner Class in Java | Uses Types & Real-time Example
 * Inner Class in Java | Uses Types & Real-time Example
 * Scientech Easy-August 07, 2019
 * So far we have seen the members of the class are variables, methods, constructors, and initializer blocks. But it is also possible to have a class or an interface as a member of a class. A class declared inside another class is known as nested class. The class which is a member of another class can be either static or non-static.
 *
 * The member class which is declared as static is known as static nested class. The member class which is non-static is known as an inner class or non-static nested class. In this tutorial, we will learn only the basic ideas of inner class in Java and later on detail will be discussed in the further tutorial.
 * Inner class in Java
 * Inner class in Java
 * An inner class in Java is a class that is declared inside of another Java class without static modifier keyword. It is also commonly known as a non-static nested class in Java. An inner class cannot have any kind of static member. So, the members of an inner class can be:
 * 1. Instance variables
 * 2. Instance methods
 * 3. Constructors
 * 4. Initializer block
 * 5. Inner class
 * Syntax of Inner class:
 * access modifier class OuterClassName {
 * ......
 * access modifier class InnerClassName  {
 * // Members of the inner class.
 * }
 * // Other members of the outer class.
 * }
 * The class that holds the inner class is called an enclosing or outer class. The enclosing class is a top-level class whereas the inner class is the member of outer class. The relationship between the outer class and the inner class is Has-A relationship. The Has-A relationship is also known as composition or aggregation in Java.
 *
 * When an inner class is the enclosing class for another inner class, it is called nesting of inner class. There is no limit of nesting of inner classes.
 * In which version Inner classes were added in Java?
 * Inner classes were added in the Java 1.1 version without any changes in the JVM used to handle the class files. Inner classes are implemented fully with the help of the compiler. the compiler generates a separate dot class file for each inner class named Outer$Inner.class and for an outer class named Outer.class.
 *
 * If any dot class file name contains $ symbol in its middle, it shows the inner class file. The format of the class files for inner classes have the same as class files for the outer classes. Therefore, JVM treats the class files for inner classes and the outer classes the same.
 * Properties of Inner class in Java
 * 1. The inner class can have the same name as the outer class.
 * 2. The scope of inner class is bounded by the scope of its outer class.
 * 3. Without existing an outer class object or instance, there will be no chance of existing inner class object.
 * 3. An inner class can directly access all the variables and methods of the outer class including private.
 *
 * 4. Since the inner class is a regular member of the outer class just like declared variables and methods in the class. That's why we can apply all the access modifiers such as public, default, protected, and private to the inner classes similar to the other members of a class. But the outer or normal class cannot be private or protected.
 *
 * 5. If the variable name of inner class is the same as the variable name of outer class, we can access the outer class variable like this.
 * OuterClassName.this.VariableName; here this represents current outer class object.
 * Instantiating an inner class
 * The instances of an inner class share a relationship with instances of an outer class. This relationship is such that we cannot create an instance of the inner class without having an instance of the outer class.
 * Therefore, to create an instance of inner class, you must have to create an instance of outer class to tie to the inner class. We can create multiple instances of the inner class for the same instance of an outer class. Let's take a real-time example to understand this concept.
 * Real-time Example of Inner class in Java
 * First Real-time Example:
 * Suppose there is a university. University contains several departments such as electronics, computer science, electrical, mechanical etc. Assume that tomorrow, Government decided to close this university due to its illegal activity happening in the university. If the university is closed, all departments of this university will be closed automatically.
 *
 *
 * That's why we can say that departments are tied to their university. i.e their functionalities are tied with its university. So, without an existing university object, there is no chance of existing department objects. Since the department is always a part of the university class. Hence, we must declare the department class inside the university class.
 * class University {  // University is outer class.
 * .......
 * class Department { // Department is inner class.
 * .......
 * }
 * }
 * Thus, without an existing one type of object, if there is no chance of existing another type of object, we should go for inner class.
 *
 * Second Real-time Example:
 * Assume that there is a car. Within a car, there are several important individual components that are required. The most important component of the car is the engine. The engine must be required to make a car. But without an existing car object, there is also no chance of existing an engine object. Since an engine is always an important part of a car. Hence, the class engine must be declared inside the class car.
 * class Car {
 * ......
 * class Engine  {
 * .....
 * }
 * The above two real-time examples are explained to get the basic ideas of inner class. Now the next example is Java API.
 *
 * Third Real-time Example:
 * As you know that in Java there is a Map concept in the collections API. A map is nothing but a group of key-value pairs. Each key-value pairs is called one entry. Now without an existing map object, Is there any chance of existing entry object? the answer is no because without existing the object of a map, the entry object cannot also exist. That's why interface entry is defined inside the map interface.
 * Interface Map  {  // Map is an outer interface.
 * .....
 * Interface Entry  { // Entry is an inner interface.
 * ....
 * }
 * }
 * Now you would have understood from the above real-time example that when have to use an inner class in the Java programming.
 *
 * Java Member inner class
 * A non-static class that is created inside a class but outside a method is called member inner class.
 *
 * Syntax:
 *
 * class Outer{
 * //code
 * class Inner{
 * //code
 * }
 * }
 * Java Member inner class example
 * In this example, we are creating msg() method in member inner class that is accessing the private data member of outer class.
 *
 *
 * class TestMemberOuter1{
 * private int data=30;
 * class Inner{
 * void msg(){System.out.println("data is "+data);}
 * }
 * public static void main(String args[]){
 * TestMemberOuter1 obj=new TestMemberOuter1();
 * TestMemberOuter1.Inner in=obj.new Inner();
 * in.msg();
 * }
 * }
 * Test it Now
 * Output:
 *
 * data is 30
 *
 *
 * Internal working of Java member inner class
 * The java compiler creates two class files in case of inner class. The class file name of inner class is "Outer$Inner". If you want to instantiate inner class, you must have to create the instance of outer class. In such case, instance of inner class is created inside the instance of outer class.
 *
 * Internal code generated by the compiler
 * The java compiler creates a class file named Outer$Inner in this case. The Member inner class have the reference of Outer class that is why it can access all the data members of Outer class including private.
 *
 * import java.io.PrintStream;
 * class Outer$Inner
 * {
 * final Outer this$0;
 * Outer$Inner()
 * {   super();
 * this$0 = Outer.this;
 * }
 * void msg()
 * {
 * System.out.println((new StringBuilder()).append("data is ")
 * .append(Outer.access$000(Outer.this)).toString());
 * }
 * }
 * </pre>
 */

public class MemberInnerClass {

}
