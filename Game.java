import env3d.Env;
import org.lwjgl.input.Keyboard;
import java.util.ArrayList;

public class Game
{
    private double gravity;
    private double floor;
    private Env env;
    private boolean finished;
    private Penguin bert;
    private Room roomHome, roomOne;
    private Room currentRoom;
    private int[] jumpCount;
    private double xdiff, ydiff, zdiff;
    private boolean colliding;
    private double blockMod;
    private ArrayList<SnowBall> snowBalls;
    private int snowBallCount;
    private boolean throwingBall;
    private double camX;
    private double camY;
    private double camZ;
    private Key key;
    private boolean haveKey;

    
    public Game()
    { 
        gravity = 0.003;
        floor = 1;
        blockMod = 0.88;
        bert = new Penguin(15, 10, 5, "models/tux/tux.png");
        roomHome = new Room(30, 20, 30, "textures/stone.gif");
        roomOne = new Room(30, 20, 30, "textures/grass11.jpg");
        snowBalls = new ArrayList<SnowBall>();
        snowBallCount = 10;
        key = new Key(5,5,5);
        haveKey = false;
        
        roomHome.setExit("east", roomOne);
        roomHome.setTextureWest("textures/AylesIceShelfOffshore30May2006Vincent3-2.jpg");  
        roomHome.setTextureEast("textures/AylesIceShelfOffshore30May2006Vincent3-3.jpg");  
        roomHome.setTextureNorth("textures/AylesIceShelfOffshore30May2006Vincent3.jpg");  
        roomHome.setTextureSouth("textures/AylesIceShelfOffshore30May2006Vincent3.jpg");  
        roomHome.addBlock(new Block(5, 0, 5, "Normal Block", 3, "models/rocks/rock1.obj", "textures/iceblockbig.jpg"));
        roomHome.addBlock(new Block(20, -20.5, 25, "Normal Block", 25, "models/rocks/rock1.obj", "textures/iceblockbig.jpg"));
        roomHome.addBlock(new Block(25, -20, 5, "Normal Block", 24, "models/rocks/rock1.obj", "textures/iceblockbig.jpg"));
        roomHome.addBlock(new Block(5, -21.5, 10, "Normal Block", 25, "models/rocks/rock1.obj", "textures/iceblockbig.jpg"));
        roomHome.addBlock(new Block(10, -7.5, 10, "Normal Block", 10, "models/rocks/rock1.obj", "textures/iceblockbig.jpg"));
        roomHome.addBlock(new Block(1, -1, 1, "Normal Block", 3, "models/rocks/rock1.obj", "textures/granite.gif"));
        roomHome.addBlock(new Block(1, -1, 25, "Normal Block", 5, "models/rocks/rock1.obj", "textures/iceblockbig.jpg"));
        roomHome.addBlock(new Block(0, 6, -1, "Normal Block", 4, "models/rocks/rock1.obj", "textures/iceblockbig.jpg"));
        roomHome.addBlock(new Block(30, -1, 1, "Normal Block", 5, "models/rocks/rock1.obj", "textures/iceblockbig.jpg"));
        roomHome.addBlock(new Block(18, 0, 1, "Normal Block", 4, "models/rocks/rock1.obj", "textures/iceblockbig.jpg"));
        roomHome.addBlock(new Block(30, 0, 30, "Normal Block", 4, "models/rocks/rock1.obj", "textures/granite.gif"));
        roomHome.addBlock(new Block(1, -1, 30, "Normal Block", 6, "models/rocks/rock1.obj", "textures/iceblockbig.jpg"));
        roomHome.addBlock(new Block(31, 2, 0, "Normal Block", 7, "models/rocks/rock1.obj", "textures/iceblockbig.jpg"));
        roomHome.addSnowPile(new SnowPile(15, -1, 15, "Normal SnowPile", 1.3, "models/rocks/rock1.obj", "textures/iceblockyellow.jpg"));
        
        roomOne.setExit("west", roomHome);
        roomOne.setTextureWest("textures/AylesIceShelfOffshore30May2006Vincent3-3.jpg");  
        roomOne.setTextureEast("textures/AylesIceShelfOffshore30May2006Vincent3-2.jpg");  
        roomOne.setTextureNorth("textures/AylesIceShelfOffshore30May2006Vincent3.jpg");  
        roomOne.setTextureSouth("textures/AylesIceShelfOffshore30May2006Vincent3.jpg");  
        roomOne.addBlock(new Block(8, 2, 0, "Normal Block", 3, "models/rocks/rock1.obj", "textures/granite.gif"));
        roomOne.addBlock(new Block(20, -20.5, 25, "Normal Block", 25, "models/rocks/rock1.obj", "textures/iceblockbig.jpg"));
        roomOne.addBlock(new Block(28, -21, 10, "Normal Block", 25, "models/rocks/rock1.obj", "textures/granite.gif"));
        roomOne.addBlock(new Block(12, -21.5, 10, "Normal Block", 25, "models/rocks/rock1.obj", "textures/iceblockbig.jpg"));
        roomOne.addBlock(new Block(17, -6.5, 7, "Normal Block", 10, "models/rocks/rock1.obj", "textures/iceblockbig.jpg"));
        roomOne.addBlock(new Block(1, -1, 1, "Normal Block", 6, "models/rocks/rock1.obj", "textures/iceblockbig.jpg"));
        roomOne.addBlock(new Block(1, -1, 26, "Normal Block", 4, "models/rocks/rock1.obj", "textures/stone.gif"));
        roomOne.addBlock(new Block(0, 5, -1, "Normal Block", 4, "models/rocks/rock1.obj", "textures/iceblockbig.jpg"));
        roomOne.addBlock(new Block(30, -1, 1, "Normal Block", 5, "models/rocks/rock1.obj", "textures/iceblockbig.jpg"));
        roomOne.addBlock(new Block(18, 0, 1, "Normal Block", 4, "models/rocks/rock1.obj", "textures/stone.gif"));
        roomOne.addBlock(new Block(30, 3, 30, "Normal Block", 12, "models/rocks/rock1.obj", "textures/iceblockbig.jpg"));
        roomOne.addBlock(new Block(1, -1, 30, "Normal Block", 6, "models/rocks/rock1.obj", "textures/iceblockbig.jpg"));
        roomOne.addBlock(new Block(31, 2, 0, "Normal Block", 7, "models/rocks/rock1.obj", "textures/iceblockbig.jpg"));
        roomOne.addBlock(new Block(23, 1, 1, "Normal Block", 1, "models/tux/tux.obj", "models/tux/ftux_happy.png"));
        roomOne.addSnowPile(new SnowPile(3, -1, 9, "Normal SnowPile", 1.3, "models/rocks/rock1.obj", "textures/iceblockyellow.jpg"));
        roomOne.addSnowPile(new SnowPile(15, -1, 15, "Normal SnowPile", 1.3, "models/rocks/rock1.obj", "textures/iceblockyellow.jpg"));
        
        
    }
    public void play()
    {
        // A variable to determine if the game is finished
        finished = false;
        
        // Create the env object so that we can manipulate
        // the 3D environment.
        env = new Env();   
        setCurrentRoom(roomHome);
        
        
        bert.setRoomDim(currentRoom.getWidth(), currentRoom.getDepth());
        env.addObject(bert);
        env.addObject(key);
        
        while (!finished)
        {
            processInput();
            followCamera();
            checkCollision();
            checkJumping();
            checkFalling();
            checkIsFalling();
            throwSnowBalls();
            key.move();
            checkKey();
            checkWin();
            env.advanceOneFrame();
            
        }
        // Exit the program cleanly
        System.exit(0);
    }
    
