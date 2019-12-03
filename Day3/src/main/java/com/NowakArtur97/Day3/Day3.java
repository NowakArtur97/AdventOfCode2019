package com.NowakArtur97.Day3;

import com.NowakArtur97.Day3.service.api.CrossedWires;
import com.NowakArtur97.Day3.service.impl.CrossedWiresImpl;

public class Day3 {
	private final static CrossedWires crossedWires = new CrossedWiresImpl();

	public static void main(String[] args) throws Exception {

		System.out.println("First Answer: " + crossedWires.countManhattanDistance());
	}
}
