package gameComponents;

import javax.swing.JFrame;

//Thuan
public class GameController {
	public JFrame canvas;
	private String cecilURL;
	private String enemy1URL;
	private String enemy2URL;
	private Boolean gameOver = false;
	
	/**
	 * Constructor for the GameController class
	 * @param canvas = the JFrame to put all the graphics on
	 * @param cURL = the URL of the image for the hero
	 * @param eURL1 = the URL of the image for one type of enemy
	 * @param eURL2 = the URL of the image for another type of enemy
	 */
	public GameController(JFrame canvas, String cURL, String eURL1, String eURL2) {
		this.canvas = canvas;
		this.canvas.setVisible(true);
		cecilURL = cURL;
		enemy1URL = eURL1;
		enemy2URL = eURL2;
	}
	
	private int play() {
		Cecil ourCecil = new Cecil(cecilURL, this);
		int count = 0;
		//create action listeners for the space bar for jumping the cecil
		while(!gameOver) {
			//spawn enemies randomly and start them
			//move enemies faster somehow as count increases
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
		GameController myGame = new GameController(new JFrame(), "https://pbs.twimg.com/profile_images/839721704163155970/LI_TRk1z_400x400.jpg", 
				"https://cdn.shopify.com/s/files/1/1061/1924/products/Poop_Emoji_7b204f05-eec6-4496-91b1-351acc03d2c7_large.png?v=1480481059", 
				"https://ih1.redbubble.net/image.127399649.0849/flat,800x800,075,t.u3.jpg" );
		//create the start screen with instructions and high score on 'canvas'
		//make the start screen invisible when they press enter,
		//and then call play()
		//set the result of play to be the new high score 
	}
	

}
