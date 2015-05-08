package pong;

public class PongGamePanelFactory {

  public PongGamePanel createGamePanel(PongModel model) {
    return new PongGamePanel(model);
  }
}
