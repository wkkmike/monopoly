package hk.edu.polyu.comp.comp2021.monopoly;

/**
 * Created by michael on 2016/11/24.
 */
public class Block {
    private int position;
    private String name;

    /**
     * Creator
     * @param position
     * @param name
     */
    public Block(int position, String name){
        this.position = position;
        this.name = name;
    }

    /**
     * Return the name of the block
     * @return  name of the block
     */
    public String getName(){
        return name;
    }

    /**
     * Get the position of the block
     * @return position
     */
    public int getPosition(){
        return position;
    }

    /**
     * print the information of the block
     */
    public void printInfo(){

    }

    /**
     * dismiss the owner of the block
     * @param p
     */
    public void dismissOwner(character p){

    }

    /**
     * doing action of that block
     * @param p
     * @param a
     */
    public void action(character p, Map a){

    }

    /**
     * print the icon of the block
     * @return a string stand for the block
     */
    public String toIcon(){
        return null;
    }
}
