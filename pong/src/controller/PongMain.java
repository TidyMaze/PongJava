package controller;

import model.PongModel;
import model.PongModelFactory;
import view.PongGamePanel;
import view.PongWindow;

public class PongMain {

	public static void main(String[] args) {

		PongModel model = new PongModelFactory().createModel2Players();
		PongGamePanel gamePanel = new PongGamePanel(model);
		PongWindow pongWindow = new PongWindow(gamePanel);
		PongGame pongGame = new PongGame(model, gamePanel);
		pongWindow.addKeyListener(pongGame);

		pongWindow.setVisible(true);
		pongGame.startGame();
	}
}
