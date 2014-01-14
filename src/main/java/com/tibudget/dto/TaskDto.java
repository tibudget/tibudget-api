package com.tibudget.dto;

import java.io.Serializable;
import java.util.Date;

public class TaskDto implements Serializable {

	private static final long serialVersionUID = -8584160633164722589L;

	public enum TaskStatus {
		SCHEDULED, WAIT_IN_QUEUE, IN_PROGRESS, SUCCESS, CANCELLED, ERROR
	}

	private String id;

	private String title;

	private TaskStatus status;

	private Date scheduledDate;

	private Date startWaitInQueueDate;

	private Date startDate;

	private Date endDate;

	private Date updateDate;

	/**
	 * The exact date of imported operation. It allow you to retreive all
	 * imported operations
	 */
	private Date importDate;
	
	/**
	 * Number of operation imported
	 */
	private int importCount;

	private int progress;

	private String iconPath;
	
	private String bundleName;
	
	private MessagesDto messages;

	public TaskDto(String id, String title, TaskStatus status, int progress, Date scheduledDate, Date startWaitInQueueDate, Date startDate,
			Date endDate, Date updateDate, Date importDate, int importCount, String iconPath, String bundleName) {
		super();
		this.id = id;
		this.title = title;
		this.status = status;
		this.progress = progress;
		this.scheduledDate = scheduledDate;
		this.startWaitInQueueDate = startWaitInQueueDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.updateDate = updateDate;
		this.importDate = importDate;
		this.importCount = importCount;
		this.iconPath = iconPath;
		this.messages = new MessagesDto();
		this.bundleName = bundleName;
	}

	public String getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public TaskStatus getStatus() {
		return this.status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public Date getScheduledDate() {
		return this.scheduledDate;
	}

	public void setScheduledDate(Date scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getProgress() {
		return this.progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public String getIconPath() {
		return this.iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	public Date getStartWaitInQueueDate() {
		return startWaitInQueueDate;
	}

	public void setStartWaitInQueueDate(Date startWaitInQueueDate) {
		this.startWaitInQueueDate = startWaitInQueueDate;
	}

	public MessagesDto getMessages() {
		return messages;
	}

	public void setMessages(MessagesDto messages) {
		this.messages = messages;
	}

	public String getBundleName() {
		return bundleName;
	}

	public void setBundleName(String bundleName) {
		this.bundleName = bundleName;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getImportDate() {
		return importDate;
	}

	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}

	public int getImportCount() {
		return importCount;
	}

	public void setImportCount(int importCount) {
		this.importCount = importCount;
	}
}
