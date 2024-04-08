package Game.Ghost;
import Game.*;

public class Obake extends Ghost {

    public Obake() {
        super();
        this.name = "obake";

        this.evidence.add(Evidence.UVLIGHT);
        this.evidence.add(Evidence.GHOST_ORB);
        this.evidence.add(Evidence.EMF);    
        this.fixedEvidence = Evidence.UVLIGHT;
    }

    public void passDoor(Game game)
    {
        System.out.println("덜컥... 유령이 문을 지나갔습니다.");
        this.EMF = 2;
        //일정 확률로 손자국이 남지 않음
        if (Game.getRandom(25)) {
            return;
        }

        //일정 확률로 6개의 손자국을 남김
        if (Game.getRandom(25)) {
            game.setHandprint(6);
        }
        //아닌경우 5개의 손자국을 남김
        else game.setHandprint(5);
    }

    public void hunt() {
        System.out.println("헌팅을 합니다. 기본적인 유령의 속도는 " + this.speed);
        System.out.println("유저를 발견한 유령의 속도는 "+(this.speed+this.acceleration));
        
        if (Game.getRandom(25)) {
            System.out.println("유령의 모습이 갑자기 바뀌었습니다.");
        }
    }
}
