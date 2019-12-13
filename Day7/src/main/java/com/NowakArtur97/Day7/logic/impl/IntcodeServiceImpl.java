package com.NowakArtur97.Day7.logic.impl;

import java.util.List;
import java.util.Stack;

import com.NowakArtur97.Day7.logic.api.IntcodeService;
import com.NowakArtur97.Day7.model.Instruction;
import com.NowakArtur97.Day7.util.api.InputsReader;
import com.NowakArtur97.Day7.util.impl.InputsReaderImpl;

public class IntcodeServiceImpl implements IntcodeService {

	private final InputsReader inputsReader;

	public IntcodeServiceImpl() {
		inputsReader = new InputsReaderImpl();
	}

	public Integer addNumbers(Integer number1, Integer number2) {

		return number1 + number2;
	}

	public Integer multiplyNumbers(Integer number1, Integer number2) {

		return number1 * number2;
	}

	private Integer runProgram(Stack<Integer> inputsStack) {

		int ip = 0;

		final Stack<Integer> outputsStack = new Stack<>();
		final List<Integer> inputs = inputsReader.loadInputsFromFile();

		while (true) {

			Instruction instruction = new Instruction(ip, inputs);

			Integer parameter1 = instruction.getParameter1();
			Integer parameter2 = instruction.getParameter2();

			switch (instruction.getOpCode()) {

			case ADD:
				instruction.getInputs().set(instruction.getInputs().get(ip + 3), addNumbers(parameter1, parameter2));
				ip += 4;
				break;

			case MULTIPLY:
				instruction.getInputs().set(instruction.getInputs().get(ip + 3),
						multiplyNumbers(parameter1, parameter2));
				ip += 4;
				break;

			case INPUT:
				instruction.getInputs().set(instruction.getInputs().get(ip + 1), inputsStack.pop());
				ip += 2;
				break;

			case OUTPUT:
				outputsStack.push(parameter1);
				ip += 2;
				break;

			case JUMP_IF_TRUE:
				ip = parameter1.equals(0) ? ip + 3 : parameter2;
				break;

			case JUMP_IF_FALSE:
				ip = parameter1.equals(0) ? parameter2 : ip + 3;
				break;

			case LESS_THAN:
				instruction.getInputs().set(instruction.getInputs().get(ip + 3), parameter1 < parameter2 ? 1 : 0);
				ip += 4;
				break;

			case EQUALS:
				instruction.getInputs().set(instruction.getInputs().get(ip + 3), parameter1.equals(parameter2) ? 1 : 0);
				ip += 4;
				break;

			case END:
				return outputsStack.pop();
			}
		}
	}

	@Override
	public Integer processIntcodeFirstAnswer() {

		final Stack<Integer> inputsStack = new Stack<>();

		inputsStack.push(1);

		return runProgram(inputsStack);

	}

	@Override
	public Integer processIntcodeSecondAnswer() {

		final Stack<Integer> inputsStack = new Stack<>();

		inputsStack.push(5);

		return runProgram(inputsStack);
	}
}
