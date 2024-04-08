package Game;

import Game.Ghost.*;

import java.util.Random;

public class Game {
    private double temperature;
    private int handprint;
    private boolean book;
    private boolean writtened;

    public boolean isWrittened() {
        return this.writtened;
    }

    public void setWrittened() {
        this.writtened = true;
    }

    public Ghost ghost = new Ghost();
    public Player player = new Player();
    public Fuse fuse = new Fuse();

    public Game() {
        this.temperature = 25;
        this.handprint = 0;
        this.book = false;
    }

    // getter and setter
    public boolean isOnBook() {
        return book;
    }

    public void setOnBook() {
        this.book = true;
    }

    public int getHandprint() {
        return handprint;
    }

    public void setHandprint(int hands) {
        handprint = hands;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature -= temperature;
    }

    public void setTemperatureValue(double temperature) {
        this.temperature = temperature;
    }

    // Random Util

    public static boolean getRandom(int percent) {
        Random random = new Random();

        if (random.nextInt(100) + 1 <= percent)
            return true;
        return false;
    }

    public static int getRandomValue(int range) {
        Random random = new Random();
        return random.nextInt(range);
    }

    public void testHunting() {
        // hunt
        if (player.getMental() <= ghost.getHuntingPoint()) {
            // 평균 정신이상력과 사냥 보정치의 합이 50~75라면 25%확률로 헌팅
            if (Game.getRandom(25)) {
                ghost.hunt();
            }
        }

        // 평균 정신이상력과 사냥 보정치의 합이 75이상이면 33%확률로 헌팅
        else if (player.getMental() <= ghost.getHuntingPoint() - 25)
            if (Game.getRandom(33))
                ghost.hunt();
    }

    public void testInteract(Game game) {

        // event
        switch (Game.getRandomValue(11)) {

            case 0, 1, 2, 3, 4:
                // 무작위 물건과 상호작용한다.
                System.out.println("* 유령이 무언가 물건을 만집니다.");

                // 33%확률로 무작위 문과 상호작용 한다
                if (Game.getRandom(33))
                    ghost.passDoor(game);

                // 66%확률로 수첩에 흔적을 남긴다.
                else
                    ghost.ghostWriting(game);
                // 무작위 소품과 상호작용 한다.
                //System.out.println("유령이 무언가 소품을 만집니다.");

                break;

            case 5, 6, 7, 8: // 또다시 0부터 12사이의 난수 굴림을 한다.

                switch (Game.getRandomValue(13)) {
                    case 0, 1: // 유령이 나타난다. 만약 셰이드이면 다시한번 정신력에따른 난수굴림을 해서 나타날지말지를 결정한다.
                        ghost.event(player);
                        break;
                    case 2: // 두꺼비집을 내린다
                        ghost.turnFuse(fuse);
                        break;
                    case 3, 4: // 물건을 던진다 - 셰이드이면 x, 폴터면 한번에 가능
                        ghost.throwObject();
                        break;
                    case 5, 6, 7: // 무작위 이벤트가 일어난다.
                        ghost.event(player);
                        break;
                    case 8, 9, 10, 11, 12: // 유령이 33%확률로 배회를 한다.
                        if (Game.getRandom(33))
                            ghost.roaming();
                        break;
                    default:
                        break;
                }
                break;

            default:
                break;
        }

    }

    public void update(Game game) {
        // 정신력 조금씩 감소

        // 퓨즈가 올라가있다면 1씩감소, 아니라면 2씩 감소한다.
        player.setMental(1);
        if (!fuse.getState())
            player.setMental(1);
        if (player.getMental() < 0)
            player.setMental();

        System.out.println("\n\n\n\n현재 정신력 : " + player.getMental()+" 현재 위치 : " + ghost.getGhostroom()+ " Fuse : " + fuse.getState());
        System.out.println(
                "[ u : 자외선 | d : 도트프로젝터 | s : 주파수 | e: EMF | v : 비디오카메라 | t : 온도계 | f : 퓨즈 누르기 | b : 공책 설치 | q : 유령 맞추기 ]");
        System.out.println();


        // 유령 상태 업데이트

        // 50%확률로 사냥모드 및 상호작용 테스트를 한다.

        if (Game.getRandom(50)) {
            game.testHunting();
            return;
        }

        if (Game.getRandom(50)) {
            game.testInteract(game);
            return;
        }
    }

}