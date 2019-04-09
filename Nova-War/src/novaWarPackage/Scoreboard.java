package novaWarPackage;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Scoreboard extends BasicGameState {
	private int[] score = new int[3];
	//ArrayList<Integer> scores = new ArrayList<>();

	public Scoreboard(int state) {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		g.drawString("Scoreboard", 180, 10);
//		g.drawString(String.valueOf(scores.get(0)), 100, 100);
//		g.drawString(String.valueOf(scores.get(1)), 100, 120);
//		g.drawString(String.valueOf(scores.get(2)), 100, 140);
//		g.drawString(String.valueOf(scores.get(3)), 100, 160);
//		g.drawString(String.valueOf(scores.get(4)), 100, 180);
//		g.drawString(String.valueOf(scores.get(5)), 100, 200);
//		g.drawString(String.valueOf(scores.get(6)), 100, 220);
//		g.drawString(String.valueOf(scores.get(7)), 100, 240);
//		g.drawString(String.valueOf(scores.get(8)), 100, 260);
//		g.drawString(String.valueOf(scores.get(9)), 100, 280);
		g.drawString(String.valueOf(score[0]), 100, 100);

	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		// TODO Auto-generated method stub
//		if (Play.tank.getHp() <= 0) {
//			for (int i = 0; i < score.length; i++) {
//				if (i == 0 && Play.score >= scores.get(i + 1)) {
//					scores.add(0, Play.score);
//				} else if (Play.score <= scores.get(i - 1) && Play.score >= scores.get(i + 1)) {
//					scores.add(i, Play.score);
//				} else {
//					scores.add(10, Play.score);
//				}
//			}
//		}

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}

}
