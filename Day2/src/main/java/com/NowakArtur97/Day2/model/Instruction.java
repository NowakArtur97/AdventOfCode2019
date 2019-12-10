package com.NowakArtur97.Day2.model;

import java.util.List;

import com.NowakArtur97.Day2.enums.Mode;
import com.NowakArtur97.Day2.enums.OpCode;

public class Instruction {

	private final OpCode opCode;
	private final Integer parameter1;
	private final Integer parameter2;
	private final Integer parameter3;
	private final List<Integer> inputs;

	public Instruction(int i, List<Integer> inputs) {
		this.inputs = inputs;
		int code = getInputs().get(i);
		this.opCode = OpCode.getOpCode(code % 100);
		this.parameter1 = getParameter(Mode.getMode((code / 100) % 2), i + 1);
		this.parameter2 = getParameter(Mode.getMode((code / 1000) % 2), i + 2);
		this.parameter3 = getParameter(Mode.getMode((code / 10000) % 2), i + 3);
	}

	private Integer getParameter(Mode mode, int offset) {
		if (offset >= getInputs().size()) {
			return null;
		}
		int ref = getInputs().get(offset);
		switch (mode) {
		case POSITION:
			return ref >= 0 && ref < getInputs().size() ? getInputs().get(ref) : null;
		case IMMEDIATE:
			return ref;
		default:
			throw new UnsupportedOperationException();
		}
	}

	public OpCode getOpCode() {
		return opCode;
	}

	public Integer getParameter1() {
		return parameter1;
	}

	public Integer getParameter2() {
		return parameter2;
	}

	public Integer getParameter3() {
		return parameter3;
	}

	public List<Integer> getInputs() {
		return inputs;
	}

}
