package com.NowakArtur97.Day1;

import java.util.List;

import com.NowakArtur97.Day1.Util.api.InputsReader;
import com.NowakArtur97.Day1.Util.impl.InputsReaderImpl;

public class Day1 {
	private static InputsReader inputsReader = new InputsReaderImpl();

	public static void main(String[] args) {
		List<Integer> inputs = inputsReader.loadInputsFromFile();
		System.out.println(inputs);
	}
}
