package com.learning.reliasure.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "notification")
public class Notification {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "notification_type")
	private String type;

	@Column(name = "header")
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String header;

	@Column(name = "body")
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String body;

	public Notification() {
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Notification [id=" + id + ", type=" + type + ", header=" + header + ", body=" + body + "]";
	}

}
