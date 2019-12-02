package com.NowakArtur97.Day2.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.NowakArtur97.Day2.service.api.IntcodeService;
import com.NowakArtur97.Day2.util.api.InputsReader;
import com.NowakArtur97.Day2.util.impl.InputsReaderImpl;

public class IntcodeServiceImpl implements IntcodeService {

	private final InputsReader inputsReader;

	private List<Integer> inputs;

	private List<Integer> inputsOriginal;

	public IntcodeServiceImpl() {

		inputsReader = new InputsReaderImpl();
		inputs = inputsReader.loadInputsFromFile();
		inputsOriginal = new ArrayList<Integer>(inputs);
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
	public Integer processOpcodeFirstAnswer() {

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

	@Override
	public Integer processOpcodeSecondAnswer() {

		for (int j = 0; j <= 99; j++) {

			int noun = j;

			for (int k = 0; k <= 99; k++) {

				inputs = new ArrayList<Integer>(inputsOriginal);

				int verb = k;

				inputs.set(1, noun);
				inputs.set(2, verb);

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

					if (inputs.get(0) == 19690720) {
						return Integer.valueOf(100 * noun + verb);
					}
				}
			}
		}

		return Integer.MAX_VALUE;
	}
}
