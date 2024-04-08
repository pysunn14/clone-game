package Game;
public class Fuse
{
    private boolean state; 
    protected int no;

    public Fuse ()
    {
        this.state = false;
    }

    public void setSwitch()
    {
        if (state) { 
            this.state = false;
            System.out.println("퓨즈 꺼짐");
        }
        else 
        {
            this.state = true;
            System.out.println("퓨즈 켜짐");
        }
    }

    public boolean getState() {return state;}
}