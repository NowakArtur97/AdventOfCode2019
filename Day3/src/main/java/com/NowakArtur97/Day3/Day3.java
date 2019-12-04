package com.NowakArtur97.Day3;

import com.NowakArtur97.Day3.logic.api.CrossedWires;
import com.NowakArtur97.Day3.logic.impl.CrossedWiresImpl;

public class Day3 {
	private final static CrossedWires crossedWires = new CrossedWiresImpl();

	public static void main(String[] args) throws Exception {

		System.out.println("First Answer: " + crossedWires.countManhattanDistanceFirstAnswer());
		
		System.out.println("Second Answer: " + crossedWires.countManhattanDistanceSecondAnswer()); 
	}
}
