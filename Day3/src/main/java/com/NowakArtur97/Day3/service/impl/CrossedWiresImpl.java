package com.NowakArtur97.Day3.service.impl;

import java.io.File;
import java.util.List;

import com.NowakArtur97.Day3.service.api.CrossedWires;
import com.NowakArtur97.Day3.util.api.InputsReader;
import com.NowakArtur97.Day3.util.impl.InputsReaderImpl;

public class CrossedWiresImpl implements CrossedWires {

	private File inputsFile1 = new File(
			"C:\\Users\\Samsung\\Spring\\eclipse-workspace\\Projects\\Advent of Code\\Day3\\src\\resources\\inputs1.txt");

	private File inputsFile2 = new File(
			"C:\\Users\\Samsung\\Spring\\eclipse-workspace\\Projects\\Advent of Code\\Day3\\src\\resources\\inputs2.txt");

	private final InputsReader inputsReader = new InputsReaderImpl();
	
	@Override
	public Integer countManhattanDistance() {
		
		List<String> wires1 = inputsReader.loadInputsFromFile(inputsFile1);
		
		List<String> wires2 = inputsReader.loadInputsFromFile(inputsFile2);
				
		return 0;
	}
}
