package com.NowakArtur97.Day8;

import com.NowakArtur97.Day8.util.api.InputsReader;
import com.NowakArtur97.Day8.util.impl.InputsReaderImpl;

public class Day8 {
	private static final InputsReader inputsReader = new InputsReaderImpl();

	public static void main(String[] args) {

		System.out.println(inputsReader.loadInputsFromFile().size());
	}
}
