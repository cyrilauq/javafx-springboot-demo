package com.example.demo;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.example.demo.DemoApplication.StageReadyEvent;
import com.example.demo.navigation.NavigableApplication;
import com.example.demo.navigation.NavigationRoutes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@Component
public class StageInitialiazer implements ApplicationListener<StageReadyEvent>, NavigableApplication {
	
	@Autowired
	public NavigationRoutes routes;
	
	private String applicationTitle;
	private ApplicationContext applicationContext;
	private Stage stage;
	
	public StageInitialiazer(@Value("${spring.application.ui.title}") String applicationTitle, ApplicationContext applicationContext) {
		this.applicationTitle = applicationTitle;
		this.applicationContext = applicationContext;
	}

	@Override
	public void onApplicationEvent(StageReadyEvent event) {
		stage = event.getStage();
		goTo("home");
		stage.setTitle(applicationTitle);
		stage.show();
	}

	@Override
	public void goTo(String sceneName) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(ResourceUtils.getURL("classpath:" + routes.getRoutePath(sceneName)));
			fxmlLoader.setControllerFactory(aClass -> applicationContext.getBean(aClass));
			Parent parent = fxmlLoader.load();
			stage.setScene(new Scene(parent, 800, 800));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
