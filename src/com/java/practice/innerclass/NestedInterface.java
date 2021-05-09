package com.java.practice.innerclass;

/**
 * @author sanath.bt
 *<pre>
 *Java Nested Interface
An interface i.e. declared within another interface or class is known as nested interface. The nested interfaces are used to group related interfaces so that they can be easy to maintain. The nested interface must be referred by the outer interface or class. It can't be accessed directly.

Points to remember for nested interfaces
There are given some points that should be remembered by the java programmer.

Nested interface must be public if it is declared inside the interface but it can have any access modifier if declared within the class.
Nested interfaces are declared static implicitely.
Syntax of nested interface which is declared within the interface
interface interface_name{  
 ...  
 interface nested_interface_name{  
  ...  
 }  
}   
Syntax of nested interface which is declared within the class
class class_name{  
 ...  
 interface nested_interface_name{  
  ...  
 }  
}   

 
Example of nested interface which is declared within the interface
In this example, we are going to learn how to declare the nested interface and how we can access it.
interface Showable{  
  void show();  
  interface Message{  
   void msg();  
  }  
}  
class TestNestedInterface1 implements Showable.Message{  
 public void msg(){System.out.println("Hello nested interface");}  
  
 public static void main(String args[]){  
  Showable.Message message=new TestNestedInterface1();//upcasting here  
  message.msg();  
 }  
}  
Test it Now
download the example of nested interface
Output:hello nested interface
As you can see in the above example, we are acessing the Message interface by its outer interface Showable because it cannot be accessed directly. It is just like almirah inside the room, we cannot access the almirah directly because we must enter the room first. In collection frameword, sun microsystem has provided a nested interface Entry. Entry is the subinterface of Map i.e. accessed by Map.Entry.
Internal code generated by the java compiler for nested interface Message
The java compiler internally creates public and static interface as displayed below:.
public static interface Showable$Message  
{  
  public abstract void msg();  
}  
Example of nested interface which is declared within the class
Let's see how can we define an interface inside the class and how can we access it.
class A{  
  interface Message{  
   void msg();  
  }  
}  
  
class TestNestedInterface2 implements A.Message{  
 public void msg(){System.out.println("Hello nested interface");}  
  
 public static void main(String args[]){  
  A.Message message=new TestNestedInterface2();//upcasting here  
  message.msg();  
 }  
}  
Test it Now
Output:hello nested interface
Can we define a class inside the interface?
Yes, If we define a class inside the interface, java compiler creates a static nested class. Let's see how can we define a class within the interface:


interface M{  
  class A{}  
}  

 *</pre>
 */
public class NestedInterface {

}