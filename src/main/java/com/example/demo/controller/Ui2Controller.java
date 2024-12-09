package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.navigation.NavigableApplication;

import javafx.scene.input.MouseEvent;

@Component
public class Ui2Controller {
	
	@Autowired
	public NavigableApplication navigableApplication;

	public void labelActionHandler(MouseEvent event) {
		System.out.println("Coucou from Ui2Controller");
		navigableApplication.goTo("home");
	}

}
