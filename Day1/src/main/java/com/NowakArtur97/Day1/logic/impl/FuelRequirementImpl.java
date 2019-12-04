package com.NowakArtur97.Day1.logic.impl;

import java.math.BigInteger;
import java.util.List;

import com.NowakArtur97.Day1.logic.api.FuelRequirement;
import com.NowakArtur97.Day1.util.api.InputsReader;
import com.NowakArtur97.Day1.util.impl.InputsReaderImpl;

public class FuelRequirementImpl implements FuelRequirement {

	private static InputsReader inputsReader = new InputsReaderImpl();

	private final List<BigInteger> inputs;

	private final BigInteger BIG_INTEGER_OF_ZERO = new BigInteger("0");

	private final BigInteger BIG_INTEGER_OF_TWO = new BigInteger("2");

	private final BigInteger BIG_INTEGER_OF_THREE = new BigInteger("3");

	public FuelRequirementImpl() {

		inputs = inputsReader.loadInputsFromFile();
	}

	@Override
	public BigInteger convertMassToFuel(BigInteger mass) {

		return mass.divide(BIG_INTEGER_OF_THREE).subtract(BIG_INTEGER_OF_TWO);
	}

	@Override
	public BigInteger sumFuelFirstAnswer() {

		BigInteger sum = BigInteger.ZERO;

		for (BigInteger input : inputs) {

			BigInteger fuel = convertMassToFuel(input);

			sum = sum.add(fuel);
		}

		return sum;
	}

	@Override
	public BigInteger sumFuelSecondAnswer() {

		BigInteger totalSum = BigInteger.ZERO;

		for (BigInteger input : inputs) {

			BigInteger sum = BigInteger.ZERO;

			input = convertMassToFuel(input);

			while (isValueBiggerThan0(input)) {

				sum = sum.add(input);

				input = convertMassToFuel(input);
			}

			totalSum = totalSum.add(sum);
		}

		return totalSum;
	}

	@Override
	public boolean isValueBiggerThan0(BigInteger input) {

		return input.compareTo(BIG_INTEGER_OF_ZERO) > -1;
	}

}
