package map;
import java.awt.*;

public interface Figure{
    public abstract void draw(Graphics g);
    public abstract void move(int dx, int dy);
    public abstract int getX();
    public abstract int getY();
}
