package com.NowakArtur97.Day5.logic.impl;

import java.util.List;
import java.util.Stack;

import com.NowakArtur97.Day5.logic.api.IntcodeService;
import com.NowakArtur97.Day5.util.api.InputsReader;
import com.NowakArtur97.Day5.util.impl.InputsReaderImpl;

public class IntcodeServiceImpl implements IntcodeService {

	private final InputsReader inputsReader;

	private List<Integer> inputs;

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
	public Integer processOpcodeFirstAnswer() {

		Stack<Integer> inputStack = new Stack<>();
		Stack<Integer> outputStack = new Stack<>();

		inputStack.push(1);

		for (int i = 0; i < inputs.size();) {

			Integer input = inputs.get(i);

			int opCode = input % 100;

			int positionMode1 = (input / 100) % 2;

			int positionMode2 = (input / 1000) % 2;

			int positionMode3 = (input / 10000) % 2;

			Integer number1 = inputs.get(i + 1);

			Integer number2 = inputs.get(i + 2);

			if (positionMode1 == 0) {
				number1 = inputs.get(number1);
			} 
			
			if (positionMode2 == 0) {
				number2 = inputs.get(number2);
			} 

			int index = inputs.get(i + 3);

			if (positionMode3 == 0) {
				index = inputs.get(index);
			} 

			if (opCode == 1) {

				Integer sum = addNumbers(number1, number2);

				inputs.set(index, sum);

				i += 4;

			} else if (opCode == 2) {

				Integer multiply = multiplyNumbers(number1, number2);

				inputs.set(index, multiply);

				i += 4;

			} else if (opCode == 3) {

				inputs.set(inputs.get(i + 1), inputStack.pop());

				i += 2;

			} else if (opCode == 4) {

				outputStack.push(number1);

				i += 2;

			} else if (opCode == 99) {
				break;
			}
		}

		return outputStack.pop(); // 1258671 low
	}

	@Override
	public Integer processOpcodeSecondAnswer() {

		return Integer.MAX_VALUE;
	}
}
