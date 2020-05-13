import java.util.ArrayList;
import java.util.HashMap;

public class Room 
{
    private String textureTop;
    private String textureBottom;
    private double width, height, depth;
    private String textureNorth, textureSouth, textureEast, textureWest;

    private String description;
    private ArrayList<Block> blocks;
    private ArrayList<SnowPile> snowPiles;
    private HashMap<String, Room> exits;
    
    public Room(double widthConstruct, double heightConstruct, double depthConstruct, String floorSkin) {
        width = widthConstruct;
        height = heightConstruct;
        depth = depthConstruct;
        textureBottom = floorSkin;
        blocks = new ArrayList<Block>();
        snowPiles = new ArrayList<SnowPile>();
        exits = new HashMap<String, Room>();
    }
    public void addBlock(Block block) {
        blocks.add(block);
    }
    public ArrayList<Block> getBlocks() {
        return blocks;
    }
    public Block getBlock(int index) {
        return blocks.get(index);
    }
    public void addSnowPile(SnowPile snowPile) {
        snowPiles.add(snowPile);
    }
    public void removeSnowPile(int position) {
        snowPiles.remove(position);
    }
    public ArrayList<SnowPile> getSnowPiles() {
        return snowPiles;
    }
    public String getDescription() {
        return description;
    }
    public void setTextureNorth(String fileName) {
        textureNorth = fileName;
    }
    public void setTextureEast(String fileName) {
        textureEast = fileName;
    }
    public void setTextureSouth(String fileName) {
        textureSouth = fileName;
    }

    public void setTextureWest(String fileName) {
        textureWest = fileName;
    }
    public double getWidth() {
        return width;
    }
    public double getDepth() {
        return depth;
    }
    public double getHeight() {
        return height;
    }
    public void setExit(String direction, Room room) {
        exits.put(direction, room);
    }
    public Room getExit(String direction){
        return exits.get(direction);
    }


    
}

 