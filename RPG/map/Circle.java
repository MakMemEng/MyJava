package map;
import java.awt.Color;
import java.awt.Graphics;

public class Circle implements Figure{
    private int x;
    private int y;

    public Circle(int x, int y){
	this.x = x;
	this.y = y;
    }

    public void draw(Graphics g){
	g.setColor(Color.black);
	g.drawOval(x, y, 10, 10);
    }

    public void move(int dx, int dy){
	this.x += dx;
	this.y += dy;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }
}

