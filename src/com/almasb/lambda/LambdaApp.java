package com.almasb.lambda;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.paint.Color;

public class LambdaApp extends Application {

	private Pane root = new Pane();
	
	private Parent createContent() {
		root.setPrefSize(600, 600);
		return root;
	}
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Scene scene = new Scene(createContent());
		
/*		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				handlekeyEvent(event);
			}
			
		});
		
		scene.setOnKeyPressed((KeyEvent event) -> handlekeyEvent(event));
		
		scene.setOnKeyPressed(event -> handlekeyEvent(event));
		*/
		scene.setOnKeyPressed(this::handlekeyEvent);
		stage.setScene(scene);
		stage.show();

	}
	
	private void handlekeyEvent(KeyEvent event) {
		Text text = new Text(event.getCode().toString());
		text.setFont(Font.font(22));
		root.getChildren().add(text);
		
		Circle circle = new Circle(100);
		//circle.setTranslateX(300);
		//circle.setTranslateY(300);
		
/*		Shape shape = Shape.subtract(new Rectangle(100,100), circle);
		shape.setTranslateX(300);
		shape.setTranslateY(300);
		
		shape.setFill(Color.BLUE);
		root.getChildren().add(shape);
		*/
		
		//Line line = new Line(0,0,100,200);
		
		for (int i = 0; i <600; i+=10) {
			Line line1 = new Line(i,0,i,600);
			line1.setStroke(Color.LIGHTGRAY);
			Line line2 = new Line(0,i,600,i);
			line2.setStroke(Color.LIGHTGRAY);
			root.getChildren().addAll(line1,line2);
			
			
		}
		
		
		PathTransition pt = new PathTransition(Duration.seconds(2),circle,text);
		pt.setAutoReverse(true);
		pt.setCycleCount(Animation.INDEFINITE);
		pt.play();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		launch(args);
	}

}
