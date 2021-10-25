package map;
import java.awt.Color;
import java.awt.Graphics;

public class Rectangle implements Figure{
    private int x;
    private int y;
    
    public Rectangle(int x, int y){
	this.x = x;
	this.y = y;
    }

    public void draw(Graphics g){
	g.setColor(Color.black);
	g.drawRect(x, y, 10, 10);
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

