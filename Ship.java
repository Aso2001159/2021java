package ship_game;
import java.util.Random;
public class Ship {
    public String name;
    public int hp=3;
    public int[][] position= new int [5][5]; 
    
    public final int[][] st = {{0,1,0},{0,1,0}};
    
    Random r =new Random();
    int randomX = 1+ r.nextInt(4);
    int randomY = 1+ r.nextInt(4);
    int cnt = 3;
   public Ship(String name,int randomX,int randomY, int hp) {
        this.name = name;
        this.hp = hp;
        while(cnt==0) {
        	if(position[randomX][randomY]!=1) {
        		this.position[randomX][randomY] = 1 ;//X,Y���W�Ɉʒu�ł���1��ݒ�
        		System.out.println(this.position[randomX][randomY]+this.name);
        		cnt--;
        	} else {
        		randomX = 1+ r.nextInt(4);
        		randomY = 1+ r.nextInt(4);
        	}
        }
    }
    
    public void nearmiss(int x,int y,String name) {
        System.out.printf("%s::X=%d,Y=%d:�g����\n",this.name,x,y);
    }
    
    public int getXY(int x,int y) { //�l���o��
    	return position[x][y];
    }
    
    public void shoot(int[][] input,int x,int y) { //���͒l�ƑD�̈ʒu�������Ȃ烁�\�b�h���s�B�߂��Ȃ�j�A�~�X���\�b�h���s�B�ł�����ł����Ă�̂��H
    	if(input[x][y]==getXY(x,y)){
    		hit(this.hp);
    	} else if(st[0][1]==getXY(x,y)||st[1][0]==getXY(x,y)||st[1][2]==getXY(x,y)||st[2][1]==getXY(x,y)) {
    		nearmiss(x,y,this.name);	
    	} else {
    		Game.miss();
    	}
    }
    
    public void ShipA(int hp) {
    	switch(this.hp) {
    		case 3:
    			System.out.printf("%s:�����Ă�\n",this.name);
    			break;
    		case 2:
    			System.out.printf("%s:���������Ă�\n",this.name);
    			break;
    		case 1:
    			System.out.printf("%s:���ɂ���\n",this.name);
    			break;
    		default:
    			System.out.printf("%s:���S\n",this.name);
    			break;
    	}
    }
    
    public void hit(int hp) {
    	if(this.hp>0) {
    		this.hp -=1;
    		System.out.printf("&s�Ƀq�b�g�c��%d",this.name,this.hp);
    	}else {
    		Game.miss();
    	}
    }
    
}