package hk.edu.polyu.comp.comp2021.monopoly;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {

    private static void findWinner(character[] a){
        for(int i=1;i<a.length;i++){
            int max = a[i].getCash();
            int no= i;
            for(int j=i;j<a.length;j++){
                if(a[j].getCash() > max){
                    max = a[j].getCash();
                    no = j;
                }
            }
            character temp = a[i];
            a[i] = a[no];
            a[no] = temp;
        }
    }

    public static void main(String[] args){
        System.out.println("This is a template for the Monopoly project.");
        character[] player = new character[5];
        Scanner sc = new Scanner(System.in);
        Pattern r = Pattern.compile("^[2-4]$");
        Map gameMap = new Map();
        int number; // number of player
        int turn = 0; // number of turns
        while(true) {
            System.out.println("Please input the number of player(s) (2-4):");
            String num = sc.nextLine();
            Matcher m = r.matcher(num);
            if(m.find()) {
                number = Integer.parseInt(num);
                break;
            }
        }
        for(int i=1;i<=number;i++){
            System.out.println("Please input the name of Player " + i + ":");
            String s=sc.nextLine();
            player[i]=new character(s, 1500, i);

            System.out.println("Your name is: " + player[i].name);
            System.out.println("Your own $" + player[i].cash + "\n");
        }

        int now;
        System.out.println(gameMap.printMap());
        
        while(turn < 100){
            int count = 0;
            for(int i=1; i<=number;i++){
                if(!player[i].isRetire()) count++;
            }
            if(count <= 1) break;
            System.out.println(turn + " turns" + "\n");
            for(int i=1; i <= number; i++){
                if(player[i].isRetire()) continue;
                System.out.println("\n" + player[i].getName() + " turns.");
                System.out.println("continue (c), report(r), auto(a), and retire(t)?input c/r/a/t ended with return.");
                Scanner sd = new Scanner(System.in);
                while (sd.hasNextLine()){
                    String s1 = sd.nextLine();
                    if(s1.equals("t") || s1.equals("T")){
                        player[i].retire(gameMap);
                        break;
                    }
                    else if(s1.equals("r") || s1.equals("R")){
                        System.out.println(gameMap.printMap());
                        System.out.println(player[i].toString(gameMap));
                        for(int m = 1; m <= number; m++){
                            if(player[m].isRetire())
                                System.out.print(player[m].getName() + ": retire    No: " + player[m].getNo() + "\n");
                            else if(player[m].injail())
                                System.out.print(player[m].getName() + " : in jail    No: " + player[m].getNo() + "\n");
                            else
                                System.out.print(player[m].getName() + " : position" + player[m].getPostion() + "    No: " + player[m].getNo() + "\n");
                        }
                        System.out.println("continue (c), report(r), auto(a), and retire(t)?input c/r/a/t ended with return.");
                        continue;
                    }
                    if(s1.equals("C") || s1.equals("c")){
                        System.out.println(gameMap.printMap());
                        player[i].move();
                        gameMap.getBlockList()[player[i].getPostion() - 1].action(player[i], gameMap);
                        break;
                    }
                    else  System.out.println("continue (c), report(r), auto(a), and retire(t)?input c/r/a/t ended with return.");
                }
            }
            turn++;
        }
        System.out.println("Game over");
        findWinner(player);
        int m = -1;
        for(int i=1;i<=number;i++){
            if(player[i].getCash() > m) {
                System.out.print(player[i].toString() + " WIN\n");
                m = player[i].getCash();
            }
            else break;
        }
    }
}
