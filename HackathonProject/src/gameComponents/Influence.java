package gameComponents;

import javax.swing.JFrame;

public class Influence {
	GameController controller;
	Cecil cecil;
	public Influence(Cecil cecil, String url, GameController controller) {
		this.controller = controller;
		this.cecil = cecil;
		//spawn an influence so it starts at the far right edge of the screen
	}
	
	public void start() {
		while(!controller.isOver()){
			//move left and check if it overlaps cecil
			//if it does then call controller.endGame() and delete yourself
			//otherwise just keep moving until you move off the left side of the screen
			//and then delete yourself.
		}
	}
	
	
	
}
