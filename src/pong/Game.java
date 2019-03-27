package pong;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Game extends Canvas implements Runnable, KeyListener{
	
	public static int WIDTH = 240;
	public static int HEIGHT = 120;
	public static int SCALE = 3;
	
	public BufferedImage layer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	
	public Player player;
	public Ememy ememy;
	
	public Game() {
		this.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		this.addKeyListener(this);
		player = new Player(100, HEIGHT-10);
		ememy = new Ememy(100, 0);
	}
	
	public static void main(String[] args){
		
		Game game = new Game();
		JFrame frame = new JFrame("Pong");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(game);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		new Thread(game).start();
	}
	
	public void tick() {
		player.tick();
		ememy.tick();		
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = layer.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		player.render(g);
		ememy.render(g);
		
		g = bs.getDrawGraphics();
		g.drawImage(layer, 0, 0, WIDTH*SCALE, HEIGHT*SCALE, null);
		
		bs.show();
	}

	@Override
	public void run() {
		while(true) {
			tick();
			render();
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.rigth = true;
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = true;
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.rigth = false;
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = false;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
