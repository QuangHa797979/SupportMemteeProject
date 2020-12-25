package com.vti.entity.converter;

import javax.persistence.AttributeConverter;

public class TypeConvertRequestRetest implements AttributeConverter<TypeRequestRetest, String>{

	@Override
	public String convertToDatabaseColumn(TypeRequestRetest attribute) {
		// TODO Auto-generated method stub
		return attribute.getValue();
	}

	@Override
	public TypeRequestRetest convertToEntityAttribute(String dbData) {
		// TODO Auto-generated method stub
		return TypeRequestRetest.of(dbData);
	}

}
