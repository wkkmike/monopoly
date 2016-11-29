package hk.edu.polyu.comp.comp2021.monopoly;

import java.util.*;
/**
 * Created by YHZ on 2016/11/20.
 */
public class character {
    private int no;
    private String name;
    private int cash;
    private int state;  //0: normal, -1: out of game, 1: in jail, 2: auto
    private int jail_round;
    private int position;
    private int propertyAmount = 20;
    private int[] house = new int[propertyAmount];
    private int houseAmount;
    private int initMoney = 1500;
    private int totalBlock = 21;
    /**
     * creator
     */
    public character(){
        name="";
        cash=initMoney;
        int state=-1;
        position=1;
        jail_round=0;
        houseAmount = 0;
    }

    /**
     * Get the name of the character
     * @return the name
     */
    public String getName(){
        return name;
    }

    /**
     * Get the No. of the character
     * @return No.
     */
    public int getNo(){
        return no;
    }

    /**
     * Get the position of the character
     * @return position of the character
     */
    public int getPostion(){
        return position;
    }

    /**
     * Creator when user take the input.
     * @param name name
     * @param amount amount of money he have
     * @param no sequence no
     */
    public character(String name, int amount,int no){
        this.no=no;
        this.name=name;
        this.cash=amount;
        state=0;
        position = 1;
        jail_round = 0;
        houseAmount = 0;
    }

    /**
     * When a person buy a property, attach it to his house array.
     * @param p the property he buy
     */
    public void buyHouse(Block p){
        house[houseAmount] = p.getPosition();
        houseAmount++;
    }

    /**
     * Set the character to auto mode
     */
    public void setAuto(){
        state = 2;
    }

    /**
     * check whether the character is in auto mode
     * @return true for auto mode.
     */
    public boolean isAuto(){
        return state == 2;
    }

    /**
     * get the cash he own
     * @return amount of cash
     */
    public int getCash(){
        return cash;
    }

    /**
     * Check if the character is retired
     * @return true for retire
     */
    public boolean isRetire(){
        return state == -1;
    }

    /**
     * Make the character retire.
     * reset position, cash and state.
     * Reset all his properties.
     * @param a map
     */
    public void retire(Map a){
        position = 0;
        cash = -1;
        state = -1;
        for(int i = 0; i < houseAmount; i++){
            a.getBlockList()[house[i] - 1].dismissOwner(this);
        }
        System.out.println("You lose.");
    }

    /**
     * Increase the cash by the amount money.
     * If after change the cash he own is less than 0, don't change, Since the person will retire.
     * @param money positive for increase money, negative for decrease money.
     */
    public void setCash(int money){
        if(cash + money >= 0) cash += money;
    }

    /**
     * Simulate roll dice
     * @return a random number between 1-6
     */
    public int rollDice(){
        Random random = new Random();
        int step = random.nextInt(6)%6+1;
        return step;
    }

    /**
     * Check whether a person is in jail
     * @return true for in jail
     */
    public boolean injail(){
        return state==1;
    }

    /**
     * Decrease the jail round
     * @return the latest jail round.
     */
    public int decreaseJailRound(){
        jail_round--;
        return jail_round;
    }

    /**
     * if a person is out of jail in this turn, reset his state and jail round.
     */
    public void outJail(){
        jail_round = 0;
        state = 0;
    }

    /**
     * Move some block according to the dice.
     * If he is injail, don't move.
     * If he pass or land on the Go block, get 1500 cash.
     */
    public void move(){
        if(this.injail()){
            System.out.println("You are in jail");
        }
        else{
            int step=rollDice();
            System.out.println("You Roll " + step + " point.");
            if((position + step) >= totalBlock){
                cash += initMoney;
                step += 1;
                System.out.println("You pass the GO block and get $1500. You have $" + cash + " now.");
            }
            position = (position + step) % totalBlock;
        }
    }

    /**
     * Get a string of the character infomation include, cash. state, name position and the property.
     * @param a map
     * @return the info
     */
    public String toString(Map a){
        StringBuilder sb=new StringBuilder();
        sb.append("Character\n");
        sb.append("Name: " + name + "\n");
        sb.append("Cash: " + cash + "\n");
        if(state == 0)
            sb.append("State: Normal\n");
        else if(state == 2)
            sb.append("State: Auto\n");
        else if(state == 1)
            sb.append("State: In jail\n");
        else if(state == -1)
            sb.append("State: Retire\n");
        sb.append("Position: " + position + "  " + a.getNameOfBlock(position)+ "\n");
        sb.append("Property: \n");
        for(int i = 0; i < houseAmount; i++){
            sb.append("    Name: " + a.getNameOfBlock(house[i]) + " Position: " + house[i] + "\n");
        }
        return sb.toString();
    }

    /**
     * Set the person in in jail state.
     */
    public void goJail(){
        this.position = 6;
        this.state=1;
        this.jail_round=2;
    }

}
