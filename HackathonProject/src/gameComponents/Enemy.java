package gameComponents;

import javax.swing.JFrame;

public class Enemy {
	GameController controller;
	Hero hero;
	public Enemy(Hero hero, String url, GameController controller) {
		this.controller = controller;
		this.hero = hero;
		//spawn an enemy so it starts at the far right edge of the screen
	}
	
	public void start() {
		while(!controller.isOver()){
			//move left and check if it overlaps hero
			//if it does then call controller.endGame() and delete yourself
			//otherwise just keep moving until you move off the left side of the screen
			//and then delete yourself.
		}
	}
	
	
	
}
