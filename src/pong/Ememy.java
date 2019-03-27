package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Ememy {
	
	public double x, y;
	public int width, height;
	
	public Ememy(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 10;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 40, 10);
	}
}
