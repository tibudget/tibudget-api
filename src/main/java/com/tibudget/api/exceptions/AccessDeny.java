package com.tibudget.api.exceptions;

import com.tibudget.dto.MessageDto.MessageType;

/**
 * Raised only when the remote site explicitly rejects authentication.
 * A network failure, an explicit request to retry later, or invalid local
 * parameters must use the corresponding exception instead.
 */
public class AccessDeny extends MessagesException {

	public AccessDeny(String messageKey, Object... messageArguments) {
		super(MessageType.ERROR, messageKey, messageArguments);
	}

	public AccessDeny(String messageKey, Throwable cause, Object... messageArguments) {
		super(MessageType.ERROR, messageKey, cause, messageArguments);
	}
}
