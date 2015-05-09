package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PongModelFactory {
  List<PlayerType> playerTypes = Arrays.asList(PlayerType.LEFT_PLAYER, PlayerType.RIGHT_PLAYER);

  public PongModel createModel2Players() {
    ArrayList<Paddle> paddles = createPaddles();
    Ball ball = new Ball();
    return new PongModel(paddles, ball);
  }

  private ArrayList<Paddle> createPaddles() {
    ArrayList<Paddle> paddles = new ArrayList<>();
    for (PlayerType type : playerTypes)
      paddles.add(new Paddle(type));
    return paddles;
  }

}
