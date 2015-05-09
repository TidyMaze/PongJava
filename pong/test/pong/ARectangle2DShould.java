package pong;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class ARectangle2DShould {

  @AfterClass
  public static void tearDownAfterClass() throws Exception {}

  private Rectangle2D.Double rectangle;

  @Before
  public void setUp() throws Exception {
    this.rectangle = new Rectangle2D.Double(0, 0, 50, 50);
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void seeIntersectionWhenInIntersection() {
    Double rectangleToIntersect = new Rectangle2D.Double(25, 0, 50, 50);
    assertTrue(rectangle.intersects(rectangleToIntersect));
  }

  @Test
  public void notSeeIntersectionWhenCloseButNotInIntersection() {
    Double rectangleToIntersect = new Rectangle2D.Double(50, 0, 50, 50);
    assertFalse(rectangle.intersects(rectangleToIntersect));
  }
}
