package character;

import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.io.IOException;

//public class Party implements ActionListener{
public class Party{
    //    private Hero hero;
    //    private Fighter fighter;
    //    private Wizard wizard;
    private Character hero;
    private Character fighter;
    private Character wizard;
    //    private Figure fig;
    //    private BattleFrame frame;
    private Character c[];
    private Random r;
    
    //    public Party(Hero h, Fighter f, Wizard w, Figure fig){
    public Party(Character h, Character f, Character w){
	this.hero = h;
	this.fighter = f;
	this.wizard = w;
	//	this.fig = fig;
	this.c = new Character[]{hero, fighter, wizard};
    }
    
    // 勇者のオブジェクトを取得
    //    public Hero getHero(){
    public Character getHero(){
	return hero;
    }

    // 戦士のオブジェクトを取得
    //    public Fighter getFighter(){
    public Character getFighter(){
	return fighter;
    }

    // 魔法使いのオブジェクトを取得
    //    public Wizard getWizard(){
    public Character getWizard(){
	return wizard;
    }

    /*
    // グラフィクス表示
    public Figure getFigure(){
	return fig;
    }

    // パーティの動作
    public void move(int dx, int dy){
	fig.move(dx, dy);
    }

    public int getX(){
	return fig.getX();
    }
    
    public int getY(){
	return fig.getY();
    }
    */
    
    /*  見直しによるコメントアウト
    // パーティの全滅判定
    public boolean deathParty(){
	if(hero.deathStatus() == true &&
	   fighter.deathStatus() == true &&
	   wizard.deathStatus() == true)
	    return true;
	else
	    return false;
    }
    */

    /*
    // 敵との戦闘
    private int fightOrder;
    private Enemy e;
    public void fight(Enemy e){
	this.e = e;
	r = new Random();
	System.out.println("＊＊＊ "+e.getName()+"が現れた！ ＊＊＊");
	fightOrder = 0;
	frame = new BattleFrame(this);
	frame.setMessageText("＊＊＊ "+e.getName()+"が現れた！ ＊＊＊");
	frame.setCommandText("コマンドを選択してください\n");
	frame.setImage(frame.getToolkit().getImage(e.getFname()));
	nextTurn();
    }

    private void nextTurn(){
	if(fightOrder == 999){
	    JFrame messageFrame = new JFrame();
	    JOptionPane.showMessageDialog(messageFrame, "全滅しました");
	    System.exit(0);
	}
	else if(fightOrder == 99){
	    fightOrder = 0; // 念の為に初期化
	    frame.dispose();
	}else if(fightOrder == 9){
	    JFrame messageFrame = new JFrame();
	    String msg = e.getName()+"を倒した！";
	    JOptionPane.showMessageDialog(messageFrame, msg);
	    frame.dispose();
	}else{
	    if(fightOrder == 3){
		frame.setCommandText(e.getName()+"の反撃\n");
		switch(r.nextInt(4)){
		case 0: e.attack(c[0]); break;
		case 1: e.attack(c[1]); break;
		case 2: e.attack(c[2]); break;
		case 3: e.magic(e);     break;
		default:                break;
		}
		fightOrder = 0;
		if(deathParty() == true){
		    fightOrder = 999;
		}
		nextTurn();
	    }else{
		// キャラの生死判定
		if(c[fightOrder].deathStatus() == true){
		    fightOrder++;
		    nextTurn();
		}else{
		    String msg = c[fightOrder].getName()+"のコマンド\n";
		    frame.setCommandText(msg);
		}
	    }
	}
    }

    public void actionPerformed(ActionEvent ae){
	String cmd = ae.getActionCommand();
	if(cmd.equals("Attack")){
	    System.out.println("攻撃する");
	    frame.setCommandText("攻撃！\n\n");
	    c[fightOrder].attack(e);
	}else if(cmd.equals("MagicEnemy")){
	    System.out.println("敵に魔法を使う");
	    frame.setCommandText("敵に魔法を唱えた！\n\n");
	    c[fightOrder].magic(e);
	}else if(cmd.equals("MagicSelf")){
	    System.out.println("自分に魔法を使う");
	    frame.setCommandText("自分に魔法を唱えた！\n\n");
	    c[fightOrder].magic(c[fightOrder]);
	}else{
	    System.out.println("逃げる");
	    fightOrder = 99;
	    nextTurn();
	}
	fightOrder++;

	if(e.deathStatus() == true){
	    fightOrder = 9;
	}
	nextTurn();
    }
    */
}
