package com.java.practice.javaFeatures;

import com.java.practice.objects.ColneableClass;
import com.java.practice.objects.Department;

/**
 * @author sanath.bt
 * 
 *         <pre>
 *Every language which supports cloning of objects has its own rules and so does java. In java, if a class needs to support cloning it has to do following things:

You must implement Cloneable interface.
You must override clone() method from Object class. [Its weird. clone() method should have been in Cloneable interface.]

By Java Docs:

Creates and returns a copy of this object. The precise meaning of "copy" may depend on the class of the object.
The general intent is that, for any object x, the expression:
1) x.clone() != x will be true
2) x.clone().getClass() == x.getClass() will be true, but these are not absolute requirements.
3) x.clone().equals(x) will be true, this is not an absolute requirement.

 
protected native Object clone() throws CloneNotSupportedException;

First statement guarantees that cloned object will have separate memory address assignment.
Second statement suggest that original and cloned objects should have same class type, but it is not mandatory.
Third statement suggest that original and cloned objects should have be equal using equals() method, but it is not mandatory.

Great, we successfully cloned the Employee object. But, remember we have two references to the same object and now both will 
change the state of the object in different parts of the application. Want to see how? Let’s see.

Note: Clone method will do shallow copy

Oops, cloned object changes are visible in original also. This way cloned objects can make havoc in the system if allowed to do so. Anybody can come and clone your application objects and do whatever he likes. Can we prevent this??

Answer is yes, we can. We can prevent this by creating Java deep copy and use copy constructors. We will learn about them later in this post. Let’s first see what is deep cloning and shallow cloning in Java.


Java Deep Copy

Deep clone is the desired behavior in most the cases. In the deep copy, we create a clone which is independent of original object and making changes in the cloned object should not affect original object.

Let see how deep copy is created in Java.

Deep clone
//Modified clone() method in Employee class
&#64;Override
protected Object clone() throws CloneNotSupportedException {
    Employee cloned = (Employee)super.clone();
    cloned.setDepartment((Department)cloned.getDepartment().clone());   
    return cloned;
}
I modified the Employee classes clone() method and added following clone method in Department class.

Department.java
//Defined clone method in Department class.
&#64;Override
protected Object clone() throws CloneNotSupportedException {
    return super.clone();
}
Now testing our cloning code gives desired result and name of the department will not be modified.

Test deep cloning
public class TestCloning 
{
    public static void main(String[] args) throws CloneNotSupportedException 
    {
        Department hr = new Department(1, "Human Resource");
 
        Employee original = new Employee(1, "Admin", hr);
        Employee cloned = (Employee) original.clone();
 
        //Let change the department name in cloned object and we will verify in original object
        cloned.getDepartment().setName("Finance");
 
        System.out.println(original.getDepartment().getName());
        System.out.println(cloned.getDepartment().getName());
    }
}
 
Output:
 
Human Resource
Finance
Here, changing state of the cloned object does not affect the original object.

So deep cloning requires satisfaction of following rules –

No need to separately copy primitives.
All the member classes in original class should support cloning and in clone method of original class in context should call super.clone() on all member classes.
If any member class does not support cloning then in clone method, one must create a new instance of that member class and copy all its attributes one by one to new member class object. This new member class object will be set in cloned object.
 *         </pre>
 */
public class CloneablePractice {
	public static void main(String[] args) throws CloneNotSupportedException {
		Department d = new Department("CS Dept", 1);
		ColneableClass cc = new ColneableClass("sanath", 1, d);
		ColneableClass ccCloned = (ColneableClass) cc.clone();

		System.out.println("cc original:" + cc);
		System.out.println("cc cloned bject:" + ccCloned);
		// Must be true and objects must have different memory addresses
		System.out.println(cc != ccCloned);

		// As we are returning same class; so it should be true
		System.out.println(cc.getClass() == ccCloned.getClass());

		// Default equals method checks for references so it should be false. If we want
		// to make it true,
		// then we need to override equals method in ColneableClass class.
		System.out.println(cc.equals(ccCloned));

		// Let change the department name in cloned object and we will verify in
		// original object
		ccCloned.setName("Name changed");

		ccCloned.getDepartment().setDeptName("EC dept");
		System.out.println("After changing dept class member value...");
		System.out.println("cc original:" + cc);
		System.out.println("cc cloned bject:" + ccCloned);

	}

}