    /**
     * A display update used for testing
     *
     */
    private void updateDisplay() {
        double xround = bert.getValueX() * 100;
               xround = Math.round(xround);
               xround = xround / 100;
        double yround = bert.getValueY() * 100;
               yround = Math.round(yround);
               yround = yround / 100;
        double zround = bert.getValueZ() * 100;
               zround = Math.round(zround);
               zround = zround / 100;
        env.setDisplayStr("X: "+xround+" Y: "+yround+" Z: "+zround);
    }
    
    /**
     * Reads user input
     */
    private void processInput() {
        int key = env.getKey();
        int keyDown = env.getKeyDown();
        if (key == 1) {
            finished = true;
        } 
        if (env.getKeyDown(Keyboard.KEY_W)) {
            checkFalling();
            checkCollision();
            bert.moveUp();
            bert.setMoving(true);
            colliding = false;
        } else if (env.getKeyDown(Keyboard.KEY_S)) {
            checkFalling();
            checkCollision();
            bert.moveDown();
            bert.setMoving(true);
            colliding = false;
        } else {
            bert.setMoving(false);
        }
        if (env.getKeyDown( Keyboard.KEY_LEFT)) {
            checkFalling();
            checkCollision();
            bert.turnLeft();
            bert.setTurning(true);
            colliding = false;
        } else
        if (env.getKeyDown(Keyboard.KEY_RIGHT)) {
            checkFalling();
            checkCollision();
            bert.turnRight();
            bert.setTurning(true);
            colliding = false;
        } else {
            bert.setTurning(false);
        }
        if (env.getKeyDown( Keyboard.KEY_A)) {
            checkFalling();
            checkCollision();
            bert.strafeLeft();
            colliding = false;
        } else
        if (env.getKeyDown(Keyboard.KEY_D)) {
            checkFalling();
            checkCollision();
            bert.strafeRight();
            colliding = false;
        }
        if (env.getKeyDown(Keyboard.KEY_SPACE) && !bert.getFalling() && !bert.getJumping()) {
               bert.resetCounter();
               bert.setJumpStart(bert.getValueY());
               bert.setJumping(true);
               colliding = false;
               bert.setFrame(0);
        } 
        if (env.getKeyDown(Keyboard.KEY_UP) && !throwingBall) {
            if (snowBallCount > 0) {
                snowBallCount--;
                SnowBall sb = new SnowBall(bert.getValueX(), bert.getValueY()+0.5, bert.getValueZ(), bert.getRotateY());
                addSnowBall(sb);
                env.addObject(sb);
                throwingBall = true;
            }
        }
        if (!env.getKeyDown(Keyboard.KEY_UP)) {
            throwingBall = false;
        }
        if (env.getKeyDown(Keyboard.KEY_DOWN)) {
            for (SnowPile snowPile : currentRoom.getSnowPiles()) {
                double dist = distance(snowPile.getX(), bert.getValueX(), snowPile.getY(), bert.getValueY(), snowPile.getZ(), bert.getValueZ());
                if (dist <= snowPile.getScale()+bert.getScale()*0.44) {
                        snowBallCount += 10;
                        snowPile.dissapear();
                }
            }
        }
     
    }
    
