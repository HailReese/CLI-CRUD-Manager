package com.github.hailreese.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.github.hailreese.controller.WriterController;
import com.github.hailreese.model.Writer;

public class WriterView {

	public WriterView(WriterController writerController, Scanner scanner) {
		this.writerController = writerController;
		this.scanner = scanner;
	}

	private final WriterController writerController;
	private Scanner scanner;

	public void handleWriterView() {
		while (true) {
			System.out.println("\n=== МЕНЮ УПРАВЛЕНИЯ ПИСАТЕЛЯМИ ===");
			System.out.println("1. Создать писателя");
			System.out.println("2. Показать всех писателей");
			System.out.println("3. Показать писателя по его id");
			System.out.println("4. Редактировать писателя");
			System.out.println("5. Удалить писателя");
			System.out.println("0. Вернуться в главное меню");
			System.out.print("Выберите действие: ");

			try {
				int choice = scanner.nextInt();
				scanner.nextLine(); // очистка буфера

				switch (choice) {
					case 1 -> createWriter();
					case 2 -> showAllWriters();
					case 3 -> showWriterById();
					case 4 -> editWriter();
					case 5 -> deleteWriter();
					case 0 -> {
						System.out.println("Выход в главное меню...");
						return;
					}
					default -> System.out.println("Неверный выбор!");
				}
			} catch (InputMismatchException e) {
				System.out.println("Неверный выбор!");
				scanner.nextLine(); // очистка буфера
			}
		}
	}

	private void createWriter() {
		System.out.print("Введите имя писателя: ");
		String firstName = scanner.next().trim();
		System.out.print("Введите фамилию писателя: ");
		String lastName = scanner.next().trim();
		writerController.create(firstName, lastName);
	}

	private void showAllWriters() {
		List<Writer> list = writerController.readAll();
		for (var writer : list) {
			System.out.println(writer.toString());
		}
	}

	private void showWriterById() {
		System.out.print("Введите id писателя: ");
		try {
			Long id = scanner.nextLong();
			scanner.nextLine(); // очистка буфера

			if (writerController.readById(id).equals(null))
				new NullPointerException();

			System.out.println(writerController.readById(id).toString());
		} catch (InputMismatchException e) {
			System.out.println("Ошибка! Неверный формат данных.");
			scanner.nextLine(); // очистка буфера
		} catch (NullPointerException e) {
			System.out.println("Ошибка! Писателя с данным id не существует.");
		}
	}

	private void editWriter() {
		System.out.print("Введите id писателя: ");
		try {
			Long id = scanner.nextLong();
			scanner.nextLine(); // очистка буфера

			if (writerController.readById(id).equals(null))
				new NullPointerException();

			System.out.print("Введите новое имя писателя: ");
			String firstName = scanner.next().trim();
			System.out.print("Введите новую фамилию писателя: ");
			String lastName = scanner.next().trim();

			System.out.println("Новые данные писателя под id " + id + ": "
					+ writerController.update(id, firstName, lastName).toString());
		} catch (InputMismatchException e) {
			System.out.println("Ошибка! Неверный формат данных");
			scanner.nextLine(); // очистка буфера
		} catch (NullPointerException e) {
			System.out.println("Ошибка! Писателя с данным id не существует");
		}
	}

	private void deleteWriter() {
		System.out.print("Введите id писателя: ");
		try {
			Long id = scanner.nextLong();
			scanner.nextLine(); // очистка буфера

			if (writerController.readById(id).equals(null))
				new NullPointerException();

			writerController.deleteWriter(id);
			System.out.println("Писатель под id " + id + " успешно удален.");
		} catch (InputMismatchException e) {
			System.out.println("Неверный формат данных");
			scanner.nextLine(); // очистка буфера
		} catch (NullPointerException e) {
			System.out.println("Писателя с данным id не существует");
		}
	}
}
