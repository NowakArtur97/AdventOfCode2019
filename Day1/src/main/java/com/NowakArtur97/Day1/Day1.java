package com.NowakArtur97.Day1;

import java.math.BigInteger;

import com.NowakArtur97.Day1.service.api.FuelRequirement;
import com.NowakArtur97.Day1.service.impl.FuelRequirementImpl;

public class Day1 {

	private final static FuelRequirement fuelRequirement = new FuelRequirementImpl();

	public static void main(String[] args) {

		BigInteger totalFuelRequired = fuelRequirement.sumFuel();

		System.out.println("Answer: " + totalFuelRequired);
	}
}
