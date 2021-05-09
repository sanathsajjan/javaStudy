package com.java.practice.testglider;

//Problem statement: 
// 0 1 4 9 this is a sequence. we need to print all the strange number for that position.

//Click on "HELP" above to see examples of handling input/debug/output 
//Format the output as specified in the problem statement and write the result to stdout 
//IMPORTANT: Remove all debug statements for your final submission
import java.util.*; 

class StrangeSequence { 

	public static void solve(int n) {
		int result = -1;
		// Write your code here
		char[] charArray = {'0', '1', '4', '9'};
		String[] stringArray = {};
		String s = new String(charArray);
		
		for(int i = 0; i<s.length(); i++) {
			if(stringArray.length >= n) {
			}
		}
		
     System.out.println(result);
	}
	
 public static void main(String[] args) { 
    Scanner in = new Scanner(System.in); 
     int n = in.nextInt();
	    solve(n);
		in.close();
 } 
} 
