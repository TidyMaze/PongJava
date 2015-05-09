package model;

import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PongModel {

  private List<Paddle> paddles;
  private Ball ball;
  private Map<RectangularShaped, MyDoubleRectangle2D> assosBoundingBoxes;
  private List<Wall> walls;
  public static final double BORDER_GAP_REL = 10.0;

  /**
   * Constructeur principal, prend en paramètres les composants du model
   * 
   * @param paddles liste des raquettes à utiliser dans la partie
   * @param ball balle à utiliser dans la partie
   */
  public PongModel(List<Paddle> paddles, Ball ball, List<Wall> walls) {
    this.paddles = paddles;
    this.ball = ball;
    this.walls = walls;
    this.assosBoundingBoxes = new HashMap<>();

    createRectangles();
  }

  private void createRectangles() {
    createWalls();
    createRectanglesForPaddles();
    createRectangleForBall();
  }

  private void createWalls() {
    for (Wall w : walls)
      assosBoundingBoxes.put(w, MyDoubleRectangle2DFactory.createRectangleFrom(w));
  }

  private void createRectangleForBall() {
    assosBoundingBoxes.put(ball, new MyDoubleRectangle2D());
  }

  private void createRectanglesForPaddles() {
    for (Paddle p : paddles)
      createRectangleFor(p);
  }

  private void createRectangleFor(Paddle p) {
    assosBoundingBoxes.put(p, new MyDoubleRectangle2D());
  }

  public List<Paddle> getPaddles() {
    return paddles;
  }

  public Ball getBall() {
    return ball;
  }

  public void update() {
    ball.update();
    updateRectangles();
  }

  private void updateRectangles() {
    updatePaddlesRectangles();
    updateBallRectangle();
  }

  private void updateBallRectangle() {
    Rectangle2D rectBall = this.assosBoundingBoxes.get(ball);
    rectBall.setRect(ball.getLeft(), ball.getTop(), ball.getDiameter(), ball.getDiameter());
    System.out.println("ball : " + rectBall);
  }

  private void updatePaddlesRectangles() {
    for (Paddle p : paddles)
      updatePaddleRectangle(p);
  }

  private void updatePaddleRectangle(Paddle p) {
    Rectangle2D rectPaddle = this.assosBoundingBoxes.get(p);
    rectPaddle.setRect(p.getLeft(), p.getTop(), p.getWidth(), p.getHeight());
    System.out.println("paddle " + p.getPlayerType() + " : " + rectPaddle);
  }

  /**
   * Calcule la position horizontale d'une raquette selon son type
   * 
   * @param type type de la raquete
   * @return position relative (0-100) de la raquette, en prenant en compte le décalage dû à la
   *         bordure
   * @throws RuntimeException Le type de joueur est invalide
   */
  public static double calculateHorizontalRelativePosition(PlayerType type) throws RuntimeException {
    HashMap<PlayerType, Double> map = new HashMap<>();
    map.put(PlayerType.LEFT_PLAYER, PongModel.BORDER_GAP_REL);
    map.put(PlayerType.RIGHT_PLAYER, 100.0 - PongModel.BORDER_GAP_REL);
    return map.get(type);
  }
}
