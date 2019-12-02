package com.NowakArtur97.Day2.service.impl;

import java.util.List;

import com.NowakArtur97.Day2.service.api.IntcodeService;
import com.NowakArtur97.Day2.util.api.InputsReader;
import com.NowakArtur97.Day2.util.impl.InputsReaderImpl;

public class IntcodeServiceImpl implements IntcodeService {

	private InputsReader inputsReader = new InputsReaderImpl();

	@Override
	public Integer addNumbers(Integer number1, Integer number2) {

		return number1 + number2;
	}

	@Override
	public Integer multiplyNumbers(Integer number1, Integer number2) {

		return number1 * number2;
	}

	@Override
	public void switchValues(List<Integer> inputs, Integer index, Integer index2) {

		Integer temp = inputs.get(index);
		inputs.set(index, inputs.get(index2));
		inputs.set(index2, temp);
	}

	@Override
	public void processOpcode() {
		
	}
}
