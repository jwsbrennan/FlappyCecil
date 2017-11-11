package gameComponents;

import java.awt.Component;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Cecil {

	public JLabel cecilPic;
	private GameController controller;
	
	
	public Cecil(String cecilPicURLorFileName, GameController controller) {
		this.controller = controller;
		ImageIcon pic = new ImageIcon(cecilPicURLorFileName);
		JLabel cecilPic = new JLabel(pic);
		controller.canvas.add(cecilPic);
		int x = controller.canvas.getWidth()/5;
		int y = controller.canvas.getHeight()/2;
		int width = pic.getIconWidth();
		int height = pic.getIconHeight();
		cecilPic.setBounds(x, y, width, height);
		
		
		controller.canvas.repaint();
	}
	
	public void jump() {
		//move the hero up and down in place 
	}
	
	
}
