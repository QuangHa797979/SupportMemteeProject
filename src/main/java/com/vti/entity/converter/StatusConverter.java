package com.vti.entity.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.vti.entity.Requestsupport.Status;

	@Converter(autoApply = true)
	public class StatusConverter implements AttributeConverter<Status, String> {

		@Override
		public String convertToDatabaseColumn(Status status) {
			return status.getSignal();
		}

		@Override
		public Status convertToEntityAttribute(String dbData) {
			return Status.fromSignal(dbData);
		}



}
