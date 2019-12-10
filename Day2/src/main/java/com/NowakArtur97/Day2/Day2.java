package com.NowakArtur97.Day2;

import com.NowakArtur97.Day2.logic.api.IntcodeService;
import com.NowakArtur97.Day2.logic.impl.IntcodeServiceImpl;

public class Day2 {

	private static final IntcodeService intcodeService = new IntcodeServiceImpl();

	public static void main(String[] args) {
		
		System.out.println("First answer: " + intcodeService.processIntcodeFirstAnswer());
		System.out.println("Second answer: " + intcodeService.processIntcodeSecondAnswer());
	}
}
