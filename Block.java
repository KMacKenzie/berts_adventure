import java.util.ArrayList;
 
/**
 * A Block prevents the player from moving.
 * 
 */
public class Block {
    private double x, y, z;
    private double scale;
    private String desc;
    private String model;
    private String texture;
    private ArrayList<String> danceModels;
    private int frame;
    
    
    public Block(double x, double y, double z, String desc, double scale, String model, String texture) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.scale = scale;
        this.desc = desc;
        this.model = model;
        this.texture = texture;
        
        danceModels = new ArrayList<String>();
        danceModels.add("models/tux/tux_dance/xd_tux_dance_000100.obj");
        danceModels.add("models/tux/tux_dance/xd_tux_dance_000101.obj");
        danceModels.add("models/tux/tux_dance/xd_tux_dance_000102.obj");
        danceModels.add("models/tux/tux_dance/xd_tux_dance_000103.obj");
        danceModels.add("models/tux/tux_dance/xd_tux_dance_000104.obj");
        danceModels.add("models/tux/tux_dance/xd_tux_dance_000105.obj");
        danceModels.add("models/tux/tux_dance/xd_tux_dance_000106.obj");
        danceModels.add("models/tux/tux_dance/xd_tux_dance_000107.obj");
        danceModels.add("models/tux/tux_dance/xd_tux_dance_000108.obj");
        danceModels.add("models/tux/tux_dance/xd_tux_dance_000109.obj");
        danceModels.add("models/tux/tux_dance/xd_tux_dance_000110.obj");
        danceModels.add("models/tux/tux_dance/xd_tux_dance_000111.obj");
        danceModels.add("models/tux/tux_dance/xd_tux_dance_000112.obj");
        danceModels.add("models/tux/tux_dance/xd_tux_dance_000113.obj");
        danceModels.add("models/tux/tux_dance/xd_tux_dance_000114.obj");
        danceModels.add("models/tux/tux_dance/xd_tux_dance_000115.obj");
        danceModels.add("models/tux/tux_dance/xd_tux_dance_000116.obj");
        danceModels.add("models/tux/tux_dance/xd_tux_dance_000117.obj");
        danceModels.add("models/tux/tux_dance/xd_tux_dance_000118.obj");
        danceModels.add("models/tux/tux_dance/xd_tux_dance_000119.obj"); 
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
    public void setScale(double delta) {
        scale = delta;
    }   
    public void dance() {
            if (frame >= danceModels.size()) {
                frame = 0;
            }
            model = danceModels.get(frame);
            frame++;
        }
}
