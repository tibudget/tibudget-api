package com.tibudget.api.exceptions;

import com.tibudget.dto.MessageDto.MessageType;

/**
 * Throw this exception when a parameter has been incorrectly set.
 */
public class ParameterError extends MessagesException {

	public ParameterError(String fieldName, String messageKey, Object... messageArguments) {
		super(MessageType.ERROR, fieldName, messageKey, null, messageArguments);
	}

	public ParameterError(String fieldName, String messageKey, Throwable cause, Object... messageArguments) {
		super(MessageType.ERROR, fieldName, messageKey, cause, messageArguments);
	}
}
