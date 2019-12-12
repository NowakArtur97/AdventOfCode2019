package com.NowakArtur97.Day8.logic.impl;

import java.util.List;

import com.NowakArtur97.Day8.logic.api.ImageDecoder;
import com.NowakArtur97.Day8.logic.api.ImageRenderer;

public class ImageDecoderImpl implements ImageDecoder {

	private final ImageRenderer imageRenderer = new ImageRendererImpl();

	@Override
	public Integer imageDecoderFirstAnswer() {

		List<List<List<Integer>>> image = imageRenderer.renderImage();

		List<List<Integer>> layerThatContainsFewestZeroDigits = imageRenderer.findLayerWithFewestDigits(image, 00);

		return imageRenderer.countNumberInList(layerThatContainsFewestZeroDigits, 1)
				* imageRenderer.countNumberInList(layerThatContainsFewestZeroDigits, 2);
	}

	@Override
	public void imageDecoderSecondAnswer() {

		List<List<List<Integer>>> image = imageRenderer.renderImage();

		imageRenderer.decodeImage(image);
	}

}
