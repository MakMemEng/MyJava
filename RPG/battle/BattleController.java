package battle;

import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class BattleController implements ActionListener{
    private BattleCharacter[] c;
    private BattleCharacter e;
    private BattleFrame frame;
    private int fightOrder;
    private Random r;  // +

    // 旧Party.javaのfightメソッドをベースにコンストラクタ化
    public BattleController(BattleCharacter[] c, BattleCharacter e){
	this.c = c;
	this.e = e;
	this.r = new Random();
	this.fightOrder = 0;
	frame = new BattleFrame(this);
	frame.setMessageText("＊＊＊ "+e.getName()+"が現れた！ ＊＊＊");
	frame.setCommandText("コマンドを選択してください\n");
	frame.setImage(frame.getToolkit().getImage(e.getFname()));
	nextTurn();
    }

    // 旧Party.javaより移植
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
	    if(fightOrder == 3){  // ここら辺は一般化した方が良い
		frame.setCommandText(e.getName()+"の反撃\n");
		switch(r.nextInt(4)){
		case 0: e.attack(c[0]); break;
		case 1: e.attack(c[1]); break;
		case 2: e.attack(c[2]); break;
		case 3: e.magic(e);     break;
		default:                break;
		}
		fightOrder = 0;
		// パーティ全滅判定方法を改訂した
		// if(deathParty() == true){
		if(c[0].deathStatus() &&
		   c[1].deathStatus() &&
		   c[2].deathStatus()){
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

    // 旧Party.javaより移植
    public void actionPerformed(ActionEvent ae){
	String cmd = ae.getActionCommand();
	if(cmd.equals("Attack")){
	    //	    System.out.println("攻撃する");
	    frame.setCommandText("攻撃！\n\n");
	    c[fightOrder].attack(e);
	}else if(cmd.equals("MagicEnemy")){
	    //	    System.out.println("敵に魔法を使う");
	    frame.setCommandText("敵に魔法を唱えた！\n\n");
	    c[fightOrder].magic(e);
	}else if(cmd.equals("MagicSelf")){
	    //	    System.out.println("自分に魔法を使う");
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
}

