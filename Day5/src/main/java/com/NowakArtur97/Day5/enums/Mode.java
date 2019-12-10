package com.NowakArtur97.Day5.enums;

public enum Mode {
	POSITION, IMMEDIATE;

	public static Mode getMode(int code) {
		switch (code) {
		case 0:
			return POSITION;
		case 1:
			return IMMEDIATE;
		default:
			throw new UnsupportedOperationException("Unknown mode: " + code);
		}
	}
}
