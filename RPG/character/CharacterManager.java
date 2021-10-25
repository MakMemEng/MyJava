package character;

import java.util.Random;
import java.util.ArrayList;

public class CharacterManager{
    private Hero h;
    private Fighter f;
    private Wizard w;
    private Party p;
    private Enemy[] e;
    private ArrayList<Enemy> eList;

    public CharacterManager(){}

    public void defaultSetting(){
	Random r = new Random();
	eList = new ArrayList<Enemy>();

	// キャラクタとパーティのオブジェクト化
	h = new Hero("勇敢な人", 40, 5);
	f = new Fighter("戦う人", 60, 8);
	w = new Wizard("魔法使える人", 35, 2);
	//	p = new Party(h, f, w, new Circle(0, 0));
	p = new Party(h, f, w);

	// 敵のオブジェクト化
	e = new Enemy[]{
	    //new Enemy("おばけA", 40, 30, new Rectangle(0, 0), "enemy1.png"),
	    //new Enemy("おばけB", 50, 20, new Rectangle(0, 0), "enemy2.png"),
	    //new Enemy("おばけC", 45, 10, new Rectangle(0, 0), "enemy3.png"),
	    //new Enemy("おばけD", 65, 20, new Rectangle(0, 0), "enemy4.png"),
	    //new Enemy("おばけE", 70, 30, new Rectangle(0, 0), "enemy5.png"),
	    new Enemy("おばけA", 40, 30, "enemy1.png"),
	    new Enemy("おばけB", 50, 20, "enemy2.png"),
	    new Enemy("おばけC", 45, 10, "enemy3.png"),
	    new Enemy("おばけD", 65, 20, "enemy4.png"),
	    new Enemy("おばけE", 70, 30, "enemy5.png"),
	};
	
	/*
	// 敵の位置決め
	for(Enemy x: e){
	    x.move((r.nextInt(29))*10, (r.nextInt(29)*10));
	}
	*/

	// 敵のリスト化
	for(Enemy x: e){
	    eList.add(x);
	}
    }

    // パーティのオブジェクトを取得
    public Party getParty(){
	return p;
    }

    // 敵のオブジェクトを取得
    public Enemy[] getEnemy(){
	return e;
    }

    // 敵のリストを取得
    public ArrayList<Enemy> getEnemyList(){
	return eList;
    }
}
