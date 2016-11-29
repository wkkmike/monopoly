package hk.edu.polyu.comp.comp2021.monopoly;

/**
 * Created by michael on 2016/11/26.
 */
public class Parking extends  Block {

    /**
     * Creator
     * @param position
     * @param name
     */
    public Parking(int position, String name){
        super(position, name);
    }

    /**
     * info about this block
     */
    @Override
    public void printInfo(){
        System.out.println("You are in the free parking block, no effect to you.");
    }

    /**
     * info about this block
     * @return
     */
    public String toString(){
        return "FreeParking:\n" + "This block has no effect";
    }

    /**
     * Action when a character land in this block.
     * No effect.
     * @param p
     * @param a
     */
    @Override
    public void action(character p, Map a){
        printInfo();
    }

    /**
     * Icon of this block
     * @return
     */
    @Override
    public String toIcon() {
        return "F ";
    }
}
