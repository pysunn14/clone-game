//client

package Client;

import java.util.Scanner;

import Game.*;
import Game.Ghost.*;

public class App {

    static Game game = new Game();

    public static void initialize()
    {
        int MAX = 4;
        //유령은 총 24가지가 존재함. 
        int randomValue = Game.getRandomValue(MAX);

        if (randomValue == 0) {
            Hantu hantu = new Hantu();
            game.ghost = hantu;    
        }

        else if (randomValue == 1)
        {
            Revenant revenant = new Revenant();
            game.ghost = revenant;
        }

        else if (randomValue == 2) {
            Deogen deogen = new Deogen();
            game.ghost = deogen;
        }

        else if (randomValue == 3) {
            Obake obake = new Obake();
            game.ghost = obake;            
        }

        else 
        {
            System.out.println("어떤 유령도 선택되지 않았습니다.");
            System.exit(0);
        }

        //debug : System.out.println("소환된 유령의 종류는 : "+game.ghost.getName());
    }

    public static void main(String[] args) {

        initialize();

        // 게임 시작 전 유령 종류 랜덤으로 선택
        Scanner in = new Scanner(System.in);

        // 게임 시작
        while (true) {

            //사용자에게 문자 입력 받을 때마다 시간 경과함.
            
            game.update(game);
            
            String cmd = in.next();
            char c = cmd.charAt(0);

            switch (c) {
                case 'u':
                System.out.println("자외선으로 손자국을 확인합니다.");
                    game.ghost.UVlight(game);
                    break;

                case 'd': //도트 프로젝터
                    System.out.println("도트프로젝터를 비춥니다.");
                    game.ghost.dotsProjector();
                    break;
                    
                    case 's': //주파수 측정기
                    System.out.println("주파수 측정기를 실행했습니다.");
                    game.ghost.spiritBox();
                    break;
                    
                    case 'e': //emf 측정기
                    System.out.println("EMF를 확인합니다.");
                    game.ghost.EMF();
                    break;

                case 'v': //비디오 카메라
                    System.out.println("비디오 카메라를 확인합니다.");
                    game.ghost.videoCamera();
                    break;

                case 't':
                    System.out.println("온도계를 확인합니다.");
                    game.ghost.chill(game);
                    System.out.println("temperature : " + game.getTemperature());
                    break;

                case 'f':
                    System.out.println("퓨즈를 눌렀습니다.");
                    game.fuse.setSwitch();      
                    break;
                
                case 'q': //유령 맞추기
                    System.out.println("정답을 입력하세요 : ");
                    String answer = in.next();

                    if (answer.equals(game.ghost.getName())) {
                        System.out.println("축하합니다. 유령의 종류를 맞췄습니다.");
                        System.exit(0);
                    }
                    else
                    {
                        System.out.println("틀렸습니다... 정답은 " + game.ghost.getName() + " 이었습니다!");
                        System.exit(0);
                    }
                    break;

                case 'b': //공책 설치
                    System.out.println("책을 놓았습니다.");
                    game.setOnBook();
                    break;

                case 'h': //강제 헌팅 실행
                    System.out.println("강제 헌팅이 시작되었습니다.");
                    game.ghost.hunt();
                    break;
                
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }
    }
}