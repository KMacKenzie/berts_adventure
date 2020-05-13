 /**
 * A pile of snow to pick up and restock on snowballs.
 * 
 */
public class SnowPile {
    private double x, y, z;
    private double scale;
    private String desc;
    private String model;
    private String texture;
    
    public SnowPile(double x, double y, double z, String desc, double scale, String model, String texture) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.scale = scale;
        this.desc = desc;
        this.model = model;
        this.texture = texture;
    }
 
    public void disappear() {
        x = 100;
    }
    public String getDesc() {
        return desc;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getZ() {
        return z;
    }
    public double getScale() {
        return scale;
    }
    public void dissapear() {
        y = 100;
    }
}
