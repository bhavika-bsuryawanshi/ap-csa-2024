import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class SimpleCanvas extends JPanel implements MouseListener
{
	int width;
	int height;
	
	long lastTime;
	
	ParticleSimulator simulator;
	
	public void mouseClicked(MouseEvent e)
	{
		simulator.mouseClicked((float)e.getX(),(float)e.getY());
	}
	
	public void mouseEntered(MouseEvent e) {}
	
	public void mouseExited(MouseEvent e) {}
	
	public void mousePressed(MouseEvent e) {}
	
	public void mouseReleased(MouseEvent e) {}
	
	public SimpleCanvas(int _width, int _height, ParticleSimulator _simulator)
	{
		width = _width;
		height = _height;
		simulator = _simulator;
		lastTime = -1L;
	}
	
	public void setupAndDisplay()
	{
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new JScrollPane(this));
		f.setSize(width,height);
		f.setLocation(200, 200);
		f.setVisible(true);
		this.addMouseListener(this);
	}

	protected void paintComponent(Graphics g) 
	{
		boolean first = (lastTime == -1L);
		long elapsedTime = lastTime - System.nanoTime();
		lastTime = System.nanoTime();
		g.setColor(Color.black);
		g.fillRect(0,0,width,height);
		g.setColor(Color.white);
		simulator.draw((Graphics2D)g,(first ? 0.0f: (float)elapsedTime/1e9f));
		repaint();
	}
	
	public void drawDot(Graphics2D g, float x, float y)
	{
		g.fillOval((int)(x+0.5f),(int)(y+0.5f),8,8);
	}
	public void drawDot(Graphics2D g, float x, float y, Color c) {
		g.setColor(c);
		drawDot(g, x, y);
	}

}
