package gameComponents;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;


public class GameController implements KeyListener{
	public JLayeredPane canvas;
	private JFrame frame;
	private String cecilURL;
	private String[] obstacleURLList;
	private Boolean gameOver = false;
	private int grade = 4;
	private ArrayList<Influence> onScreenInfluences;
	private Cecil ourCecil;
	private int influenceSpeed;
	
	/**
	 * Constructor for the GameController class
	 * @param canvas = the JFrame to put all the graphics on
	 * @param cURL = the URL of the image for the hero
	 * @param eURL1 = the URL of the image for one type of enemy
	 * @param eURL2 = the URL of the image for another type of enemy
	 */
	public GameController(JFrame canvas, String cURL, String obstacleURLList[]) {
		this.frame = canvas;
		this.canvas = new JLayeredPane();
		this.frame.add(this.canvas);
		this.frame.setSize(2250, 1500);
		this.frame.setVisible(true);
		this.canvas.setVisible(true);
		ImageIcon pic = new ImageIcon("pictures//background.png");
		JLabel bgPic = new JLabel(pic);
		bgPic.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
		this.canvas.add(bgPic, this.canvas.DEFAULT_LAYER);
		bgPic.setVisible(true);
		
		cecilURL = cURL;
		this.obstacleURLList = obstacleURLList;
		this.frame.addKeyListener(this);
		
		
		this.canvas.setVisible(false);
		JLabel instructions1 = new JLabel();
		JLabel instructions2 = new JLabel();
		JLabel instructions3 = new JLabel();
		JLabel instructions4 = new JLabel();
		JLabel instructions5 = new JLabel();
		this.frame.add(instructions1);
		this.frame.add(instructions2);
		this.frame.add(instructions3);
		this.frame.add(instructions4);
		this.frame.add(instructions5);
		instructions1.setText("In this game, you will play as Cecil the Sagehen. See how far you can go before you fail!");
		instructions2.setText("You must avoid touching the red boxes that represent negative influences in your life, ");
		instructions3.setText("while at the same time try to collect the green positive influence boxes.");
		instructions4.setText("Press Enter to begin the game");
		int h = this.frame.getHeight();
		instructions1.setBounds(375, h/2, 1500, 50);
		instructions2.setBounds(375, h/2 + 50, 1500, 50);
		instructions3.setBounds(375, h/2 + 100, 1500, 50);
		instructions4.setBounds(375, h/2 + 150, 1500, 50);
		instructions1.setVisible(true);
		instructions2.setVisible(true);
		instructions3.setVisible(true);
		instructions4.setVisible(true);
		Font myFont = new Font(instructions1.getFont().getName(), Font.PLAIN, 35);
		instructions1.setFont(myFont);
		instructions2.setFont(myFont);
		instructions3.setFont(myFont);
		instructions4.setFont(myFont);
		
		
	}
	
	private int play() {
		ourCecil = new Cecil(cecilURL, this);
		
		canvas.repaint();
		int count = 0;
		
		
		while(!gameOver) {
			//spawn enemies randomly and start them
			//move enemies faster somehow as count increases
			
			int waitTime;
			Random rand = new Random();
			waitTime = (rand.nextInt(7) + 1) * 15;
			int obstacleIndex = rand.nextInt(15);
			
			long startTime = System.currentTimeMillis();
			long elapsedTime = 0;
			while(elapsedTime < waitTime) {
				elapsedTime = (System.currentTimeMillis() - startTime)/1000;
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
		
		String fileList[] = new String[] {
				"pictures//1.png","pictures//2.png",
				"pictures//3.png","pictures//4.png",
				"pictures//5.png","pictures//6.png",
				"pictures//7.png","pictures//8.png",
				"pictures//9.png","pictures//10.png",
				"pictures//11.png","pictures//12.png",
				"pictures//13.png","pictures//14.png",
				"pictures//15.png","pictures//16.png"
		};
		
		GameController myGame = new GameController(new JFrame(), "pictures//cecilTransparent.png", 
				fileList );
		
		myGame.play();
		//create the start screen with instructions and high score on 'canvas'

		
		
		
		//make the start screen invisible when they press enter,
		//and then call play()
		//set the result of play to be the new high score 
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyCode() == 0) {
			ourCecil.jump();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}