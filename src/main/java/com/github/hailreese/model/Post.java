package com.github.hailreese.model;

import java.util.ArrayList;
import java.util.List;

public class Post {

	public Post(String title, String content) {
		this.id = maxId + 1;
		this.labelsId = new ArrayList<>();
		this.status = Status.ACTIVE;
		this.title = title;
		this.content = content;
	}

	private static long maxId;
	private final long id;
	private String title;
	private String content;
	private List<Long> labelsId;
	private Status status;

	public long getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Long> getLabelsId() {
		return this.labelsId;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
