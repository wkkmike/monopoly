package hk.edu.polyu.comp.comp2021.monopoly;
import java.util.Random;
/**
 * Created by michael on 2016/11/26.
 */
public class Chance extends Block {

    public Chance(int position, String name){
        super(position, name);
    }

    public int changeMoney(){
        Random rand = new Random();
        int  n = rand.nextInt(51) - 30;
        return n * 10;
    }

    public void action(character p, Map a){
        int n = changeMoney();
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

    public void printInfo(){
        System.out.println("You are in a Chance Box, you may win or lose money");
    }

    public String toString(){
        return "Chance: \n" + "Character lands on this block may get -300 to 200 money randomly.\n";
    }

    public String toIcon(){
        if(getPosition() == 9)
            return "?         ";
        else if(getPosition() == 19)
            return "?\n";
        else
            return "? ";
    }
}
