package pong;

public class PongMain {

  public static void main(String[] args) {

    PongModel model = PongModelFactory.createModel2Players();
    PongGame pongGame = new PongGame(model);

    PongGamePanel gamePanel = PongGamePanelFactory.createGamePanel(model);
    PongWindow pongWindow = new PongWindow(gamePanel);

    pongWindow.setVisible(true);

    pongGame.startGame();
  }
}
