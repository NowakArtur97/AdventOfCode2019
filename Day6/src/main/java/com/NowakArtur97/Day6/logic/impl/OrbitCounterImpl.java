package com.NowakArtur97.Day6.logic.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.NowakArtur97.Day6.logic.api.OrbitCounter;
import com.NowakArtur97.Day6.model.Orbit;
import com.NowakArtur97.Day6.util.api.InputsReader;
import com.NowakArtur97.Day6.util.impl.InputsReaderImpl;

public class OrbitCounterImpl implements OrbitCounter {

	private static int COUNTER = 0;

	private final static char ORBIT_SEPARATOR = ')';

	private final InputsReader inputReader;

	private Set<Orbit<String>> orbitMap;

	private final List<String> listOfOrbits;

	public OrbitCounterImpl() {

		this.inputReader = new InputsReaderImpl();
		this.listOfOrbits = inputReader.loadInputsFromFile();
		this.orbitMap = new HashSet<>();
		fillOrbitsMap();
	}

	@Override
	public int countOrbitsFirstAnswer() {

		createTreeOfOrbits();

		for (Orbit<String> orbit : orbitMap) {
			countOrbits(orbit);
		}

		return COUNTER; // 2306 low
	}

	private void countOrbits(Orbit<String> parent) {

		for (Orbit<String> orbitChild : parent.getChildren()) {
			COUNTER++;
			countOrbits(orbitChild);
		}
	}

	private void createTreeOfOrbits() {

		for (String orbit : listOfOrbits) {

			String[] orbits = orbit.split("\\" + ORBIT_SEPARATOR);

			Orbit<String> parentOrbit = findOrbitByName(orbits[0]);
			Orbit<String> childOrbit = findOrbitByName(orbits[1]);

			parentOrbit.addChildOrbit(childOrbit);
		}
	}

	private void fillOrbitsMap() {

		for (String orbit : listOfOrbits) {

			String[] orbits = orbit.split("\\" + ORBIT_SEPARATOR);

			orbitMap.add(new Orbit<String>(orbits[0]));
			orbitMap.add(new Orbit<String>(orbits[1]));
		}
	}

	private Orbit<String> findOrbitByName(String name) {
		return orbitMap.stream().filter(orbit -> orbit.getName().equals(name)).findFirst().get();
	}

}
