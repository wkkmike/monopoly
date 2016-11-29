package hk.edu.polyu.comp.comp2021.monopoly;

/**
 * Created by michael on 2016/11/24.
 */
public class Map {
    private Block Go1;
    private Block Central2;
    private Block WanChai3;
    private Block Tax4;
    private Block Stanley5;
    private Block Jail6;
    private Block ShekO7;
    private Block MongKok8;
    private Block Chance9;
    private Block TsingYi10;
    private Block Parking11;
    private Block Shatin12;
    private Block Chance13;
    private Block TuenMun14;
    private Block TaiPo15;
    private Block GoToJail16;
    private Block SaiKung17;
    private Block YuenLong18;
    private Block Chance19;
    private Block TaiO20;
    {
        Go1 = new Go(1,"Go");
        Central2 = new Property(800, 90, 2, "Central");
        WanChai3 = new Property(700, 65, 3, "Wan Chai");
        Tax4 = new Tax(4, "Income Tax");
        Stanley5 = new Property(600, 60, 5, "Stanley");
        Jail6 = new Jail(6, "Jail");
        ShekO7 = new Property(400, 10, 7, "Shek O");
        MongKok8 = new Property(500, 40, 8, "Mong Kok");
        Chance9 = new Chance(9,"Chance");
        TsingYi10 = new Property(400, 15, 10, "Tsing Yi");
        Parking11 = new Parking(11, "FreeParking");
        Shatin12 = new Property(700, 75, 12, "Shatin");
        Chance13 = new Chance(13, "Chance");
        TuenMun14 = new Property(400, 20, 14, "Tuen Mun");
        TaiPo15 = new Property(500, 25, 15, "Tai Po");
        GoToJail16 = new GoToJail(16, "GoToJail");
        SaiKung17 = new Property(400, 10, 17, "Sai Kung");
        YuenLong18 = new Property(400, 25, 18, "Yuen Long");
        Chance19 = new Chance(19, "Chance");
        TaiO20 = new Property(600, 25, 20, "Tai O");

    }
    private Block[] BlockList = new Block[]{Go1, Central2, WanChai3, Tax4, Stanley5, Jail6, ShekO7, MongKok8, Chance9, TsingYi10,
            Parking11, Shatin12, Chance13, TuenMun14, TaiPo15, GoToJail16, SaiKung17, YuenLong18, Chance19, TaiO20};

    /**
     * Get the block this map have.
     * @return the blocklist
     */
    public Block[] getBlockList(){
        return BlockList;
    }

    /**
     * Get the name of a block by it's position
     * @param p the position of the block
     * @return the name of the block
     */
    public String getNameOfBlock(int p){
        return BlockList[p-1].getName();
    }

    /**
     * get the map in command line
     * @return a string stand for the map.
     */
    public String printMap(){
        StringBuilder sb=new StringBuilder();
        for(int i=10; i<=15;i++){
            sb.append(BlockList[i].toIcon());
        }
        sb.append(BlockList[9].toIcon());
        sb.append(BlockList[16].toIcon());
        sb.append(BlockList[8].toIcon());
        sb.append(BlockList[17].toIcon());
        sb.append(BlockList[7].toIcon());
        sb.append(BlockList[18].toIcon());
        sb.append(BlockList[6].toIcon());
        sb.append(BlockList[19].toIcon());
        for(int i=5; i>=0; i--){
            sb.append(BlockList[i].toIcon());
        }
        return sb.toString();
    }


    public static void main(String[] args){
        Map a = new Map();
        System.out.println(a.BlockList[7].getName());
        System.out.println(a.printMap());
    }
}
