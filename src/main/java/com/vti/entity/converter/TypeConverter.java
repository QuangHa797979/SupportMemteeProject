package com.vti.entity.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.vti.entity.Request.Type;

@Converter(autoApply = true)
public class TypeConverter implements AttributeConverter<Type, String> {

	@Override
	public String convertToDatabaseColumn(Type type) {
		return type.getKind();
	}

	@Override
	public Type convertToEntityAttribute(String dbData) {
		return Type.fromKind(dbData);
	}

}