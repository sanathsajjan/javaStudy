package com.java.practice.designPaatern.creative;

import java.util.ArrayList;
import java.util.List;
//A fully initailized instance to be copied or cloned
//No need to create new instance every time when there is a need of original instance just we need to clone the original instance.
// In this example we are creating Flight instance as a cloned object. 
// We will be having default flights on top of that we will be adding or deeting the flights based on our convienience on cloned object. 
public class PrototypePatternExample {
	
	public static void main(String[] args) {
		Flight defaultFlights = new Flight();
		
		//Morning flights
		//Get default flight list and modify the default list
		Flight morningFlights = (Flight) defaultFlights.clone();
		morningFlights.getDefaultFlightList().add("Kigfisher");
		
		//Night flights
		//Get default flight list and modify the default list
		Flight nightFlights = (Flight) defaultFlights.clone();
		nightFlights.getDefaultFlightList().remove("Emirates");
		
		System.out.println("Default flight lsit:"+ defaultFlights);
		System.out.println("Morning flight lsit:"+ morningFlights);
		System.out.println("Night flight lsit:"+ nightFlights);
		System.out.println("Default flight lsit:"+ defaultFlights);
	}

}


class Flight implements Cloneable{
	
	private List<String> defaultFlights = new ArrayList<>();
	
	public Flight(){
		defaultFlightList();
	}
	
	public Flight(List<String> temp) {
		this.defaultFlights = temp;
	}

	public void defaultFlightList(){
		defaultFlights.add("British Airways");
		defaultFlights.add("Air India");
		defaultFlights.add("Air Mauritus");
		defaultFlights.add("Emirates");
	}
	
	public List<String> getDefaultFlightList(){
		return this.defaultFlights;
	}
	
	@Override
	public Object clone(){
		List<String> temp = new ArrayList<>();
		this.getDefaultFlightList().forEach(e -> temp.add(e));
		return new Flight(temp);
	}

	@Override
	public String toString() {
		return "Flight [defaultFlights=" + defaultFlights + "]";
	}
	
	
}