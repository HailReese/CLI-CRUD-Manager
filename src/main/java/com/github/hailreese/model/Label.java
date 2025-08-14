package com.github.hailreese.model;

public class Label {

	public Label(String name) {
		this.id = maxId + 1;
		this.name = name;
		this.status = Status.ACTIVE;
	}

	private static long maxId;
	private final long id;
	private String name;
	private Status status;

	public long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
