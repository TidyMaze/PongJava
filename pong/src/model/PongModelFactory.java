package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PongModelFactory {
	List<PlayerType> playerTypes = Arrays.asList(PlayerType.LEFT_PLAYER, PlayerType.RIGHT_PLAYER);

	public PongModel createModel2Players() {
		List<Paddle> paddles = createPaddles();
		Ball ball = new Ball();
		List<Wall> walls = createWalls();
		return new PongModel(paddles, ball, walls);
	}

	private static List<Wall> createWalls() {
		return Arrays.stream(Position.values())
				.map(p -> WallFactory.createWall(p))
				.collect(Collectors.toList());
	}

	private List<Paddle> createPaddles() {
		return playerTypes.stream().map(Paddle::new).collect(Collectors.toList());
	}
}
