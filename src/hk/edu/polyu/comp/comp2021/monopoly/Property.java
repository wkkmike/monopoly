package hk.edu.polyu.comp.comp2021.monopoly;

import java.util.Scanner;

/**
 * Created by michael on 2016/11/24.
 */
public class Property extends Block{
    private int rent;
    private int price;
    private character owner  =  null;

    public Property(int price, int rent, int position, String name){
        super(position, name);
        this.rent = rent;
        this.price = price;
    }

    public void action(character p, Map a){
        printInfo();
        if(getOwner() == null){
            if(price <= p.getCash()){
                System.out.print(this);
                System.out.println("Would you want to buy this property? Input end by return.Y/N: ");
                Scanner sc = new Scanner(System.in);
                while (sc.hasNextLine()){
                    String s1 = sc.nextLine();
                    if(s1.equals("y") || s1.equals("Y")){
                        setOwner(p);
                        p.buyHouse(this);
                        System.out.println("You own this property. You have $" + p.getCash() + " now.");
                        break;
                    }
                    else if(s1.equals("n") || s1.equals("N")){
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

    public int getPrice(){
        return price;
    }

    public int getRent(){
        return rent;
    }

    public character getOwner(){
        return owner;
    }

    public void setOwner(character p){
        this.owner = p;
        p.setCash(-price);
    }

    public void dismissOwner(character p){
        if(p == this.owner)
            this.owner = null;
    }

    public void buyProperty(character p){
        if(this.getOwner() != null){
            System.out.println("This property is owned by others. You can not buy it.");
            return;
        }
        this.owner = p;
        System.out.println("You buy " + getName() + ".");
    }

    public void printInfo(){
        System.out.print("You are in " + getName() + ".");
        if(this.owner == null){
            System.out.println("This property has not been bought.");
        }
        else{
            System.out.println("This property is own by " + owner.getName() + ".");
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Property\n");
        if(owner == null)
            sb.append("Owner； No owner\n");
        else
            sb.append("Owner: " + owner.getName() + "\n");
        sb.append("Price: $" + getPrice() + "\n");
        sb.append("Rent: $" + getRent() + "\n");
        sb.append("Position: " + super.getPosition() + "\n");
        return sb.toString();
    }

    @Override
    public String toIcon() {
        if(getPosition() > 0 && getPosition() < 6){
            if(owner == null){
                return "0 ";
            }
            else
                return owner.getNo() + " ";
        }
        else if(getPosition() > 6 && getPosition() < 11){
            if(owner == null){
                return "0         ";
            }
            else
                return owner.getNo() + "         ";
        }
        else if(getPosition() > 11 & getPosition() < 16){
            if(owner == null)
                return "0 ";
            else
                return owner.getNo() + " ";
        }
        else if(getPosition() > 16 && getPosition() < 21){
            if(owner == null)
                return "0\n";
            else
                return owner.getNo() + "\n";
        }
        else
            return "error";
    }
}