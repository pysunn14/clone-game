package Game;

interface GhostOrbb {

}

interface GhostWriting {

    default void ghostWriting() {
        System.out.println("고스트라이팅 중......");
    }
}

interface EMF5level {

}

public enum Evidence {
    NONE,
    EMF, 
    SPIRIT_BOX, 
    COOLNESS, 
    UVLIGHT, 
    GHOST_ORB,  
    GHOST_WRITING, 
    DOTS_PROJECTOR
}