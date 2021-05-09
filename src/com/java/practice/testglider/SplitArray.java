package com.java.practice.testglider;

import java.util.*;
import java.util.stream.Stream; 

class SplitArray { 

    public static void main(String[] args) { 
       Scanner in = new Scanner(System.in); 
       // Click HELP above to see examples of handling input/debug/output 
       // INPUT: int n = in.nextInt(); 
       // DEBUG: System.out.println(n); 
       // OUTPUT: System.out.println(result); 

       // Write the code to solve the problem below, 
       // format the "result" as specified in the problem statement 
       // and finally, write the result to stdout 
       // IMPORTANT: Remove all debug statements for final submission 
       
       int n = Integer.valueOf(in.nextLine());
       String input = in.nextLine();
       String inputAsArray[] = input.split(" ");
       int  numberList[] = new int[n];
       int count = 0;
       int length = inputAsArray.length;
       int sumLeft = 0;
       int sumRight = 0;
        
       for(String s:inputAsArray ){
           numberList[count++] = Integer.parseInt(s);
       }
      
      
        int i =0;
        int j = 0;
       for( i = 0, j=length-1 ; i< j ; j--,i++ ){
           
          sumLeft += numberList[i];
          sumRight += numberList[j];
          
           
       }
       
       


       if(sumRight == sumLeft){
           System.out.println("YES"); 
       }
       else{
           System.out.println("NO"); 
       }

       
       
      
    } 
} 
