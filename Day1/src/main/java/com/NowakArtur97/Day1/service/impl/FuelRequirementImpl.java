package com.NowakArtur97.Day1.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.NowakArtur97.Day1.service.api.FuelRequirement;
import com.NowakArtur97.Day1.util.api.InputsReader;
import com.NowakArtur97.Day1.util.impl.InputsReaderImpl;

public class FuelRequirementImpl implements FuelRequirement {

	private static InputsReader inputsReader = new InputsReaderImpl();

	private List<BigInteger> inputs = new ArrayList<>();

	private final BigInteger BIG_INTEGER_OF_TWO = new BigInteger("2");

	private final BigInteger BIG_INTEGER_OF_THREE = new BigInteger("3");

	@Override
	public BigInteger convertMassToFuel(BigInteger mass) {

		return mass.divide(BIG_INTEGER_OF_THREE).subtract(BIG_INTEGER_OF_TWO);
	}

	@Override
	public BigInteger sumFuel() {

		inputs = inputsReader.loadInputsFromFile();

		BigInteger sum = BigInteger.ZERO;

		for (BigInteger input : inputs) {

			BigInteger fuel = convertMassToFuel(input);

			sum = sum.add(fuel);
		}

		return sum;
	}

}
