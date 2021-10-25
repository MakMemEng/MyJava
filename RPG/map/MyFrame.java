package map;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.util.Random;
import java.awt.event.KeyListener;  // +

public class MyFrame extends JFrame{
    private MyPanel panel;
    
    //  public MyFrame(AdminWorld aw){
        public MyFrame(KeyListener keyListener){
	super("RPGゲーム");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(300, 300);
	//	panel = new MyPanel(aw);
	panel = new MyPanel();
	add(panel, BorderLayout.CENTER);
	setVisible(true);
	addKeyListener(keyListener);  // +
    }

    public void addObj(Figure f){
	panel.addObj(f);
    }
}
