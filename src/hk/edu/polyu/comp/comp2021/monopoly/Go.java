package hk.edu.polyu.comp.comp2021.monopoly;

/**
 * Created by michael on 2016/11/26.
 */
public class Go extends Block {
    /**
     * Creator
     * @param position position
     * @param name name
     */
    public Go(int position, String name){
        super(position, name);
    }

    /**
     * print information about go
     */
    @Override
    public void printInfo(){
        System.out.println("You are in the Go block.");
    }

    /**
     * Action when a character land in this block. No effect.
     * @param p person who do action
     * @param a map
     */
    @Override
    public void action(character p, Map a){
        printInfo();
    }

    /**
     * print the information of this block.
     * @return the info
     */
    public String toString(){
        return "Go:\n" + "Give $1500 to everyone pass through this block.\n";
    }

    /**
     * A string of the block icon
     * @return icon
     */
    @Override
    public String toIcon(){
        return "G\n";
    }
}
