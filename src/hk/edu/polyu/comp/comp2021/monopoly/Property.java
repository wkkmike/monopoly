package hk.edu.polyu.comp.comp2021.monopoly;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by michael on 2016/11/24.
 */
public class Property extends Block{
    private int rent;
    private int price;
    private final int thisYear = 2016;
    private character owner  =  null;
    private final int num11 = 11;//left-up corner
    private final int num16 = 16;//right-up corner
    private final int num21 = 21;//right-down corner
    /**
     * Creator
     * @param price price
     * @param rent rent
     * @param position position
     * @param name name
     */
    public Property(int price, int rent, int position, String name){
        super(position, name);
        this.rent = rent;
        this.price = price;
    }

    /**
     * contain the name and the price of the property and can be
     * owned by players. If a player lands on an unowned
     * property, he can choose to buy it for the written price or
     * do nothing. If a player lands on a property owned by
     * another player, he has to pay a rent
     * @param p person lands on this block
     * @param a map
     */
    @Override
    public void action(character p, Map a){
        printInfo();
        if(getOwner() == null){
            if(price <= p.getCash()){
                System.out.print(this);
                System.out.println("Would you want to buy this property? Input end by return.Y/N: ");
                Scanner sc = new Scanner(System.in);
                while (p.isAuto() || sc.hasNextLine()){
                    String s1="N";
                    if(!p.isAuto()) s1 = sc.nextLine();
                    Random r = new Random();

                    if(s1.equals("y") || s1.equals("Y") || (p.isAuto() && ((r.nextInt(thisYear) & 1 ) > 0))){
                        setOwner(p);
                        p.buyHouse(this);
                        System.out.println("You own this property. You have $" + p.getCash() + " now.");
                        break;
                    }
                    else if(s1.equals("n") || s1.equals("N") || (p.isAuto())){
                        System.out.println("You don't buy this property");
                        break;
                    }
                    else  System.out.println("Would you want to buy this property? Input end by return.Y/N: ");
                }
            }
            else{
                System.out.println("You don't have enough money to buy this property.");
            }
        }
        else{
            if(p == getOwner()){
                System.out.println("This is you property.");
            }
            else{
                System.out.println("You need to give " + owner.getName() + " $" + rent + " rental.");
                if(rent > p.getCash()) {
                    int m = p.getCash();
                    owner.setCash(m);
                    p.setCash(-rent);
                    p.retire(a);
                    System.out.println(owner.getName() + " get $" + m + ", have $" + owner.getCash() + " now.");
                }
                else{
                    p.setCash(-rent);
                    owner.setCash(rent);
                    System.out.println("You have $" + p.getCash() + " now." + owner.getName() + " have $" + owner.getCash() + " now.");
                }
            }
        }
    }

    /**
     * get the price of the property
     * @return price of this property
     */
    public int getPrice(){
        return price;
    }

    /**
     * Get the rent
     * @return rent of this property
     */
    public int getRent(){
        return rent;
    }

    /**
     * get the owner
     * @return owner of the property
     */
    public character getOwner(){
        return owner;
    }

    /**
     * Set the new owner of the property
     * @param p the new owner
     */
    public void setOwner(character p){
        this.owner = p;
        p.setCash(-price);
    }

    /**
     * Dismiss the owner if the param is the owner of the property
     * @param p the owner of this property
     */
    @Override
    public void dismissOwner(character p){
        if(p == this.owner)
            this.owner = null;
    }

    /**
     * Info of this block, who owner the block
     */
    @Override
    public void printInfo(){
        System.out.print("You are in " + getName() + ".");
        if(this.owner == null){
            System.out.println("This property has not been bought.");
        }
        else{
            System.out.println("This property is own by " + owner.getName() + ".");
        }
    }

    /**
     * Info of this property: name, owner, price, rent, position
     * @return info
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Property\n");
        if(owner == null)
            sb.append("Owner: No owner\n");
        else
            sb.append("Owner: " + owner.getName() + "\n");
        sb.append("Price: $" + getPrice() + "\n");
        sb.append("Rent: $" + getRent() + "\n");
        sb.append("Position: " + super.getPosition() + "\n");
        return sb.toString();
    }

    /**
     * Icon of this property
     * 0: no owner
     * 1-4: Own by character NO.1-4
     * @return icon
     */
    @Override
    public String toIcon() {
        if(getPosition() > 0 && getPosition() < 6){
            if(owner == null){
                return "0 ";
            }
            else
                return owner.getNo() + " ";
        }
        else if(getPosition() > 6 && getPosition() < num11){
            if(owner == null){
                return "0         ";
            }
            else
                return owner.getNo() + "         ";
        }
        else if(getPosition() > num11 & getPosition() < num16){
            if(owner == null)
                return "0 ";
            else
                return owner.getNo() + " ";
        }
        else if(getPosition() > num16 && getPosition() < num21){
            if(owner == null)
                return "0\n";
            else
                return owner.getNo() + "\n";
        }
        else
            return "error";
    }
}
