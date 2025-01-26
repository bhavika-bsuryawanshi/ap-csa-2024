import java.awt.Graphics2D;
import java.util.ArrayList;

public class ParticleSimulator 
{
	/* Main drawing canvas */
	SimpleCanvas canvas;
	ArrayList<Particle> particles;
	
	/* Constructor */
	public ParticleSimulator(ArrayList<Particle> _particles)
	{
		/* Create canvas object with 500x500 spatial dimensions. */
		particles = _particles;
		canvas = new SimpleCanvas(500,500,this);
	}	

	/* This function is called automatically whenever the user clicks 
	 * anywhere in the window using the mouse. */
	public void mouseClicked(float x, float y)
	{
		/* In this starter code the coordinates are simply output to the console. */ 
		System.out.println(x + "," + y);
		for (int i = 0; i < 20; i++) {
			particles.add(generateParticle(x, y));
		}
	}
   
   // Add code to this method for Part 4
    public static Particle generateParticle(double mouseX, double mouseY) {
        double rangeX = (int) (Math.random() * 720 ) - 360;
        double rangeY = (int) (Math.random() * 720 ) - 360;
        Particle x = new Particle(mouseX, mouseY, rangeX, rangeY);
        return x;
    }
	
	/* This is the main drawing function that is automatically called
	 * whenever the canvas is ready to be redrawn. The 'elapsedTime' argument
	 * is the time, in seconds, since the last time this function was called. */
	public void draw(Graphics2D g, float elapsedTime) {
		for (Particle particle : particles) {
			particle.move(elapsedTime);
			//canvas.drawDot(g, (float)particle.getXPosition(), (float)particle.getYPosition());
			particle.setRandomColor();
			canvas.drawDot(g, (float)particle.getXPosition(), (float)particle.getYPosition(), particle.getColor());
		}
	}
	
	/* This function runs the simulator. */
	public void play() {
		canvas.setupAndDisplay();
	}
}
