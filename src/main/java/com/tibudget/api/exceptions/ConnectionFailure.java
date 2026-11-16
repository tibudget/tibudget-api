package com.tibudget.api.exceptions;

import com.tibudget.dto.MessageDto.MessageType;

/**
 * Raised when communication with the remote site fails because of a network
 * problem, such as a DNS failure, connection failure, or timeout.
 */
public class ConnectionFailure extends MessagesException {

	public ConnectionFailure(String messageKey, Object... messageArguments) {
		super(MessageType.ERROR, messageKey, messageArguments);
	}

	public ConnectionFailure(String messageKey, Throwable cause, Object... messageArguments) {
		super(MessageType.ERROR, messageKey, cause, messageArguments);
	}
}
