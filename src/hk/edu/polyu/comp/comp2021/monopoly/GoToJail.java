package hk.edu.polyu.comp.comp2021.monopoly;

/**
 * Created by michael on 2016/11/26.
 */
public class GoToJail extends Block{
    public GoToJail(int position, String name){
        super(position, name);
    }

    public void action(character p, Map a){
        printInfo();
        p.goJail();
    }

    public void printInfo(){
        System.out.println("You are in the GoToJail Block, you will be sent to the jail.");
    }

    public String toString(){
        return "GoToJail:\n" + "Send character land on this place to Jail.\n";
    }
    public String toIcon(){
        return "=\n";
    }
}

