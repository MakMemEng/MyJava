import character.Character;
import character.Enemy;
import map.Figure;
import map.Rectangle;
import battle.BattleCharacter;
import java.awt.Graphics;

public class FiguredEnemy extends Enemy implements Figure, BattleCharacter{
    private Figure fig;

    public FiguredEnemy(String name, int hp, int power, String imFname){
	super(name, hp, power, imFname);
	this.fig = new Rectangle(0,0);
    }

    public Figure getFigure(){
	return fig;
    }

    public void move(int dx, int dy){
	fig.move(dx, dy);
    }

    public int getX(){
	return fig.getX();
    }

    public int getY(){
	return fig.getY();
    }

    public void draw(Graphics g){
	fig.draw(g);
    }

    public void attack(BattleCharacter c){
	Character chara;
	if( c instanceof BattleCharacterAdapter ){
	    chara = ((BattleCharacterAdapter)c).getCharacter();
	}else{
	    chara = (Character)c;
	}
	super.attack(chara);
    }

    public void magic(BattleCharacter c){
	Character chara;
	if( c instanceof BattleCharacterAdapter ){
	    chara = ((BattleCharacterAdapter)c).getCharacter();
	}else{
	    chara = (Character)c;
	}
	super.magic(chara);
    }
}
