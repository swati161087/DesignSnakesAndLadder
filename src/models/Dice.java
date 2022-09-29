package models;

public class Dice {
    private int maxNo;
    private int minNo;
    public Dice(int maxNo) {
        this.maxNo = maxNo;
        minNo=1;
    }
    public int rollDice(){
        int range = maxNo - minNo + 1;
        int rand = (int)(Math.random() * range) + minNo;

        return rand;
    }
}
