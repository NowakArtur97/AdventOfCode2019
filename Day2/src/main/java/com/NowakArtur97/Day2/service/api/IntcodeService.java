package com.NowakArtur97.Day2.service.api;

import java.util.List;

public interface IntcodeService {

	Integer addNumbers(Integer number1, Integer number2);
	
	Integer multiplyNumbers(Integer number1, Integer number2);

	void switchValues(List<Integer> inputs, Integer index, Integer index2);

	void processOpcode();
}
