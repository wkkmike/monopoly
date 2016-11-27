package hk.edu.polyu.comp.comp2021.monopoly;

/**
 * Created by michael on 2016/11/26.
 */
public class Parking extends  Block {

    public Parking(int position, String name){
        super(position, name);
    }

    public void printInfo(){
        System.out.println("You are in the free parking block, no effect to you.");
    }

    public String toString(){
        return "FreeParking:\n" + "This block has no effect";
    }

    public void action(character p, Map a){
        printInfo();
    }

    @Override
    public String toIcon() {
        return "F ";
    }
}
