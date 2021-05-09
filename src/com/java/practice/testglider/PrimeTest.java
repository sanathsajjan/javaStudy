package com.java.practice.testglider;

import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Glider
public class PrimeTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        String list_string = in.nextLine();
        List<BigInteger> list = Stream.of(list_string.split(","))
                .map(m -> new BigInteger(m))
                .collect(Collectors.toList());
        List<BigInteger> results = list.stream().filter(i -> isPrime(i.intValue())).collect(Collectors.toList());
        String resultString = results.stream().map(BigInteger::toString).collect(Collectors.joining(","));
        System.out.println(resultString);
		
	}
	
	public static boolean isPrime(int n) {
		// Problem setup code {
        //check if n is a multiple of 2
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
	}
}
