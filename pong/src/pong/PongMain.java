package pong;

public class PongMain {

  public static void main(String[] args) {

    PongModel model = new PongModelFactory().createModel2Players();
    PongGame pongGame = new PongGame(model);

    PongGamePanel gamePanel = new PongGamePanelFactory().createGamePanel(model);
    PongWindow pongWindow = new PongWindow(gamePanel);

    pongWindow.setVisible(true);

    pongGame.startGame();
  }
}
