package com.NowakArtur97.Day2.enums;

public enum OpCode {

	ADD, MULTIPLY, END;

	public static OpCode getOpCode(int code) {
		switch (code) {
		case 1:
			return ADD;
		case 2:
			return MULTIPLY;
		case 99:
			return END;
		default:
			throw new UnsupportedOperationException("Unknown opcode: " + code);
		}
	}
}
