package hk.edu.polyu.comp.comp2021.monopoly;

/**
 * Created by michael on 2016/11/26.
 */
public class Tax extends Block{
    /**
     * Creator
     * @param position
     * @param name
     */
    public Tax(int position, String name){
        super(position, name);
    }

    /**
     * Info of tax block
     */
    @Override
    public void printInfo(){
        System.out.println("You are in  Income Tax block, you will be charged 10% income tax.");
    }

    /**
     * info of this block
     * @return
     */
    public String toString(){
        return "Tax:\n" + "Charge character who lands on this block 10% of his money.\n";
    }

    /**
     * If a player lands on this square he pays 10% of
     * his money (rounded down to a multiple of 10) as tax
     * @param p
     * @param a
     */
    @Override
    public void action(character p, Map a){
        printInfo();
        int tax = p.getCash() / 10;
        p.setCash(-tax);
        System.out.println("You are charged $" + tax + ". You have $" + p.getCash() + " now.");
    }

    /**
     * Icon of this property
     * @return
     */
    @Override
    public String toIcon() {
        return "$ ";
    }
}
