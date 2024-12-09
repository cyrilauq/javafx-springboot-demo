package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import javafx.application.Application;

@SpringBootApplication
public class DemoApplicationLauncher {

	public static void main(String[] args) {
		Application.launch(DemoApplication.class, args);
	}

}
