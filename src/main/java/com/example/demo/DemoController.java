package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.navigation.NavigableApplication;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

@Component
public class DemoController {
	
	@FXML // Tells that the field is populated from an fxml file
	public Label textLbl;
	
	@Autowired
	public NavigableApplication navigableApplication;
	
	// Will handle the click even from the fxml file on the event with the function name as a value
	public void labelActionHandler(MouseEvent event) {
		System.out.println("Coucou from DemoController");
		navigableApplication.goTo("ui2");
	}

}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         