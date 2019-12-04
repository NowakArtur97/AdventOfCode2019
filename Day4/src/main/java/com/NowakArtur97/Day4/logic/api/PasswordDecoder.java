package com.NowakArtur97.Day4.logic.api;

public interface PasswordDecoder {

	long countPossibleAnswersFirstQuestion(int start, int end);
	long countPossibleAnswersSecondQuestion(int start, int end);
}
