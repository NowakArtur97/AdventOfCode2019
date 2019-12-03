package com.NowakArtur97.Day3.util.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.NowakArtur97.Day3.util.api.InputsReader;

public class InputsReaderImpl implements InputsReader {

	@Override
	public List<String> loadInputsFromFile(File file) {
		StringBuilder sb = new StringBuilder();

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

			String input = null;

			while ((input = bufferedReader.readLine()) != null) {
				sb.append(input);
			}

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found Exception " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO Exception " + e.getMessage());
		}

		return convertStringToListOfIntegers(sb.toString());
	}

	private List<String> convertStringToListOfIntegers(String string) {

		return Stream.of(string.split(",")).collect(Collectors.toList());
	}

}
