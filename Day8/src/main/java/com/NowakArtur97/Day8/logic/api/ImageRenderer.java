package com.NowakArtur97.Day8.logic.api;

import java.util.List;

public interface ImageRenderer {

	List<List<Integer>> findLayerWithFewestDigits(List<List<List<Integer>>> image, Integer NUMBER);

	int countNumberInList(List<List<Integer>> list, Integer NUMBER);

	List<List<List<Integer>>> renderImage();

	void decodeImage(List<List<List<Integer>>> image);

}
