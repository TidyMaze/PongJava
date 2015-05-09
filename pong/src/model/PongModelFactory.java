package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PongModelFactory {
  private static final double DEFAULT_BALL_DIAMETER = 2;
  List<PlayerType> playerTypes = Arrays.asList(PlayerType.LEFT_PLAYER, PlayerType.RIGHT_PLAYER);

  public PongModel createModel2Players() {
    ArrayList<Paddle> paddles = createPaddles();
    Ball ball = createBall();
    return new PongModel(paddles, ball);
  }

  private static Ball createBall() {
    return new Ball();
  }

  private ArrayList<Paddle> createPaddles() {
    ArrayList<Paddle> paddles = new ArrayList<>();
    for (PlayerType type : playerTypes)
      paddles.add(new Paddle(type));
    return paddles;
  }

}
