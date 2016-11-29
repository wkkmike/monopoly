package hk.edu.polyu.comp.comp2021.monopoly;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {

    private static void findWinner(character[] a, int num){
        for(int i=1;i<=num;i++){
            int max = a[i].getCash();
            int no= i;
            for(int j=i;j<=num;j++){
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

        String data;

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
                System.out.println("continue (c), report(r), auto(a), show all(s) and retire(t)?input c/r/a/t/s ended with return.");
                try {
                    Thread.sleep(500);
                }
                catch (InterruptedException e){

                }
                InputStream inc = System.in;
                if(player[i].isAuto()){
                    data = "c\n";
                    System.setIn(new ByteArrayInputStream(data.getBytes()));
                }
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
                            else if(player[m].isAuto())
                                System.out.print(player[m].getName() + " : in Auto mode    No: " + player[m].getNo() + "\n");
                            else
                                System.out.print(player[m].getName() + " : position" + player[m].getPostion() + "    No: " + player[m].getNo() + "\n");
                        }
                        System.out.println("continue (c), report(r), auto(a), show all(s) and retire(t)?input c/r/a/t/s ended with return.");
                        continue;
                    }

                    else if(s1.equals("s") || s1.equals("S")){
                        for(int m = 1; m<=number; m++){
                            System.out.println(player[m].toString(gameMap));
                        }
                        System.out.println("continue (c), report(r), auto(a), show all(s) and retire(t)?input c/r/a/t/s ended with return.");
                        continue;
                    }

                    else if(s1.equals("A") || s1.equals("a")){
                        System.out.println(player[i].getName() + " change to auto mode.");
                        player[i].setAuto();
                        if(player[i].rollDice() <= 3)
                            data = "y\n";
                        else
                            data = "n\n";
                        System.setIn(new ByteArrayInputStream(data.getBytes()));
                        player[i].move();
                        gameMap.getBlockList()[player[i].getPostion() - 1].action(player[i], gameMap);
                        System.setIn(inc);
                        break;
                    }
                    else if(s1.equals("C") || s1.equals("c")){
                        System.out.println(gameMap.printMap());
                        player[i].move();
                        if(player[i].isAuto()){
                            if(player[i].rollDice() <= 3){
                                data = "y\n";
                            }
                            else {
                                data = "n\n";
                            }
                            System.setIn(new ByteArrayInputStream(data.getBytes()));
                        }
                        gameMap.getBlockList()[player[i].getPostion() - 1].action(player[i], gameMap);
                        System.setIn(inc);
                        break;
                    }
                    else  System.out.println("continue (c), report(r), auto(a), show all(s) and retire(t)?input c/r/a/t/s ended with return.");
                }
            }
            turn++;
        }
        System.out.println("Game over");
        findWinner(player, number);
        int m = -1;
        for(int i=1;i<=number;i++){
            if(player[i].getCash() > m) {
                System.out.print(player[i].getName() + " WIN\n");
                m = player[i].getCash();
            }
            else break;
        }
    }
}
