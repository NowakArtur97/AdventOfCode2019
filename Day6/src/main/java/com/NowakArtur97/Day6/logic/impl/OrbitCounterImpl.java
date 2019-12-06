package com.NowakArtur97.Day6.logic.impl;

import java.util.ArrayList;
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
		createTreeOfOrbits();
	}

	@Override
	public int countOrbitsFirstAnswer() {

		for (Orbit<String> orbit : orbitMap) {
			countOrbits(orbit);
		}

		return COUNTER;
	}

	@Override
	public int countOrbitsSecondAnswer() {

		Orbit<String> YOU = findOrbitByName("YOU");
		Orbit<String> SAN = findOrbitByName("SAN");

		List<Orbit<String>> parentsYOU = getAllParentsToParent(YOU, "COM");
		List<Orbit<String>> parentsSAN = getAllParentsToParent(SAN, "COM");

		parentsYOU.retainAll(parentsSAN);

		Orbit<String> firstShareParent = parentsYOU.get(0);

		parentsYOU = getAllParentsToParent(YOU, firstShareParent.getName());
		parentsSAN = getAllParentsToParent(SAN, firstShareParent.getName());

		return parentsYOU.size() + parentsSAN.size() - 2;
	}

	private List<Orbit<String>> getAllParentsToParent(Orbit<String> orbit, String parentName) {

		List<Orbit<String>> parentList = new ArrayList<Orbit<String>>();

		while (!orbit.getName().equals(parentName)) {
			orbit = orbit.getParent();
			parentList.add(orbit);
		}

		return parentList;
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
