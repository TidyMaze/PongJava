package pong;

public class PongGamePanelFactory {

  public static PongGamePanel createGamePanel(PongModel model) {
    return new PongGamePanel(model);
  }
}
