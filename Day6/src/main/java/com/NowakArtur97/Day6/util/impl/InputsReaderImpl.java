package com.NowakArtur97.Day6.util.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.NowakArtur97.Day6.util.api.InputsReader;

public class InputsReaderImpl implements InputsReader {

	private List<String> inputs = new ArrayList<>();

	private File inputsFile = new File(
			"C:\\Users\\Samsung\\Spring\\eclipse-workspace\\Projects\\Advent of Code\\Day6\\src\\resources\\inputs.txt");

	@Override
	public List<String> loadInputsFromFile() {

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputsFile))) {

			String input = null;

			while ((input = bufferedReader.readLine()) != null) {
				inputs.add(input);
			}

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found Exception " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO Exception " + e.getMessage());
		}

		return inputs;
	}

}
