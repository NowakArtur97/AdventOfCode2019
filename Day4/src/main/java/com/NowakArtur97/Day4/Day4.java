package com.NowakArtur97.Day4;

import com.NowakArtur97.Day4.logic.api.PasswordDecoder;
import com.NowakArtur97.Day4.logic.impl.PasswordDecoderImpl;

public class Day4 {
	private static final PasswordDecoder passwordDecoder = new PasswordDecoderImpl();

	public static void main(String[] args) {
		System.out.println("First answer: " + passwordDecoder.countPossibleAnswersFirstQuestion(134792, 675810));
		System.out.println("Second answer: " + passwordDecoder.countPossibleAnswersSecondQuestion(134792, 675810));
	}
}
