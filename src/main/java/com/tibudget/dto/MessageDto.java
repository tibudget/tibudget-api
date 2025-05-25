package com.tibudget.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class MessageDto implements Serializable {

	public enum MessageType {
		INFO, ERROR, WARN, SUCCESS,
	}
	
	private final MessageType type;
	
	private final Object[] messageArguments;
	
	private final String messageKey;
	
	private final String fieldName;

	public MessageDto(MessageType type, String fieldName, String messageKey, Object... messageArguments) {
		super();
		this.type = type;
		this.fieldName = fieldName;
		this.messageKey = messageKey;
		this.messageArguments = messageArguments;
	}

	public MessageDto(MessageType type, String messageKey, Object... messageArguments) {
		this(type, null, messageKey, messageArguments);
	}

	public MessageDto(String messageKey, Object... messageArguments) {
		this(MessageType.ERROR, null, messageKey, messageArguments);
	}

	public MessageDto(String fieldName, String messageKey, Object... messageArguments) {
		this(MessageType.ERROR, fieldName, messageKey, messageArguments);
	}

	public MessageType getType() {
		return type;
	}

	public Object[] getMessageArguments() {
		return messageArguments;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public String getFieldName() {
		return fieldName;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof MessageDto)) return false;
		MessageDto that = (MessageDto) o;
		return type == that.type && Objects.deepEquals(messageArguments, that.messageArguments) && Objects.equals(messageKey, that.messageKey) && Objects.equals(fieldName, that.fieldName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, Arrays.hashCode(messageArguments), messageKey, fieldName);
	}

	@Override
	public String toString() {
		return "MessageDto{" +
				"type=" + type +
				", messageArguments=" + Arrays.toString(messageArguments) +
				", messageKey='" + messageKey + '\'' +
				", fieldName='" + fieldName + '\'' +
				'}';
	}
}
