package com.vti.entity.converter;

public enum StatusRequestRetest {

	SEND("SEND"), EXAM_SCHEDULED("EXAM_SCHEDULED"), FINISH("FINISH"), REFUSE("REFUSE");

	private String value;

	private StatusRequestRetest(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static StatusRequestRetest of(String value) {

		if (value == null) {
			return null;
		}

		for (StatusRequestRetest status : StatusRequestRetest.values()) {
			if (status.getValue().equals(value)) {
				return status;
			}
		}
		return null;
	}

}
