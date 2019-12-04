package com.NowakArtur97.Day4.logic.impl;

import com.NowakArtur97.Day4.logic.api.PasswordDecoder;

public class PasswordDecoderImpl implements PasswordDecoder {

	@Override
	public long countPossibleAnswersFirstQuestion(int start, int end) {

		long counter = 0;

		for (long i = start; i <= end; i++) {

			if (areTwoAdjacentDigitsSameFirstQuestion(i) && doNumbersNeverDecrease(i)) {
				counter++;
			}
		}

		return counter;
	}

	@Override
	public long countPossibleAnswersSecondQuestion(int start, int end) {

		long counter = 0;

		for (long i = start; i <= end; i++) {

			if (areTwoAdjacentDigitsSameSecondQuestion(i) && doNumbersNeverDecrease(i)) {
				counter++;
			}
		}

		return counter;
	}

	private boolean areTwoAdjacentDigitsSameFirstQuestion(long password) {

		String passwordValue = String.valueOf(password);

		for (int i = 0; i < passwordValue.length() - 1; i++) {
			if (passwordValue.charAt(i) == passwordValue.charAt(i + 1)) {
				return true;
			}
		}

		return false;
	}

	private boolean areTwoAdjacentDigitsSameSecondQuestion(long password) {

		String passwordValue = String.valueOf(password);

		for (int i = 0; i < passwordValue.length() - 1; i++) {
			if (passwordValue.charAt(i) == passwordValue.charAt(i + 1)
					&& areDigitsNotPartOfALargerGroup(passwordValue, i)) {
				return true;
			}
		}

		return false;
	}

	private boolean areDigitsNotPartOfALargerGroup(String passwordValue, int index) {

		char toCheck = passwordValue.charAt(index);

		for (int i = 0; i < passwordValue.length(); i++) {

			if (i != index && i != (index + 1) && passwordValue.charAt(i) == toCheck) {

				return false;
			}
		}

		return true;
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
