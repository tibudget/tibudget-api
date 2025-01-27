package com.tibudget.api.exceptions;

import com.tibudget.dto.MessageDto.MessageType;

/**
 * Throw this exception when user credentials
 * are wrong or do not permit the operation.
 */
public class AccessDeny extends MessagesException {

	public AccessDeny(String messageKey, Object... messageArguments) {
		super(MessageType.ERROR, messageKey, messageArguments);
	}

	public AccessDeny(String messageKey, Throwable cause, Object... messageArguments) {
		super(MessageType.ERROR, messageKey, cause, messageArguments);
	}
}
