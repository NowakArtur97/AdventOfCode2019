package com.NowakArtur97.Day8;

import com.NowakArtur97.Day8.logic.api.ImageDecoder;
import com.NowakArtur97.Day8.logic.impl.ImageDecoderImpl;

public class Day8 {

	private static final ImageDecoder imageDecoder = new ImageDecoderImpl();

	public static void main(String[] args) {

		System.out.println("First Answer: " + imageDecoder.imageDecoderFirstAnswer());
		System.out.println("Second Answer: ");
		imageDecoder.imageDecoderSecondAnswer();
	}
}
