package com.vti.entity.converter;

public enum TypeRequestRetest {

	MULTIPLE_CHOICE("MULTIPLE_CHOICE"), ESSAY("ESSAY"), INTERVIEW("INTERVIEW");



	private String value;

	private TypeRequestRetest(String value) {
		this.value = value;
	}

	private void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static TypeRequestRetest of(String value) {

		if (value == null) {
			return null;
		}

		for (TypeRequestRetest type : TypeRequestRetest.values()) {
			if (type.getValue().equals(value)) {
				return type;
			}
		}
		return null;
	}

}
