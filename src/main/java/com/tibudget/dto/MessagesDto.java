package com.tibudget.dto;

import java.io.Serializable;
import java.util.*;

import com.tibudget.dto.MessageDto.MessageType;

public class MessagesDto implements Serializable {

	Map<String, List<MessageDto>> messages;

	public MessagesDto() {
		super();
		messages = new HashMap<>();
	}

	public MessagesDto(Iterable<MessageDto> msg) {
		this();
		for (MessageDto messageDto : msg) {
            List<MessageDto> thisMsg = messages.computeIfAbsent(messageDto.getFieldName(), k -> new ArrayList<>());
            thisMsg.add(messageDto);
		}
	}

	public boolean hasGlobalMessages() {
		return hasFieldMessages(null);
	}

	public List<MessageDto> getGlobalMessages() {
		return getFieldMessages(null);
	}

	public List<MessageDto> getAllMessages() {
		List<MessageDto> allMessages = new ArrayList<MessageDto>();
		for (List<MessageDto> messageDtos : messages.values()) {
			allMessages.addAll(messageDtos);
		}
		return allMessages;
	}

	public boolean hasFieldMessages(String fieldName) {
		return messages.get(fieldName) != null;
	}

	public List<MessageDto> getFieldMessages(String fieldName) {
		return messages.get(fieldName);
	}
	
	public boolean hasMessageType(MessageType type) {
		for (List<MessageDto> messageDtos : messages.values()) {
			for (MessageDto messageDto : messageDtos) {
				if (messageDto.getType() == type) {
					return true;
				}
			}		
		}
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof MessagesDto)) return false;
		MessagesDto that = (MessagesDto) o;
		return Objects.equals(messages, that.messages);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(messages);
	}

	@Override
	public String toString() {
		return "MessagesDto{" +
				"messages=" + messages +
				'}';
	}
}
