package com.vti.entity.converter;

import javax.persistence.AttributeConverter;

public class StatusConvertRequestRetest implements AttributeConverter<StatusRequestRetest, String>{

	@Override
	public String convertToDatabaseColumn(StatusRequestRetest attribute) {
		// TODO Auto-generated method stub
		return attribute.getValue();
	}

	@Override
	public StatusRequestRetest convertToEntityAttribute(String dbData) {
		// TODO Auto-generated method stub
		return StatusRequestRetest.of(dbData);
	}

}
