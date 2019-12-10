package com.NowakArtur97.Day5.enums;

public enum OpCode {

	ADD, MULTIPLY, INPUT, OUTPUT, END;

	public static OpCode getOpCode(int code) {
		switch (code) {
		case 1:
			return ADD;
		case 2:
			return MULTIPLY;
		case 3:
			return INPUT;
		case 4:
			return OUTPUT;
		case 99:
			return END;
		default:
			throw new UnsupportedOperationException("Unknown opcode: " + code);
		}
	}
}
