package com.NowakArtur97.Day3.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.NowakArtur97.Day3.model.Point;
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
	public Integer countManhattanDistance() throws Exception {

		List<String> directions1 = inputsReader.loadInputsFromFile(inputsFile1);

		List<String> directions2 = inputsReader.loadInputsFromFile(inputsFile2);

		List<Point> wire1 = createWire(directions1);
		List<Point> wire2 = createWire(directions2);

		wire1.retainAll(wire2);

		List<Point> pointsWithoutCentralPort = wire1.stream().filter(p -> p.getX() != 0 && p.getY() != 0)
				.collect(Collectors.toList());

		List<Point> ordered = pointsWithoutCentralPort.stream().sorted(
				(p1, p2) -> (Math.abs(p1.getX()) + Math.abs(p1.getY())) - (Math.abs(p2.getX()) + Math.abs(p2.getY())))
				.collect(Collectors.toList());

		Point closestPoint = ordered.get(0);

		int closestDistance = Math.abs(closestPoint.getX()) + Math.abs(closestPoint.getY());

		return closestDistance;
	}

	private List<Point> createWire(List<String> directions) throws Exception {

		List<Point> wire = new ArrayList<>();

		wire.add(new Point(0, 0));

		for (String direction : directions) {

			String course = direction.substring(0, 1);

			int amount = Integer.parseInt(direction.substring(1));

			createPointsBasedOnCourse(course, amount, wire);
		}

		return wire;
	}

	private void createPointsBasedOnCourse(String course, int amount, List<Point> wire) throws Exception {

		int xOffset = 0;

		int yOffset = 0;

		switch (course) {

		case "R":
			xOffset = 1;
			break;
		case "L":
			xOffset = -1;
			break;
		case "U":
			yOffset = 1;
			break;
		case "D":
			yOffset = -1;
			break;
		default:
			throw new Exception();
		}

		createStraightLineOfPoints(amount, wire, xOffset, yOffset);
	}

	private void createStraightLineOfPoints(int amount, List<Point> wire, int xOffset, int yOffset) {

		for (int i = 0; i < amount; i++) {

			Point lastPoint = wire.get(wire.size() - 1);

			Point currentPoint = new Point(lastPoint.getX() + xOffset, lastPoint.getY() + yOffset);

			wire.add(currentPoint);
		}
	}
}
