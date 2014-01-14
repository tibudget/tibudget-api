package com.tibudget.api.exceptions;

import com.tibudget.dto.MessageDto.MessageType;

/**
 * Throw this exception when user credentials
 * are wrong or do not permit the operation.
 */
public class AccessDeny extends MessagesException {

	private static final long serialVersionUID = 6905246317721861876L;
	
	public AccessDeny(String messageKey, Object... messageArguments) {
		super(MessageType.ERROR, messageKey, messageArguments);
	}

	public AccessDeny(String messageKey, Throwable cause, Object... messageArguments) {
		super(MessageType.ERROR, messageKey, cause, messageArguments);
	}
}
