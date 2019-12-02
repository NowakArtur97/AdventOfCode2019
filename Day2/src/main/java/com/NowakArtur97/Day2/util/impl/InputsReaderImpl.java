package com.NowakArtur97.Day2.util.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.NowakArtur97.Day2.util.api.InputsReader;

public class InputsReaderImpl implements InputsReader {

	private File inputsFile = new File(
			"C:\\Users\\Samsung\\Spring\\eclipse-workspace\\Projects\\Advent of Code\\Day2\\src\\resources\\inputs.txt");

	@Override
	public List<Integer> loadInputsFromFile() {

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

		return convertStringToArrayList(sb);
	}

	private List<Integer> convertStringToArrayList(StringBuilder sb) {
		return Stream.of(sb.toString().split(",")).map(Integer::parseInt).collect(Collectors.toList());
	}

}
