package com.tibudget.api.exceptions;

import java.util.Collections;

import com.tibudget.dto.MessageDto;
import com.tibudget.dto.MessageDto.MessageType;
import com.tibudget.dto.MessagesDto;

/**
 * Exception that can contain messages to display to the end user.
 * <p>
 * Subclasses can use this exception to attach one or more user-facing messages
 * alongside an optional cause.
 */
public abstract class MessagesException extends Exception {

	private MessagesDto messages;

	public MessagesException(MessageType type, String messageKey, Object... messageArguments) {
		this(type, messageKey, null, messageArguments);
	}

	public MessagesException(MessageType type, String messageKey, Throwable cause, Object... messageArguments) {
		super(messageKey, cause);
		MessageDto msg = new MessageDto(type, messageKey, messageArguments); 
		this.messages = new MessagesDto(Collections.singletonList(msg));
	}

	public MessagesException(MessageType type, String fieldName, String messageKey, Throwable cause, Object... messageArguments) {
		super(messageKey, cause);
		MessageDto msg = new MessageDto(type, fieldName, messageKey, messageArguments); 
		this.messages = new MessagesDto(Collections.singletonList(msg));
	}

	/**
	 * Returns the messages associated with this exception.
	 *
	 * @return the messages
	 */
	public MessagesDto getMessages() {
		return messages;
	}
}
