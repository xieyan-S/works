package com.works.mms.entity;

import java.util.Date;

public class Message {

	private Integer id;
	private String title;
	private Integer senderId;
	private String sender;
	private Integer receiverId;
	private String receiver;
	private String content;
	private Date date;
	private boolean seen;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getSenderId() {
		return senderId;
	}
	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public Integer getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(Integer receiverId) {
		this.receiverId = receiverId;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isSeen() {
		return seen;
	}
	public void setSeen(boolean seen) {
		this.seen = seen;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", title=" + title + ", senderId=" + senderId + ", sender=" + sender
				+ ", receiverId=" + receiverId + ", receiver=" + receiver + ", content=" + content + ", date=" + date
				+ ", seen=" + seen + "]";
	}
	
}
