package com.github.hailreese.model;

import java.util.ArrayList;
import java.util.List;

public class Writer {

	private Writer() {
		this.id = maxId + 1;
		this.posts = new ArrayList<>();
		this.status = Status.ACTIVE;
	}

	public Writer(String firstName, String lastName) {
		this();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Writer(String firstName) {
		this();
		this.firstName = firstName;
		this.lastName = "None";
	}

	private static int maxId;
	private final int id;
	private String firstName;
	private String lastName;
	private List<Post> posts;
	private Status status;

	public int getId() {
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

	public List<Post> getPosts() {
		return this.posts;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