    /**
     * Sets the camera to follow Bert
     */
    private void followCamera() {
        camX = env.getCameraX();
        camY = env.getCameraY();
        camZ = env.getCameraZ();
        env.setCameraXYZ( (float) (bert.getValueX() - 4 * Math.sin(bert.getRotateY()/180 * Math.PI)), 
        bert.getValueY()+1,
        (float) (bert.getValueZ() - 4 * Math.cos(bert.getRotateY()/180 * Math.PI)));
        env.setCameraYaw(bert.getRotateY()-180);
        env.setCameraPitch(-10);
        env.setDefaultControl(false);
        if (env.getCameraX() <= 0 ) { 
            env.setCameraXYZ(camX,bert.getValueY()+1,(float) (bert.getValueZ() - 4 * Math.cos(bert.getRotateY()/180 * Math.PI)));
        }
        if (env.getCameraX() >= currentRoom.getWidth()) {
            env.setCameraXYZ(camX,bert.getValueY()+1,(float) (bert.getValueZ() - 4 * Math.cos(bert.getRotateY()/180 * Math.PI)));
        }
        if (env.getCameraZ() <= 0) {
            env.setCameraXYZ((float) (bert.getValueX() - 4 * Math.sin(bert.getRotateY()/180 * Math.PI)),bert.getValueY()+1,camZ);
        }
        if (env.getCameraZ() >= currentRoom.getDepth()) {
            env.setCameraXYZ((float) (bert.getValueX() - 4 * Math.sin(bert.getRotateY()/180 * Math.PI)),bert.getValueY()+1,camZ);
        }
    }
    
    /**
     * Used to check to see if bert is jumping, used to properly apply gravity
     */
    private void checkJumping() {
        if (bert.getJumping() == true) {
            bert.jump(gravity);
        }
    }
    
    /**
     * checks to see if bert should be falling, used to properly apply gravity
     */
    private void checkFalling() {
        if (bert.getValueY() > floor) {
            if (!bert.getJumping() && !colliding) {
                bert.setFalling(true);
            }
        }
    }
    /**
     * checks to see if bert is falling
     */
    private void checkIsFalling() {
        if (bert.getFalling() == true) {
            bert.fall(gravity);
            if (bert.getValueY() < floor) {
                bert.setValueY(floor);
                bert.setFalling(false);
                bert.setActuallyFalling(false);
            }
        }
    }
    
    /**
     * Changes the room
     */
    private void setCurrentRoom(Room room) {
        if (room != null) {
            currentRoom = room;
            env.setRoom(currentRoom);
            for (Block block : currentRoom.getBlocks()) {
              env.addObject(block);
            }
            for (SnowPile snowPile : currentRoom.getSnowPiles()) {
              env.addObject(snowPile);
            }
        }
    }
    
