package gameComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Influence {
	GameController controller;
	Cecil cecil;
	boolean good;
	
	int CecilZoneStart;
	int CecilZoneEnd;

	private double velocity;
	
	private int x;
	private int y;
	
	boolean moving;
	int canvasHeight;
	int canvasWidth;
	int myWidth;
	int myHeight;
	ImageIcon pic;
	JLabel influencePic;
	Timer timer;
	
	public Influence(Cecil cecil, String url, boolean good, GameController controller) {
		this.controller = controller;
		this.cecil = cecil;
		this.good = good;
		
		pic = new ImageIcon(url);
		influencePic = new JLabel(pic);
		controller.canvas.add(influencePic, controller.canvas.DRAG_LAYER);
		
		canvasHeight = controller.canvas.getHeight();
		canvasWidth = controller.canvas.getWidth();
		myWidth = pic.getIconWidth();
		myHeight = pic.getIconHeight();
		
		x = canvasWidth;
		y = canvasHeight - myHeight;
		influencePic.setBounds(x, y, myWidth, myHeight);
		moving = true;
		velocity = controller.influenceSpeed;
				
		timer = new Timer(30, animate);
		timer.setRepeats(true);
		timer.start();
		//spawn an influence so it starts at the far right edge of the screen
	}
	
	ActionListener animate = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if ((y+myHeight) <= 0) {
				moving = false;
				timer.stop();
				controller.removeInfluence();
			}
			if (moving) {
				x -= velocity;
				influencePic.setBounds(x, y, myWidth, myHeight);
				if((x< cecil.getRight())||((x + myWidth)> cecil.getLeft())) {
					if(y< cecil.getBottom()) {
						if(good) {
							controller.changeScore();
							System.out.println("Score increased!");
						}else {
							controller.endGame();
							System.out.println("You lose!");
						}
					}
				}
				//check if influence is in the range of cecils x value and if cecils height is low enough to overlap.
			}
				
		}
	};
}
