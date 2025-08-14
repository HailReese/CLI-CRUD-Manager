package com.github.hailreese.model;

import java.util.ArrayList;
import java.util.List;

public class Post {

	private Post() {
		this.id = maxId + 1;
		this.labels = new ArrayList<>();
		this.status = Status.ACTIVE;
	}

	public Post(String title, String content) {
		this();
		this.title = title;
		this.content = content;
	}

	public Post(String title) {
		this();
		this.title = title;
		this.content = "None";
	}

	private static long maxId;
	private final long id;
	private String title;
	private String content;
	private List<Label> labels;
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

	public List<Label> getLabels() {
		return this.labels;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
