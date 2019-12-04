package com.NowakArtur97.Day4.service.impl;

import com.NowakArtur97.Day4.service.api.PasswordDecoder;

public class PasswordDecoderImpl implements PasswordDecoder {

	@Override
	public long countPossibleAnswers(int start, int end) {

		long counter = 0;
		
		for (long i = start; i <= end; i++) {

			if (areTwoAdjacentDigitsSame(i) && doNumbersNeverDecrease(i)) {
				counter++;
			}
		}

		return counter;
	}

	private boolean areTwoAdjacentDigitsSame(long password) {

		String passwordValue = String.valueOf(password);

		for (int i = 0; i < passwordValue.length() - 1; i++) {
			if (passwordValue.charAt(i) == passwordValue.charAt(i + 1)) {
				return true;
			}
		}
		
		return false;
	}

	private boolean doNumbersNeverDecrease(long password) {

		String passwordValue = String.valueOf(password);

		for (int i = 0; i < passwordValue.length() - 1; i++) {
			if (passwordValue.charAt(i) > passwordValue.charAt(i + 1)) {
				return false;
			}
		}

		return true;
	}

}
