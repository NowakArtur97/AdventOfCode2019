package com.NowakArtur97.Day2.service.impl;

import java.util.List;

import com.NowakArtur97.Day2.service.api.IntcodeService;
import com.NowakArtur97.Day2.util.api.InputsReader;
import com.NowakArtur97.Day2.util.impl.InputsReaderImpl;

public class IntcodeServiceImpl implements IntcodeService {

	private final InputsReader inputsReader;

	private final List<Integer> inputs;

	public IntcodeServiceImpl() {

		inputsReader = new InputsReaderImpl();
		inputs = inputsReader.loadInputsFromFile();
	}

	@Override
	public Integer addNumbers(Integer number1, Integer number2) {

		return number1 + number2;
	}

	@Override
	public Integer multiplyNumbers(Integer number1, Integer number2) {

		return number1 * number2;
	}

	@Override
	public Integer processOpcode() {

		inputs.set(1, 12);
		inputs.set(2, 2);
		
		for (int i = 0; i < inputs.size();) {

			Integer input = inputs.get(i);

			if (input == 1) {

				Integer number1 = inputs.get(inputs.get(i + 1));

				Integer number2 = inputs.get(inputs.get(i + 2));

				Integer sum = addNumbers(number1, number2);

				int index = inputs.get(i + 3);

				inputs.set(index, sum);

				i += 4;

			} else if (input == 2) {

				Integer number1 = inputs.get(inputs.get(i + 1));

				Integer number2 = inputs.get(inputs.get(i + 2));

				Integer multiply = multiplyNumbers(number1, number2);

				int index = inputs.get(i + 3);

				inputs.set(index, multiply);

				i += 4;

			} else if (input == 99) {
				break;
			}
		}

		return inputs.get(0);
	}
}
