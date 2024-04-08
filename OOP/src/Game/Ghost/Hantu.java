package Game.Ghost;

import Game.*;

public class Hantu extends Ghost {

    public Hantu() {
        super();
        this.name = "hantu";
        this.speed = 1.4;
        this.acceleration = 1.3;

        this.evidence.add(Evidence.UVLIGHT);
        this.evidence.add(Evidence.GHOST_ORB);
        this.evidence.add(Evidence.COOLNESS);    
        this.fixedEvidence = Evidence.COOLNESS;
    }

    public void hunt()
    {
        System.out.println("헌팅을 합니다. 유령방에서 멀리 떨어진 곳에서의 유령의 속도는 " + this.speed);
        System.out.println("유령방 근처에서의 속도는 "+(this.speed+this.acceleration));
    }
}