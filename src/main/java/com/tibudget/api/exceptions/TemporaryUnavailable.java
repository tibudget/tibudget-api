package com.tibudget.api.exceptions;

import com.tibudget.dto.MessageDto.MessageType;

/**
 * Raised when the remote site responds and explicitly indicates that the
 * operation should be retried later, for example during maintenance.
 * A network failure alone does not indicate temporary unavailability.
 */
public class TemporaryUnavailable extends MessagesException {

	public TemporaryUnavailable(String messageKey, Object... messageArguments) {
		super(MessageType.ERROR, messageKey, messageArguments);
	}

	public TemporaryUnavailable(String messageKey, Throwable cause, Object... messageArguments) {
		super(MessageType.ERROR, messageKey, cause, messageArguments);
	}
}
