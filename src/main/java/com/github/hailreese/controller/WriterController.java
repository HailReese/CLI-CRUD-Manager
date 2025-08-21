package com.github.hailreese.controller;

import java.util.List;

import com.github.hailreese.model.Writer;
import com.github.hailreese.repository.interfaces.WriterRepository;

public class WriterController {
	private final WriterRepository writerRepo;

	public WriterController(WriterRepository writerRepo) {
		this.writerRepo = writerRepo;
		Writer.setMaxId(writerRepo.getMaxId());
	}

	public void create(String firstName, String lastName) {
		Writer writer = new Writer(firstName, lastName);
		writerRepo.save(writer);
	}

	public List<Writer> readAll() {
		return writerRepo.getAll();
	}

	public Writer readById(Long id) {
		return writerRepo.getById(id);
	}

	public Writer update(Long id, String firstName, String lastName) {
		Writer writer = writerRepo.getById(id);
		writer.setFirstName(firstName);
		writer.setLastName(lastName);
		return writerRepo.update(writer);
	}

	public void deleteWriter(Long id) {
		writerRepo.deleteById(id);
	}
}
