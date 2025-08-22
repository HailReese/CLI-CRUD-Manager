package com.github.hailreese.repository.classes;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.github.hailreese.model.Status;
import com.github.hailreese.model.Writer;
import com.github.hailreese.repository.interfaces.WriterRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonWriterRepositoryImpl implements WriterRepository {

	private static final String filePath = Paths.get("src", "main", "resources", "WriterRepo.json").toString();
	private static final Type listTypeToken = new TypeToken<List<Writer>>() {
	}.getType();
	private final Gson gson = new Gson();

	@Override
	public Writer getById(Long id) {
		List<Writer> writers = readWriters();
		return writers.stream()
				.filter(e -> e.getId() == id)
				.filter(e -> e.getStatus().equals(Status.ACTIVE))
				.findFirst()
				.orElse(null);
	}

	@Override
	public List<Writer> getAll() {
		return readWriters();
	}

	@Override
	public Writer save(Writer entity) {
		try {
			List<Writer> writers = readWriters();
			writers.add(entity);

			Files.write(Paths.get(filePath), gson.toJson(writers, listTypeToken).getBytes());
			return entity;
		} catch (IOException e) {
			return null;
		}
	}

	@Override
	public Writer update(Writer entity) {
		try {
			List<Writer> writers = readWriters();
			writers.set((int) (entity.getId() - 1), entity);

			Files.write(Paths.get(filePath), gson.toJson(writers, listTypeToken).getBytes());
			return entity;
		} catch (IOException e) {
			return null;
		}
	}

	@Override
	public void deleteById(Long id) {
		try {
			List<Writer> writers = readWriters();
			Writer writer = getById(id);
			writer.setStatus(Status.DELETED);
			writers.set((int) (id - 1), writer);

			Files.write(Paths.get(filePath), gson.toJson(writers, listTypeToken).getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<Writer> readWriters() {
		List<Writer> temp;
		if (!Files.exists(Paths.get(filePath))) {
			try {
				Files.createFile(Paths.get(filePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return temp = new ArrayList<>();
		}
		try {
			temp = gson.fromJson(new String(Files.readAllBytes(Paths.get(filePath))), listTypeToken);
		} catch (IOException e) {
			return temp = new ArrayList<>();
		}
		if (temp == null) {
			return temp = new ArrayList<>();
		}
		return temp;
	}

	@Override
	public Long getMaxId() {
		List<Writer> list = readWriters();
		if (!list.isEmpty()) {
			Writer lastWriter = list.getLast();
			return lastWriter.getId();
		} else {
			return 0L;
		}
	}
}
