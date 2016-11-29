package hk.edu.polyu.comp.comp2021.monopoly;
import java.util.Random;
/**
 * Created by michael on 2016/11/26.
 */
public class Chance extends Block {

    /**
     * Creator
     * @param position
     * @param name
     */
    public Chance(int position, String name){
        super(position, name);
    }

    /**
     * Get a number between -300 to 200 the character get(10 mulriple)
     * @return the number of money he get
     */
    public int changeMoney(){
        Random rand = new Random();
        int  n = rand.nextInt(51) - 30;
        return n * 10;
    }

    /**
     * Doing action when a person in the chance block.
     * He may get -300 to 200 dollar.
     * If he bankrupt, he will retire.
     * @param p
     * @param a
     */
    @Override
    public void action(character p, Map a){
        int n = changeMoney();
        printInfo();
        if(n >= 0) {
            p.setCash(n);
            System.out.println("You win $" + n + ". You have $" + p.getCash() + " now.");
        }
        else{
            if(p.getCash() + n >= 0){
                p.setCash(n);
                System.out.println("You lose $" + (-n) + ". You have $" + p.getCash() + " now.");
            }
            else{
                System.out.println("You lose $" + (-n) + ".");
                p.setCash(n);
                p.retire(a);
            }
        }
    }

    /**
     * print information about this block
     */
    @Override
    public void printInfo(){
        System.out.println("You are in a Chance Box, you may win or lose money");
    }

    /**
     * print the effect of this block
     * @return
     */
    public String toString(){
        return "Chance: \n" + "Character lands on this block may get -300 to 200 money randomly.\n";
    }

    /**
     * get the icon of this block
     * @return
     */
    @Override
    public String toIcon(){
        if(getPosition() == 9)
            return "?         ";
        else if(getPosition() == 19)
            return "?\n";
        else
            return "? ";
    }
}
