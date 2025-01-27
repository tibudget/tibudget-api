package com.tibudget.api.exceptions;

import com.tibudget.dto.MessageDto.MessageType;

/**
 * Throw this exception when you cannot connect
 * to the remote host for unknown reason (no internet
 * connection, remote host does not respond, etc.)
 */
public class ConnectionFailure extends MessagesException {

	public ConnectionFailure(String messageKey, Object... messageArguments) {
		super(MessageType.ERROR, messageKey, messageArguments);
	}

	public ConnectionFailure(String messageKey, Throwable cause, Object... messageArguments) {
		super(MessageType.ERROR, messageKey, cause, messageArguments);
	}
}
