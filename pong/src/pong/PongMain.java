package pong;

public class PongMain {

  public static void main(String[] args) {

    PongModel model = new PongModelFactory().createModel2Players();
    PongGamePanel gamePanel = new PongGamePanelFactory().createGamePanel(model);
    PongWindow pongWindow = new PongWindow(gamePanel);
    PongGame pongGame = new PongGame(model, gamePanel);
    pongWindow.addKeyListener(pongGame);

    pongWindow.setVisible(true);

    pongGame.startGame();
  }
}
