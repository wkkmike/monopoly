package hk.edu.polyu.comp.comp2021.monopoly;

/**
 * Created by michael on 2016/11/26.
 */
public class Tax extends Block{
    public Tax(int position, String name){
        super(position, name);
    }

    public void printInfo(){
        System.out.println("You are in  Income Tax block, you will be charged 10% income tax.");
    }

    public String toString(){
        return "Tax:\n" + "Charge character who lands on this block 10% of his money.\n";
    }

    public void action(character p, Map a){
        printInfo();
        int tax = p.getCash() / 10;
        p.setCash(-tax);
        System.out.println("You are charged $" + tax + ". You have $" + p.getCash() + " now.");
    }

    @Override
    public String toIcon() {
        return "$ ";
    }
}
