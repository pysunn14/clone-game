package Game.Ghost;

public class Player extends Unit {
    private int mental;

    private int level;
    private int money;

    public Player()
    {
        this.level = 1;
        this.money = 1000;
        this.name = "USER";
        this.mental = 100;
        this.speed = 1.7;
    }

    public int getMental() {return mental;}
    public void setMental(int value) {this.mental -= value;}
    public void setMental() {this.mental = 0;}
}