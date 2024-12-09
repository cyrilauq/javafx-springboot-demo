package com.example.demo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class DemoApplication extends Application {
	private ConfigurableApplicationContext applicationContext;
	
	@Override
	public void init() throws Exception {
		applicationContext = new SpringApplicationBuilder(DemoApplicationLauncher.class).run();
	}
	
	@Override
	public void stop() throws Exception {
		applicationContext.close();
		Platform.exit();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		applicationContext.publishEvent(new StageReadyEvent(primaryStage));
	}
	
	static class StageReadyEvent extends ApplicationEvent {

		private static final long serialVersionUID = -5757225594330285138L;

		public StageReadyEvent(Stage stage) {
			super(stage);
		}
		
		public Stage getStage() {
			return ((Stage) getSource());
		}
	}

}