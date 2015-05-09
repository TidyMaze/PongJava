package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class PongGamePanel extends JPanel implements Observer {

  private static final long serialVersionUID = 4807803417286222422L;

  private static final int BORDER_GAP_REL = 10;
  private static final int paddleWidth = 2;
  private PongModel pongModel;

  /**
   * Constructeur du panneau, prend le model utilisé pour l'affichage
   * 
   * @param model Model lié à la vue
   */
  public PongGamePanel(PongModel model) {
    this.pongModel = model;
    this.setBackground(Color.BLACK);
    pongModel.addObserver(this);
  }


  /**
   * Paint le panneau sur le graphics
   * 
   * @param g Graphics sur lequel on dessine
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    drawBackground(g);
    drawMovingParts(g);
  }

  /**
   * Dessine les parties mobile à l'écran
   * 
   * @param g Graphics sur lequel on dessine
   */
  private void drawMovingParts(Graphics g) {
    drawPaddles(g);
    drawBall(g);
  }

  /**
   * Dessine la balle à l'écran
   * 
   * @param g Graphics sur lequel on dessine
   */
  private void drawBall(Graphics g) {
    Ball ball = pongModel.getBall();
    drawBall(ball, g);
  }

  /**
   * Dessine une balle à l'écran
   * 
   * @param ball
   * @param g Graphics sur lequel on dessine
   */
  private void drawBall(Ball ball, Graphics g) {
    drawRelativeSquare(g, ball.getX(), ball.getY(), ball.getDiameter(), Color.WHITE);
  }


  /**
   * Dessine les raquettes à l'écran
   * 
   * @param g Graphics sur lequel on dessine
   */
  private void drawPaddles(Graphics g) {
    for (Paddle p : pongModel.getPaddles())
      drawPaddle(p, g);
  }

  /**
   * Dessine une raquette à l'écran
   * 
   * @param p la raquette à dessiner
   * @param g Graphics sur lequel on dessine
   */
  private void drawPaddle(Paddle p, Graphics g) {
    PlayerType type = p.getPlayerType();

    int horizontalRelPosition = calculateHorizontalRelativePosition(type);
    double verticalRelPosition = p.getVerticalRelativePosition();
    double paddleLength = p.getLength();

    drawRelativeRect(g, horizontalRelPosition, verticalRelPosition, paddleWidth, paddleLength,
        Color.WHITE);
  }

  /**
   * Dessine un rectangle, de la couleur choisie
   * 
   * @param g graphics sur lequel dessiner
   * @param x absisse du centre du rectangle relatif (0-100)
   * @param y ordonnee du centre du rectangle relatif (0-100)
   * @param diameter hauteur du rectangle relatif (0-100)
   * @param color couleur du rectangle
   */
  private void drawRelativeSquare(Graphics g, double x, double y, double diameter, Color color) {
    Color oldColor = changeColorAndSave(g, color);

    int absX = ConversionUtils.toAbsolute(x, this.getWidth());
    int absY = ConversionUtils.toAbsolute(y, this.getHeight());
    int absDiam =
        ConversionUtils.toAbsolute(diameter, CalcUtils.moy(this.getWidth(), this.getHeight()));

    int top = absY - absDiam / 2;
    int left = absX - absDiam / 2;

    g.fillRect(left, top, absDiam, absDiam);

    g.setColor(oldColor);
  }

  /**
   * Dessine un rectangle, de la couleur choisie
   * 
   * @param g graphics sur lequel dessiner
   * @param x absisse du centre du rectangle relatif (0-100)
   * @param y ordonnee du centre du rectangle relatif (0-100)
   * @param width épaisseur du rectangle relatif (0-100)
   * @param height hauteur du rectangle relatif (0-100)
   * @param color couleur du rectangle
   */
  private void drawRelativeRect(Graphics g, double x, double y, double width, double height,
      Color color) {
    Color oldColor = changeColorAndSave(g, color);

    int absX = ConversionUtils.toAbsolute(x, this.getWidth());
    int absY = ConversionUtils.toAbsolute(y, this.getHeight());
    int absW = ConversionUtils.toAbsolute(width, this.getWidth());
    int absH = ConversionUtils.toAbsolute(height, this.getHeight());

    int top = absY - absH / 2;
    int left = absX - absW / 2;

    g.fillRect(left, top, absW, absH);

    g.setColor(oldColor);
  }

  /**
   * Change la couleur du Graphics et retourne l'ancienne couleur
   * 
   * @param g Graphics dont on veut changer la couleur
   * @param color nouvelle couleur
   * @return l'ancienne couleur
   */
  private static Color changeColorAndSave(Graphics g, Color color) {
    Color oldColor = g.getColor();
    g.setColor(color);
    return oldColor;
  }

  /**
   * Calcule la position horizontale d'une raquette selon son type
   * 
   * @param type type de la raquete
   * @return position relative (0-100) de la raquette, en prenant en compte le décalage dû à la
   *         bordure
   * @throws RuntimeException Le type de joueur est invalide
   */
  private static int calculateHorizontalRelativePosition(PlayerType type) throws RuntimeException {
    switch (type) {
      case LEFT_PLAYER:
        return BORDER_GAP_REL;
      case RIGHT_PLAYER:
        return 100 - BORDER_GAP_REL;
      default:
        throw new RuntimeException("Type de joueur invalide : " + type);
    }
  }

  /**
   * Dessine le background du panneau de jeu
   * 
   * @param g Graphics sur lequel on dessine
   */
  private void drawBackground(Graphics g) {
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, this.getWidth(), this.getHeight());
  }


  @Override
  public void update(Observable o, Object arg) {
    this.repaint();
  }
}
