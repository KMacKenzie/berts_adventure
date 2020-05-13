import java.util.ArrayList;

/**
 * A penguin class to be used in various games.
 * 
 * @Author: Kenny Mackenzie
 * @Version: 2010-09-21
 */

public class Penguin
{
    private double x, y, z;
    private String texture;
    private String model;
    private double rotateY;
    private double rotateZ;
    private int counter;
    private ArrayList<String> walkModels;
    private ArrayList<String> shakeModels;
    private ArrayList<String> dieModels;
    private ArrayList<String> danceModels;
    private ArrayList<String> jumpModels;
    private ArrayList<String> fallModels;
    private int frame;
    private double scale;
    private double speed;
    private double jumpSpeed;
    private double prev_x, prev_y, prev_z;
    private double roomWidth, roomDepth;
    private double jumpStart;
    private boolean moving;
    private boolean turning;
    private boolean falling;
    private boolean jumping;
    private boolean actuallyFalling;

        
    public Penguin(double x, double y, double z, String texture) {
        counter = 0;
        this.x = x;
        this.y = y;
        this.z = z;
        this.prev_x = x;
        this.prev_y = y;
        this.prev_z = z;
        moving = false;
        turning = false;
        falling = false;
        jumping = false;
        actuallyFalling = false;

        
        this.texture = texture;
        scale = 1.85;
        speed = 0.05;
        jumpSpeed = 0.1;
                
        walkModels = new ArrayList<String>();
        walkModels.add("models/tux/tux_walk/xd_tux_walk_000025.obj");
        walkModels.add("models/tux/tux_walk/xd_tux_walk_000026.obj");
        walkModels.add("models/tux/tux_walk/xd_tux_walk_000027.obj");
        walkModels.add("models/tux/tux_walk/xd_tux_walk_000028.obj");
        walkModels.add("models/tux/tux_walk/xd_tux_walk_000029.obj");
        walkModels.add("models/tux/tux_walk/xd_tux_walk_000030.obj");
        walkModels.add("models/tux/tux_walk/xd_tux_walk_000031.obj");
        walkModels.add("models/tux/tux_walk/xd_tux_walk_000032.obj");
        walkModels.add("models/tux/tux_walk/xd_tux_walk_000033.obj");
        walkModels.add("models/tux/tux_walk/xd_tux_walk_000034.obj");
        walkModels.add("models/tux/tux_walk/xd_tux_walk_000035.obj");
        walkModels.add("models/tux/tux_walk/xd_tux_walk_000036.obj");
        walkModels.add("models/tux/tux_walk/xd_tux_walk_000037.obj");
        walkModels.add("models/tux/tux_walk/xd_tux_walk_000038.obj");
        walkModels.add("models/tux/tux_walk/xd_tux_walk_000039.obj");
        walkModels.add("models/tux/tux_walk/xd_tux_walk_000040.obj");
        walkModels.add("models/tux/tux_walk/xd_tux_walk_000041.obj");
        walkModels.add("models/tux/tux_walk/xd_tux_walk_000042.obj");
        walkModels.add("models/tux/tux_walk/xd_tux_walk_000043.obj");
        walkModels.add("models/tux/tux_walk/xd_tux_walk_000044.obj");
        
        
        shakeModels = new ArrayList<String>();
        shakeModels.add("models/tux/tux_shake/xd_tux_shake_000050.obj");
        shakeModels.add("models/tux/tux_shake/xd_tux_shake_000051.obj");
        shakeModels.add("models/tux/tux_shake/xd_tux_shake_000052.obj");
        shakeModels.add("models/tux/tux_shake/xd_tux_shake_000053.obj");
        shakeModels.add("models/tux/tux_shake/xd_tux_shake_000054.obj");
        shakeModels.add("models/tux/tux_shake/xd_tux_shake_000055.obj");
        shakeModels.add("models/tux/tux_shake/xd_tux_shake_000056.obj");
        shakeModels.add("models/tux/tux_shake/xd_tux_shake_000057.obj");
        shakeModels.add("models/tux/tux_shake/xd_tux_shake_000058.obj");
        shakeModels.add("models/tux/tux_shake/xd_tux_shake_000059.obj");
        shakeModels.add("models/tux/tux_shake/xd_tux_shake_000060.obj");
        shakeModels.add("models/tux/tux_shake/xd_tux_shake_000061.obj");
        shakeModels.add("models/tux/tux_shake/xd_tux_shake_000062.obj");
        shakeModels.add("models/tux/tux_shake/xd_tux_shake_000063.obj");
        shakeModels.add("models/tux/tux_shake/xd_tux_shake_000064.obj");
        shakeModels.add("models/tux/tux_shake/xd_tux_shake_000065.obj");
        shakeModels.add("models/tux/tux_shake/xd_tux_shake_000066.obj");
        shakeModels.add("models/tux/tux_shake/xd_tux_shake_000067.obj");
        shakeModels.add("models/tux/tux_shake/xd_tux_shake_000068.obj");
        shakeModels.add("models/tux/tux_shake/xd_tux_shake_000069.obj"); 

        dieModels = new ArrayList<String>();
        dieModels.add("models/tux/tux_die/xd_tux_die_000075.obj");
        dieModels.add("models/tux/tux_die/xd_tux_die_000076.obj");
        dieModels.add("models/tux/tux_die/xd_tux_die_000077.obj");
        dieModels.add("models/tux/tux_die/xd_tux_die_000078.obj");
        dieModels.add("models/tux/tux_die/xd_tux_die_000079.obj");
        dieModels.add("models/tux/tux_die/xd_tux_die_000080.obj");
        dieModels.add("models/tux/tux_die/xd_tux_die_000081.obj");
        dieModels.add("models/tux/tux_die/xd_tux_die_000082.obj");
        dieModels.add("models/tux/tux_die/xd_tux_die_000083.obj");
        dieModels.add("models/tux/tux_die/xd_tux_die_000084.obj");
        dieModels.add("models/tux/tux_die/xd_tux_die_000085.obj");
        dieModels.add("models/tux/tux_die/xd_tux_die_000086.obj");
        dieModels.add("models/tux/tux_die/xd_tux_die_000087.obj");
        dieModels.add("models/tux/tux_die/xd_tux_die_000088.obj");
        dieModels.add("models/tux/tux_die/xd_tux_die_000089.obj");
        dieModels.add("models/tux/tux_die/xd_tux_die_000090.obj");
        dieModels.add("models/tux/tux_die/xd_tux_die_000091.obj");
        dieModels.add("models/tux/tux_die/xd_tux_die_000092.obj");
        dieModels.add("models/tux/tux_die/xd_tux_die_000093.obj");
        dieModels.add("models/tux/tux_die/xd_tux_die_000094.obj");
        
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

        jumpModels = new ArrayList<String>();
        jumpModels.add("models/tux/tux_jump/xd_tux_jump_000125.obj");
        jumpModels.add("models/tux/tux_jump/xd_tux_jump_000126.obj");
        jumpModels.add("models/tux/tux_jump/xd_tux_jump_000127.obj");
        jumpModels.add("models/tux/tux_jump/xd_tux_jump_000128.obj");
        jumpModels.add("models/tux/tux_jump/xd_tux_jump_000129.obj");
        jumpModels.add("models/tux/tux_jump/xd_tux_jump_000130.obj");
        jumpModels.add("models/tux/tux_jump/xd_tux_jump_000131.obj");
        jumpModels.add("models/tux/tux_jump/xd_tux_jump_000132.obj");
        jumpModels.add("models/tux/tux_jump/xd_tux_jump_000133.obj");
        jumpModels.add("models/tux/tux_jump/xd_tux_jump_000134.obj");
        jumpModels.add("models/tux/tux_jump/xd_tux_jump_000135.obj");
        jumpModels.add("models/tux/tux_jump/xd_tux_jump_000136.obj");
        jumpModels.add("models/tux/tux_jump/xd_tux_jump_000137.obj");
        jumpModels.add("models/tux/tux_jump/xd_tux_jump_000138.obj");
        jumpModels.add("models/tux/tux_jump/xd_tux_jump_000139.obj");
        jumpModels.add("models/tux/tux_jump/xd_tux_jump_000140.obj");
        jumpModels.add("models/tux/tux_jump/xd_tux_jump_000141.obj");
        jumpModels.add("models/tux/tux_jump/xd_tux_jump_000142.obj");
        jumpModels.add("models/tux/tux_jump/xd_tux_jump_000143.obj");
        jumpModels.add("models/tux/tux_jump/xd_tux_jump_000144.obj"); 

        fallModels = new ArrayList<String>();
        fallModels.add("models/tux/tux_fall/xd_tux_fall_000150.obj");
        fallModels.add("models/tux/tux_fall/xd_tux_fall_000151.obj");
        fallModels.add("models/tux/tux_fall/xd_tux_fall_000152.obj");
        fallModels.add("models/tux/tux_fall/xd_tux_fall_000153.obj");
        fallModels.add("models/tux/tux_fall/xd_tux_fall_000154.obj");
        fallModels.add("models/tux/tux_fall/xd_tux_fall_000155.obj");
        fallModels.add("models/tux/tux_fall/xd_tux_fall_000156.obj");
        fallModels.add("models/tux/tux_fall/xd_tux_fall_000157.obj");
        fallModels.add("models/tux/tux_fall/xd_tux_fall_000158.obj");
        fallModels.add("models/tux/tux_fall/xd_tux_fall_000159.obj");
        fallModels.add("models/tux/tux_fall/xd_tux_fall_000160.obj");
        fallModels.add("models/tux/tux_fall/xd_tux_fall_000161.obj");
        fallModels.add("models/tux/tux_fall/xd_tux_fall_000162.obj");
        fallModels.add("models/tux/tux_fall/xd_tux_fall_000163.obj");
        fallModels.add("models/tux/tux_fall/xd_tux_fall_000164.obj");
        fallModels.add("models/tux/tux_fall/xd_tux_fall_000165.obj");
        fallModels.add("models/tux/tux_fall/xd_tux_fall_000166.obj");
        fallModels.add("models/tux/tux_fall/xd_tux_fall_000167.obj");
        fallModels.add("models/tux/tux_fall/xd_tux_fall_000168.obj");
        fallModels.add("models/tux/tux_fall/xd_tux_fall_000169.obj");
        

        frame = 0;
        model = walkModels.get(frame);
    }
    public void resetCounter() {
        counter = 0;
    }
    public void setFrame(int value) {
        frame = value;
    }
    public double getScale() {
        return scale;
    }
    public double getSpeed() {
        return speed;
    }
    public void setMoving(boolean value) {
        moving = value;
    }
    public boolean getMoving() {
        return moving;
    }
    public void setTurning(boolean value) {
        turning = value;
    }
    public boolean getTurning() {
        return turning;
    }
    public void setJumping(boolean value) {
        jumping = value;
    }
    public boolean getJumping() {
        return jumping;
    }
    public void setFalling(boolean value) {
        falling = value;
    }
    public boolean getFalling() {
        return falling;
    }
    public void setJumpStart(double ground) {
        jumpStart = ground;
    }
    public double getJumpStart() {
        return jumpStart;
    }
    public void setActuallyFalling(boolean value) {
        actuallyFalling = value;
    }
    public void moveDown() {
        prev_z = z;
        prev_x = x;
        prev_y = y;
        x -= ((float)(speed*Math.sin(Math.PI*rotateY/180)));
        z -= ((float)(speed*Math.cos(Math.PI*rotateY/180)));
        if (!actuallyFalling && !jumping) {
            frame = frame + 1;
            if (frame >= walkModels.size()) {
                frame = 0;
            }
            model = walkModels.get(frame);
        }
    }
    public void moveUp() {
        prev_z = z;
        prev_x = x;
        prev_y = y;
        x += ((float)(speed*Math.sin(Math.PI*rotateY/180)));
        z += ((float)(speed*Math.cos(Math.PI*rotateY/180)));
        if (!actuallyFalling && !jumping) {
            frame = frame + 1;
            if (frame >= walkModels.size()) {
                frame = 0;
            }
            model = walkModels.get(frame);
        }
    }
    public void turnRight() {
        prev_z = z;
        prev_x = x;
        prev_y = y;
        rotateY -= 3;
        if (!moving && !actuallyFalling && !jumping) {
            frame = frame + 1;
            if (frame >= walkModels.size()) {
                frame = 0;
            }
            model = walkModels.get(frame);
        }
    }
    public void turnLeft() {
        prev_z = z;
        prev_x = x;
        prev_y = y;
        rotateY += 3;
        if (!moving && !actuallyFalling && !jumping) {
            frame = frame + 1;
            if (frame >= walkModels.size()) {
                frame = 0;
            }
            model = walkModels.get(frame);
        }
    }
    public void strafeLeft() {
        prev_z = z;
        prev_x = x;
        prev_y = y;
        x += ((float)(speed*Math.sin(Math.PI*(rotateY+90)/180)));
        z += ((float)(speed*Math.cos(Math.PI*(rotateY+90)/180)));
        if (!moving && !actuallyFalling && !jumping && !turning) {
            frame = frame + 1;
            if (frame >= walkModels.size()) {
                frame = 0;
            }
            model = walkModels.get(frame);
        }
    }
    public void strafeRight() {
        prev_z = z;
        prev_x = x;
        prev_y = y;
        x += ((float)(speed*Math.sin(Math.PI*(rotateY-90)/180)));
        z += ((float)(speed*Math.cos(Math.PI*(rotateY-90)/180)));
        if (!moving && !actuallyFalling && !jumping && !turning) {
            frame = frame + 1;
            if (frame >= walkModels.size()) {
                frame = 0;
            }
            model = walkModels.get(frame);
        }
    }
    public void jump(double gravity) {
        y = (jumpStart+(jumpSpeed*counter))+(0.5*(-gravity)*counter*counter);
        counter++;
        frame++;
        if (frame < 19) {
            model = jumpModels.get(frame);
            counter--;
        }
        if (jumpSpeed*counter < 0.5*(gravity)*counter*counter*2) {
            counter = 0;
            jumping = false;
        }
    }
    public void fall(double gravity) {
        if (!jumping) {
            actuallyFalling = false;
            prev_y = y;
            y = y+(-gravity)*counter;
            counter++;
            if (counter > 10) {
                actuallyFalling = true;
                frame = frame + 1;
                if (frame >= fallModels.size()) {
                    frame = 0;
                }
                model = fallModels.get(frame);
            }
        }
    }
    public void revert() {
        x = prev_x;
        z = prev_z;
        y = prev_y;
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
    public void setValueY(double newY) {
        y = newY;
    }
    public void changeTexture(String newTexture) {
        texture = newTexture;
    }
    public double getRotateY() {
        return rotateY;
    }
    public void setRotateY(double ang) {
        rotateY = ang;
    }
    public void isDead() { //penguin has died, flops on its side with cross eyes.
        texture = "models/tux/tux_dead.png";
        frame = frame + 1;
            if (frame >= dieModels.size()) {
                frame = 0;
                model = dieModels.get(frame);
            }
        rotateY = 0;
    }
    public void dance() { //penguin found his lover, dance!
            frame = frame + 1;
            if (frame >= danceModels.size()) {
                frame = 0;
                model = danceModels.get(frame);
            }
    }
    public void shake() {
            frame = frame + 1;
            if (frame >= shakeModels.size()) {
                frame = 0;
                model = shakeModels.get(frame);
            }
    }
    public void setRoomDim(double w, double d){
        roomWidth = w;
        roomDepth = d;
    }
        public void setExitFrom(String dir) {
        if (dir.equals("east")) {
            setX(scale);
        } else if (dir.equals("west")) {
            setX(roomWidth-scale);
        }
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public void setZ(double z) {
        this.z = z;
    }


} 