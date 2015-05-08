package pong;

import java.util.ArrayList;
import java.util.Arrays;

public class PongModelFactory {

  public static PongModel createModel2Players() {
    ArrayList<Paddle> paddles = createPaddles();
    Ball ball = creatBall();

    return new PongModel(paddles, ball);
  }

  private static Ball creatBall() {
    Ball ball = new Ball();
    return ball;
  }

  private static ArrayList<Paddle> createPaddles() {
    ArrayList<Paddle> paddles = new ArrayList<>();
    for (PlayerType type : Arrays.asList(PlayerType.LEFT_PLAYER, PlayerType.RIGHT_PLAYER))
      paddles.add(new Paddle(type));
    return paddles;
  }

}
