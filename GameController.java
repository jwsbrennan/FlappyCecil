package gameComponents;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;


public class GameController implements KeyListener, MouseListener{
	public JLayeredPane canvas;
	private JFrame frame;
	private String cecilURL;
	private Boolean gameOver = false;
	private int grade = 4;
	private ArrayList<Influence> onScreenInfluences;
	private Cecil ourCecil;
	protected int influenceSpeed = 10;
	private JLabel i1;
	private JLabel i2;
	private JLabel i3;
	private JLabel i4;
	private Random rand = new Random();
	private int hiScore = 0;
	private int score = 0;
	boolean started = false;
	private String fileList[] = new String[] {
			"pictures//1.png","pictures//2.png",
			"pictures//3.png","pictures//4.png",
			"pictures//5.png","pictures//6.png",
			"pictures//7.png","pictures//8.png",
			"pictures//9.png","pictures//10.png",
			"pictures//11.png","pictures//12.png",
			"pictures//13.png","pictures//14.png",
			"pictures//15.png","pictures//16.png"
	};
	JLabel hiScoreCounter;


	
	/**
	 * Constructor for the GameController class
	 * @param canvas = the JFrame to put all the graphics on
	 * @param cURL = the URL of the image for the hero
	 * @param eURL1 = the URL of the image for one type of enemy
	 * @param eURL2 = the URL of the image for another type of enemy
	 */
	public GameController(JFrame canvas, String cURL) {
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
		this.canvas.setVisible(false);

		cecilURL = cURL;
		this.frame.addKeyListener(this);
		
		hiScoreCounter = new JLabel();
		this.frame.add(hiScoreCounter);
		hiScoreCounter.setVisible(true);
		hiScoreCounter.setText("High Score: " + hiScore);
		hiScoreCounter.setBounds(1500, 50, 700, 150);
		Font scoreFont = new Font(hiScoreCounter.getFont().getName(), Font.PLAIN, 30);
		hiScoreCounter.setFont(scoreFont);
		
		
		i1 = new JLabel();
		i2 = new JLabel();
		i3 = new JLabel();
		i4 = new JLabel();
		JLabel instructions5 = new JLabel();
		this.frame.add(i1);
		this.frame.add(i2);
		this.frame.add(i3);
		this.frame.add(i4);
		this.frame.add(instructions5);
		i1.setText("In this game, you will play as Cecil the Sagehen. See how far you can go before you fail!");
		i2.setText("You must avoid touching the red boxes that represent negative influences in your life, ");
		i3.setText("while at the same time try to collect the green positive influence boxes.");
		i4.setText("Click anywhere to begin the game");
		int h = this.frame.getHeight();
		i1.setBounds(375, h/2, 1500, 50);
		i2.setBounds(375, h/2 + 50, 1500, 50);
		i3.setBounds(375, h/2 + 100, 1500, 50);
		i4.setBounds(375, h/2 + 150, 1500, 50);
		i1.setVisible(true);
		i2.setVisible(true);
		i3.setVisible(true);
		i4.setVisible(true);
		Font myFont = new Font(i1.getFont().getName(), Font.PLAIN, 35);
		i1.setFont(myFont);
		i2.setFont(myFont);
		i3.setFont(myFont);
		i4.setFont(myFont);
		
		this.frame.addMouseListener(this);
		
		influenceSpeed = 22;
		ourCecil = new Cecil(cecilURL, this);
		
	}
	
	private int play() {
		
		while(!started) {
			//Do nothing
			System.out.println(started);
		}
		
		
		Influence myInfluence = new Influence(ourCecil, fileList[1], false, this);
		
		canvas.repaint();
		score = 0;
		
		
		while(!gameOver) {
			//spawn enemies randomly and start them
			//move enemies faster somehow as count increases
			
			int waitTime;
			waitTime = (rand.nextInt(7) *100 + 1500);
			int obstacleIndex = rand.nextInt(15);
			
			long startTime = System.currentTimeMillis();
			long elapsedTime = 0;
			while(elapsedTime < waitTime) {
				elapsedTime = (new Date().getTime() - startTime);
			}
			
			String myURL = fileList[obstacleIndex];
			boolean goodness;
			if(obstacleIndex>9) {
				goodness = true;
			}else {
				goodness = false;
			}
			Influence notMyInfluence = new Influence(ourCecil, myURL, goodness, this);
			
		}
		return score;
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
	public void changeScore() {
		score += 100;
	}
	
	public void removeInfluence() {
		onScreenInfluences.remove(0);
	}
	
	
	public static void main(String[] args) {
		//create a new GameController
		

		
		GameController myGame = new GameController(new JFrame(), "pictures//cecilTransparent.png");
		
		int newScore = myGame.play();
		myGame.compareNewScore(newScore);
		//create the start screen with instructions and high score on 'canvas'

		
		
		
		//make the start screen invisible when they press enter,
		//and then call play()
		//set the result of play to be the new high score 
	}
	
	public void compareNewScore(int score) {
		if(score>hiScore) {
			hiScore = score;
		}
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

	@Override
	public void mouseClicked(MouseEvent e) {
		if(!started) {
			i1.setVisible(false);
			i2.setVisible(false);
			i3.setVisible(false);
			i4.setVisible(false);
			this.canvas.setVisible(true);
			started = true;
			
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
