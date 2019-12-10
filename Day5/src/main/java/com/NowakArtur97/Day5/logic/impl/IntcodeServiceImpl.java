package com.NowakArtur97.Day5.logic.impl;

import java.util.ArrayList;
import java.util.List;

import com.NowakArtur97.Day5.logic.api.IntcodeService;
import com.NowakArtur97.Day5.model.Instruction;
import com.NowakArtur97.Day5.util.api.InputsReader;
import com.NowakArtur97.Day5.util.impl.InputsReaderImpl;

public class IntcodeServiceImpl implements IntcodeService {

	private final InputsReader inputsReader;
	private final List<Integer> originalInputs;

	public IntcodeServiceImpl() {
		inputsReader = new InputsReaderImpl();
		originalInputs = inputsReader.loadInputsFromFile();
	}

	public Integer addNumbers(Integer number1, Integer number2) {

		return number1 + number2;
	}

	public Integer multiplyNumbers(Integer number1, Integer number2) {

		return number1 * number2;
	}

	private void runProgram(List<Integer> inputs) {

		int i = 0;

		while (true) {

			Instruction instruction = new Instruction(i, inputs);

			Integer parameter1 = instruction.getParameter1();
			Integer parameter2 = instruction.getParameter2();

			switch (instruction.getOpCode()) {

			case ADD:
				instruction.getInputs().set(instruction.getInputs().get(i + 3), addNumbers(parameter1, parameter2));
				i += 4;
				break;

			case MULTIPLY:
				instruction.getInputs().set(instruction.getInputs().get(i + 3),
						multiplyNumbers(parameter1, parameter2));
				i += 4;
				break;

			case END:

				return;
			}
		}
	}

	@Override
	public Integer processIntcodeFirstAnswer() {

		List<Integer> inputs = new ArrayList<>(originalInputs);

		inputs.set(1, 12);
		inputs.set(2, 2);

		runProgram(inputs);

		return inputs.get(0);
	}

	@Override
	public Integer processIntcodeSecondAnswer() {

		List<Integer> inputs;

		for (int noun = 0; noun < 100; noun++) {
			for (int verb = 0; verb < 100; verb++) {

				inputs = new ArrayList<>(originalInputs);

				inputs.set(1, noun);
				inputs.set(2, verb);

				runProgram(inputs);

				if (inputs.get(0) == 19690720) {
					return 100 * noun + verb;
				}
			}
		}

		throw new IllegalStateException("Didn`t find answer");
	}
}
