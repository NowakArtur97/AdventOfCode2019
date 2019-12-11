package com.NowakArtur97.Day8.logic.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.NowakArtur97.Day8.logic.api.ImageRenderer;
import com.NowakArtur97.Day8.util.api.InputsReader;
import com.NowakArtur97.Day8.util.impl.InputsReaderImpl;

public class ImageRendererImpl implements ImageRenderer {

	private final InputsReader inputsReader;

	private final static Integer IMAGE_WIDTH = 25;
	private final static Integer IMAGE_HEIGHT = 6;

	public ImageRendererImpl() {
		this.inputsReader = new InputsReaderImpl();
	}

	@Override
	public Integer imageRendererFirstAnswer() {

		Stack<Integer> inputs = inputsReader.loadInputsFromFile();

		List<List<List<Integer>>> image = renderImage(inputs);

		List<List<Integer>> layerThatContainsFewestZeroDigits = findLayerWithFewestDigits(image, 00);

		return countNumberInList(layerThatContainsFewestZeroDigits, 1)
				* countNumberInList(layerThatContainsFewestZeroDigits, 2);
	}

	private List<List<Integer>> findLayerWithFewestDigits(List<List<List<Integer>>> image, final Integer NUMBER) {

		int min = Integer.MAX_VALUE;
		int index = 0;

		for (int i = 0; i < image.size(); i++) {

			List<List<Integer>> layer = image.get(i);

			int sum0 = countNumberInList(layer, NUMBER);

			if (min > sum0) {
				min = sum0;
				index = i;

			}
		}

		return image.get(index);
	}

	private int countNumberInList(List<List<Integer>> list, final Integer NUMBER) {

		int sum = 0;

		for (List<Integer> row : list) {

			for (Integer value : row) {

				if (value.equals(NUMBER)) {
					sum++;
				}
			}
		}

		return sum;
	}

	private List<List<List<Integer>>> renderImage(Stack<Integer> inputs) {

		List<List<List<Integer>>> image = new ArrayList<List<List<Integer>>>();

		while (!inputs.isEmpty()) {
			List<List<Integer>> layer = new ArrayList<>();
			for (int height = 0; height < IMAGE_HEIGHT; height++) {

				List<Integer> row = new ArrayList<>();

				for (int width = 0; width < IMAGE_WIDTH; width++) {
					row.add(inputs.pop());
				}
				layer.add(row);
			}
			image.add(layer);
		}
		return image;
	}
}
