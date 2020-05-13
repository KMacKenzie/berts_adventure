
/**
 * Snowball to throw at bad penguins
 * 
 * @author Kenny M 
 * @version Oct 3rd
 */
public class SnowBall {
    // instance variables - replace the example below with your own
    private double x,y,z, speed, jumpStart, jumpSpeed, rotateY, rotateX, rotateZ, rotateSpeed, scale;
    private int counter;
    private String model, texture;



    public SnowBall(double x, double y, double z, double rotateY) {
        this.x = x+((float)(0.5*Math.sin(Math.PI*(rotateY-90)/180)));
        this.y = y;
        this.z = z+((float)(0.5*Math.cos(Math.PI*(rotateY-90)/180)));
        this.jumpStart = y;
        this.rotateY = rotateY;
        counter = 0;
        speed = 0.25;
        jumpSpeed = 0.05;
        model = "models/rocks/rock1.obj";
        texture = "textures/iceblockyellow.jpg";
        rotateSpeed = -3;
        scale = 0.1;
    }
    
    /**
     * The method used to throw snowballs
     */
    public void throwBall(double gravity) {
        x += (float)(speed*Math.sin(Math.PI*rotateY/180));
        z += (float)(speed*Math.cos(Math.PI*rotateY/180));
        y = (jumpStart+(jumpSpeed*counter))+(0.5*(-gravity)*counter*counter);
        counter++;
        rotateX += (float)(rotateSpeed*Math.sin(Math.PI*rotateY/180));
        rotateZ += (float)(rotateSpeed*Math.cos(Math.PI*rotateY/180));
    }
    
}
