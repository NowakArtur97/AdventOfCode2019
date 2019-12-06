package com.NowakArtur97.Day6;

import com.NowakArtur97.Day6.logic.api.OrbitCounter;
import com.NowakArtur97.Day6.logic.impl.OrbitCounterImpl;

public class Day6 {
	private final static OrbitCounter orbitCounter = new OrbitCounterImpl();

	public static void main(String[] args) {
		System.out.println(orbitCounter.countOrbits());
	}
}
