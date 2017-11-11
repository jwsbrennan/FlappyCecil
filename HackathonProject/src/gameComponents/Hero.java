package gameComponents;

import java.awt.Component;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Hero {

	public JLabel heroPic;
	public JLabel weaponPic;
	private GameController controller;
	
	
	public Hero(String heroPicURLorFileName, String weaponURL, GameController controller) {
		this.controller = controller;
		ImageIcon pic = new ImageIcon(heroPicURLorFileName);
		JLabel heroPic = new JLabel(pic);
		controller.canvas.add(heroPic);
		int x = controller.canvas.getWidth()/5;
		int y = controller.canvas.getHeight()/2;
		int width = pic.getIconWidth();
		int height = pic.getIconHeight();
		heroPic.setBounds(x, y, width, height);
		
		//set the weapon's initial position to be above the height of the enemies so it won't kill them,
		//and the weapon should initially be invisible.
		
		controller.canvas.repaint();
	}
	
	public void jump() {
		//move the hero up and down in place 
	}
	
	public void attack() {
		//make weapon visible
		//move weapon down so it is in front of the hero,
		//then do the attack animation using a while/for loop
		//move the weapon back up to its original starting place
		//make it invisible
		
	}
	
	
}
