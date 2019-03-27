package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	
	public boolean rigth, left;
	public int x, y;
	public int width, height;
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 10;
	}
	
	public void tick() {
		if(rigth) {
			System.out.println("Entrei");
			x++;
		}else if(left) {
			x--;
		}
		
		if(x + width > Game.WIDTH) {
			x = Game.WIDTH - width;
		}else if(x < 0) {
			x= 0;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, 40, 10);
	}

}
