package com.order.exception;

public class CodeNotFoundException extends Exception {
	public CodeNotFoundException() {
		super("Code entered is wrong.");
	}
}
