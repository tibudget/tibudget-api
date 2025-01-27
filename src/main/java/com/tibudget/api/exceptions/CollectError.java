package com.tibudget.api.exceptions;

import com.tibudget.dto.MessageDto.MessageType;

/**
 * Throw this exception when an error occured while
 * collecting datas. This can occur when service has changed
 * and you cannot parse it anymore.
 */
public class CollectError extends MessagesException {

	public CollectError(String messageKey, Object... messageArguments) {
		super(MessageType.ERROR, messageKey, messageArguments);
	}

	public CollectError(String messageKey, Throwable cause, Object... messageArguments) {
		super(MessageType.ERROR, messageKey, cause, messageArguments);
	}
}
