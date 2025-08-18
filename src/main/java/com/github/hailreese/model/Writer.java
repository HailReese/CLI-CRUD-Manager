package com.github.hailreese.model;

import java.util.ArrayList;
import java.util.List;

public class Writer {

	public Writer(String firstName, String lastName) {
		this.id = maxId + 1;
		this.firstName = firstName;
		this.lastName = lastName;
		this.postsId = new ArrayList<>();
		this.status = Status.ACTIVE;
	}

	private static long maxId;
	private final long id;
	private String firstName;
	private String lastName;
	private List<Long> postsId;
	private Status status;

	public long getId() {
		return this.id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Long> getPostsId() {
		return this.postsId;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
