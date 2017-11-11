package gameComponents;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;


public class GameController {
	public JFrame canvas;
	private String cecilURL;
	private String[] obstacleURLList;
	private Boolean gameOver = false;
	private int grade = 4;
	private ArrayList<Influence> onScreenInfluences;
	
	
	/**
	 * Constructor for the GameController class
	 * @param canvas = the JFrame to put all the graphics on
	 * @param cURL = the URL of the image for the hero
	 * @param eURL1 = the URL of the image for one type of enemy
	 * @param eURL2 = the URL of the image for another type of enemy
	 */
	public GameController(JFrame canvas, String cURL, String obstacleURLList[]) {
		this.canvas = canvas;
		canvas.setSize(1500, 1000);
		this.canvas.setVisible(true);
		cecilURL = cURL;
		this.obstacleURLList = obstacleURLList;
	}
	
	private int play() {
		Cecil ourCecil = new Cecil(cecilURL, this);
		
		canvas.repaint();
		int count = 0;
		//create action listeners for the space bar for jumping the cecil
		while(!gameOver) {
			//spawn enemies randomly and start them
			//move enemies faster somehow as count increases
			
			int waitTime;
			Random rand = new Random();
			waitTime = (rand.nextInt(7) + 1) * 15;
			int obstacleIndex = rand.nextInt(23);
			
			long startTime = System.currentTimeMillis();
			long elapsedTime = 0;
			while(elapsedTime < waitTime) {
				elapsedTime = System.currentTimeMillis() - startTime;
			}
			
			String myURL = obstacleURLList[obstacleIndex];
			Influence myInfluence = new Influence(ourCecil, myURL, this);
			myInfluence.start();
			
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
	
	public int getGrade() {
		return grade;
	}
	
	/**
	 * @pre => x = 1 or x = -1 
	 */	 
	public void changeGrade(int x) {
		grade += x;
		if(grade>4) {
			grade = 4;
		}else if(grade<0) {
			grade = 0;
		}else if(grade == 0) {
			endGame();
		}
	}
	
	public void removeInfluence() {
		onScreenInfluences.remove(0);
	}
	
	
	public static void main(String[] args) {
		//create a new GameController
		GameController myGame = new GameController(new JFrame(), "pictures//gmailicon.jpg", 
				new String[]{"https://cdn.shopify.com/s/files/1/1061/1924/products/Poop_Emoji_7b204f05-eec6-4496-91b1-351acc03d2c7_large.png?v=1480481059", 
				"https://ih1.redbubble.net/image.127399649.0849/flat,800x800,075,t.u3.jpg"} );
		myGame.play();
		//create the start screen with instructions and high score on 'canvas'
		//make the start screen invisible when they press enter,
		//and then call play()
		//set the result of play to be the new high score 
	}
	

}
