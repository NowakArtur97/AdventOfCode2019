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

	private final static Character BLACK = ' ';
	private final static Character WHITE = '#';

	public ImageRendererImpl() {
		this.inputsReader = new InputsReaderImpl();
	}

	@Override
	public List<List<Integer>> findLayerWithFewestDigits(List<List<List<Integer>>> image, final Integer NUMBER) {

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

	@Override
	public int countNumberInList(List<List<Integer>> list, final Integer NUMBER) {

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

	@Override
	public List<List<List<Integer>>> renderImage() {

		List<List<List<Integer>>> image = new ArrayList<List<List<Integer>>>();
		 Stack<Integer> inputs = inputsReader.loadInputsFromFile();

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

	@Override
	public void decodeImage(List<List<List<Integer>>> image) {

		int height = 0;

		while (height < IMAGE_HEIGHT) {
			int width = 0;
			while (width < IMAGE_WIDTH) {
				for (List<List<Integer>> layer : image) {
					if (generatePixel(height, width, layer)) {
						break;
					}
					continue;
				}
				width++;
			}
			height++;
			System.out.println();
		}
	}

	private boolean generatePixel(int height, int width, List<List<Integer>> layer) {
		List<Integer> pixels = layer.get(height);
		Integer pixel = pixels.get(width);
		if (pixel.equals(0)) {
			System.out.print(BLACK);
			return true;
		} else if (pixel.equals(1)) {
			System.out.print(WHITE);
			return true;
		}
		return false;
	}
}