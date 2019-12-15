package com.NowakArtur97.Day7;

import com.NowakArtur97.Day7.logic.api.IntcodeService;
import com.NowakArtur97.Day7.logic.impl.IntcodeServiceImpl;

public class Day7 {
	private final static IntcodeService intcodeService = new IntcodeServiceImpl();

	public static void main(String[] args) {
		
		System.out.println("First Answer: " + intcodeService.processIntcodeFirstAnswer());
	}
}
