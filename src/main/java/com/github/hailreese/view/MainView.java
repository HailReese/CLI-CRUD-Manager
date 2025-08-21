package com.github.hailreese.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.github.hailreese.controller.WriterController;
import com.github.hailreese.repository.classes.GsonWriterRepositoryImpl;
import com.github.hailreese.repository.interfaces.WriterRepository;

public class MainView {
	private final Scanner scanner;
	private final WriterView writerView;
	// private final PostView postView;
	// private final LabelView labelView;

	public MainView() {
		this.scanner = new Scanner(System.in);
		// Инициализируем репозитории и контроллеры
		WriterRepository writerRepo = new GsonWriterRepositoryImpl();
		WriterController writerController = new WriterController(writerRepo);
		this.writerView = new WriterView(writerController, scanner);

	}

	public void showMainMenu() {
		while (true) {
			System.out.println("\n=== ГЛАВНОЕ МЕНЮ ===");
			System.out.println("1. Управление писателями");
			System.out.println("2. Управление постами");
			System.out.println("3. Управление метками");
			System.out.println("0. Выход");
			System.out.print("Выберите действие: ");

			try {
				int choice = scanner.nextInt();
				scanner.nextLine(); // очистка буфера

				switch (choice) {
					case 1 -> writerView.handleWriterView();
					// case 2 -> postView.showPostMenu();
					// case 3 -> labelView.showLabelMenu();
					case 0 -> {
						System.out.println("Выход...");
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
}