    /**
     * Checks collision with walls
     */
    private void checkWall() {
        if (bert.getValueX() > currentRoom.getWidth()-bert.getScale()*0.44 && bert.getValueZ() > 10 && bert.getValueZ() < 20) {
            // Going east
            exitTo("east");
        } else if (bert.getValueX() < bert.getScale()*0.44 && bert.getValueZ() > 10 && bert.getValueZ() < 20) {
            // Going west
            exitTo("west");
        } else if (bert.getValueX() > currentRoom.getWidth()-bert.getScale()*0.44 && bert.getValueZ() <= 10 || 
                   bert.getValueX() > currentRoom.getWidth()-bert.getScale()*0.44 && bert.getValueZ() >= 20) {
            bert.revert();
        } else if (bert.getValueX() < bert.getScale()*0.44 && bert.getValueZ() <= 10 || 
                   bert.getValueX() < bert.getScale()*0.44 && bert.getValueZ() >= 20) {
            bert.revert();
        } else if (bert.getValueZ() > currentRoom.getWidth()-bert.getScale()*0.44) {
            bert.revert();
        } else if (bert.getValueZ() < bert.getScale()*0.44) {
            bert.revert();
        }
    }
    
    /**
     * checks collision with blocks
     */
    private void checkCollision() {
        checkWall();
        for (Block block : currentRoom.getBlocks()) {
            double dist = distance(block.getX(), bert.getValueX(), block.getY(), bert.getValueY(), block.getZ(), bert.getValueZ());
            if (dist <= block.getScale()*blockMod+bert.getScale()*0.44) {
                if ((block.getScale()*blockMod+bert.getScale())-(bert.getValueY()-block.getY()) < bert.getSpeed()*50) {
                    bert.setValueY(bert.getValueY()+bert.getSpeed()*0.5);
                    bert.resetCounter();
                    colliding = true;
                    bert.setFalling(false);
                    bert.setJumping(false);
                } else {
                    colliding = true;
                    bert.revert();
                    bert.setFalling(false);
                    bert.setJumping(false);
                    bert.resetCounter();
                }
            }
        }
    }
    /**
     * checks collision with the Key
     */
    private void checkKey() {
        checkWall();
        double dist = distance(key.getValueX(), bert.getValueX(), key.getValueY(), bert.getValueY(), key.getValueZ(), bert.getValueZ());
        if (dist <= key.getScale()+bert.getScale()*0.44) {
            haveKey = true;
            key.dissapear();
            env.setDisplayStr("           You found the Key!");
        }
    }
    
    /**
     * checks to see if the game has been won
     */
    private void checkWin() {
        double dist = distance(23, bert.getValueX(), 1, bert.getValueY(), 1, bert.getValueZ());
              if (dist <= 3 && currentRoom == roomOne) {
                  Block win = currentRoom.getBlock(13);
                  win.setScale(2);
                  win.dance();
                  env.setDisplayStr("                         You Win!!!");
              }
    }
    
    /**
     * A basic distance checker
     */
    private double distance(double x1, double x2, double y1, double y2, double z1, double z2) {
        xdiff = x2 - x1;
        ydiff = y2 - y1;
        zdiff = z2 - z1;
        return (double) Math.sqrt(xdiff*xdiff + ydiff*ydiff + zdiff*zdiff);
    }   
    
    /**
     * changes the room
     */
    private void exitTo(String dir) {
        if (currentRoom.getExit(dir) != null) {       
            if (haveKey) {
                setCurrentRoom(currentRoom.getExit(dir));
                bert.setRoomDim(currentRoom.getWidth(), currentRoom.getDepth());
                bert.setExitFrom(dir);           
                env.addObject(bert);
                env.setDisplayStr("");
            } else {
                env.setDisplayStr("          You need a key to open this door!         ");
                bert.revert();
            }
        } else {
            bert.revert();
        }
    }
    
    /**
     * boots the game up without having to call play method
     */
    public static void main (String [] args) {
        (new Game()).play();
    }
    
    /**
     * adds a snowball to the array
     */
    public void addSnowBall(SnowBall sb) {
        snowBalls.add(sb);
    }
    
    /**
     * returns the snowball array
     */
    public ArrayList<SnowBall> getSnowBalls() {
        return snowBalls;
    }
    
    /**
     * moves all the snowballs
     */
    private void throwSnowBalls() {
        for (SnowBall snowBall : getSnowBalls()) {
                  snowBall.throwBall(gravity);
        }
    }

}
