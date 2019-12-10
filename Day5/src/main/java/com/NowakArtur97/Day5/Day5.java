package com.NowakArtur97.Day5;

import com.NowakArtur97.Day5.logic.api.IntcodeService;
import com.NowakArtur97.Day5.logic.impl.IntcodeServiceImpl;

public class Day5 {
	private final static IntcodeService intcodeService = new IntcodeServiceImpl();

	public static void main(String[] args) {
		
		System.out.println("First Answer: " + intcodeService.processIntcodeFirstAnswer());
	}
}
