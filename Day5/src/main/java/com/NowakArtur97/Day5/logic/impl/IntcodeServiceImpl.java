package com.NowakArtur97.Day5.logic.impl;

import java.util.List;
import java.util.Stack;

import com.NowakArtur97.Day5.logic.api.IntcodeService;
import com.NowakArtur97.Day5.model.Instruction;
import com.NowakArtur97.Day5.util.api.InputsReader;
import com.NowakArtur97.Day5.util.impl.InputsReaderImpl;

public class IntcodeServiceImpl implements IntcodeService {

	private final InputsReader inputsReader;
	private final Stack<Integer> outputsStack;
	private final List<Integer> inputs;

	public IntcodeServiceImpl() {
		inputsReader = new InputsReaderImpl();
		inputs = inputsReader.loadInputsFromFile();
		outputsStack = new Stack<>();
	}

	public Integer addNumbers(Integer number1, Integer number2) {

		return number1 + number2;
	}

	public Integer multiplyNumbers(Integer number1, Integer number2) {

		return number1 * number2;
	}

	private void runProgram(Stack<Integer> inputsStack) {

		int i = 0;

		while (true) {

			Instruction instruction = new Instruction(i, inputs);

			Integer parameter1 = instruction.getParameter1();
			Integer parameter2 = instruction.getParameter2();

			switch (instruction.getOpCode()) {

			case ADD:
				instruction.getInputs().set(instruction.getInputs().get(i + 3), 
						addNumbers(parameter1, parameter2));
				i += 4;
				break;

			case MULTIPLY:
				instruction.getInputs().set(instruction.getInputs().get(i + 3),
						multiplyNumbers(parameter1, parameter2));
				i += 4;
				break;

			case INPUT:
				instruction.getInputs().set(instruction.getInputs().get(i + 1), inputsStack.pop());
				i += 2;
				break;

			case OUTPUT:
				outputsStack.push(parameter1);
				i += 2;
				break;

			case END:
				return;
			}
		}
	}

	@Override
	public Integer processIntcodeFirstAnswer() {

		final Stack<Integer> inputsStack = new Stack<>();

		inputsStack.push(1);

		runProgram(inputsStack);

		return outputsStack.pop();
	}

	@Override
	public Integer processIntcodeSecondAnswer() {

		throw new IllegalStateException("Didn`t find answer");
	}
}
