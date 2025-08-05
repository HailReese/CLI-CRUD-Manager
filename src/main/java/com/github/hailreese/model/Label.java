package com.github.hailreese.model;

public class Label {

	public Label(String name) {
		this.id = maxId + 1;
		this.name = name;
		this.status = Status.ACTIVE;
	}

	private static int maxId;
	private final int id;
	private String name;
	private Status status;

	public int getId() {
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
