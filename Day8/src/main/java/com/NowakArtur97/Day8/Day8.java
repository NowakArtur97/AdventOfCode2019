package com.NowakArtur97.Day8;

import com.NowakArtur97.Day8.logic.api.ImageRenderer;
import com.NowakArtur97.Day8.logic.impl.ImageRendererImpl;

public class Day8 {

	private static final ImageRenderer imageRenderer = new ImageRendererImpl();

	public static void main(String[] args) {

		System.out.println("First Answer: " + imageRenderer.imageRendererFirstAnswer());
	}
}
