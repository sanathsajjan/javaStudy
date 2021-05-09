package com.java.practice.oopsConcepts;



import java.util.ArrayList;
import java.util.List; 

/*Composition

Composition is a restricted form of Aggregation in which two entities are highly dependent on each other.

It represents part-of relationship.
In composition, both the entities are dependent on each other.
When there is a composition between two entities, the composed object cannot exist without the other entity.
Lets take example of Library.*/

// class book
class Book  
{ 
  
    public String title; 
    public String author; 
      
    Book(String title, String author) 
    { 
          
        this.title = title; 
        this.author = author; 
    } 
} 
  
// Libary class contains  
// list of books. 
class Library  
{ 
  
    // reference to refer to list of books. 
    private final List<Book> books; 
      
    Library (List<Book> books) 
    { 
        this.books = books;  
    } 
      
    public List<Book> getTotalBooksInLibrary(){ 
          
       return books;   
    } 
      
} 
  
// main method 
class Composition
{ 
    public static void main (String[] args)  
    { 
          
        // Creating the Objects of Book class. 
        Book b1 = new Book("EffectiveJ Java", "Joshua Bloch"); 
        Book b2 = new Book("Thinking in Java", "Bruce Eckel"); 
        Book b3 = new Book("Java: The Complete Reference", "Herbert Schildt"); 
          
        // Creating the list which contains the  
        // no. of books. 
        List<Book> books = new ArrayList<Book>(); 
        books.add(b1); 
        books.add(b2); 
        books.add(b3); 
          
        Library library = new Library(books); 
          
        List<Book> bks = library.getTotalBooksInLibrary(); 
        for(Book bk : bks){ 
              
            System.out.println("Title : " + bk.title + " and " 
            +" Author : " + bk.author); 
        } 
    } 
} 
/*Output

Title : EffectiveJ Java and  Author : Joshua Bloch
Title : Thinking in Java and  Author : Bruce Eckel
Title : Java: The Complete Reference and  Author : Herbert Schildt

In above example a library can have no. of books on same or different subjects. 
So, If Library gets destroyed then All books within that particular library will be destroyed. 
i.e. book can not exist without library. That�s why it is composition.*/
