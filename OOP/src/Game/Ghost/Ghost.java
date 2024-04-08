package Game.Ghost;

import java.util.Set;
import Game.*;

import java.util.HashSet;

class Unit {
    protected String name;
    protected double speed;

    public String getName() {
        return name;
    }
}

public class Ghost extends Unit {

    protected int huntingPoint;
    protected double acceleration;
    protected int huntingCooldown;
    protected int ghostActivityLevel;
    protected String ghostRoom;
    protected int EMF;

    protected Set<Evidence> evidence;
    protected Evidence fixedEvidence;

    public Ghost() {
        this.huntingPoint = 50;
        this.speed = 1.7;
        this.acceleration = 1.1;
        this.huntingCooldown = 25;
        this.ghostRoom = "거실";
        this.EMF = 0;
        this.evidence = new HashSet<Evidence>();
        this.fixedEvidence = Evidence.NONE;
    }

    // getter and setter

    public String getGhostroom() {
        return ghostRoom;
    }

    public int getHuntingPoint() {
        return this.huntingPoint;
    }

    // 증거 관련 유령 반응
    public void chill(Game game) {
        // 온도를 일정량 떨어뜨림.
        game.setTemperature(Game.getRandomValue(6));
        // 일반적인 유령은 0도 이하로 내려가지 않음
        if (!this.evidence.contains(Evidence.COOLNESS)) {
            if (game.getTemperature() < 0) {
                game.setTemperatureValue(0);
            }
        }
        // 서늘함을 가진 특성이라면 0도 이하로 내려가도 괜찮음. 단 최하온도는 -10으로 설정
        if (this.evidence.contains(Evidence.COOLNESS)) {
            if (game.getTemperature() < -10) {
                game.setTemperatureValue(-10);
            }
        }
    }

    public void videoCamera() {
        if (this.evidence.contains(Evidence.GHOST_ORB)) {
            System.out.println("+... +... + ...");
        }
    }

    public void dotsProjector() {
        if (this.evidence.contains(Evidence.DOTS_PROJECTOR)) {
            if (Game.getRandom(20)) {
                System.out.println("모습이 보입니다.");
            }
        }
    }

    public void EMF() {
        System.out.println("EMF level : " + this.EMF);
    }

    public void UVlight(Game game) {
        if (this.evidence.contains(Evidence.UVLIGHT) && game.getHandprint() > 0) {
            System.out.println("손가락이 " + game.getHandprint() + "개인 손자국이 있습니다.");
        }
    }

    public void spiritBox() {
        if (this.evidence.contains(Evidence.SPIRIT_BOX)) {
            System.out.println("Spirit Box : Hello");
        }

        else
            System.out.println("Spirit Box : x");
    }


    // 모든 유령이 공통으로 할 수 있는 행동
    public void hunt() {
        System.out.println("헌팅을 합니다. 기본적인 유령의 속도는 " + this.speed);
        System.out.println("유저를 발견한 유령의 속도는 " + (this.speed + this.acceleration));
    }

    public void event(Player player) {
        System.out.println("이벤트 실행 : 유령이 실체화했습니다!");
        this.EMF = 4;
        // 플레이어의 정신력 10 감소시킴
        player.setMental(10);

        // 확률적으로 EMF5단계 신호
        if (this.evidence.contains(Evidence.EMF)) {
            if (Game.getRandom(25)) {
                this.EMF = 5;
            }
        }
    }

    public void turnFuse(Fuse fuse) {
        System.out.println("유령이 퓨즈를 강제로 만집니다.");
        fuse.setSwitch();
        this.EMF = 2;

        // 확률적으로 EMF5단계 신호
        if (this.evidence.contains(Evidence.EMF)) {
            if (Game.getRandom(25)) {
                this.EMF = 5;
            }
        }
    }

    public void throwObject() {
        System.out.println("물건을 던졌습니다.");
        this.EMF = 3;

        // 확률적으로 EMF5단계 신호
        if (this.evidence.contains(Evidence.EMF)) {
            if (Game.getRandom(25)) {
                this.EMF = 5;
            }
        }

    }

    public void passDoor(Game game) {
        System.out.println("유령이 문을 지나갔습니다.");
        game.setHandprint(5);
        this.EMF = 2;

        // 확률적으로 EMF5단계 신호
        if (this.evidence.contains(Evidence.EMF)) {
            if (Game.getRandom(25)) {
                this.EMF = 5;
            }
        }
    }

    public void ghostWriting(Game game) {

        // 아직 책이 라이팅되지 않은 상태이면, 상태를 판정한다.
        if (game.isWrittened()) { return;}
        if (game.isOnBook()) {
            if (this.evidence.contains(Evidence.GHOST_WRITING)) {
                System.out.println("Ghost Writing : #$@$%^!#@%&&#&!#@$#");
            } else
                System.out.println("Ghost Writing : ...");
            this.EMF = 3;
        }
        game.setWrittened();

        // 확률적으로 EMF5단계 신호
        if (this.evidence.contains(Evidence.EMF)) {
            if (Game.getRandom(25)) {
                this.EMF = 5;
            }
        }
    }

    public void roaming() {
        System.out.println("유령이 로밍을 갑니다.");
    }
}