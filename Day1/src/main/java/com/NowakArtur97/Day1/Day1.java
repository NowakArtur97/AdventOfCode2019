package com.NowakArtur97.Day1;

import java.math.BigInteger;

import com.NowakArtur97.Day1.service.api.FuelRequirement;
import com.NowakArtur97.Day1.service.impl.FuelRequirementImpl;

public class Day1 {

	private final static FuelRequirement fuelRequirement = new FuelRequirementImpl();

	public static void main(String[] args) {

		BigInteger totalFuelRequired1 = fuelRequirement.sumFuelFirstAnswer();

		BigInteger totalFuelRequired2 = fuelRequirement.sumFuelSecondAnswer();

		System.out.println("First answer: " + totalFuelRequired1);

		System.out.println("Second answer: " + totalFuelRequired2);
	}
}
