package com.NowakArtur97.Day2.enums;

public enum Mode {
	POSITION, IMMEDIATE;

	public static Mode getMode(int code) {
		switch (code) {
		case 0:
			return POSITION;
		default:
			throw new UnsupportedOperationException("Unknown mode: " + code);
		}
	}
}
