import java.awt.Color;
public class Particle 
{
    // Add code to this method for Part 2 and Part 3
    public void move(double elapsedTime) {
     setXPosition(getXPosition() + (getXVelocity() * elapsedTime));
     setYVelocity(getYVelocity() - 0.1);
     setYPosition(getYPosition() + (getYVelocity() * elapsedTime));  
    }

    // Add code to this method for Part 5
    public void setRandomColor() {
        Color sparkle = new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
        setColor(sparkle);
    }

    // ----------------------------------------------------------
    // CLASS DEFINITIONS - DO NOT CHANGE ANY CODE BELOW THIS LINE

    public Particle(double _xPos, double _yPos, double _xVel, double _yVel) {
        this.xPosition = _xPos;
        this.yPosition = _yPos;
        this.xVelocity = _xVel;
        this.yVelocity = _yVel;
    }

    private Color color;
    public Color getColor() {
        return this.color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    private double xPosition;
    public void setXPosition(double xPosition) {
        this.xPosition = xPosition;
    }
    public double getXPosition() {
        return this.xPosition;
    }
    private double yPosition;
    public void setYPosition(double yPosition) {
        this.yPosition = yPosition;
    }
    public double getYPosition() {
        return this.yPosition;
    }
    private double xVelocity;
    public void setXVelocity(double xVelocity) {
        this.xVelocity = xVelocity;
    }
    public double getXVelocity() {
        return this.xVelocity;
    }
    private double yVelocity;
    public void setYVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }
    public double getYVelocity() {
        return this.yVelocity;
    }
}
