package ship_game;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        // TODO �����������ꂽ���\�b�h�E�X�^�u
    	
    	Scanner sc = new Scanner(System.in);
        Random random = new Random();
        
        int inputX;
        int inputY;
        int[][] input= new int[5][5];
        int randomValue01 =1 + random.nextInt(4);
        int randomValue02 =1 + random.nextInt(4);
        
        Ship s1 = new Ship("s1",randomValue01,randomValue02,3);
        Ship s2 = new Ship("s2",randomValue01,randomValue02,3);
        Ship s3 = new Ship("s3",randomValue01,randomValue02,3);
            	
        Game.GameStart();
        
        while(s1.hp!=0&&s2.hp!=0&&s3.hp!=0) {
        	Game.GameTurn();
    		s1.ShipA(s1.hp);
    		s2.ShipA(s2.hp);
    		s3.ShipA(s3.hp);
    		System.out.println("���W����͂��Ă�������(0-4,5�ȏ��4�ɂȂ�)");
    		inputX = sc.nextInt();
    		inputY= sc.nextInt();
    		if(inputX>=5||inputY>=5) {
    			inputX = 4;
    			inputY = 4;
    		}
    		input[inputX][inputY]=1;
    		s1.shoot(input,inputX,inputY);
    		s2.shoot(input,inputX,inputY);
    		s3.shoot(input,inputX,inputY);
    		
    	}        
        sc.close();
    }
}