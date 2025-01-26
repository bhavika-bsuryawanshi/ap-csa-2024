import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Launcher for the simulator. Do not edit any code in this file
 */

public class Main
{	
	public static void main(String[] args) throws Exception
	{  
		ArrayList<Particle> particles = new ArrayList<Particle>();
		ParticleSimulator simulator = new ParticleSimulator(particles);

		/* 1. Read in the 400 particles contained in particles.csv. */
		Scanner scanner = new Scanner(new File("particles.csv"));

		while (scanner.hasNextLine()) {
			String[] line = scanner.nextLine().split(",");
			particles.add(new Particle(Double.parseDouble(line[0]), Double.parseDouble(line[1]), Double.parseDouble(line[2]), Double.parseDouble(line[3])));
		}
		scanner.close();
		simulator.play();
	}	
}
