package com.tibudget.api.exceptions;

import com.tibudget.dto.MessageDto.MessageType;

/**
 * Raised when validation of collector parameters fails.
 * The field name identifies the parameter concerned by the validation error.
 * An authentication rejection from the remote site must use {@link AccessDeny}.
 */
public class ParameterError extends MessagesException {

	public ParameterError(String fieldName, String messageKey, Object... messageArguments) {
		super(MessageType.ERROR, fieldName, messageKey, null, messageArguments);
	}

	public ParameterError(String fieldName, String messageKey, Throwable cause, Object... messageArguments) {
		super(MessageType.ERROR, fieldName, messageKey, cause, messageArguments);
	}
}
