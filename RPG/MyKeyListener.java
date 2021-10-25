import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Random;

public class MyKeyListener extends  KeyAdapter{
    private AdminWorld aw;

    public MyKeyListener(AdminWorld aw){
	this.aw = aw;
    }

    public void keyPressed(KeyEvent event){
	int keycode = event.getKeyCode();
	aw.pressed(keycode);
    }
}
