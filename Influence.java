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
	
	public Influence(Cecil cecil, String url, GameController controller) {
		this.controller = controller;
		this.cecil = cecil;
		
		pic = new ImageIcon(url);
		influencePic = new JLabel(pic);
		controller.canvas.add(influencePic);
		
		canvasHeight = controller.canvas.getWidth();
		canvasWidth = controller.canvas.getHeight();
		myWidth = pic.getIconWidth();
		myHeight = pic.getIconHeight();
		
		x = canvasHeight;
		y = canvasWidth - myWidth;
		influencePic.setBounds(x, y, myWidth, myHeight);
		moving = true;
		velocity = controller.influenceSpeed;
		
		System.out.println("influence created");
		
		timer = new Timer(30, animate);
		timer.setRepeats(true);
		timer.start();
		//spawn an influence so it starts at the far right edge of the screen
	}
	
	ActionListener animate = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if ((y+myWidth) <= 0) {
				moving = false;
				timer.stop();
				controller.removeInfluence();
			}
			if (moving) {
				x -= velocity;
				influencePic.setBounds(x, y, myWidth, myHeight);
			}
				
		}
	};
}
	
	
	

