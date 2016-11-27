package hk.edu.polyu.comp.comp2021.monopoly;

/**
 * Created by michael on 2016/11/26.
 */
public class Go extends Block {
    public Go(int position, String name){
        super(position, name);
    }

    public void printInfo(){
        System.out.println("You are in the Go block.");
    }

    public void action(character p, Map a){
        printInfo();
    }

    public String toString(){
        return "Go:\n" + "Give $1500 to everyone pass through this block.\n";
    }

    public String toIcon(){
        return "G\n";
    }
}
