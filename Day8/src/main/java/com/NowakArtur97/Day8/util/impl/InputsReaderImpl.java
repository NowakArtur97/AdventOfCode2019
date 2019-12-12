package com.NowakArtur97.Day8.util.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.NowakArtur97.Day8.util.api.InputsReader;

public class InputsReaderImpl implements InputsReader {

	private File inputsFile = new File(
			"C:\\Users\\Samsung\\Spring\\eclipse-workspace\\Projects\\Advent of Code\\Day8\\src\\resources\\inputs.txt");

	@Override
	public Stack<Integer> loadInputsFromFile() {

		StringBuilder sb = new StringBuilder();

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputsFile))) {

			String input = null;

			while ((input = bufferedReader.readLine()) != null) {
				sb.append(input);
			}

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found Exception " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO Exception " + e.getMessage());
		}

		Stack<Integer> stack = convertListToStack(sb.toString());

		return stack;
	}

	private Stack<Integer> convertListToStack(String string) {
		
		List<Integer> inputs = convertStringToListOfIntegers(string);
		
		Stack<Integer> stack = new Stack<>();
		for (int i = inputs.size() - 1; i >= 0; i--) {
			stack.push(inputs.get(i));
		}
		return stack;
	}

	private List<Integer> convertStringToListOfIntegers(String string) {

		return Stream.of(string.split("")).map(Integer::parseInt).collect(Collectors.toList());
	}

}
