package com.tibudget.api.exceptions;

import com.tibudget.dto.MessageDto.MessageType;

/**
 * Raised when collection or parsing fails, for example because the remote
 * site's data format has changed. Use the more specific exceptions for
 * authentication rejection, network failures, explicit requests to retry later,
 * and parameter validation failures.
 */
public class CollectError extends MessagesException {

	public CollectError(String messageKey, Object... messageArguments) {
		super(MessageType.ERROR, messageKey, messageArguments);
	}

	public CollectError(String messageKey, Throwable cause, Object... messageArguments) {
		super(MessageType.ERROR, messageKey, cause, messageArguments);
	}
}
