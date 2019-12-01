package com.NowakArtur97.Day1.service.api;

import java.math.BigInteger;

public interface FuelRequirement {

	BigInteger convertMassToFuel(BigInteger mass);

	BigInteger sumFuel();
}
