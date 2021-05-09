package com.java.practice.javaFeatures;


//1. Support for try-with-resources � introduced in Java 7
//allows us to declare resources to be used in a try block with the assurance that the resources will be closed when after 
//execution of that block. 
//The resources declared must implement the AutoCloseable interface.

/*
2. Using try-with-resources
Simply put, to be auto-closed, a resource must be both declared and initialized inside the try, as shown below:

try (PrintWriter writer = new PrintWriter(new File("test.txt"))) {
    writer.println("Hello World");
}
3. Replacing try�catch-finally with try-with-resources
The simple and obvious way to use the new try-with-resources functionality is to replace the traditional and verbose try-catch-finally block.

Let�s compare the following code samples � first is a typical try-catch-finally block, then the new approach, using an equivalent
try-with-resources block:


Scanner scanner = null;
try {
    scanner = new Scanner(new File("test.txt"));
    while (scanner.hasNext()) {
        System.out.println(scanner.nextLine());
    }
} catch (FileNotFoundException e) {
    e.printStackTrace();
} finally {
    if (scanner != null) {
        scanner.close();
    }
}
And here�s the super succinct solution using try-with-resources:

try (Scanner scanner = new Scanner(new File("test.txt"))) {
    while (scanner.hasNext()) {
        System.out.println(scanner.nextLine());
    }
} catch (FileNotFoundException fnfe) {
    fnfe.printStackTrace();
}
4. try-with-resources with Multiple Resources
Multiple resources can be declared just fine in a try-with-resources block by separating them with semicolon:

try (Scanner scanner = new Scanner(new File("testRead.txt"));
    PrintWriter writer = new PrintWriter(new File("testWrite.txt"))) {
    while (scanner.hasNext()) {
    writer.print(scanner.nextLine());
    }
}
5. A Custom Resource with AutoCloseable
To construct a custom resource that will be correctly handled by a try-with-resources block, the class should implement the Closeable
or AutoCloseable interfaces and override the close method:

public class MyResource implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("Closed MyResource");
    }
}

6. Resource Closing Order
Resources that were defined/acquired first will be closed last; let�s look at an example of this behavior:

public class AutoCloseableResourcesFirst implements AutoCloseable {
 
    public AutoCloseableResourcesFirst() {
        System.out.println("Constructor -> AutoCloseableResources_First");
    }
 
    public void doSomething() {
        System.out.println("Something -> AutoCloseableResources_First");
    }
 
    @Override
    public void close() throws Exception {
        System.out.println("Closed AutoCloseableResources_First");
    }
}

public class AutoCloseableResourcesSecond implements AutoCloseable {
 
    public AutoCloseableResourcesSecond() {
        System.out.println("Constructor -> AutoCloseableResources_Second");
    }
 
    public void doSomething() {
        System.out.println("Something -> AutoCloseableResources_Second");
    }
 
    @Override
    public void close() throws Exception {
        System.out.println("Closed AutoCloseableResources_Second");
    }
}

private void orderOfClosingResources() throws Exception {
    try (AutoCloseableResourcesFirst af = new AutoCloseableResourcesFirst();
        AutoCloseableResourcesSecond as = new AutoCloseableResourcesSecond()) {
 
        af.doSomething();
        as.doSomething();
    }
}
Output:
Constructor -> AutoCloseableResources_First
Constructor -> AutoCloseableResources_Second
Something -> AutoCloseableResources_First
Something -> AutoCloseableResources_Second
Closed AutoCloseableResources_Second
Closed AutoCloseableResources_First

7. catch & finally
A try-with-resources block can still have the catch and finally blocks � which will work in the same way as with a traditional try block.

8. Conclusion
In this article, we have discussed how to use try-with-resources, how to replace try, catch and finally with try-with-resources,
building custom resources with AutoCloseable and order in which resources are closed.*/
public class TrywithResourceSample {

}
