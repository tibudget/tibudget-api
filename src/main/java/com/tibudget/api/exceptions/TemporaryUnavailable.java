package com.tibudget.api.exceptions;

import com.tibudget.dto.MessageDto.MessageType;

/**
 * Throw this exception when the service you want
 * to connect is temporary unavalaible, that means
 * the host can be reach but the service you need
 * is closed for maintenance or whatever reason.
 */
public class TemporaryUnavailable extends MessagesException {

	private static final long serialVersionUID = 6905246317721861876L;

	public TemporaryUnavailable(String messageKey, Object... messageArguments) {
		super(MessageType.ERROR, messageKey, messageArguments);
	}

	public TemporaryUnavailable(String messageKey, Throwable cause, Object... messageArguments) {
		super(MessageType.ERROR, messageKey, cause, messageArguments);
	}
}
