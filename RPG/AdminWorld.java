import character.*;
import battle.*;
import map.*;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class AdminWorld{
    private final int UP    = 38;
    private final int DOWN  = 40;
    private final int LEFT  = 37;
    private final int RIGHT = 39;
    
    private MyFrame map;
    private Party p;
    private FiguredParty pf;
    private ArrayList<Enemy> eList;
    private ArrayList<FiguredEnemy> efList;

    private CharacterManager cm;

    public AdminWorld(CharacterManager cm){
	this.cm = cm;
	this.p = cm.getParty();
	eList = new ArrayList<Enemy>();
	eList = cm.getEnemyList();
	efList = new ArrayList<FiguredEnemy>();
	MyKeyListener keyListener = new MyKeyListener(this);
	map = new MyFrame(keyListener);
    }

    // キャラクタの画面表示
    public void initialize(){
	// PartyとFiguredPartyの対応付け
	pf = new FiguredParty(p.getHero(),
			      p.getFighter(),
			      p.getWizard());
	map.addObj(pf.getFigure());

	// EnemyとFiguredEnemyの対応付け，初期位置設定
	Random r = new Random();
	for(int i=0; i<eList.size(); i++){
	    FiguredEnemy ef = new FiguredEnemy(eList.get(i).getName(),
					       eList.get(i).getHp(),
					       eList.get(i).getPower(),
					       eList.get(i).getFname());
	    ef.move((r.nextInt(29))*10, (r.nextInt(29)*10));
	    efList.add(ef);
	}
	for(FiguredEnemy x: efList){
	    map.addObj(x.getFigure());
	}
		
	map.repaint();
    }

    public void pressed(int keyCode){
	System.out.println("Push「"+keyCode+"」");

	// パーティの行動
	switch(keyCode){
	case UP:    pf.move(  0, -10); break;
	case DOWN:  pf.move(  0,  10); break;
	case LEFT:  pf.move(-10,   0); break;
	case RIGHT: pf.move( 10,   0); break;
	default: break;
	}

	// 敵のランダム行動
	Random r = new Random();
	for(FiguredEnemy ef: efList){
	    switch(r.nextInt(5)){
	    case 0: ef.move(  0, -10); break;
	    case 1: ef.move(  0,  10); break;
	    case 2: ef.move(-10,   0); break;
	    case 3: ef.move( 10,   0); break;
	    default: break;
	    }
	}
	
	// 表示のリフレッシュ
	map.repaint();

	// 敵との遭遇判定
	Enemy e = encount();
	if(e != null){
	    new BattleController(
		 new BattleCharacter[]{
		     // 以下のget関連は一般化した方が良い
		     new BattleCharacterAdapter(p.getHero()),
		     new BattleCharacterAdapter(p.getFighter()),
		     new BattleCharacterAdapter(p.getWizard())
		 },
		 (FiguredEnemy)e);
	}
    }
    
    private Enemy encount(){
	for(FiguredEnemy x: efList){
	    if(pf.getX() == x.getX() && pf.getY() == x.getY())
		return (Enemy)x;
	}

	return null;
    }

    // メインメソッド
    public static void main(String argc[]){
	CharacterManager cm = new CharacterManager();
	cm.defaultSetting();
	AdminWorld aw = new AdminWorld(cm);
	aw.initialize();
    }
}
