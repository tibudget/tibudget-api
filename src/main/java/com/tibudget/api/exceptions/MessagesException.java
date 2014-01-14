package com.tibudget.api.exceptions;

import java.util.Collections;

import com.tibudget.dto.MessageDto;
import com.tibudget.dto.MessagesDto;
import com.tibudget.dto.MessageDto.MessageType;

/**
 * Exception that can contains messages to display to the end user 
 */
public abstract class MessagesException extends Exception {

	private static final long serialVersionUID = 1531870875502714752L;

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
	 * @return The messages so you can manage the list if you need to
	 */
	public MessagesDto getMessages() {
		return messages;
	}
}
