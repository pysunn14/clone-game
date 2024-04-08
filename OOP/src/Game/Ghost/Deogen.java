package Game.Ghost;

import Game.*;

public class Deogen extends Ghost {

    public Deogen() {
        super();
        this.name = "deogen";
        this.speed = 3.0;
        this.acceleration = -2.6;
        this.huntingPoint = 40;

        this.evidence.add(Evidence.SPIRIT_BOX);
        this.evidence.add(Evidence.DOTS_PROJECTOR);
        this.evidence.add(Evidence.GHOST_WRITING);

        this.fixedEvidence = Evidence.SPIRIT_BOX;
    }

    public void hunt() {
        System.out.println("헌팅을 합니다. 기본적인 유령의 속도는 " + this.speed);
        System.out.println("유저를 발견한 유령의 속도는 "+(this.speed+this.acceleration));
        
    }
}