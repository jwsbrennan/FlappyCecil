package gameComponents;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Cecil {

	public JLabel cecilPic;
	private GameController controller;
	private double velocity;
	private double acceleration;
	private int jumpCharge;
	private int x;
	private int y;
	int width;
	int height;
	int groundY;
	double gravity = -0.1;
	boolean moving;
	Timer timer;
	
	
	public Cecil(String cecilPicURLorFileName, GameController controller) {
		this.controller = controller;
		ImageIcon pic = new ImageIcon(cecilPicURLorFileName);
		cecilPic = new JLabel(pic);
		controller.canvas.add(cecilPic, controller.canvas.DRAG_LAYER);

		width = pic.getIconWidth();
		height = pic.getIconHeight();
		groundY = controller.canvas.getHeight() - height;
		x = 20;
		y = groundY;

		cecilPic.setBounds(x, groundY, width, height);
		moving = false;
		velocity = 0;
		acceleration = 0;
		jumpCharge = 2;
		controller.canvas.repaint();
		
		Timer timer = new Timer(30, animate);
		timer.setRepeats(true);
		timer.start();
		
	}
	
	ActionListener animate = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (velocity<0 && (y-velocity)>=groundY) {
				cecilPic.setBounds(x, groundY, width, height);
				velocity = 0;
				acceleration = 0;
				moving = false;
				jumpCharge = 2;
			} else if(!belowGround() && moving) {
				y -= velocity;
	        	cecilPic.setBounds(x, y, width, height);
				velocity += acceleration;
				acceleration += gravity;
			}
		}
	};
	
	private boolean belowGround() {
		return (y > groundY);
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getLeft() {
		return x;
	}
	
	public int getRight() {
		return (x + width);
	}
	
	public int getBottom() {
		return (y - height);
	}
	
	
	public void jump() {
		//move the hero up and down in place 
		if (jumpCharge > 0) {
			velocity = 25;
			acceleration = 0;
			moving = true;
			jumpCharge--;
		}
	}
	
	
}


