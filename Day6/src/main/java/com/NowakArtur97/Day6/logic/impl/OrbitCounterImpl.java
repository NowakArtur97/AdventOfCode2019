package com.NowakArtur97.Day6.logic.impl;

import java.util.List;

import com.NowakArtur97.Day6.logic.api.OrbitCounter;
import com.NowakArtur97.Day6.util.api.InputsReader;
import com.NowakArtur97.Day6.util.impl.InputsReaderImpl;

public class OrbitCounterImpl implements OrbitCounter {

	private final InputsReader inputReader;

	private final List<String> orbits;

	public OrbitCounterImpl() {
		this.inputReader = new InputsReaderImpl();
		this.orbits = inputReader.loadInputsFromFile();
	}

	@Override
	public int countOrbits() {

		return 0;
	}

}
