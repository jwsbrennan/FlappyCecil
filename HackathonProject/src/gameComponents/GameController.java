package gameComponents;

import javax.swing.JFrame;

public class GameController {
	public JFrame canvas;
	private String heroURL;
	private String weaponURL;
	private String enemy1URL;
	private String enemy2URL;
	private Boolean gameOver = false;
	
	/**
	 * Constructor for the GameController class
	 * @param canvas = the JFrame to put all the graphics on
	 * @param hURL = the URL of the image for the hero
	 * @param wURL = the URL of the image for the hero's weapon
	 * @param eURL1 = the URL of the image for one type of enemy
	 * @param eURL2 = the URL of the image for another type of enemy
	 */
	public GameController(JFrame canvas, String hURL, String wURL, String eURL1, String eURL2) {
		this.canvas = canvas;
		heroURL = hURL;
		weaponURL = wURL;
		enemy1URL = eURL1;
		enemy2URL = eURL2;
	}
	
	private int play() {
		Hero ourHero = new Hero(heroURL, weaponURL, this);
		int count = 0;
		//create action listeners for the space bar for jumping the hero
		//and for the 'a' key to attack
		while(!gameOver) {
			//spawn enemies randomly and start them
			//spawn more or different enemies as count increases
			count++;
		}
		return count;
	}
	
	public Boolean isOver() {
		return gameOver;
	}
	
	public void endGame() {
		gameOver = true;
	}
	
	public static void main(String[] args) {
		//create a new GameController
		GameController myGame = new GameController(new JFrame(), "google.com", "bing.com", "facebook.com", )
		//create the start screen with instructions and high score on 'canvas'
		//make the start screen invisible when they press enter,
		//and then call play()
		//set the result of play to be the new high score 
	}
	

}
