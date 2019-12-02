package com.NowakArtur97.Day2;

import com.NowakArtur97.Day2.service.api.IntcodeService;
import com.NowakArtur97.Day2.service.impl.IntcodeServiceImpl;

public class Day2 {

	private static final IntcodeService intcodeService = new IntcodeServiceImpl();

	public static void main(String[] args) {

		System.out.println("First answer " + intcodeService.processOpcodeFirstAnswer());
		System.out.println("Second answer " + intcodeService.processOpcodeSecondAnswer());
	}
}
