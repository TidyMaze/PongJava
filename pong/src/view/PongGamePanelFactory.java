package view;

import model.PongModel;

public class PongGamePanelFactory {

  public PongGamePanel createGamePanel(PongModel model) {
    return new PongGamePanel(model);
  }
}
