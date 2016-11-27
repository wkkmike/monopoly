package hk.edu.polyu.comp.comp2021.monopoly;

import java.util.Scanner;

/**
 * Created by michael on 2016/11/24.
 */
public class Jail extends Block {
    int[] inJail = new int[4];
    public Jail(int position, String name){
        super(position, name);
    }

    public void action(character p, Map d){
        if(!p.injail()){
            printInfo();
        }
        else{
            if(p.getCash() < 50){
                System.out.println("You don't have enough money to pay the fine.");
                int a = p.rollDice();
                int b = p.rollDice();
                System.out.println("Your first roll get " + a + "Your second roll get " + b + ".");
                if(a == b){
                    p.outJail();
                    System.out.println("Congratulation! You are out of jail.");
                }
                else{
                    int r = p.decreaseJailRound();
                    if(r < 0){
                        System.out.println("Sorry this is the third turns, you must pay fine, but you don't have enough money.");
                        p.outJail();
                        p.retire(d);
                        return;
                    }
                    r++;
                    System.out.println("Sorry, you are still in jail. You still have " + r + " opportunity.");
                }
            }
            else {
                System.out.println("Would you want to pay $50 to get out of jail? Input end by return.Y/N: ");
                Scanner sc = new Scanner(System.in);
                while (sc.hasNextLine()) {
                    String s1 = sc.nextLine();
                    if (s1.equals("y") || s1.equals("Y")) {
                        p.setCash(-50);
                        p.outJail();
                        System.out.println("You pay $50 fine. You leave jail. You have $" + p.getCash() + " now.");
                        break;
                    } else if (s1.equals("n") || s1.equals("N")) {
                        int a = p.rollDice();
                        int b = p.rollDice();
                        System.out.println("Your first roll get " + a + ". Your second roll get " + b + ".");
                        if(a == b){
                            p.outJail();
                            System.out.println("Congratulation! You are out of jail.");
                        }
                        else{
                            int r = p.decreaseJailRound();
                            if(r < 0){
                                System.out.println("Sorry this is the third turns, you must pay fine.");
                                p.setCash(-50);
                                p.outJail();
                                System.out.println("You pay $50 fine. You leave jail. You have $" + p.getCash() + " now.");
                                p.move();
                                return;
                            }
                            r++;
                            System.out.println("Sorry, you are still in jail. You still have " + r + " opportunity.");
                            break;
                        }
                    } else System.out.println("Would you want to pay $50 to get out of jail? Input end by return.Y/N: ");
                }
            }
        }
    }

    public void printInfo(){
        System.out.println("You just pass by jail, no effect.");
    }

    public String toString() {
        String r = "he is in Jail and cannot make a move. A player gets out of\n" +
                "Jail by either throwing doubles1 on any of his next three turns (if he succeeds in doing this he immediately\n" +
                "moves forward by the number of spaces shown by his doubles throw) or paying a fine of HKD 50 before he\n" +
                "rolls the dice on either of his next two turns. If the player does not throw doubles by his third turn he must" +
                "pay the HKD 50 fine. He then gets out of Jail and immediately moves forward the number of spaces shown\n" +
                "by his throw.";
        return r;
    }
    public String toIcon(){
        return "# ";
    }
    
}