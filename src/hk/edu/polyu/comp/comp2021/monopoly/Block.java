package hk.edu.polyu.comp.comp2021.monopoly;

/**
 * Created by michael on 2016/11/24.
 */
public class Block {
    private int position;
    private String name;

    public Block(int position, String name){
        this.position = position;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getPosition(){
        return position;
    }
    public void printInfo(){

    }

    public void dismissOwner(character p){

    }

    public void action(character p, Map a){

    }

    public String toIcon(){
        return null;
    }
}
