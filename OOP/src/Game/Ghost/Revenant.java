package Game.Ghost;

import Game.*;

public class Revenant extends Ghost {

    public Revenant() {
        super();
        this.name = "revenant";
        this.speed = 1.0;
        this.acceleration = 2.0;

        this.evidence.add(Evidence.COOLNESS);
        this.evidence.add(Evidence.GHOST_ORB);
        this.evidence.add(Evidence.GHOST_WRITING);    
    }
}