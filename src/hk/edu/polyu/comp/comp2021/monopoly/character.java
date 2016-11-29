package hk.edu.polyu.comp.comp2021.monopoly;

import java.util.*;
/**
 * Created by YHZ on 2016/11/20.
 */
public class character {
    int no;
    String name;
    int cash;
    int state;  //0: normal, -1: out of game, 1: in jail, 2: auto
    int jail_round;
    int position;
    int[] house = new int[20];
    int houseAmount;
    public character(){
        name="";
        cash=1500;
        int state=-1;
        position=1;
        jail_round=0;
        houseAmount = 0;
    }

    public String getName(){
        return name;
    }

    public int getNo(){
        return no;
    }

    public int getPostion(){
        return position;
    }

    public character(String name, int amount,int no){
        this.no=no;
        this.name=name;
        this.cash=amount;
        state=0;
        position = 1;
        jail_round = 0;
        houseAmount = 0;
    }

    public void buyHouse(Block p){
        house[houseAmount] = p.getPosition();
        houseAmount++;
    }

    public void setAuto(){
        state = 2;
    }

    public boolean isAuto(){
        return state == 2;
    }

    public int getCash(){
        return cash;
    }

    public boolean isRetire(){
        return state == -1;
    }

    public void retire(Map a){
        cash = -1;
        state = -1;
        for(int i = 0; i < houseAmount; i++){
            a.getBlockList()[house[i] - 1].dismissOwner(this);
        }
        System.out.println("You lose.");
    }

    public void setCash(int money){
        if(cash + money >= 0) cash += money;
    }

    public int rollDice(){
        Random random = new Random();
        int step = random.nextInt(6)%6+1;
        return step;
    }

    public boolean injail(){
        return state==1;
    }

    public int decreaseJailRound(){
        jail_round--;
        return jail_round;
    }

    public void outJail(){
        jail_round = 0;
        state = 0;
    }

    public void move(){
        if(this.injail()){
            System.out.println("You are in jail");
        }
        else{
            int step=rollDice();
            System.out.println("You Roll " + step + " point.");
            if((position + step) >= 21){
                cash += 1500;
                step += 1;
                System.out.println("You pass the GO block and get $1500. You have $" + cash + " now.");
            }
            position = (position + step)%21;
        }
    }

    public void go(int step){
        this.position=(this.position + step)%21;
    }

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

    public void goJail(){
        this.position = 6;
        this.state=1;
        this.jail_round=2;
    }

}
