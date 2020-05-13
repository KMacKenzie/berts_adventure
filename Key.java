public class Key
{
    private double x, y, z;
    private double rotateY;
    private double scale;
   
    public Key(double x, double y, double z)

    {
        this.x = x;
        this.y = y;
        this.z = z;
        scale = 1;
    }
   
    /**
     * The method gets called every frame
     */
    public void move()
    {
        rotateY += 1;
    }  
    
    public void dissapear() {
        y = 900;
    }
    
    public double getScale() {
        return scale;
    }
    
    public double getValueZ() {
        return z;
    }
    public double getValueX() {
        return x;
    }
    public double getValueY() {
        return y;
    }
}
