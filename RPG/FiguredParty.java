import character.Character;
import character.Party;
import map.Figure;
import map.Circle;
import java.awt.Graphics;

public class FiguredParty extends Party implements Figure{
    private Figure fig;
    
    public FiguredParty(Character h, Character f, Character w){
	super(h, f, w);
	this.fig = new Circle(0, 0);
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
}
