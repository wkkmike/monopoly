package hk.edu.polyu.comp.comp2021.monopoly;

/**
 * Created by michael on 2016/11/26.
 */
public class GoToJail extends Block{
    /**
     * Creator
     * @param position positon
     * @param name name
     */
    public GoToJail(int position, String name){
        super(position, name);
    }

    /**
     * Sent the person land in this block to jail
     * @param p person who do action
     * @param a map
     */
    @Override
    public void action(character p, Map a){
        printInfo();
        p.goJail();
    }

    /**
     * Info about this block
     */
    @Override
    public void printInfo(){
        System.out.println("You are in the GoToJail Block, you will be sent to the jail.");
    }

    /**
     * Info about this block
     * @return info
     */
    public String toString(){
        return "GoToJail:\n" + "Send character land on this place to Jail.\n";
    }

    /**
     * Icon of this block
     * @return icon
     */
    @Override
    public String toIcon(){
        return "=\n";
    }
}

